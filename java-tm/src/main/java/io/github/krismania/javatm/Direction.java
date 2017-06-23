package io.github.krismania.javatm;

import com.google.gson.annotations.SerializedName;

public enum Direction
{
	@SerializedName("L")
	LEFT(-1),
	@SerializedName("R")
	RIGHT(1);
	
	private int value;
	
	Direction(int value)
	{
		this.value = value;
	}
	
	Direction(char dir)
	{
		switch (dir)
		{
			case 'L': this.value = -1;
			case 'R': this.value = 1;
			default: throw new IllegalArgumentException("Direction must be L or R.");
		}
	}
	
	public int getValue()
	{
		return value;
	}
}
