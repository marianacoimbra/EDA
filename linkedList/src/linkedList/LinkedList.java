package linkedList;

import linkedList.LinkedList;

// AE 2.3: Lista duplamente encadeada

class DoubleRecursiveLinkedListImpl implements LinkedList {
	private Node head;
	private Node last;

	public DoubleRecursiveLinkedListImpl() {
		this.head.setData(null);
		this.last.setData(null);
	}

	public boolean isEmpty() {
		return (this.head == null);
	}

	@Override
	public void addLast(int elemento) {
		if (isEmpty()) {
			this.head = new Node(elemento);
		} else {
			this.addLast(this.head, elemento);
		}
	}

	private void addLast(Node node, int elemento) {
		if (node.next == null) {
			Node newNode = new Node(elemento);
			node.setNext(newNode);
			newNode.setPrevious(node);
			return;
		} else {
			addLast(node.next, elemento);
		}
	}

	// retorna a quantidade de elementos da lista

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return size(this.head);
		}
	}

	private int size(Node node) {
		if (node.getData() == null) {
			return 0;
		} else {
			return 1 + size(node.next);
		}
	}

	// retorna a soma de todos os elementos da lista

	@Override
	public int soma() {
		return this.soma(this.head);
	}

	private int soma(Node node) {
		if (node.getData() == null) {
			return 0;
		} else {
			return node.getData() + soma(node.next);
		}
	}

	// retorna se a lista está ordenada
	@Override
	public boolean isSorted() {
		return false;
		// TODO Auto-generated method stub
	}

	// adiciona o elemento em um determinado índice. Aqui você não pode alterar o
	// elemento que já está no índice. Deve encaixar o novo.
	@Override
	public void add(int index, int elemento) {
		if (isEmpty()) {
			head = new Node();
			last = new Node();
		}
		// add antes do head
		if (index == 0) {
			Node newNode = new Node(elemento);
			head.setPrevious(newNode);
			head = newNode;
			head.setPrevious(new Node());
		}
		if (index == this.size()) {
			Node newNode = new Node(elemento);
			newNode.setPrevious(last);
			this.last.setNext(newNode);
		} else {
			Node nodeRef = head;
			for (int i = 0; i < index; i++) {
				nodeRef = nodeRef.next;
			}
			Node newNode = new Node(elemento);
			newNode.setNext(nodeRef.next);
			nodeRef.setNext(newNode);
			newNode.setPrevious(nodeRef);
			newNode.next.previous = new Node();
		}
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

}

class Node {
	Integer data;
	Node next;
	Node previous;

	public Node(int elemento) {
		this.setData(elemento);
		this.setNext(null);
		this.setPrevious(null);
	}

	public Node() {

	}

	public Integer getData() {
		return this.data;
	}

	public Integer getNext() {
		return this.next.getData();
	}

	public Integer getPrevious() {
		return this.previous.getData();
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}

public interface LinkedList {

	// Recursivos

	public void addLast(int elemento);

	public int size();

	public int soma();

	public boolean isSorted();

	// Iterativos

	public void add(int index, int elemento);

	public void remove(int index);
}
