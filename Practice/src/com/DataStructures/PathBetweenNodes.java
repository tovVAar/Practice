/*Given a directed graph, design an algorithm to find out whether there is a route
between two nodes*/
package com.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//imports
class PathBetweenNodes{
    class Node{
	    List<Node> paths;
	    char data; 
	    boolean wasVisited;
    
	    public Node(char p_data){
		    data = p_data;
		    paths = new ArrayList<Node>();
		    wasVisited = false;
		}
	    
	    public Node(){
		    data = ' ';
		    paths = new ArrayList<Node>();
		    wasVisited = false;
		}

		protected void addPath(Node p_node){
		    paths.add(p_node);
		}
	
		@Override
		public boolean equals(Object p_obj){
		    if(p_obj == null)
		        return false;
		    if(p_obj == this)
		        return true;
		    else
		    	return false;
		}
    }
    

    public boolean searchDFS(Node p_node, Node p_target, Stack<Node> p_foundPath){
	    if(p_node == null || p_target == null)
	        return false;
		if(p_node.equals(p_target)){
			p_foundPath.push(p_node);
		    return true;
	    }
	    else{
	    p_node.wasVisited = true;
	    boolean isCorrectPath = false;
	    for(Node i_node : p_node.paths){
		    if(i_node.wasVisited == false){
		        isCorrectPath = searchDFS(i_node, p_target, p_foundPath);
		        if(isCorrectPath){
		        	p_foundPath.push(p_node);
		            return true;
		        }
		    }
	    }
	return false;
	}
}
    
    protected void printPath(Stack<Node> p_stack){
    	assert(!p_stack.isEmpty()):"I cannot print an empty queue";
    	System.out.print(p_stack.pop().data);
        while(!p_stack.isEmpty()){
        	System.out.print(" -> " + p_stack.pop().data);
        }
        System.out.println();
    }

	protected void findPath(Node p_node, Node p_target){
	    Stack<Node> foundPath = new Stack<Node>();
		boolean found1 = searchDFS(p_node, p_target, foundPath);
	    if(found1){
	        System.out.println("Found path from "
								+ p_node.data
								+ " to "
								+ p_target.data
								);
	        printPath(foundPath);
	    }
	    foundPath.clear();
	    boolean found2 = searchDFS(p_target, p_node, foundPath);
		if(found2){
		        System.out.println("Found path from "
									+ p_target.data
									+ " to "
									+ p_node.data
									);
		        printPath(foundPath);
		}
        if(!(found1 || found2))
        	System.out.println("Any path found from " 
        						+ p_target.data 
        						+ " to " 
        						+ p_node.data 
        						+ " nor from " 
        						+ p_node.data 
        						+ " to " 
        						+ p_target.data 
        						);
	}

public static void main(String[] args){
    PathBetweenNodes pbn = new PathBetweenNodes();
    Node A = pbn.new Node('a');
    Node B = pbn.new Node('b');
    Node C = pbn.new Node('c');
    Node D = pbn.new Node('d');
    Node E = pbn.new Node('e');
    Node F = pbn.new Node('f');
    Node G = pbn.new Node('g');

    A.addPath(B);
    B.addPath(D);
    C.addPath(E);
    D.addPath(C);
    D.addPath(F);
    D.addPath(E);
    E.addPath(G);

    pbn.findPath(A,G);
    pbn.findPath(C,F);
}
}
