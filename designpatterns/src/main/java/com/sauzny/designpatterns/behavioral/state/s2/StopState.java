package com.sauzny.designpatterns.behavioral.state.s2;

import com.sauzny.designpatterns.behavioral.state.s1.State;
import com.sauzny.designpatterns.behavioral.state.s3.Context;

public class StopState implements State {

	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}

	public String toString() {
		return "Stop State";
	}
}