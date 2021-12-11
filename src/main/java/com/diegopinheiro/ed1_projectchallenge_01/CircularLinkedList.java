package com.diegopinheiro.ed1_projectchallenge_01;

public class CircularLinkedList {
	private CircularListNode sentinel;

	public CircularLinkedList() {
		this.sentinel = new CircularListNode(null, null, null);
		this.sentinel.setNext(this.sentinel);
		this.sentinel.setPrevious(this.sentinel);
	}

	public boolean isEmpty() {
		return this.sentinel.getNext() == this.sentinel && this.sentinel.getPrevious() == this.sentinel;
	}

	public int size() {
		int size = 0;
		CircularListNode courrentNode = this.getHead();
		while (courrentNode != this.sentinel) {
			size++;
			courrentNode = courrentNode.getNext();
		}
		return size;
	}

	public void addFirst(Integer i) {
		CircularListNode oldHead = this.getHead();
		CircularListNode newFirstCircularNode = new CircularListNode(i, oldHead, this.sentinel);
		oldHead.setPrevious(newFirstCircularNode);
		this.setHead(newFirstCircularNode);
	}

	public void addLast(Integer i) {
		CircularListNode oldLastCircularNode = this.getTail();
		CircularListNode newLastCircularNode = new CircularListNode(i, this.sentinel, oldLastCircularNode);
		oldLastCircularNode.setNext(newLastCircularNode);
		this.sentinel.setPrevious(newLastCircularNode);

	}

	public CircularListNode search(Integer i) {
		CircularListNode courrentNode = this.getHead();
		while (courrentNode.getValue() != i && courrentNode != this.sentinel) {
			courrentNode = courrentNode.getNext();
		}
		return courrentNode == this.sentinel ? null : courrentNode;
	}

	public void delete(CircularListNode nodeDelete) {
		CircularListNode nodeDeletePrevious = nodeDelete.getPrevious();
		nodeDeletePrevious.setNext(nodeDelete.getNext());
		CircularListNode nodeDeleteNext = nodeDelete.getNext();
		nodeDeleteNext.setPrevious(nodeDeletePrevious);
	}

	public boolean isEquals(CircularLinkedList l2) {
		CircularListNode courrentNodeL2List = l2.getHead();
		CircularListNode courrentNodeThisList = this.getHead();

		if (l2.size() != this.size()) {
			return false;
		}
		while (courrentNodeThisList != this.sentinel) {
			if (courrentNodeL2List.equals(courrentNodeThisList)) {
				courrentNodeL2List = courrentNodeL2List.getNext();
				courrentNodeThisList = courrentNodeThisList.getNext();
			} else {
				return false;
			}
		}
		return true;
	}

	public void reverse() {
		CircularListNode courrentNode = this.sentinel;
		CircularListNode nextCourrentNode = this.getHead();
		do {
			courrentNode.setNext(courrentNode.getPrevious());
			courrentNode.setPrevious(nextCourrentNode);
			courrentNode = nextCourrentNode;
			nextCourrentNode = nextCourrentNode.getNext();
		} while (courrentNode != this.sentinel);
	}

	public boolean isOrdered(boolean ascending) {
		CircularListNode courrentNode = getHead();
		if (this.size() > 0) {
			while (courrentNode.getNext() != this.sentinel) {
				if (courrentNode.getValue() > courrentNode.getNext().getValue() && ascending) {
					return false;
				} else if (ascending == false && courrentNode.getValue() < courrentNode.getNext().getValue()) {
					return false;
				}
				courrentNode = courrentNode.getNext();
			}
		}
		return true;
	}

	public CircularLinkedList copy() {
		CircularLinkedList copiedList = new CircularLinkedList();
		CircularListNode thisCourrentNode = getHead();

		while (thisCourrentNode != this.sentinel) {
			copiedList.addLast(thisCourrentNode.getValue());
			thisCourrentNode = thisCourrentNode.getNext();
		}
		return copiedList;
	}

	public int get(int i) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		if (i == 0) {
			return getHead().getValue();
		}

		CircularListNode searchedNode = getHead();

		for (int j = 0; j < i; j++) {
			searchedNode = searchedNode.getNext();
			if (searchedNode == this.sentinel) {
				searchedNode = searchedNode.getNext();
			}
		}
		return searchedNode.getValue();
	}

	public void setHead(CircularListNode newHead) {
		this.sentinel.setNext(newHead);
	}

	public CircularListNode getTail() {
		return this.sentinel.getPrevious();
	}

	public CircularListNode getHead() {
		return this.sentinel.getNext();
	}

	public CircularListNode getSuccessor(CircularListNode currentNode){
		if (this.isEmpty()) {
			return null;
		}
		return currentNode.getNext() == this.sentinel ? this.getHead() : currentNode.getNext();
	}

}
