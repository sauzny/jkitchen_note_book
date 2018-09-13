package com.sauzny.designpatterns.behavioral.visitor.s3;

import com.sauzny.designpatterns.behavioral.visitor.s2.Computer;
import com.sauzny.designpatterns.behavioral.visitor.s2.Keyboard;
import com.sauzny.designpatterns.behavioral.visitor.s2.Monitor;
import com.sauzny.designpatterns.behavioral.visitor.s2.Mouse;

public interface ComputerPartVisitor {
	
	void visit(Computer computer);

	void visit(Mouse mouse);

	void visit(Keyboard keyboard);

	void visit(Monitor monitor);
}
