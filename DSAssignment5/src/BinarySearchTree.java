import java.util.List;
/**
 * Interface for operations of Binary Search Tree
 * @author Akshat
 *
 */

public interface BinarySearchTree {
	
		public boolean isEmpty();
		
		
		public boolean insert(String key, String value) throws Exception;
		
		
		public boolean delete(String key) throws Exception;
		
		
		public String findValue(String key) throws Exception;
		
		
		public List<Data> getAll() throws Exception;
		
		
		public List<Data> getBetweenKeys(String key1, String key2) throws Exception;
}
