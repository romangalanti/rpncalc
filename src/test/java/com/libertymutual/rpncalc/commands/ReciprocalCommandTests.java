package com.libertymutual.rpncalc.commands;

import static org.assertj.core.api.Assertions.*;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class ReciprocalCommandTests {

	private Stack<Double> stack;
	private ReciprocalCommand command;

	@Test
	public void test_reciprocal_for_most_recently_added_value_to_stack() {
		//Arrange
		stack.push(2.0);
		
		//Act
		command.execute();
		
		//Assert
		assertThat(stack).hasSize(1);
		assertThat(stack).contains(.5);
	}
	
	@Test
	public void test_reciprocal_undo() {
		//Arrange
		stack.push(2.0);
		command.execute();
		
		//Act
		command.undo();
		
		//Assert
		assertThat(stack).hasSize(1);
		assertThat(stack).contains(2.0);
	}
	
	@Before
	public void setUp() {
		stack = new Stack<Double>();
		command = new ReciprocalCommand(stack);
		
	}

}
