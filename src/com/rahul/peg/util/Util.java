package com.rahul.peg.util;

import java.util.ArrayList;

import com.rahul.peg.graph.Node;

public class Util {
	/**
	 * Builds a graph whose data type is <b>ClassType</b> and returns the root
	 * node.
	 * 
	 * @param ClassType
	 * @param adjMatrix
	 * @return root
	 */
	@SuppressWarnings("rawtypes")
	public static <ClassType> Node<ClassType> buildGraph(Class ClassType,
			ClassType[] data, int[][] adjMatrix) {
		ArrayList<Node<ClassType>> nodes = new ArrayList<Node<ClassType>>();

		for (int i = 0; i < adjMatrix.length; i++)
			nodes.add(new Node<ClassType>());

		for (int i = 0; i < adjMatrix.length; i++) {
			nodes.get(i).setData(data[i]);
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (adjMatrix[i][j] < Integer.MAX_VALUE)
					nodes.get(i).addEdge(nodes.get(j), adjMatrix[i][j]);
			}
		}

		return nodes.get(0);
	}
}
