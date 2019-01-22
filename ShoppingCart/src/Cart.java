import java.util.*;

public class Cart {
	static ArrayList<Item> cartList= new ArrayList<Item>();
	Item i1;
	
	public void addToCart(String proName, int proId, float proPrice, int proQty)
	{	i1= new Item();
		i1.setProductId(proId);
		i1.setProductName(proName);
		i1.setProductPrice(proPrice);
		i1.setProductQty(proQty);
		cartList.add(i1);
	}
	
	public void showCart()
	{
		if(cartList.size()!=0)
		{
		for(int i=0;i<cartList.size();i++)
		{
			i1=cartList.get(i);
			System.out.println(i1.getProductId()+"  "+i1.getProductName()+"  "+i1.getProductPrice()+"  "+i1.getProductQty());
		}
		}
		
		else{
			System.out.println("Cart is Empty..!!");
		}
		
	}
	
	public float finalBill()
	{
		float finalAmount=0.0f;
		
		if(cartList.size()==0)
			return -1;
		for(int i=0;i<cartList.size();i++)
		{
			i1= cartList.get(i);
			finalAmount=finalAmount+(i1.getProductPrice()*i1.getProductQty());
		}
		
		
		return finalAmount;
		
	}
	
	public void updateCart(int proId, int proQty)
	{
		for(int loop=0;loop<cartList.size();loop++)
		{
			if(proId == cartList.get(loop).getProductId())
			{
				cartList.get(loop).setProductQty((cartList.get(loop).getProductQty()+proQty));
			}
		}
	}
	
	
	public boolean modifyCart(int id, int qty)
	{
		boolean flg=false;
		for(int loop=0;loop<cartList.size();loop++)
		{
			i1= cartList.get(loop);
			if(i1.getProductId()==id)
			{
				i1.setProductQty(qty);
				flg=true;
			}
			
				
			
		}
		return flg;
	}
	
	public boolean checkItem(int pid)
	{
		boolean flg=false;
		for(int loop=0;loop<cartList.size();loop++)
		{
			i1= cartList.get(loop);
			if(i1.getProductId()==pid)
				flg=true;
			
		}
		return flg;
	}
	
	
	public boolean checkProductInCart(int proId)
	{
		boolean flg= false;
	
		for(int loop =0;loop<cartList.size();loop++)
		{
			if(proId == cartList.get(loop).getProductId())
			{
				flg=true;
			}
		}
		
		
		return flg;
	}
	
}
