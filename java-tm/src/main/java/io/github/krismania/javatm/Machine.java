package io.github.krismania.javatm;

import java.util.ArrayList;

/**
 * Contains instructions on how the TM will operate, including things such as the
 * machine's blank character, its initial and final states, and a list of transitions
 */
class Machine
{
	private char empty;
	private String initialState;
	private ArrayList<String> finalStates;
	private ArrayList<Transition> transitions;
	private Tape tape;
	
	private String currentState; // stores the current state of execution
	private boolean halt; // set to true once the machine cannot transition
	
	public void initTape(String contents)
	{
		tape = new Tape(contents, empty);
	}
	
	public Tape getTape()
	{
		return tape;
	}
	
	public void execute()
	{
		// set current state to the initial state
		setState(initialState);
		// reset halt flag
		halt = false;
		
		// execute until halting
		System.out.println(tape);
		while (!halt)
		{
			executeStep();
		}
	}
	
	/**
	 * Executes a single step in the machine's computation by writing to and 
	 * moving the tape based on it's contents and the current state
	 */
	private void executeStep()
	{
		Transition t = getTransition(currentState, tape.scan());
		if (t != null)
		{
			// execute the transition
			tape.write(t.write);
			tape.move(t.move);
			
			// update machine state
			currentState = t.stateOut;
		}
		else
		{
			halt = true;
		}
		
		System.out.println(currentState + " // " + tape);
	}
	
	/**
	 * Sets the current state of the machine to the given state
	 */
	private void setState(String state)
	{
		currentState = state;
	}
	
	/**
	 * Returns the transition applicable to the given state and tape symbol,
	 * or null if there is none.
	 * TODO: Only returns 1 transition, meaning non-deterministic machines
	 * cannot be correctly simulated
	 */
	private Transition getTransition(String state, char input)
	{
		// search through the transitions
		for (Transition t : transitions)
		{
			// if stateIn matches & input match, return this state
			if (t.stateIn.equals(state) && t.read == input)
			{
				return t;
			}
		}
		return null; // no transition found
	}
	
	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		output.append(String.format("Initial:%s,Final:%s,Blank:'%c'\n", initialState, finalStates.toString(), empty));
		
		for (Transition t : transitions)
		{
			output.append(t.toString() + "\n");
		}
		
		return output.toString();
	}
}
