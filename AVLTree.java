/**
 * Implementation of AVL tree data structure that holds Node ojbects 
 * that stores an integer as their data.
 * @author Isaac Mast
 */
public class AVLTree {

	// declare instance variables
	private Node root;

	/**
	 * Constructs an empty AVL tree.
	 */
	public AVLTree() {
		this.root = null;
	}

	/**
	 * Constructs an AVL tree, setting root to a new Node that contains
	 * the int value, data
	 * @param data - the int value to be stored in the AVLtree's root node
	 */
	public AVLTree(int data) {
		this.root = new Node(data);
	}
	/**
	 * Gets the root Node of the AVLTree
	 * @return root - the root Node of the AVLTree
	 */
	public Node getRoot() {
		return this.root;
	}

	/**
	 * Creates a new Node that contains an integer, data, and 
	 * inserts it into the AVL tree. 
	 * @param data - int value to be stored in the new Node object
	 * @throws NodeAlreadyExistsException - if the tree contains a node 
	 * that already has an int value equal to data
	 */
	public void add(int data) throws NodeAlreadyExistsException {
		try {
			Node current = root;
			Node parent = current;
			if (root == null) {
				root = new Node(data);
				System.out.println(AVLTreeTest.SUCCESS);
			} else {
				while (current != null && data != current.getData()) {
					if (data < current.getData()) {
						parent = current;
						current = current.getLeftChild();
					} else {
						parent = current;
						current = current.getRightChild();
					}
				}
				if (current != null && data == current.getData()) {
					System.out.println(AVLTreeTest.FAILED);
					throw new NodeAlreadyExistsException(NodeAlreadyExistsException.MESSAGE + data);
				} else if (data < parent.getData() && parent.getLeftChild() == current) {
					parent.setLeftChild(new Node(data));
					System.out.println(AVLTreeTest.SUCCESS);
				} else {
					parent.setRightChild(new Node(data));
					System.out.println(AVLTreeTest.SUCCESS);
				}
			}
		} catch (NodeAlreadyExistsException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Finds a Node in the AVL tree that contains the integer, data
	 * @return true if a Node is found in the AVL tree that contains
	 * the int value, data
	 * @return false if a Node is not found in the AVL tree that
	 * contains the int value, data
	 */
	public boolean contains(int data) {
		Node current = root;
		while (current != null && data != current.getData()) {
			if (data < current.getData()) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		if (current == null) {
			return false;
		}
		return true;
	}

	/**
	 * Performs a pre-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void preOrder(Node current) {
		if (current == null) {
			//System.out.print("null ");
		} else {
			System.out.print(current.getData() + " ");
			preOrder(current.getLeftChild());
			preOrder(current.getRightChild());
		}
	}

	/**
	 * Performs an in-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void inOrder(Node current) {
		if (current == null) {
			//System.out.print("null ");
		} else {
			inOrder(current.getLeftChild());
			System.out.print(current.getData() + " ");
			inOrder(current.getRightChild());
		}
	}

	/**
	 * Performs a post-order traversal of the AVLTree and prints out
	 * the data of each Node
	 * @param current - the visited Node in the AVLTree
	 */
	public void postOrder(Node current) {
		if (current == null) {
			//System.out.print("null ");
		} else {
			postOrder(current.getLeftChild());
			postOrder(current.getRightChild());
			System.out.print(current.getData() + " ");
		}
	}

	public void printTree() {
		if(root != null) {
			TreeFormatter formatter = new TreeFormatter();
			System.out.println(formatter.topDown(root));
		} else {
			System.out.println("Árvore vazia!");
		}
	}

	//clear()
	public void clear() {
		root = null;
	}


	//height()
	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		} else {
			int leftHeight = height(node.getLeftChild());
			int rightHeight = height(node.getRightChild());
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}


	//size()
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			int leftSize = size(node.getLeftChild());
			int rightSize = size(node.getRightChild());
			return 1 + leftSize + rightSize;
		}
	}


	//isEmpty()
	public boolean isEmpty() {
		return root == null;
	}


}
