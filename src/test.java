import java.util.Scanner;


public class test {
	private enum genre {
		comedy("comedy"), drama("drama"), documentary("documentary"), horror("horror"), romance("romance"), musical("musical");
		private String name;
		private genre(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD d = new DVD("abc",0);
		Linked temp = new Linked(d,null);
		Linked temp2 = new Linked(d,temp);
		System.out.print("b".compareTo("abb"));
		d.display();
		//temp2.display();
		
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Enter three unique integer values.");
		/*
		int b = scanner1.nextInt();
		String s = scanner2.nextLine();
		int a = scanner1.nextInt();
		System.out.print(s.length());
		System.out.println(a+b);
		*/
		genre gen = genre.comedy;
		System.out.println(gen);
		System.out.println(gen.toString().equals("comedy"));
		
		switch (gen.toString()) {
		case "comedy":
			System.out.print("ss");
		}
		
	}

}
