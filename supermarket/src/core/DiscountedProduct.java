package core;

public class DiscountedProduct implements Product {

	private String label;
	private int unitPrice;
	private int multiplier;
	private int discountedPrice;

	public DiscountedProduct(String label, int unitPrice, int multiplier, int i) {
		this.label = label;
		this.unitPrice = unitPrice;
		this.multiplier = multiplier;
		this.discountedPrice = i;
	}
	
	@Override
	public boolean matches(char productLabel) {
		return (productLabel + "").equalsIgnoreCase(this.label);
	}

	@Override
	public int totalPrice(int itemsBought) {
		int withDiscountedPrice = itemsBought / this.multiplier;
		int withoutDiscountedPrice = itemsBought - withDiscountedPrice * this.multiplier;		
		
		return this.discountedPrice * withDiscountedPrice + this.unitPrice * withoutDiscountedPrice;
	}

}
