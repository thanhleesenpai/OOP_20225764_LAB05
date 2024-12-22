package hust.soict.dsai.aims.media;

public class TestMedia {
    public static void main(String[] args) {
        // Tạo đối tượng Book
        Book book = new Book();
        book.setId(1);
        book.setTitle("OOP in Java");
        book.setCategory("Education");
        book.setCost(25.5f);

        // Hiển thị thông tin Book
        System.out.println("Book Info:");
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Category: " + book.getCategory());
        System.out.println("Cost: $" + book.getCost());

        // Tạo đối tượng DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        dvd.setId(2);
        dvd.setTitle("Star Wars");
        dvd.setCategory("Sci-Fi");
        dvd.setCost(15.0f);

        // Hiển thị thông tin DVD
        System.out.println("\nDVD Info:");
        System.out.println("ID: " + dvd.getId());
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Category: " + dvd.getCategory());
        System.out.println("Cost: $" + dvd.getCost());
        System.out.println(dvd.getLength());

    }
}
