package core;

import java.util.Arrays;
import java.util.List;

public class PriceRules {

	private List<Product> products;

	public PriceRules(){
		this.products = Arrays.asList(new Product("A", 50), 
									  new Product("B", 30), 
									  new Product("C", 20), 
									  new Product("D", 15));
	}
	
	public List<Product> products() {
		return this.products;
	}

	public Product matching(char productLabel) {
		for(Product product : this.products()){
			if(product.matches(productLabel)){
				return product;
			}
		}
		return null;
	}

}
