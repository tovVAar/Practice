/* Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the
 two subtrees of any node never differ by more than one.*/
package com.DataStructures;
//imports
class BalancedTree{
	protected class Node{
		Node parent;
		Node left;
		Node right;
		int data;

		public Node(int p_data){
			data = p_data;
			parent = null;
			left = null;
			right = null;
		}
		
		protected void addLeft(int p_data){
			Node newLeft = new Node(p_data);
			this.left = newLeft;
			newLeft.parent = this;
		}
		
		protected void addRight(int p_data){
			Node newRight = new Node(p_data);
			this.right = newRight;
			newRight.parent = this;
		}
		
		protected void addNode(int p_data){
			addNode(p_data, this);
		}
		
		protected void addNode(int p_data, Node p_node){
			if(p_data < p_node.data){
				if(p_node.left == null)
					p_node.addLeft(p_data);
				else
					addNode(p_data, p_node.left);
			}
		else if(p_data > p_node.data){
				if(p_node.right == null)
					p_node.addRight(p_data);
				else
					addNode(p_data, p_node.right);
			}
			else
				return; //Node == new data
		}
	}

	protected int getHight(Node p_node){
		if(p_node == null)
			return 0;
		else {
			int left = getHight(p_node.left);
			if(left == -1)
				return -1;
			int right = getHight(p_node.right);
			if(right == -1)
				return -1;
			if(Math.abs(left-right)>1)
				return -1;
			else
				return Math.max(left, right) + 1;
		}
	}

	protected boolean isBalanced(Node p_node){
		if(p_node == null || getHight(p_node) != -1)
			return true;
		else 
			return false;		
	}

	public static void main(String [] args){
		BalancedTree bt = new BalancedTree();
		Node root = bt.new Node(100);
		root.addNode(50);
		root.addNode(150);
		root.addNode(80);
		root.addNode(120);
		root.addNode(200);
	
		System.out.println("This tree " + (bt.isBalanced(root)?"is":"is not") + " balanced");
		
		Node rootUnbalanced = bt.new Node(100);
		rootUnbalanced.addNode(90);
		rootUnbalanced.addNode(80);
		rootUnbalanced.addNode(70);
		rootUnbalanced.addNode(110);
		rootUnbalanced.addNode(120);
		rootUnbalanced.addNode(130);
	
		System.out.println("This tree " + (bt.isBalanced(rootUnbalanced)?"is":"is not") + " balanced");
	}

}


