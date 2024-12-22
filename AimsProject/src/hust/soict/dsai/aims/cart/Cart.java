package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>(); 

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) { 
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Items in cart:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: $" + totalCost());
    }
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public ArrayList<Media> getItems() {
        return itemsOrdered;
    }
    public Media findMediaById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
    public void clear() {
    	itemsOrdered.clear();
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) { 
                return media;
            }
        }
        return null; 
    }

    public String printCart() {
    	String info = "";
        if (itemsOrdered.isEmpty()) {
            info = "The cart is empty";
        }
        else {
            info += ("***********************CART***********************\n");
            info += "Ordered Items:\n";
            for (Media item : itemsOrdered) {
                info += (item.toString()) + "\n";
            }
            info = info + "Total cost: " + totalCost();
            info += "***************************************************\n";
        }
        return info;
    }
    public void emptyCart() {
    	itemsOrdered.clear();
    }


}
