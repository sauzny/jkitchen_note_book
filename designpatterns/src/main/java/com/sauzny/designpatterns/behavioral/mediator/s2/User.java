package com.sauzny.designpatterns.behavioral.mediator.s2;

import com.sauzny.designpatterns.behavioral.mediator.s1.ChatRoom;

public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}
