package com.DataStructures;

/* Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
EXAMPLE
Input:the node c from the linked list a->b->c->d-> e
Result:nothing is returned, but the new linked list looks like a->b->d->e
 */

//import

public class ElementRemover{
	public class Node{
		char data;
		Node next;
	
		public Node(char p_data){
			data = p_data;
		}
		
		protected boolean hasNext(){
			return next != null;
		}
		
		protected Node getNext(){
			return next;
		}
		
		protected char getData(){
			return data;
		}
		
		protected void setData(char p_data){
			data = p_data;
		}
		
		protected void setNext(Node p_next){
			next = p_next;
		}
		
		protected void addTail(char p_data){
			Node tail = this;
			while(tail.hasNext())
				tail = tail.getNext();
			tail.setNext(new Node(p_data));
		}
		
		public String toString(){
			return getData() + (hasNext()?("->"+getNext()):"");
		}
	}

	public void removeNode(Node p_node){
		if (p_node == null || !p_node.hasNext()) return;
		p_node.setData(p_node.getNext().getData());
		p_node.setNext(p_node.getNext().getNext());
	
	}

public static void main(String[] args){
	ElementRemover er = new ElementRemover();
Node root = er.new Node('a');
root.addTail('b');
root.addTail('c');
root.addTail('d'); // <-- removing this one
root.addTail('e');
root.addTail('f');
root.addTail('g');

Node d_node = root.getNext().getNext().getNext();
Node a_node = root;
Node g_node = d_node.getNext().getNext().getNext();

//Removing a node in the middle
System.out.println(root);
er.removeNode(d_node);
System.out.println(root);
//Removing node a, root
er.removeNode(a_node);
System.out.println(root);
//Node g cannot be removed with this method
er.removeNode(g_node);
System.out.println(root);

}

}