package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class NegateCommand extends OneArgumentCommand {

	public NegateCommand(Stack<Double> numberStack) {
		super(numberStack);
	}
	
	@Override
	protected double doMaths() {
		return (-1) * getValuePopped();
	}
	
}