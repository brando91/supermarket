package core;

import java.util.HashMap;

public class Checkout {

	private PriceRules priceRules;
	private HashMap<Product, Integer> scanned;

	public Checkout(PriceRules priceRules) {
		this.priceRules = priceRules;
		this.scanned = new HashMap<Product, Integer>();
	}

	public int totals() {
		int total = 0;
		for(Product product : this.scanned.keySet()){
			total += product.priceFor(this.scanned.get(product));
		}
		return total;
	}

	public void scan(char productLabel) {
		Product product = this.priceRules.matching(productLabel);
		
		if(!this.scanned.containsKey(product)){
			this.scanned.put(product, 0);
		}
		this.scanned.put(product, this.scanned.get(product) + 1); 
	}
	
	public int Price(String items) {
	    for(char item : items.toCharArray()){
	    	scan(item);
	    }
	    return totals();
	}

}
