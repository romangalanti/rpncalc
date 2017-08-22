package com.libertymutual.rpncalc.commands;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class SineCommandTests {

	private Stack<Double> stack;
	private SineCommand command;

	@Test
	public void test_sine_command() {
		//Arrange
		stack.push(45.0);
		
		//Act
		command.execute();
		
		//Assert
		assertThat(stack).hasSize(1);
		assertThat(stack.pop()).isCloseTo(Math.sin(45.0), within(0.0000001));
		
	}
	
	@Test
	public void undo_sine_command() {
		//Arrange
		stack.push(45.0);
		command.execute();
		
		//Act
		command.undo();
		
		//Assert
		assertThat(stack).hasSize(1);
		assertThat(stack.pop()).isCloseTo(45.0, within(0.0000001));
	}
	
	@Before
	public void setUp() {
		stack = new Stack<Double>();
		command = new SineCommand(stack);
	}

}
