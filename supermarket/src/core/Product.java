package core;

public class Product {

	private String label;
	private int unitPrice;

	public Product(String label, int unitPrice) {
		this.label = label;
		this.unitPrice = unitPrice;
	}

	public boolean matches(char productLabel) {
		return (productLabel + "").equalsIgnoreCase(this.label);
	}

	public int unitPrice() {
		return this.unitPrice;
	}

}
