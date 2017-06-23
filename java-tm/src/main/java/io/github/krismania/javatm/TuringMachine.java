package io.github.krismania.javatm;

/**
 * Description of a Turing machine, including some metadata.
 */
public class TuringMachine
{
	private String name, description, author;
	private Machine machine;

	public void execute()
	{
		// TODO: Machine execution
	}
	
	@Override
	public String toString()
	{
		String format = "\"%s\" by %s - %s";
		return String.format(format, name, author, description);
	}
}
