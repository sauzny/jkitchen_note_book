package com.sauzny.designpatterns.behavioral.visitor;

import com.sauzny.designpatterns.behavioral.visitor.s1.ComputerPart;
import com.sauzny.designpatterns.behavioral.visitor.s2.Computer;
import com.sauzny.designpatterns.behavioral.visitor.s4.ComputerPartDisplayVisitor;

public class VisitorDemo {

	public static void main(String[] args) {

		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}

}
