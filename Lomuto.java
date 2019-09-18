package ae14;
import java.util.*;
import java.lang.*;

class Lomuto {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] numeros = entrada.nextLine().split(" ");
		int[] array = new int[numeros.length];
	
		for(int i = 0; i < numeros.length; i++) {
			array[i] = Integer.parseInt(numeros[i]);
		}
		
		lomuto(array,  0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	public static int lomuto(int[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] < (array[leftIndex])) {
				i++;
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				System.out.println(Arrays.toString(array));
			}
		}
		int aux = array[i];
		array[i] = array[leftIndex];
		array[leftIndex] = aux;
		System.out.println(Arrays.toString(array));
		return i;
	}
}
