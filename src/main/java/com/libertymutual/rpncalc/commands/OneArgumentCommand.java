package com.libertymutual.rpncalc.commands;

import java.util.Stack;

public abstract class OneArgumentCommand implements Undoable {
	
	private Stack<Double> numberStack;
	private double valuePopped;

	public OneArgumentCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		valuePopped = numberStack.pop();
		double result = doMaths();
		numberStack.push(result);
	}
	
	protected abstract double doMaths();
	
	@Override
	public void undo() {
		numberStack.pop();
		numberStack.push(valuePopped);
	}
	
	protected double getValuePopped() {
		return valuePopped;
	}
}
