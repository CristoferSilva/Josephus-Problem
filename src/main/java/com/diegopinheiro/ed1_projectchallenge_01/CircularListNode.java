package com.diegopinheiro.ed1_projectchallenge_01;

public class CircularListNode {
	private Integer value;
	private CircularListNode next;
	private CircularListNode previous;

	public CircularListNode(Integer i, CircularListNode next, CircularListNode previous) {
		this.value = i;
		this.next = next;
		this.previous = previous;
	}

	public int getValue() {
		return this.value;
	}

	public CircularListNode getPrevious() {
		return this.previous;
	}

	public CircularListNode getNext() {
		return this.next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(CircularListNode next) {
		this.next = next;
	}

	public void setPrevious(CircularListNode previous) {
		this.previous = previous;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CircularListNode) {
			CircularListNode nodeCompare = (CircularListNode) obj;
			return nodeCompare.getValue() == this.getValue();
		}
		return false;
	}

}
