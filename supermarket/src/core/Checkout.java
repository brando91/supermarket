package core;

public class Checkout {

	private PriceRules priceRules;
	private int total;

	public Checkout(PriceRules priceRules) {
		this.priceRules = priceRules;
		this.total = 0;
	}

	public int totals() {
		return this.total;
	}

	public void scan(char productLabel) {
		for(Product product : this.priceRules.products()){
			if(product.matches(productLabel)){
				this.total += product.unitPrice();
			}
		}
	}
	
	public int Price(String items) {
	    for(char item : items.toCharArray())
	        scan(item);
	    return totals();
	}

}
