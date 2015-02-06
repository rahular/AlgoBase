/**
 * 
 */
package com.rahul.peg.tests;

import com.rahul.peg.algorithms.GraphAlgorithms;
import com.rahul.peg.graph.Node;
import com.rahul.peg.util.Handler;
import com.rahul.peg.util.Util;

/**
 * @author rahular Feb 6, 2015
 */
public class NodeTest {
	private static Node<Integer> createGraph() {
		Node<Integer> root = new Node<Integer>(10);

		Node<Integer> levelOneA = new Node<Integer>(20);
		Node<Integer> levelOneB = new Node<Integer>(30);
		Node<Integer> levelOneC = new Node<Integer>(40);

		Node<Integer> levelTwoA = new Node<Integer>(50);
		Node<Integer> levelTwoB = new Node<Integer>(60);
		Node<Integer> levelTwoC = new Node<Integer>(70);

		root.addEdge(levelOneA, 2);
		root.addEdge(levelOneB, 3);
		root.addEdge(levelOneC, 4);

		levelOneA.addEdge(levelTwoA, 5);
		levelOneB.addEdge(levelTwoB, 6);
		levelOneC.addEdge(levelTwoC, 7);

		return root;
	}

	public static void main(String[] args) {
		Node<Integer> root = createGraph();
		// root.printGraph();

		System.out.println("BFS Traversal: ");
		GraphAlgorithms.BFS(root, new Handler() {

			@Override
			public void performAction(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});

		System.out.println("\nDFS Traversal: ");
		GraphAlgorithms.DFS(root, new Handler() {

			@Override
			public void performAction(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});

		System.out.println("\nAdjacency Matrix: ");
		int[][] adjMatrix = root.getAdjMatrix();
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				System.out.format("%15d", adjMatrix[i][j]);
			}
			System.out.println();
		}
		
		Integer[] data = {10, 20, 30, 40, 50, 60, 70};
		root = Util.buildGraph(Integer.class, data, adjMatrix);
		
		System.out.println("\nBFS Traversal: ");
		GraphAlgorithms.BFS(root, new Handler() {

			@Override
			public void performAction(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});

		System.out.println("\nDFS Traversal: ");
		GraphAlgorithms.DFS(root, new Handler() {

			@Override
			public void performAction(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});
	}
}
