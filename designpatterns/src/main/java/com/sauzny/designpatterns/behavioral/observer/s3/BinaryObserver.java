package com.sauzny.designpatterns.behavioral.observer.s3;

import com.sauzny.designpatterns.behavioral.observer.s1.Subject;
import com.sauzny.designpatterns.behavioral.observer.s2.Observer;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
	}
}