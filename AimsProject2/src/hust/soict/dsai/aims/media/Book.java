package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<>();

	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
	    super(id, title, category, cost);
	    this.authors = authors;
	}

	public void addAuthor(String authorName) {
	    if (!authors.contains(authorName)) {
	        authors.add(authorName);
	    } else {
	        System.out.println("Author already exists in the list.");
	    }
	}
	public void removeAuthor(String authorName) {
	    if (authors.contains(authorName)) {
	        authors.remove(authorName);
	    } else {
	        System.out.println("Author not found in the list.");
	    }
	}
	@Override
    public String toString() {
        return "Book [Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + "]";
    }

}
