package io.github.krismania.javatm;

/**
 * Describes a single transition for the TM.
 */
class Transition
{
	private String stateIn, stateOut;
	private char read, write;
	private Direction move;
	
	@Override
	public String toString()
	{
		String format = "StateIn:%s,Read:'%c',Write:'%c',Move:%s,StateOut:%s";
		return String.format(format, stateIn, read, write, move.toString(), stateOut);
	}
}
