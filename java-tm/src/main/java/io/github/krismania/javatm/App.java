package io.github.krismania.javatm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;

public class App 
{
    public static void main(String[] args) throws FileNotFoundException
    {
    	FileReader fr = new FileReader(new File("../incrementor.json"));
        Gson gson = new Gson();
        
        // load TM from json
        TuringMachine tm = gson.fromJson(fr, TuringMachine.class);     
        System.out.println(tm);
        
        // initialize the tape
        tm.initTape("10100111");
        
        // execute machine
        tm.execute();
    }
}
