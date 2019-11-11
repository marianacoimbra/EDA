import java.util.ArrayList;


import java.util.Scanner;

class BFS_direita {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] array = entrada.nextLine().split(" ");
		
		int[] inteiros = turnToInt(array);
		
		BFSDireita bst = new BFSDireita();

		for (int element : inteiros) {
			bst.add(element);
		}
		
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Node> queue = new ArrayList<Node>();

		int index = -1, qtdElements = bst.qtdElements - 1;
		queue.add(bst.getRoot());

		while (index < qtdElements) {
			r.add(queue.get(++index).data);
			if (queue.get(index).right != null)
				queue.add(queue.get(index).right);
			if (queue.get(index).left != null)
				queue.add(queue.get(index).left);
		}

		for (int i = 0; i <= qtdElements; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(r.get(i));
		}
		System.out.println();
		entrada.close();
	}
	
	static int[] turnToInt(String[] array) {
		int[] aux = new int[array.length];
		for(int i = 0; i<array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;
	}
}

class Node {

	int data;
	Node left;
	Node right;
	Node parent;

	public Node(int value) {
		this.data = value;
	}

	public Node(int value, Node parent) {
		this.data = value;
		this.parent = parent;
	}

	public void add(int value) {
		if (value > this.data) {
			if (this.right == null) {
				this.right = new Node(value, this);
			} else {
				this.right.add(value);
			}
		} else if (value < this.data) {
			if (this.left == null) {
				this.left = new Node(value, this);
			} else {
				this.left.add(value);
			}
		}
	}
}

class BFSDireita {

	private Node root;
	int qtdElements = 0;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		qtdElements++;
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
	}

	public Node getRoot() {
		return this.root;
	}

}
