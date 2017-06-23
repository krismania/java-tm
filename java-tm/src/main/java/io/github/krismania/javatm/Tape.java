package io.github.krismania.javatm;

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
		
		// put a blank char on the ends of the tape
		left.push(empty);
		right.push(empty);
		// also set current symbol to blank
		current = empty;
		
		// reverse contents string (it will be pushed into last-first) and split
		// it into a character array.
		char[] contentsArray = new StringBuilder(contents).reverse().toString().toCharArray();
		
		// push characters to the right stack to fill the tape
		for (char c : contentsArray) { right.push(c); }
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
		// TODO: Move the tape
	}
	
	@Override
	public String toString()
	{
		// TODO: Print contents of tape
		return "Tape";
	}
}
