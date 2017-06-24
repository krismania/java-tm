# java-tm
A Turing machine simulator in Java. Probably not very useful or robust, but it _does_ work!

### Compilation
Use Maven with the `mvn package` command to compile to a runnable jar, or download the compiled jar from [Releases](https://github.com/krismania/java-tm/releases)

### Usage
Java-tm accepts 2 command line arguments: the location of a json TM description, and a string representing the initial tape. For example: `java -jar jtm.jar /path/to/tm.json 00101110`

#### Json Format
Java-tm expects a json file with the following structure:
```
{
	"name": "Name of Machine",
	"description": "Short description",
	"author": "Author Name",
	"machine": {
		"empty": "ϵ",                   <-- the symbol to be considered "blank"
		"initialState": "init",         <-- the initial state of the machine
		"finalStates": [ "done" ],      <-- array of final, accepting states
		"transitions": [ ... ]          <-- array of transitions (see below)
	}
}
```

A transition has the following structure:
```
{"stateIn": "q0", "stateOut": "q1", "read": "0", "write": "1", "move": "R"}
```
This describes a transition where the machine is in state 'q0' and reads '0', it will write '1', change to state 'q1' and move the tape right. **States** (e.g. initialState, stateIn) are represented as strings, and **Symbols** (e.g. empty, write) should be single characters. Additionally, each transition's **move** value must be `L` or `R`.

_See the supplied sample machine (incrementor.json) for an example._

### Issues
What is non-determinism? This program certainly doesn't know.
