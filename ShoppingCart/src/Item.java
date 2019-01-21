import java.util.*;
public class Item {

	private  String productName;
	private  int productId;
	private  float productPrice;
	private int productQty;
	private final int productFinalQty;
	 public  ArrayList<Item> stock= new ArrayList<Item>();
	
	 public Item(String proName, int proId, float proPrice, int proQty, int proFinalQty)
	 {
		 this.productName=proName;
		 this.productId=proId;
		 this.productPrice=proPrice;
		 this.productQty=proQty;
		 this.productFinalQty=proFinalQty;
	 }
	 
		public Item()
		{
			productFinalQty=0;
		}
		
		public void showItem()
		{
			Item item;
			for(int loop=0;loop<stock.size();loop++)
			{
				item= stock.get(loop);
				System.out.println(item.getProductId()+"  "+item.getProductName()+"  "+item.getProductPrice()+"  "+item.getProductQty());
			}
		}
		
		public void addToStock()
		{
			
			Item i1= new Item("Nokia 6.1 Plus",1,100,10,10);
			stock.add(0,i1);
			Item i2= new Item("iphone x",2,500,20,20);
			stock.add(1,i2);
			Item i3= new Item("Pixel 3XL",3,400,15,15);
			stock.add(2,i3);
			Item i4= new Item("Samsung S9",4,300,5,5);
			stock.add(3,i4);
			Item i5= new Item("OnePlus 6t",5,200,25,25);
			stock.add(4,i5);
			Item i6= new Item("Honor 20",6,250,10,10);
			stock.add(5,i6);
		}
		
		
		
	
	public void setProductName(String productName)
	{
		this.productName=productName;
	}
	
	public void setProductId(int productId)
	{
		this.productId=productId;			
	}
	
	public void setProductPrice(float productPrice)
	{
		this.productPrice=productPrice;
	}
	
	public void setProductQty(int productQty)
	{
		this.productQty=productQty;
	}
	
	public String getProductName()
	{
		return productName;
	}
	
	public int getProductId()
	{
		return productId;
	}
	
	public float getProductPrice()
	{
		return productPrice;
	}
	
		
	public int getProductQty()
	{
		return productQty;
	}
	
		
	public int getProductFinalQty()
	{
		return productFinalQty;
	}
	
	
	
   public void updateItem(int pid,int qty)
   {	Item item ;
	   for(int loop=0;loop<stock.size();loop++)
	   {
		   item=stock.get(loop);
		  
		   if(item.getProductId()==pid )
		   {
			   System.out.println(item.getProductId());
			   item.setProductQty(item.getProductQty()-qty);

			   break;
		   }
	   }
   }
	
	
   
   public boolean checkQty(int pid , int qty)
   {
	   boolean flg= true;
	   
	   for( int i=0;i<stock.size();i++)
		{
			if(pid == stock.get(i).getProductId())
			{
				if(qty>=stock.get(i).getProductQty())
				{
					System.out.println("Required Quantity not available..");
					flg= false;
					break;
				}
		
				
			}
  
		}
	   return flg;
   }
   
   public boolean checkItem(int pid)
   {
	   boolean flg=false;
	   Item i1;
	   for(int loop=0;loop<stock.size();loop++)
	   {
		   i1=stock.get(loop);
		   if(i1.getProductId()==pid)
		   {
			   flg=true;
		     break;
		   }
	   }
	   return flg;
   }
   
   public void modifyItemQty(int proId, int proQty)
   {
	   for(int loop=0;loop<stock.size();loop++)
	   {
		   if(proId == stock.get(loop).productId)
		   {
			   stock.get(loop).setProductQty(stock.get(loop).getProductFinalQty()- proQty);;
		   }
	   }
   }
   }

   

