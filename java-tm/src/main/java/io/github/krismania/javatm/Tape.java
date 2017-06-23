package io.github.krismania.javatm;

import java.util.Stack;

/**
 * Contains a single 2-way infinite tape. 
 */
class Tape
{
	private final char empty;
	
	private Stack<Character> left;
	private char current;
	private Stack<Character> right;
	
	public Tape(String contents, char empty)
	{
		this.empty = empty;
		
		// TODO: Copy contents to tape
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
