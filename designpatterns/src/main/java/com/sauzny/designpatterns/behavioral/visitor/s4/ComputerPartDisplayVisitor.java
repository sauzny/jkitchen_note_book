package com.sauzny.designpatterns.behavioral.visitor.s4;

import com.sauzny.designpatterns.behavioral.visitor.s2.Computer;
import com.sauzny.designpatterns.behavioral.visitor.s2.Keyboard;
import com.sauzny.designpatterns.behavioral.visitor.s2.Monitor;
import com.sauzny.designpatterns.behavioral.visitor.s2.Mouse;
import com.sauzny.designpatterns.behavioral.visitor.s3.ComputerPartVisitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor.");
	}
}