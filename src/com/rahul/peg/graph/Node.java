/**
 * 
 */
package com.rahul.peg.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.rahul.peg.algorithms.GraphAlgorithms;
import com.rahul.peg.util.Handler;

/**
 * @author rahular Feb 6, 2015
 */
public class Node<NodeDataType> {
	private NodeDataType data;
	private ArrayList<Node<?>> edges;
	private ArrayList<Integer> weights;

	public Node() {
		this.edges = new ArrayList<Node<?>>();
		this.weights = new ArrayList<Integer>();
	}

	public Node(NodeDataType data) {
		this();
		this.data = data;
	}

	public NodeDataType getData() {
		return data;
	}

	public void setData(NodeDataType data) {
		this.data = data;
	}

	public ArrayList<Node<?>> getEdges() {
		return edges;
	}

	/**
	 * Use this method only for constructing unweighted graphs
	 * 
	 * @param edges
	 */
	@SuppressWarnings("unchecked")
	public void addEdges(Node<NodeDataType>... edges) {
		for (Node<NodeDataType> node : edges) {
			this.edges.add(node);
			this.weights.add(0);
		}
	}

	/**
	 * Use this for constructing unweighted graphs. The weight of the edge
	 * defaults to 0.
	 * 
	 * @param edge
	 */
	public void addEdge(Node<NodeDataType> edge) {
		this.edges.add(edge);
		this.weights.add(0);
	}

	/**
	 * Use this for constructing weighted graphs.
	 * 
	 * @param edge
	 * @param weight
	 */
	public void addEdge(Node<NodeDataType> edge, int weight) {
		this.edges.add(edge);
		this.weights.add(weight);
	}

	public ArrayList<Integer> getWeights() {
		return weights;
	}
	
	private int getWeightTo(Node<?> outGoer) {
		try {
			return weights.get(edges.indexOf(outGoer));
		} catch(Exception e) {
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * Prints the level ordered traversal of the graph
	 */
	public void printGraph() {

		Queue<Node<?>> currentLevel = new LinkedList<Node<?>>();
		Queue<Node<?>> nextLevel = new LinkedList<Node<?>>();

		currentLevel.add(this);

		while (!currentLevel.isEmpty()) {
			Iterator<Node<?>> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				Node<?> currentNode = iter.next();
				nextLevel.addAll(currentNode.getEdges());
				System.out.print(currentNode.getData() + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Node<?>>();
		}
	}

	/**
	 * Constructs the adjacency matrix for the graph. The indices of the matrix
	 * represent the nodes as they appear in Breadth First traversal.
	 * 
	 * @return Adjacency matrix
	 */
	public int[][] getAdjMatrix() {
		final ArrayList<Node<?>> nodes = new ArrayList<Node<?>>();
		GraphAlgorithms.BFS(this, new Handler() {
			
			@Override
			public void performAction(Node<?> node) {
				nodes.add(node);
			}
		});
		
		int size = nodes.size();
		final int[][] adjMatrix = new int[size][size];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
			adjMatrix[i][i] = 0;
		}
		
		GraphAlgorithms.BFS(this, new Handler() {
			
			@Override
			public void performAction(Node<?> node) {
				int i = nodes.indexOf(node), j;
				for(Node<?> outGoer : node.getEdges()) {
					j = nodes.indexOf(outGoer);
					adjMatrix[i][j] = node.getWeightTo(outGoer);
				}
			}
		});
		
		return adjMatrix;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object instanceof Node == false)
			return false;
		if (this == (Node<NodeDataType>) object)
			return true;

		return false;
	}
}
