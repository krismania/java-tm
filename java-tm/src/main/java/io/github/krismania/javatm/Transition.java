package io.github.krismania.javatm;

/**
 * Describes a single transition for the TM.
 */
class Transition
{
	public final String stateIn, stateOut;
	public final char read, write;
	public final Direction move;
	
	public Transition(String stateIn, char read, String stateOut, char write, Direction move)
	{
		this.stateIn = stateIn;
		this.read = read;
		this.stateOut = stateOut;
		this.write = write;
		this.move = move;
	}
	
	@Override
	public String toString()
	{
		String format = "StateIn:%s,Read:'%c',Write:'%c',Move:%s,StateOut:%s";
		return String.format(format, stateIn, read, write, move.toString(), stateOut);
	}
}
