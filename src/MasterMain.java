import java.util.Scanner;
import java.util.Random;

public class MasterMain {

	public static boolean encontre(int[] vector, int numero) {
		boolean encontre = false;
		for (int i = 0; i < vector.length && !encontre; i++) {
			if (numero == vector[i]) {
				encontre = true;
			}
		}
		return encontre;
	}

	static int[] transforma(int ingreso) { // Supongo ingreso = 1234
		int[] array = new int[4];
		int multiploDiez = 1000;
		for (int i = 0; i < array.length; i++) { // i = 0
			array[i] = ingreso / multiploDiez; // 1234 / 1000 --> 1
			ingreso = ingreso % multiploDiez; // 1234 % 1000 --> 234
			multiploDiez /= 10; // 1000 / 10 --> 100
		}
		return array;
	}

	public static void main(String[] args) {

		Scanner dato = new Scanner(System.in);
		Random azar = new Random();

		int NumAzar = 1 + azar.nextInt(4);
		int ingreso; // El numero ingresado por teclado
		int[] descifrador = new int[4]; // El número transformado en array
		int[] codificador = new int[4]; // El array a descifrar (generado al azar)
		int verde = 0, rojo = 0; // Contadores

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 6; j++) {
				codificador[i] = 1 + azar.nextInt(4);
			}
		}
		System.out.print("Numeros al alzar del juego: ");
		for (int i : codificador) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.print("Ingrese un numero: ");
		ingreso = dato.nextInt();
		descifrador = transforma(ingreso);

		for (int i = 0; i < 4; i++) {
			if (codificador [i] == descifrador[i]) {
				verde = verde + 1;
				System.out.println("Verde: " + descifrador[i]);
			} else {
				rojo = rojo + 1;
				System.out.println("Rojo: " + descifrador[i]);
			}
		}
		System.out.println("Numeros verdes total es: " + verde);
		System.out.println("Numeros rojos total es: " + rojo);
		System.out.println("Hola");
	}
}
