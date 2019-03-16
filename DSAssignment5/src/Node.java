/**
 * 
 * @author Akshat
 *
 */
public class Node {
	Data data;
	Node leftChild;
	Node rightChild;
	
	public Node(String key, String value)
	{
		this.data = new Data(key, value);
		this.leftChild = null;
		this.rightChild = null;
	}

	
	public void setKey(String key)
	{
		this.data.setKey(key);
	}
	
	public void setValue(String value)
	{
		this.data.setValue(value);
	}
	
	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getKey() {
		return data.getKey();
	}

	public String getValue() {
		return data.getValue();
	}

}
