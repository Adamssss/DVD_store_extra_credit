
public class Linked {

	/**
	 * a Linked list to store the ordered DVDs
	 * @param args
	 */
	private DVD dvd;
	private Linked next;
	
	public Linked(DVD dvd,Linked next) {
		this.dvd = dvd;
		this.next = next;
	}
	
	public DVD getDVD() {
		return dvd;
	}
	
	public boolean contains(String title) {
		if (next == null) {
			return dvd.getTitle().equals(title);
		}
		return dvd.getTitle().equals(title) || next.contains(title);
	}
	
	public void insert(DVD d) {
		String t = d.getTitle();
		if (next == null) {
			if (dvd.getTitle().compareTo(t) < 0) {
				// append
				next = new Linked(d,null);				
			} else {
				// prepend
				DVD temp = dvd;
				this.dvd = d;
				next = new Linked(temp,null);
			}
		} else {
			if (dvd.getTitle().compareTo(t) < 0) {
				// recursion
				next.insert(d);		
			} else {
				// insert
				DVD temp = dvd;
				this.dvd = d;
				Linked onext = next;
				next = new Linked(temp,onext);
			}
		}
	}
	
	public void remove(String title) {
		if (dvd.getTitle().equals(title)){
			if (next == null) {
				dvd = null;
			} else {
				this.dvd = next.dvd;
				this.next = next.next;
			}
		} else {
			if (next != null) {
				if(next.dvd.getTitle().equals(title)) {
					this.next = next.next;
				} else {
					next.remove(title);
				}
			}
		}
	}
	
	public void displayInventory() {
		if (next == null) {
			if (dvd != null && !dvd.isRented()) dvd.display();
		} else {
				if (!dvd.isRented()) dvd.display();
				next.displayInventory();
		}
	}
	
	public DVD find(String title) {
		if (next == null) {
			if (dvd.getTitle().equals(title)) {
				return dvd;
			}
			return null;		
		}
		if (dvd.getTitle().equals(title)) {
			return dvd;
		}
		return next.find(title);
	}
	
	public void displayGenre(String g) {
		if (next == null) {
			if (dvd != null && !dvd.isRented()) {
				if (g.equals(dvd.getGenre())) dvd.display();
			}
		} else {
				if (!dvd.isRented()) {
					if (g.equals(dvd.getGenre())) dvd.display();
				}
				next.displayGenre(g);
		}
	}
	
	public int countGenre(String g) {
		if (next == null) {
			if (g.equals(dvd.getGenre())) {
				return 1;
			}
			return 0;
		}
		if (g.equals(dvd.getGenre())) {
			return 1 + next.countGenre(g);
		}
		return next.countGenre(g);
	}
}
