package com.libertymutual.rpncalc.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.rpncalc.commands.AddCommand;
import com.libertymutual.rpncalc.commands.ClearCommand;
import com.libertymutual.rpncalc.commands.DivideCommand;
import com.libertymutual.rpncalc.commands.MultiplyCommand;
import com.libertymutual.rpncalc.commands.NegateCommand;
import com.libertymutual.rpncalc.commands.PushCommand;
import com.libertymutual.rpncalc.commands.ReciprocalCommand;
import com.libertymutual.rpncalc.commands.SquareRootCommand;
import com.libertymutual.rpncalc.commands.SubtractCommand;
import com.libertymutual.rpncalc.commands.SwapCommand;
import com.libertymutual.rpncalc.commands.Undoable;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	Stack<Double> numberStack;
	Stack<Undoable> commandHistory;
	
	public CalculatorController() {
		numberStack = new Stack<Double>();
		commandHistory = new Stack<Undoable>();
	}
	
	@PostMapping("values")
	public String pushValueOntoStack(double enteredValue) {
		PushCommand command = new PushCommand(enteredValue, numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/clear")
	public String clearStack() {
		ClearCommand command = new ClearCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/undo")
	public String undoTheLastCommand() {
		if (commandHistory.size() > 0) {
			Undoable command = commandHistory.pop();
			command.undo();
		}
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/add")
	public String addTheTwoTopStackNumbers() {
		AddCommand command = new AddCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/subtract")
	public String subtractTheTwoTopStackNumbers() {
		SubtractCommand command = new SubtractCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/multiply")
	public String multiplyTheTwoTopStackNumbers() {
		MultiplyCommand command = new MultiplyCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/divide")
	public String divideTheTwoTopStackNumbers() {
		DivideCommand command = new DivideCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/reciprocal")
	public String reciprocalTheNumber() {
		ReciprocalCommand command = new ReciprocalCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/squareroot")
	public String SquareRootTheNumber() {
		SquareRootCommand command = new SquareRootCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}

	@PostMapping("operation/negate")
	public String negateTheTwoTopStackNumbers() {
		NegateCommand command = new NegateCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/swap")
	public String swapTheTwoTopStackNumbers() {
		SwapCommand command = new SwapCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@GetMapping("")
	public String showCalculatorHomePage(Model model) {
		model.addAttribute("stack", numberStack);
		model.addAttribute("canShowBinaryOperator", numberStack.size() > 1);
		model.addAttribute("canShowUnaryOperator", numberStack.size() > 0);
		model.addAttribute("undoSize", commandHistory.size());
		return "calculator/calculator-form";
	}

}
