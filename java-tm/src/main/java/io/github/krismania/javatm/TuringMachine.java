package io.github.krismania.javatm;

/**
 * Description of a Turing machine, including some metadata.
 */
public class TuringMachine
{
	private String name, description, author;
	private Machine machine;

	public void initTape(String contents)
	{
		machine.initTape(contents);
	}
	
	public void execute()
	{
		machine.execute();
	}
	
	@Override
	public String toString()
	{
		String format = "\"%s\" by %s - %s";
		return String.format(format, name, author, description);
	}
}
