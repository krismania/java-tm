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
	
	public void initTape(String contents)
	{
		tape = new Tape(contents, empty);
	}
	
	public Tape getTape()
	{
		return tape;
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
