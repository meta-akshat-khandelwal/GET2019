package Question3;

import org.json.simple.JSONArray;

public class NestedList {
	//Linked List to store the nested list
		LinkedList nestedList = new LinkedList();

		//constructor to create the nested list from the JSON array
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
		
		/**
		 * Private helper method to get the value from the JSON and store using linked allocation
		 * @param jsonArray which contains the input value
		 * @return the linked list which contain the input value 
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

		/**
		 * getSum method to get the sum of the whole list
		 * @return the sum of the whole list
		 */

		public Long getSum() 
		{
			Node head = nestedList.getHead();
			return sumOfAllValues(head);
		}
		
		/**
		 * private helper method to get the sum of the whole list
		 * @param node is the starting node from which sum is to be calculated
		 * @return the sum of the whole list
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

		/**
		 * method to get the maximum value from the list
		 * @return the max value from the list
		 */

		public Long getMaxValue() 
		{
			Node head = nestedList.getHead();
			return getMaxValueFromList(head);
		}

		/**
		 * private helper method to find the maximum value from the list
		 * @param node 
		 * @return the value which is maximum in the list
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

		/**
		 * method to check whether given value is available in the list
		 * @param value is to be searched for
		 * @return true if value is present or false
		 */

		public boolean isValueAvailable(int value)
		{
			Node head = nestedList.getHead();
			return searchValue(head, value);
		}
		
		/**
		 * private helper method to search the given value in the list
		 * @param node is the starting node from which searching to be start
		 * @param value to be searched for
		 * @return true if value is available or false
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
