package core;

public abstract class Product {

	protected String label;
	protected int unitPrice;

	public Product(String label, int unitPrice) {
		this.label = label;
		this.unitPrice = unitPrice;
	}
	
	abstract int priceFor(int itemsBought);

	boolean matches(char productLabel) {
		return (productLabel + "").equalsIgnoreCase(this.label);
	}

}
