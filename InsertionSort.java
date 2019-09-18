package eda;

import java.util.Arrays;
import java.util.Scanner;

class InsertionSort {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");

		int[] array = new int[numeros.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(numeros[i]);
		}
			insertioSort(array);
			System.out.println(Arrays.toString(array));
	}

	public static void insertioSort(int[] array) {
		for (int i = array.length - 1; i >= 0 ; i --) {
			int j = i;
			while(j>0 && array[j] < array[j - 1]) {
				int aux = array[j];
				array[j] = array[j - 1];
				array[j - 1] = aux;
			}
		}
	}
}	