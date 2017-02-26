import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class TestFecha {
	
	public static void main(String[] args) {
		// dateTestSinJunit();
		dateTestConJunit();
	}

	public static void dateTestSinJunit() {
		Scanner sc = new Scanner(System.in);
		int d, m, y;

		System.out.println("Introduce fecha: ");
		System.out.print("dia: ");
		d = sc.nextInt();
		System.out.print("mes: ");
		m = sc.nextInt();
		System.out.print("año: ");
		y = sc.nextInt();

		Fecha date = new Fecha(d, m, y);

		System.out.println("FECHA: " + date.toString());

		if (date.valida()==true){
			System.out.println("fecha valida");
		} else {
			System.out.println("fecha invalida");
		}

		sc.close();
	}

	@Test
	public static void dateTestConJunit() {
		try {
			// caso de prueba valido para isCorrectDate
				Fecha fechaValidador = new Fecha(12, 5, 1995);
			assertEquals(fechaValidador.valida(), true);

			// casos de prueba invalidos para isCorrectDate
			Fecha fechaDia = new Fecha(32, 5, 1995);
			assertEquals(fechaDia.valida(), false);
			Fecha fechaMes = new Fecha(12, 13, 1995);
			assertEquals(fechaMes.valida(), false);
			Fecha fechaNegativoDia = new Fecha(-2, 5, 1995);
			assertEquals(fechaNegativoDia.valida(), false);
			Fecha fechaNegativoMes = new Fecha(12, -5, 1995);
			assertEquals(fechaNegativoMes.valida(), false);
			Fecha fechaNegativoAño = new Fecha(12, 5, -1);
			assertEquals(fechaNegativoAño.valida(), false);
			Fecha fechaCeroDia = new Fecha(0, 5, 1995);
			assertEquals(fechaNegativoMes.valida(), false);
			Fecha fechaCeroMes = new Fecha(12, 0, 1995);
			assertEquals(fechaNegativoMes.valida(), false);
			Fecha fechaDiaNoInt = new Fecha('a', 5, 1995);
			assertEquals(fechaDiaNoInt.valida(), false);
			Fecha fechaMesNoInt = new Fecha(12, 'b', 1995);
			assertEquals(fechaMesNoInt.valida(), false);
			Fecha fechaAñoNoInt = new Fecha(12, 5, 'c');
			assertEquals(fechaAñoNoInt.valida(), false);

			// caso de prueba valido para toString
			Fecha fechaString = new Fecha(12, 5, 1995);
			assertEquals(fechaDia.toString(), "12/5/1995");
			
			//caso de prueba valido para isLapYear
			/*
			Fecha fechaBisiesto = new Fecha(12, 5, 2024);
			assertEquals(fechaBisiesto.bisiesto(), true);
			Fecha fechaNOBisiesto = new Fecha(12, 5, 2023);
			assertEquals(fechaNOBisiesto.bisiesto(), false);
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
