import java.util.ArrayList;
import java.util.List;


public class BSTImplementation implements BinarySearchTree {

	Node root;
	
	public BSTImplementation() {
	root=null;
	}
	
	/*
	 * Checks if tree is empty
	 * @return true if empty false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}

	
	/*
	 *to insert a key - value in tree
	 *@param, key
	 *@param, value
	 *@return true if successful , false otherwise 
	 */
	@Override
	public boolean insert(String key, String value) throws Exception {
		
		if(isEmpty())
		{
			root=new Node(key, value);
			return true;
		}
		
		
		return  addData(key, value, root);
	}
	
	
	/*
	 * adds data to tree by creating new node
	 * @param, key
	 * @param, value
	 * @param, parent node
	 * @return true if successful,  false otherwise
	 * @throws error of key already exists
	 */
	public boolean addData(String key, String value, Node node) throws Exception
	{
		// if key is greater than parent key
		if(key.compareTo(node.getKey())>0)
		{
			// right child is null of parent node
			if(node.getRightChild()== null)
			{
				node.setRightChild(new Node(key, value)) ;
			}
			else
			{
				// if right child of parent is not null
				addData(key, value, node.getRightChild());
			}
			
			return true;
		}
		
		
		else
		{
			
			// if key is lesser than parent key
			if(key.compareTo(node.getKey())<0)
		   {
				// if left child is null
				if(node.getLeftChild() == null)
				{ 
				 node.setLeftChild(new Node(key, value));
				}
			
			else
				{
				// if left child of parent is not null
				addData(key, value, node.getLeftChild());
				}
			
			
			return true;
		   }
		}
		
	     throw new Exception("Key already Exists");
		
		
	}

	
	/*
	 *delete any key value from tree
	 *@param, key
	 *@return, true if successful , false otherwise 
	 *@throws error if tree is empty 
	 */
	@Override
	public boolean delete(String key) throws Exception {
		
		if(isEmpty())
			throw new Exception("tree is empty");
		
		deleteNode(key,root);
		return true;
		
		
	}
	
	/*
	 *delete node from tree 
	 * @param key
	 * @param parent node
	 * @throws Exception of not available in tree
	 */
	public void deleteNode(String key, Node node )throws Exception
	{
		Node parent=null;;
		
		//find the parent node and that particular node which contains the given key
		while(node != null && node.getKey()!= key)
		{
			parent = node;
			
			if(key.compareTo(node.getKey())>0)
			{
				node= node.getRightChild();
			}
			
			if(key.compareTo(node.getKey())<0)
			{
				node=node.getLeftChild();
			}
		}
		
		if(node == null)
		{
			throw new Exception("Node not available in tree");
		}
		
		//if node doesn't have any children
		if(node.getLeftChild()==null && node.getRightChild()==null)
		{
			if(node != root)
			{
				if(parent.getLeftChild() == node)
				{
					parent.setLeftChild(null);
				}
				else 
				{
					parent.setRightChild(null);
				}
			}
			else
			{
				root = null;
			}
		}
		
		//if node has two children
		else if(node.getLeftChild()!=null && node.getRightChild()!=null)
		{
			Node successor = minValue(node.getRightChild());
			String val = successor.getValue();
			String key1 = successor.getKey();
			
			deleteNode(successor.getKey(),root);
			
			node.setKey(key1);
			node.setValue(val);
		}
		
		//if node has only one children
		else
		{
			Node child = (node.getLeftChild()!=null) ? node.getLeftChild() : node.getRightChild();
			
			if(node != root)
			{
				if(node == parent.getLeftChild())
				{
					parent.setLeftChild(child);
				}
				else
				{
					parent.setRightChild(child);
				}
			}
			else
			{
				root=child;
			}
			
		}
	}
	
	
	/*
	 *to find minimum value node in tree 
	 * @param node
	 * @return node of minimum key in tree
	 */
	private Node minValue(Node node) 
	{
		if(node.getLeftChild()!=null)
		{
			return minValue(node.getLeftChild());
		}
		return node;
		
	}
	
	/*
	 * finds value  corresponding to key
	 * @param, key
	 * @return value 
	 * @throws  error of key does not exists or tree is empty
	 */
	@Override
	public String findValue(String key) throws Exception {
		if(isEmpty())
		{
			throw new Exception("Tree is Empty");
		}
		else if(!checkKey(key))
		{
			
			throw new Exception("Key doesn't Exist");
		}
		else
		{
			Node node =  findValueOfKey(root , key);
			return node.getValue();
		}
	
	}
	
	
	/*
	 *helper method to find value for key 
	 * @param node
	 * @param key
	 * @return node corresponding to key
	 * @throws Exception
	 */
		private Node findValueOfKey(Node node, String key) throws Exception 
		{
			
			if(key.equals(node.getKey()))
			{
				return node;
			}
			else if(key.compareTo(node.getKey()) <= -1)
			{
				return findValueOfKey(node.getLeftChild(),key);
			}
			else if(key.compareTo(node.getKey()) >= 1)
			{
				return findValueOfKey(node.getRightChild(),key);
			}
			else
				return null;
		}

		/*list of all key value pairs 
		 * @return list of data
		 * @throws trees is empty
		 * 
		 */
	@Override
	public List<Data> getAll() throws Exception {
		List<Data> dataList = new ArrayList<>();
		if(isEmpty())
		{
			throw new Exception("Tree is empty");
		}
		dataList = inorder(root, dataList);
		return dataList;
	}

	/*
	 * Inorders the tree 
	 * @param node
	 * @param dataList
	 * @return list
	 */
	private List<Data> inorder(Node node, List<Data> dataList) throws Exception
	{
		if(node!=null)
		{
			inorder(node.getLeftChild(), dataList);
			System.out.println(node.getKey()+"    "+node.getValue());
			dataList.add(new Data(node.getKey(), node.getValue()));
			inorder(node.getRightChild(), dataList);
		}
		return dataList;
	}
	
	
	/*
	 * get data between two keys
	 * @param key1
	 * @param key2
	 * @return list of data between two keys
	 * @throws error of key not exists
	 */
	@Override
	public List<Data> getBetweenKeys(String key1, String key2) throws Exception {

		if(checkKey(key1) && checkKey(key2))
		{
			List<Data> subList = new ArrayList<>();
			for(Data d : getAll())
			{
				if(key1.compareTo(d.getKey()) <= 0 && key2.compareTo(d.getKey()) >= 0)
					subList.add(d);
			}
			return subList;
		}
		
		throw new Exception("Key Doesn't Exist");
	}
	
	/*
	 * checks for the key exists
	 * @param key
	 * @return true if exists, false otherwise
	 * @throws Exception
	 */
	private boolean checkKey(String key) throws Exception 
	{
		for(Data d : getAll())
			if(key.equals(d.getKey()))
				return true;
		return false;
	}

	
	
	
	  public static void main(String[] args) throws Exception {
		  
		  BSTImplementation tree= new BSTImplementation();
		  
		  tree.insert("50","one"); 
	        tree.insert("30","two"); 
	        tree.insert("20","three"); 
	        tree.insert("40","four"); 
	        tree.insert("70","five"); 
	        tree.insert("60","six"); 
	        tree.insert("80","seven"); 
	        tree.getAll();
	        System.out.println();
	        tree.delete("20");
	        tree.getAll();
	  }

}
