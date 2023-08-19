package testcase;

import org.testng.annotations.Test;

import page.Ecommerce;

public class Testcase extends Ecommerce{
	
	
	@Test
	public void test() throws Exception {
		
		Ecommerce Ecom = new Ecommerce();
		
		Ecom.login("tamsilahmedbe@gmail.com", "Moopan@12");
		
		Ecom.shop();
		
		Ecom.Scrolldown();
		
		Ecom.cart();
		
		Ecom.Scrollup();
		
		Ecom.shopping();
		
		Ecom.Scrolldown();
		
		Ecom.checkout();
		
		Ecom.billing("KDNL", "123, xyz street", "624586", "8596741236");
		
		Ecom.confirm();
		
		Ecom.confirmation();
		
	}

}
