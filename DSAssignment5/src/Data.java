/**
 * To hold Data of Dictionary 
 * @author Akshat
 *
 */
public class Data {
	String value;
	String key;
	
	
	public Data(String key, String value) 
	{
		super();
		this.value = value;
		this.key = key;
	}
	
	
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
	
}
