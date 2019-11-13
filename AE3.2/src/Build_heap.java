import java.util.Arrays;
import java.util.Scanner;

class Build_heap {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] array = entrada.nextLine().split(" ");
		Heap heap = new Heap(array.length);

		heap.buildHeap(TurnToInt(array));

		System.out.println(heap.toString());

		entrada.close();
	}

	public static int[] TurnToInt(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;
	}
}

class Heap {
	private int[] heap;
	private int tail;

	public Heap(int capacidade) {
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public void buildHeap(int[] array) {
		heap = array;
		tail = array.length - 1;

		for (int i = array.length / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	public void add(int element) {
		tail += 1;
		this.heap[tail] = element;

		int i = tail;
		while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
			int aux = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = aux;
			i = parent(i);
		}
	}

	public int left(int index) {
		return 2 * index + 1;
	}

	public int right(int index) {
		return 2 * (index + 1);
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	private void heapify(int index) {
		if (isLeaf(index) || !isValidIndex(index)) {
			return;
		}

		// compares index, left and right to find max
		int index_max = max_index(index, left(index), right(index));

		// if current index is not greater than its children,
		// swap and keep heapifying.

		if (index_max != index) {
			swap(index, index_max);
			heapify(index_max);
		}
	}

	private boolean isLeaf(int index) {
		return index > parent(tail) && index <= tail;
	}

	private boolean isValidIndex(int index) {
		return index >= 0 && index <= tail;
	}

	private void swap(int index, int max_index) {
		int aux = this.heap[index];
		this.heap[index] = this.heap[max_index];
		this.heap[max_index] = aux;
	}

	private int max_index(int index, int left, int right) {
		if (this.heap[index] > this.heap[left]) {
			if (isValidIndex(right)) {
				if (this.heap[index] < this.heap[right])
					return right;
			}

			return index;

		} else {
			if (isValidIndex(right)) {
				if (this.heap[left] < this.heap[right])

					return right;
			}

			return left;
		}
	}

	public String toString() {
		return Arrays.toString(this.heap);
	}
}
