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
			if(visited.get(tempNode) == null)
				handler.doThis(tempNode);

			visited.put(tempNode, true);
			ArrayList<?> outGoers = tempNode.getEdges();
			for (Object node : outGoers) {
				if(visited.get(node) == null)
					q.add((Node<?>) node);
			}
		}
	}
}
