import java.util.Scanner;

public class Valor_mais_proximo_bst {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String[] array = entrada.nextLine().split(" ");
		int[] inteiros = new int[array.length];
		BST bst = new BST();

		for (int i = 0; i < inteiros.length; i++) {
			inteiros[i] = Integer.parseInt(array[i]);
		}

		// preenchimento da bst
		for (int i = 0; i < inteiros.length; i++) {
			bst.insert(inteiros[i]);
		}

	}

}

class BST {
	BTNode root;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void insert(int value) {
		if (isEmpty()) {
			this.root = new BTNode(value);
		} else {
			this.root.insert(value);
		}
	}
}

class BTNode {
	int data;
	BTNode right;
	BTNode left;
	BTNode parent;

	public BTNode(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value > this.data) {
			if (this.right == null) {
				BTNode newNode = new BTNode(value);
				this.right = newNode;
				newNode.parent = this;
			} else {
				this.right.insert(value);
			}
		} else if (value < this.data) {
			if (this.left == null) {
				BTNode newNode = new BTNode(value);
				this.left = newNode;
				newNode.parent = this;
			}
		}
	}
	
	public void inOrder() {
		if(this.left != null) {
			this.left.inOrder();
		}
		System.out.print(this.data + " ");
		if(this.right != null) {
			this.right.inOrder();
		}
	}
	
}