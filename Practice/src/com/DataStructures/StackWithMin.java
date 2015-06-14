/*How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should
all operate in O(1) time.*/
package com.DataStructures;

import java.util.Stack;

public class StackWithMin{

    Stack<Integer> intStack;
    Stack<Integer> minStack;

    public StackWithMin(){
        intStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

	protected void push(int p_intVal){
	    intStack.push(p_intVal);
	    if(minStack.empty())
	        minStack.push(p_intVal);
	    else
	        if(minStack.peek()>=p_intVal)
	            minStack.push(p_intVal);
	}
	
	protected int pop(){
	    assert !intStack.empty() : "intStack is already empty";
	    if(intStack.peek() == minStack.peek())
	        minStack.pop();
	    return intStack.pop();
	}
	
	protected int peek(){
	    return intStack.peek();
	}
	
	protected int peekMin(){
	    return minStack.peek();
	}
	
	
	public static void main(String [] args){
	    StackWithMin swm = new StackWithMin();
	    swm.push(10);
	    swm.push(3);
	    swm.push(4);
	    System.out.println("Min within stack is " + swm.peekMin());
	    swm.pop();
	    System.out.println("Min within stack is " + swm.peekMin());
	    swm.pop();
	    System.out.println("Min within stack is " + swm.peekMin());
	}    
}