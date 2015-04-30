
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
	
	public void setOnSalePrice(double price) {
		onSalePrice = price;
	}
	
	public void display() {

			System.out.print(title + "\t\t\t\t");
			double price;
			if (onSale) {
				price = onSalePrice;
			} else {
				price = rentalPrice;
			}
			if (price > 0) {
				System.out.print(price);
				System.out.print("\t\t");
			} else {
				System.out.print("Currently Free!\t");
			}
			System.out.println(numberOfTimesRented);

	}
}
