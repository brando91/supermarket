package core;

public class SimpleProduct implements Product{

	private String label;
	private int unitPrice;

	public SimpleProduct(String label, int unitPrice) {
		this.label = label;
		this.unitPrice = unitPrice;
	}

	@Override
	public boolean matches(char productLabel) {
		return (productLabel + "").equalsIgnoreCase(this.label);
	}

	@Override
	public int totalPrice(int itemsBought) {
		return this.unitPrice * itemsBought;
	}

}
