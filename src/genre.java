public enum genre {

	// attempt to use enum class
	comedy("comedy"), drama("drama"), documentary("documentary"), horror(
			"horror"), romance("romance"), musical("musical");

	private String name;

	private genre(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}