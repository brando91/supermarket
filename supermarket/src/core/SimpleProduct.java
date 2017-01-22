package core;

public class SimpleProduct extends Product{

	public SimpleProduct(String label, int unitPrice) {
		super(label, unitPrice);
	}

	@Override
	public int priceFor(int itemsBought) {
		return this.unitPrice * itemsBought;
	}

}
