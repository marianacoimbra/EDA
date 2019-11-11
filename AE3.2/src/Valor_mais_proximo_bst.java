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

	public BTNode search(int value) {
		return search(this.root, value);
	}

	private BTNode search(BTNode node, int value) {
		if (node == null) {
			return null;
		}
		if (value == node.data) {
			return node;
		}
		if (value < node.data) {
			return search(node.left, value);
		} else if (value > node.data) {
			return search(node.right, value);
		}
	}

	public void preOrder() {
		if (!isEmpty()) {
			this.root.preOrder();
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

	public void preOrder() {
		System.out.println(this.data + " ");
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
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

}