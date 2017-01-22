package core;

public class DiscountedProduct extends Product {

	private int multiplier;
	private int discountedPrice;

	public DiscountedProduct(String label, int unitPrice, int multiplier, int discountedPrice) {
		super(label, unitPrice);
		this.multiplier = multiplier;
		this.discountedPrice = discountedPrice;
	}

	@Override
	public int priceFor(int itemsBought) {
		int withDiscountedPrice = itemsBought / this.multiplier;
		int withoutDiscountedPrice = itemsBought - withDiscountedPrice * this.multiplier;		
		
		return this.discountedPrice * withDiscountedPrice + this.unitPrice * withoutDiscountedPrice;
	}

}
