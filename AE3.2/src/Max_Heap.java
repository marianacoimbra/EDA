import java.util.Scanner;

class Max_Heap {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] array = entrada.nextLine().split(" ");
		int[] inteiros = new int[array.length];
		
		for(int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(array[i]);
		}
		
		//heap(inteiros);
	}

	class Heap {
		
	}
	
}
