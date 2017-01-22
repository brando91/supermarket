package core;

public class SimpleProduct extends Product{

	public SimpleProduct(String label, int unitPrice) {
		super(label, unitPrice);
	}

	@Override
	public boolean matches(char productLabel) {
		return (productLabel + "").equalsIgnoreCase(this.label);
	}

	@Override
	public int priceFor(int itemsBought) {
		return this.unitPrice * itemsBought;
	}

}
