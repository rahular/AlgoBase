## AlgoBase

This is my attempt to build a usable library of well known algorithms which will be helpful in programming competitions or for my research. Expect it to be updated irregularly.

### Graphs
Creating graphs is easy. There are 2 methods to create them:
* Node by node

```java

	Node<Integer> root = new Node<Integer>(10);

	Node<Integer> levelOneA = new Node<Integer>(20);
	Node<Integer> levelOneB = new Node<Integer>(30);
	Node<Integer> levelOneC = new Node<Integer>(40);

	Node<Integer> levelTwoA = new Node<Integer>(50);
	Node<Integer> levelTwoB = new Node<Integer>(60);
	Node<Integer> levelTwoC = new Node<Integer>(70);
	
	// Connecting nodes with weighted edges
	root.addEdge(levelOneA, 2);
	root.addEdge(levelOneB, 3);
	root.addEdge(levelOneC, 4);

	levelOneA.addEdge(levelTwoA, 5);
	levelOneB.addEdge(levelTwoB, 6);
	levelOneC.addEdge(levelTwoC, 7);
```

* Using an adjacency matrix

```java

	/** The first parameter denotes the kind of data to be stored in the node
	 *
	 * the second parameter is an array of data whose length is equal to the number 
	 * of nodes in the graph (n).
	 *
	 * The third parameter is an n*n matrix
	 */
	root = Util.buildGraph(Integer.class, dataArray, adjMatrix);
```

Graph algorithms currently implemented are:

* Breadth first traversal
* Depth first traversal
* Pre order Traversal
* Post order Traversal

Handlers can be given to these algorithms to perform certain actions on each node it visits. For example:

```java

		GraphAlgorithms.BFS(root, new Handler() {

			@Override
			public void performAction(Node<?> node) {
				System.out.print(node.getData() + " ");
			}
		});
```


 
