/**
 * 
 */
package com.rahul.peg.tests;

import com.rahul.peg.algorithms.GraphAlgorithms;
import com.rahul.peg.graph.Node;
import com.rahul.peg.util.Handler;

/**
 * @author rahular
 * Feb 6, 2015
 */
public class NodeTest {
	@SuppressWarnings("unchecked")
	private static Node<Integer> createGraph() {
		Node<Integer> root = new Node<Integer>(10);
		
		Node<Integer> levelOneA = new Node<Integer>(20);
		Node<Integer> levelOneB = new Node<Integer>(30);
		Node<Integer> levelOneC = new Node<Integer>(40);
		
		Node<Integer> levelTwoA = new Node<Integer>(50);
		Node<Integer> levelTwoB = new Node<Integer>(60);
		Node<Integer> levelTwoC = new Node<Integer>(70);
		
		root.addEdges(levelOneA, levelOneB, levelOneC);
		
		levelOneA.addEdge(levelTwoA);
		levelOneB.addEdge(levelTwoB);
		levelOneC.addEdge(levelTwoC);
		
		return root;
	}
	
	public static void main(String[] args) {
		createGraph().printGraph();
		GraphAlgorithms.BFS(createGraph(), new Handler() {
			
			@Override
			public void doThis(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});
	}
}
