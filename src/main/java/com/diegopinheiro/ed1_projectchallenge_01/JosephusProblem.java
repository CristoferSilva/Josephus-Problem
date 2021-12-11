package com.diegopinheiro.ed1_projectchallenge_01;

public class JosephusProblem {
	

	public static Integer[] solve(int m, int numberOfPeople){
		int score = 0;
		CircularListNode courrentPerson;
		CircularLinkedList people = new CircularLinkedList();
		Integer[] eliminatedPeople = new Integer[numberOfPeople];
		
		for (int i = 0; i < numberOfPeople; i++) {
			people.addLast(i);
		}
		courrentPerson = people.getHead();
		
		while(!people.isEmpty()) {
			for (int i = 0; i < m - 1; i++) {
				courrentPerson = people.getSuccessor(courrentPerson);
			}
			people.delete(courrentPerson);
			eliminatedPeople[score] = courrentPerson.getValue();
			courrentPerson = people.getSuccessor(courrentPerson);
			score++;
		}
		return eliminatedPeople;
	}
}
