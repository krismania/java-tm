package io.github.krismania.javatm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class App 
{
    public static void main(String[] args)
    {
    	if (args.length == 2)
    	{
    		String tmFile = args[0];
    		String initialTape = args[1];
    		
    		try (InputStreamReader file = new InputStreamReader(new FileInputStream(tmFile), "UTF-8"))
    		{
    			Gson gson = new Gson();
    			
    			// load TM from json
    	        TuringMachine tm = gson.fromJson(file, TuringMachine.class);     
    	        System.out.println(tm);
    	        
    	        // initialize the tape
    	        tm.initTape(initialTape);
    	        
    	        // execute machine
    	        tm.execute();
    		}
    		catch (IOException e)
    		{
    			System.out.println("There was an error opening the file.");
    		}
    	}
    	else
    	{
    		System.out.println("Please supply the path to a TM Json and an initial tape.");
    	}
    }
}
