/**
 * Node for an AVL tree that holds an integer, data, and pointers to
 * its left and right children, leftChild and rightChild, respectively.
 * @author Isaac Mast
 */
public class Node {

	private int data;
	private int height;
	private Node leftChild;
	private Node rightChild;


	public Node(int data) {
		this.data = data;
		this.height = 1;
		this.leftChild = null;
		this.rightChild = null;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getLeftChild() {
		return this.leftChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getRightChild() {
		return this.rightChild;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//calcular o balanceamento do nodo
	public int getBalanceFactor() {
		int leftHeight = (leftChild != null) ? leftChild.getHeight() : 0;
		int rightHeight = (rightChild != null) ? rightChild.getHeight() : 0;
		return leftHeight - rightHeight;
	}
}

