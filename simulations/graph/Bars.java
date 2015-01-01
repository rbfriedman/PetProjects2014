package graph;

import java.util.Stack;


public class Bars extends Stack<Bar> {
	public void addBar(Bar bar){
		this.add(bar);
	}
	
	public Bar getBar(){
		return this.pop();
	}
}
