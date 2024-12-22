package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(int id, String title, String category, float cost) {
	    this.id = id;
	    this.title = title;
	    this.category = category;
	    this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; 
	    if (obj == null || getClass() != obj.getClass()) return false; 

	    Media media = (Media) obj;
	    return this.title != null && this.title.equalsIgnoreCase(media.title);
	}
	@Override
	public String toString() {
	    return "Media [Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + "]";
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

}
