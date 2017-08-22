package com.libertymutual.rpncalc.commands;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class AddCommandTests {

	private Stack<Double> stack;
	private AddCommand command;
	
	@Test
	public void test_undo_restores_the_stack_state_after_execute() {
		// Arrange
		stack.push(1.0);
		stack.push(2.99999999);
		command.execute();
		
		// Act
		command.undo();
		
		//Assert
		assertThat(stack).hasSize(2);
		assertThat(stack.pop()).isEqualTo(2.99999999);
		assertThat(stack.pop()).isEqualTo(1.0);
	}

	@Test
	public void test_execute_sums_two_most_recently_added_numbers_in_the_stack() {
		// Arrange
		stack.push(4.5);
		stack.push(3.0);
		//stack.push(1.1);
		//stack.push(3.2);
		
		// Act
		command.execute();
		
		// Assert
		assertThat(stack).hasSize(1);
		assertThat(stack).contains(7.5);
		// assertThat(stack.pop()).isCloseTo(4.3, within(0.0000001));
	}
	
	@Before
	public void setUp() {
		stack = new Stack<Double>();
		command = new AddCommand(stack);
	}

}
