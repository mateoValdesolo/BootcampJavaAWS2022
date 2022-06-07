package clase3;

/**
*
* @author Mateo Valdesolo
* 
*/
public class BTNode<T extends Comparable<T>> {

	private T value;
	private BTNode<T> left, right;

	public BTNode(T value, BTNode<T> left, BTNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BTNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public BTNode<T> getRight() {
		return this.right;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}
}
