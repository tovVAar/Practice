/*Implement a MyQueue class which implements a queue using two stacks.*/
package com.DataStructures;

//imports
import java.util.Stack;

public class MyQueue{
    Stack<Integer> newNodes, oldNodes;

    public MyQueue(){
        newNodes = new Stack<Integer>();
        oldNodes = new Stack<Integer>();
	}
	
	protected void reAllocateStack(Stack<Integer> p_from, Stack<Integer> p_to){
	    while(!p_from.empty()){
	        p_to.push(p_from.pop());
	    }
	}
	
	    protected void push(int p_data){
	    if(!oldNodes.empty())
	        reAllocateStack(oldNodes, newNodes);
	    newNodes.push(p_data);    
	}
	
	protected int pop(){
	    assert (!newNodes.empty() || !oldNodes.empty()): "Queue is already empty n_n’";
	    if(!newNodes.empty())
	        reAllocateStack(newNodes, oldNodes);
	    return oldNodes.pop();
	}
	
	public static void main(String[] args){
	    MyQueue mq = new MyQueue();
	    mq.push(1);
	    mq.push(2);
	    mq.push(33);
	    mq.push(4);
	    mq.push(5);
	    System.out.println(mq.pop());
	    System.out.println(mq.pop());
	    System.out.println(mq.pop());
	    System.out.println(mq.pop());
	    mq.push(6);
	    mq.push(7);
	    System.out.println(mq.pop());
	    System.out.println(mq.pop());
	}
}