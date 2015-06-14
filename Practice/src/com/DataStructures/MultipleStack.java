/*Describe how you could use a single array to implement three stacks.*/

package com.DataStructures;

import java.util.Arrays;
//import...

public class MultipleStack{
    int stackSize;
    int numberOfStacks;
    int [] multipleStack;
    int [] topOfStack;

    public MultipleStack(int p_stackSize, int p_numberOfStacks){
	    assert p_stackSize > 0      : "stackSize must be > 0";
	    assert p_numberOfStacks > 0 : "numberOfStacks must be > 0";
	    stackSize = p_stackSize;
	    numberOfStacks = p_numberOfStacks;
	    multipleStack = new int [stackSize * numberOfStacks];
	    topOfStack = new int [p_numberOfStacks];
	    Arrays.fill(topOfStack, -1);
	}

	protected void pushToStack(int p_stackNumber, int p_value){
	    assert (p_stackNumber > 0 && p_stackNumber <= numberOfStacks) : "That’s a not valid Stack";
	    p_stackNumber--;
	    assert (!isStackFull(p_stackNumber)) : "Stack "+(p_stackNumber+1)+" is full";
	    topOfStack[p_stackNumber]++;
	    multipleStack[getTopStackIndex(p_stackNumber)] = p_value;
	    
	}
	
	protected int popToStack(int p_stackNumber){
	assert (p_stackNumber > 0 && p_stackNumber <= numberOfStacks) : "That’s a not valid Stack";
	p_stackNumber--;
	    assert (!isStackEmpty(p_stackNumber)): "Stack "+(p_stackNumber + 1) + "is already empty";
	    topOfStack[p_stackNumber]--;
	    return multipleStack[getTopStackIndex(p_stackNumber) + 1];
	}
	
	protected int getTopStackIndex(int p_stackNumber){
	    return (p_stackNumber * stackSize) + (topOfStack[p_stackNumber]);
	}
	
	protected boolean isStackFull(int p_stackNumber){
	    return (topOfStack[p_stackNumber]>=(stackSize-1));
	}
	
	protected boolean isStackEmpty(int p_stackNumber){
	    return (topOfStack[p_stackNumber]<0);
	}
	
	public String toString(){
	    StringBuffer output = new StringBuffer("");
	    for(int i=0;i<numberOfStacks;i++){
	    	output.append("Stack #" + (i+1) + ": ");
	        if(!isStackEmpty(i)) 
	        	output.append(Arrays.toString(Arrays.copyOfRange(multipleStack, (i * stackSize), (getTopStackIndex(i)+1))));
	        output.append("\n");
	    }
	    return output.toString();
	}
	
	public static void main(String [] args){
	    int stacks = 4;
	    int stackSize = 3;
	    MultipleStack ms = new MultipleStack(stackSize, stacks);
	    int l_stack = 2;
	    int l_value = 999;
	    
	    
	    ms.pushToStack(l_stack, l_value);
	    ms.pushToStack(l_stack, l_value);
	    ms.pushToStack(1, l_value);
	    ms.pushToStack(l_stack, l_value);
	    System.out.println(ms);
	    ms.popToStack(l_stack);
	    System.out.println(ms);
	}
}