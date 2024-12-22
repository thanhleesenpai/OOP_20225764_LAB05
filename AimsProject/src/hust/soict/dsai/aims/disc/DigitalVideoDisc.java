package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public static int getnbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
	    this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
	    this.category = category;
	    this.title = title;
	    this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
	    this.director = director;
	    this.category = category;
	    this.title = title;
	    this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	    this.title = title;
	    this.category = category;
	    this.director = director;
	    this.length = length;
	    this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String category) {
		super();
		this.category = category;
	}
	public DigitalVideoDisc(String director) {
		super();
		this.director = director;
	}
	public DigitalVideoDisc(int length) {
		super();
		this.length = length;
	}
	public DigitalVideoDisc(float cost) {
		super();
		this.cost = cost;
	}
	public void setTitle(String title) {
	    this.title = title;
	}
	public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
	
	public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title); // So sánh tiêu đề không phân biệt chữ hoa/thường
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + (category != null ? category : "Unknown") + " - "
                + (director != null ? director : "Unknown") + " - " + length + ": " + cost + "f";
    }
}

