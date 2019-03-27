package Question3;
/**
 * @author Akshat
 */
import org.json.simple.JSONArray;

public class NestedList {

		LinkedList nestedList = new LinkedList();


		public NestedList(JSONArray jsonArray) throws Exception 
		{
			if(jsonArray == null)
			{
				throw new Exception("Json object should not be null");
			}
			else
			{
				//calling the private helper method to store the list
				nestedList = createNestList(jsonArray);
			}
		}
		
		/*
		 * Helper method to get the value from the JSON and store in linked list
		 * @param jsonArray
		 * @return  linked list
		 */
		private LinkedList createNestList(JSONArray jsonArray) 
		{
			LinkedList sublist = new LinkedList();
			for(Object object : jsonArray)
			{
				if(object!=null)
				{
					if(object instanceof Long)
					{
						long value = (Long) object;
						sublist.add(value);
					}
					else
					{
						//getting the nested json array from the input
						JSONArray newJsonArray = (JSONArray) object;
						LinkedList list = createNestList(newJsonArray);
						sublist.add(list);
					}
				}
			}
			return sublist;
		}

		/*
		 * getSum method to get the sum of the whole list
		 * @return sum of whole list
		 */

		public Long getSum() 
		{
			Node head = nestedList.getHead();
			return sumOfAllValues(head);
		}
	
		/*
		 * Helper method to get the sum of the whole list
		 * @param starting node from where sum is to calculate
		 * @return sum of whole list
		 */
		private Long sumOfAllValues(Node node)
		{
			Long sum = (long) 0;
			if(node != null)
			{
				//traversing the list to the end
				while(node != null)
				{
					if(node.getData() instanceof Long)
					{
						sum += (Long) node.getData();
						node = node.getNext();
					}
					//if node is pointing to another linked list then call the same method recursively
					else
					{
						Node head = ((LinkedList)node.getData()).getHead();
						node = node.getNext();
						sum += sumOfAllValues(head);
					}
				}
			}
			return sum;
		}

		/*
		 * get the maximum value from list
		 * @return max value
		 */

		public Long getMaxValue() 
		{
			Node head = nestedList.getHead();
			return getMaxValueFromList(head);
		}

		/*
		 * Helper method to find the maximum value from list
		 * @param node 
		 * @return maximum value
		 */
		private Long getMaxValueFromList(Node node) 
		{
			Long max = (long) 0;
			
			if(node != null)
			{
				//traversing the linked list to the end
				while(node != null)
				{
					if(node.getData() instanceof Long)
					{
						if(max < (Long) node.getData())
						{
							max= (Long) node.getData();
						}
						node = node.getNext();
					}
					//if node is pointing to another linked list then call the same method recursively
					else
					{
						Node head = ((LinkedList)node.getData()).getHead();
						node = node.getNext();
						max = (long) getMaxValueFromList(head);
					}
				}
			}
			
			return max;
		}

		/*
		 *To check whether given value is available in list
		 * @param value
		 * @return true if present, false otherwise
		 */

		public boolean isValueAvailable(int value)
		{
			Node head = nestedList.getHead();
			return searchValue(head, value);
		}
		
		/*
		 * Helper method to search the value in  list
		 * @param node is starting node 
		 * @param value to be search
		 * @return true if available,false otherwise
		 */
		private boolean searchValue(Node node, int value) 
		{
			if(node != null)
			{
				//traversing the list to the end
				while(node != null)
				{
					if(node.getData() instanceof Long)
					{
						if(value == (Long) node.getData())
						{
							return true;
						}
						node = node.getNext();
					}
					//if node is pointing to another linked list then call the same method recursively
					else
					{
						Node head = ((LinkedList)node.getData()).getHead();
						node = node.getNext();
						return searchValue(head, value);
					}
				}
			}
			return false;
		}
}
