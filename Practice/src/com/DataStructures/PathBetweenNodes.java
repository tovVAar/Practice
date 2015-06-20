/*Given a directed graph, design an algorithm to find out whether there is a route
between two nodes*/
package com.DataStructures;

import java.util.ArrayList;
import java.util.List;

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

    public boolean searchDFS(Node p_node, Node p_target){
	    if(p_node == null || p_target == null)
	        return false;
		if(p_node.equals(p_target)){
			System.out.println(" "+ p_node.data +" ");
		    return true;
	    }
	    else{
	    p_node.wasVisited = true;
	    boolean isCorrectPath = false;
	    foreach(Node i_node in p_node.paths){
		    if(i_node.wasVisited == false){
		        isCorrectPath = searchDFS(i_node, p_target);
		        if(isCorrectPath){
		            System.out.println(" "+p_node.data+" ");
		            return true;
		        }
		    }
	    }
	return false;
	}
}

protected void findPath(Node p_node, Node p_target){
    boolean found1 = searchDFS(p_node, p_target);
    if(found1)
        System.out.println("Found path from "
+ p_node.data
+ " to "
+ p_target.data
);
        boolean found2 = searchDFS(p_target, p_node);
if(found2)
        System.out.println("Found path from "
+ p_target.data
+ " to "
+ p_node.data
);
        if(!(found1 || found2))
            System.out.println("Any path found");
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
