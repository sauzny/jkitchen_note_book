package com.sauzny.designpatterns.behavioral.mediator.s1;

import java.util.Date;

import com.sauzny.designpatterns.behavioral.mediator.s2.User;

public class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
	}
}
