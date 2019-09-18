package eda;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		
		int[] array = new int[numeros.length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(numeros[i]);
		}
		selectionSortRecursivo(array, 0);
	}

	public static void selectionSortRecursivo(int[] array, int i) {
		int i_menor = i;
		for (int j = i + 1; j < array.length; j++) {
			if(array[j] < array[i_menor]) {
				i_menor = j;
			}
		}
		int aux = array[i_menor];
		array[i_menor] = array[i];
		array[i] = aux;
		if(i < array.length - 1) {
			System.out.println(Arrays.toString(array));
			selectionSortRecursivo(array, i + 1);
		}

	}
}