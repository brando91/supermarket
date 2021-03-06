package core;

import java.util.ArrayList;
import java.util.List;

public class PriceRules {

	private List<Product> products;

	public PriceRules(){
		this.products = new ArrayList<Product>();
		this.products.add(new DiscountedProduct("A", 50, 3, 130)); 
		this.products.add(new DiscountedProduct("B", 30, 2, 45));
		this.products.add(new SimpleProduct("C", 20)); 
		this.products.add(new SimpleProduct("D", 15));
	}
	
	public Product matching(char productLabel) {
		for(Product product : this.products){
			if(product.matches(productLabel)){
				return product;
			}
		}
		return null;
	}

}
