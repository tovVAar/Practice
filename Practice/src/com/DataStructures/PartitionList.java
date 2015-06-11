/*Write code to partition a linked list around a value x, such that all nodes less than
	x come before all nodes greater than or equal to x
*/
package com.DataStructures;

public class PartitionList{

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
		
		public void setData(int p_data){
			data = p_data;
		}
		
		
		public void addTail(int p_data){
			Node tail = this;
			while(tail.hasNext())
				tail = tail.getNext();
			tail.setNext(new Node(p_data));
		}
		
		public void addAtLeft(Node p_node){
			Node rightNode = new Node (this.getData());
			rightNode.setNext(this.getNext());
			this.setData(p_node.getData());
			this.setNext(rightNode);
		}
	
		public void deleteMe(){
			if(this.hasNext()){
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else 
				return;
		}
	
		public Node getTail(){
			Node tail = this;
			while(tail.hasNext())
				tail = tail.getNext();
			return tail;
		}
	
		public boolean hasNext(){
			return getNext() != null;
		}
		
		public String toString(){
			return this.data + (this.hasNext()?("->"+this.getNext()): "");
		}
	}

	public Node partitionateList(Node p_root, Node p_pivot){
		Node tail = p_root.getTail();
		Node n_explorer = p_root;
		//LEFT side
		while(n_explorer.hasNext() && n_explorer.getData() != p_pivot.getData() ){
			if(n_explorer.getData() > p_pivot.getData()){
				tail.addTail(n_explorer.getData());
				n_explorer.deleteMe();
			} else {
				n_explorer = n_explorer.getNext();
			}
		}
		if(n_explorer.hasNext() && n_explorer.getData() == p_pivot.getData()) n_explorer = n_explorer.getNext();
		while(n_explorer.hasNext()){
			if(n_explorer.getData() < p_pivot.getData()){
				p_root.addAtLeft(n_explorer);
				n_explorer.deleteMe();
			} else {
				n_explorer = n_explorer.getNext();
			}
		}
		return p_root;
	}

	public static void main(String[] args){
		PartitionList pl = new PartitionList();
		Node root = pl.new Node(1);
		root.addTail(10);
		root.addTail(2);
		root.addTail(20);
		root.addTail(3);
		root.addTail(30);
		root.addTail(4);
		root.addTail(40);
		root.addTail(3);
		root.addTail(50);
		root.addTail(0);
		Node n_pivot = root.getNext().getNext().getNext().getNext().getNext().getNext(); //4

		System.out.println(root);
		root = pl.partitionateList(root, n_pivot);
		System.out.println(root);		
	}

}