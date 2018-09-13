package com.sauzny.designpatterns.behavioral.state.s2;

import com.sauzny.designpatterns.behavioral.state.s1.State;
import com.sauzny.designpatterns.behavioral.state.s3.Context;

public class StartState implements State {

	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString() {
		return "Start State";
	}
}