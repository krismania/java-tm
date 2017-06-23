package io.github.krismania.javatm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Contains a single 2-way infinite tape. 
 */
class Tape
{
	private Stack<Character> left;
	private char current;
	private Stack<Character> right;
	
	private final char empty; // the tape's blank symbol
	
	public Tape(String contents, char empty)
	{
		this.empty = empty;
		
		// init stacks
		left = new Stack<Character>();
		right = new Stack<Character>();
		
		// reverse contents string (it will be pushed into last-first) and split
		// it into a character array. First character of contents is excluded (this
		// becomes the current symbol)
		char[] contentsArray = new StringBuilder(contents.substring(1)).reverse().toString().toCharArray();
		
		// push characters to the right stack to fill the tape
		for (char c : contentsArray) { right.push(c); }
		
		// copy the first contents char into the current position
		current = contents.charAt(0);
	}
	
	/**
	 * Returns the currently scanned character
	 */
	public char scan()
	{
		return current;
	}
	
	public void write(char c)
	{
		current = c;
	}
	
	/**
	 * Moves the tape head in the specified direction.
	 */
	public void move(Direction d)
	{
		switch (d)
		{
			case LEFT:
				right.push(current);
				if (left.empty())
				{
					current = empty;
				}
				else
				{
					current = left.pop();
				}
				break;
			case RIGHT:
				left.push(current);
				if (right.empty())
				{
					current = empty;
				}
				else
				{
					current = right.pop();
				}
				break;
		}
	}
	
	@Override
	public String toString()
	{
		ArrayList<Character> leftArray = new ArrayList<Character>(left);
		ArrayList<Character> rightArray = new ArrayList<Character>(right);
		
		Collections.reverse(rightArray);
		// required as the bottom of the stack (the leftmost char) will be at the
		// end of the ArrayList.
		
		// join the two arrays together with the current symbol in between.
		// also adds a blank symbol to either end.
		ArrayList<Character> outputArray = new ArrayList<Character>();
		outputArray.add(empty);
		outputArray.addAll(leftArray);
		outputArray.add(current);
		outputArray.addAll(rightArray);
		outputArray.add(empty);
		
		// build output from the new array
		StringBuilder output = new StringBuilder("|");
		
		for (int i = 0; i < outputArray.size(); i++)
		{
			// check if this is the currently scanned symbol
			if (i == (leftArray.size() + 1))
			{
				// if it is, add brackets to output to signify
				output.append("[" + outputArray.get(i) + "]|");
			}
			else
			{
				// else output regularly
				output.append(" " + outputArray.get(i) + " |");
			}
		}
		
		return output.toString();
	}
}
