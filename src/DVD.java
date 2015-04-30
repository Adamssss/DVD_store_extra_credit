
public class DVD {

	/**
	 * @param args
	 */
	private String title;
	private double rentalPrice,onSalePrice;
	private boolean onSale;
	private int numberOfTimesRented;
	private boolean isCurrentlyRented;
	private enum genre {comedy, drama, documentary, horror, romance, musical}
	
	public DVD(String title,double price) {
		this.title = title;
		this.rentalPrice = price;
		onSale = false;
		isCurrentlyRented = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void flipsale(){
		onSale = !onSale;
	}
	
	public boolean isOnSale() {
		return onSale;
	}
	
	public boolean isRented() {
		return isCurrentlyRented;
	}
	
	public void flipRent() {
		isCurrentlyRented = !isCurrentlyRented;
	}
	
	public void setOnSalePrice(double price) {
		onSalePrice = price;
	}
	
	public double getPrice() {
		if (onSale) return onSalePrice;
		return rentalPrice;
	}
	
	public void rent() {
		
	}
	
	public void display() {

			System.out.print(title);
			double price;
			if (onSale) {
				price = onSalePrice;
				System.out.print(" - On Sale!");
			} else {
				price = rentalPrice;
				System.out.print("           ");
			}
			for(int i=0;i<20-title.length();i++){
				System.out.print(" ");
			}
			System.out.print("\t");
			if (price > 0) {
				System.out.print(price);
				System.out.print("\t\t");
			} else {
				System.out.print("Currently Free!\t");
			}
			System.out.println(numberOfTimesRented);

	}
}
