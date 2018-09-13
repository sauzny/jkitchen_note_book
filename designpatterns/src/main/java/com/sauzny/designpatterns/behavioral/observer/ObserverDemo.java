package com.sauzny.designpatterns.behavioral.observer;

import com.sauzny.designpatterns.behavioral.observer.s1.Subject;
import com.sauzny.designpatterns.behavioral.observer.s3.BinaryObserver;
import com.sauzny.designpatterns.behavioral.observer.s3.HexaObserver;
import com.sauzny.designpatterns.behavioral.observer.s3.OctalObserver;

public class ObserverDemo {

	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}
