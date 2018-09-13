package com.sauzny.designpatterns.behavioral.observer.s1;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.designpatterns.behavioral.observer.s2.Observer;

public class Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
