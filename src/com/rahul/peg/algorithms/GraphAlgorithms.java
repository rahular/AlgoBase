/**
 * 
 */
package com.rahul.peg.algorithms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import com.rahul.peg.graph.Node;
import com.rahul.peg.util.Handler;

/**
 * @author rahular Feb 6, 2015
 */
public class GraphAlgorithms {
	public static void BFS(Node<?> root, Handler handler) {
		Hashtable<Node<?>, Boolean> visited = new Hashtable<Node<?>, Boolean>();
		Queue<Node<?>> q = new LinkedList<Node<?>>();

		q.add(root);

		while (!q.isEmpty()) {
			Node<?> tempNode = q.remove();
			if (visited.get(tempNode) == null)
				if(handler != null)
					handler.performAction(tempNode);

			visited.put(tempNode, true);
			ArrayList<?> outGoers = tempNode.getEdges();
			for (Object node : outGoers) {
				if (visited.get(node) == null)
					q.add((Node<?>) node);
			}
		}
	}

	public static void DFS(Node<?> root, Handler handler) {
		Hashtable<Node<?>, Boolean> visited = new Hashtable<Node<?>, Boolean>();

		DFSHelper(root, handler, visited);
	}
	
	public static void preOrder(Node<?> node, Handler handler) {
		if(node == null) return;
		if(handler != null) {
			handler.performAction(node);
		}
		for(Node<?> child : node.getEdges()) {
			preOrder(child, handler);
		}
	}
	
	public static void postOrder(Node<?> node, Handler handler) {
		if(node == null) return;
		for(Node<?> child : node.getEdges()) {
			postOrder(child, handler);
		}
		if(handler != null) {
			handler.performAction(node);
		}
	}

	private static void DFSHelper(Node<?> node, Handler handler, Hashtable<Node<?>, Boolean> visited) {
		if(visited.get(node) == null) {
			if(handler != null)
				handler.performAction(node);
			visited.put(node, true);
			for(Node<?> outGoer : node.getEdges()) {
				DFSHelper(outGoer, handler, visited);
			}
		}
	}
}
