package ae14;

import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = new int[numeros.length];

		for(int i = 0; i < numeros.length; i++) {
			array[i] = Integer.parseInt(numeros[i]);
		}
		mergesort(array, 0, array.length - 1);
	}
	
	private static void print(int[] numeros, int comeco, int fim) {
		int[] novoArray = new int[fim - comeco + 1];
		int j = 0;
		for (int i = comeco; i <= fim; i++) {
			novoArray[j++] = numeros[i];
		}
		System.out.println(Arrays.toString(novoArray));
	}

	public static void mergesort(int[] array, int leftIndex, int rightIndex) {
		print(array,leftIndex,rightIndex);
		if(leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			mergesort(array,leftIndex, meio);
			mergesort(array, meio + 1, rightIndex);
			merge(array, leftIndex, rightIndex, meio);
		}
	}

	public static void merge(int[] array, int leftIndex,int rightIndex,int meio) {
		int i = leftIndex;
		int j= meio + 1;
		int k = leftIndex;
		int[] arrayAux = Arrays.copyOf(array, array.length);
		
		while(i <= meio && j <= rightIndex) {	
			if(arrayAux[i] <= arrayAux[j]) {
				array[k] = arrayAux[i];
				i++;
			} else {
				array[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		
		while(j <= rightIndex) {
			array[k] = arrayAux[j];
			j++;
			k++;
		}
		while(i<= meio) {
			array[k] = arrayAux[i];
			i++;
			k++;
		}
		print(array,leftIndex,rightIndex);
	}
	
}