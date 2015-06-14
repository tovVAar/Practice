package com.DataStructures;


public class AddNodesClass {
	
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
		
		public void addTail(Node p_node){
			Node tail = this;
			while(tail.hasNext())
				tail = tail.getNext();
			tail.setNext(p_node);
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


	public int addNodes(Node p_nodeA, Node p_nodeB, int p_base){
		if(p_nodeA == null || p_nodeB == null){
			if(p_nodeA != null)
				return (int)(p_nodeA.getData() * Math.pow(10,p_base)) 
				+ addNodes(p_nodeA.getNext(), null, p_base + 1);
			else if(p_nodeB != null)
				return (int)(p_nodeB.getData() * Math.pow(10,p_base))
				+ addNodes(null, p_nodeB.getNext(), p_base + 1);
			else 
				return 0;
		} else {
		return (int)(p_nodeA.getData() * Math.pow(10,p_base))
			+ (int)(p_nodeB.getData() * Math.pow(10,p_base))
			+ addNodes(p_nodeA.getNext(), p_nodeB.getNext(), p_base + 1);
		}
	}

	public Node parseInt2Node(int p_num){
		Node n_parsed = null;
		while(p_num > 0){
			if(n_parsed == null)
				n_parsed = new Node(p_num%10);
			else
				n_parsed.addTail(p_num%10);
			p_num /= 10;
		}
		return n_parsed;
	}

public static void main(String[] args){
	AddNodesClass adc = new AddNodesClass();
	//617
	Node nodeA = adc.new Node(7);
	nodeA.addTail(1);
	nodeA.addTail(6);
	
	//295
	Node nodeB = adc.new Node(5);
	nodeB.addTail(9);
	nodeB.addTail(2);

	Node n_result;

	int i_result = adc.addNodes(nodeA, nodeB, 0);
	System.out.println(nodeA);
	System.out.println("  +  ");
	System.out.println(nodeB);
	System.out.println("  =  ");
	n_result = adc.parseInt2Node(i_result);
	System.out.println(n_result);
}

}
