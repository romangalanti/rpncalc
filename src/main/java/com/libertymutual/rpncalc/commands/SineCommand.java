package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public class SineCommand extends OneArgumentCommand {
	
	public SineCommand(Stack<Double> numberStack) {
		super(numberStack);		
	}
	
	@Override
	protected double doMaths() {
		return Math.sin(getValuePopped());
	}
}