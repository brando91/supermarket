package core;

public class Checkout {

	public Checkout(PriceRules priceRules) {
		// TODO Auto-generated constructor stub
	}

	public int totals() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void scan(char c) {
		// TODO Auto-generated method stub
		
	}
	
	public int Price(String items) {
	    Checkout co = new Checkout(new PriceRules());
	    for(char c : items.toCharArray())
	        co.scan(c);
	    return co.totals();
	}

}
