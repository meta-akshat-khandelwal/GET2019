import java.util.List;
/**
 * Interface for operations of Dictionary
 * @author Akshat
 *
 */

public interface Dictionary {
	
		public boolean add(String key, String value) throws Exception;
		
		
		public boolean delete(String key) throws Exception;
		
		
		public String getValue(String key) throws Exception;
		
		
		public List<Data> getSortedKeyValue() throws Exception;
		
		
		public List<Data> getSortedKeyValueBetweenKeys(String key1, String key2) throws Exception;
}
