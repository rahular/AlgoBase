/**
 * 
 */
package com.rahul.peg.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rahular Feb 6, 2015
 */
public class Node<NodeDataType> {
	private NodeDataType data;
	private ArrayList<Node<NodeDataType>> edges;

	public Node() {
		this.edges = new ArrayList<Node<NodeDataType>>();
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

	public ArrayList<Node<NodeDataType>> getEdges() {
		return edges;
	}

	@SuppressWarnings("unchecked")
	public void addEdges(Node<NodeDataType> ... edges) {
		for(Node<NodeDataType> node : edges)
			this.edges.add(node);
	}

	public void addEdge(Node<NodeDataType> edge) {
		this.edges.add(edge);
	}

	public void printGraph() {

		Queue<Node<NodeDataType>> currentLevel = new LinkedList<Node<NodeDataType>>();
		Queue<Node<NodeDataType>> nextLevel = new LinkedList<Node<NodeDataType>>();

		currentLevel.add(this);

		while (!currentLevel.isEmpty()) {
			Iterator<Node<NodeDataType>> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				Node<NodeDataType> currentNode = iter.next();
				nextLevel.addAll(currentNode.getEdges());
				System.out.print(currentNode.getData() + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Node<NodeDataType>>();
		}
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
