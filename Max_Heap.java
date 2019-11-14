import java.util.Scanner;

class Max_Heap {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] array = entrada.nextLine().split(" ");
		int[] inteiros = new int[array.length];

		for(int i = 0; i < array.length; i++) {
			inteiros[i] = Integer.parseInt(array[i]);
		}
		
		System.out.println(is_heap(inteiros));

		entrada.close();
	}
	
	public static boolean is_heap(int[] array) {
		int i = 0;
		boolean isHeap = true;
		while(i < array.length) {
			if(2 * i + 1 < array.length) {
				if(array[2 * i + 1] > array[i]) {
					isHeap = false;
					break;
				}
			}
			if(2 * (i + 1) < array.length) {
				if(array[2 * (i + 1)]> array[i]) {
					isHeap = false;
					break;
				}
			}
			i++;
		}
		return isHeap;
	}
}

