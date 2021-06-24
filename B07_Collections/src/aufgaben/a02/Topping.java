package aufgaben.a02;

public enum Topping {
	SALAMI(false, true, 2.25), SCHINKEN(false, false, 2.45), EI(false, false, 0.65),
	KAESE(false, false, 1.95), PEPPERONI(true, true, 0.95), ZWIEBEL(true, false, 0.85),
	CHAMPIGNONS(true, false, 1.15);

	private final boolean vegetable;
	private final boolean hot;
	private final double price;

	private Topping(boolean vegetable, boolean hot, double price) {
		this.vegetable = vegetable;
		this.hot = hot;
		this.price = price;
	}

	public boolean isVegetable() {
		return vegetable;
	}

	public boolean isHot() {
		return hot;
	}

	public double getPrice() {
		return price;
	}

	
}
