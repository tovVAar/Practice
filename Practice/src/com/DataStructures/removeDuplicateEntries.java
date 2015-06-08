/*Write code to remove duplicates from an unsorted linkedlist.
FOLLOWUP
How would you solve this problem if a temporary buffer is not allowed?
*/
package com.DataStructures;

public class removeDuplicateEntries {
	public class Node{
	int data;
	Node next;

	public Node(int p_data){
	data = p_data;
	next = null;
}

	public Node getNext(){
		return next;
}

public void setNext(Node p_next){
	next = p_next;
}

public int getData(){
	return data;
}

public void addTail(int p_data){
	Node tail = this;
	while(tail.hasNext())
		tail = tail.getNext();
	tail.setNext(new Node(p_data));
}

public void jumpNextNode(){
	if(next != null){
next = getNext().getNext();	
}
}

public boolean hasNext(){
	return getNext() != null;
}

public String toString(){
	return this.data + (this.hasNext()?("->"+this.getNext()): "");
}
	}

	public Node cleanDuplicates(Node p_rootNode){
		Node l_nodeFl = p_rootNode;
		Node l_nodeSl;

		if(p_rootNode == null)
			return null;
		
		while(l_nodeFl.hasNext()){
			l_nodeSl = l_nodeFl;
			while(l_nodeSl.hasNext()){
				if(l_nodeFl.getData() == l_nodeSl.getNext().getData())
					l_nodeSl.jumpNextNode();
				else
					l_nodeSl = l_nodeSl.getNext();
			}
			l_nodeFl = l_nodeFl.getNext();
		}
		return p_rootNode;
}

public static void main(String[] args){
	removeDuplicateEntries remDup = new removeDuplicateEntries();
	Node node = remDup.new Node(5);
	node.addTail(1);
	node.addTail(1);
	node.addTail(1);
	node.addTail(1);
	node.addTail(4);
	node.addTail(3);
	node.addTail(2);
	node.addTail(5);
	node.addTail(3);
	node.addTail(1);
	node.addTail(1);
	node.addTail(1);
	

	System.out.println(node);
	node = remDup.cleanDuplicates(node);
	System.out.println(node);
}
}



