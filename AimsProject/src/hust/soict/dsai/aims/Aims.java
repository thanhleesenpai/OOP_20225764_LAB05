package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;



public class Aims {
    public static void main(String[] args) {
//        Store store = new Store();
//
//        Cart cart = new Cart();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
//
//        ArrayList<String> authors = new ArrayList<>();
//        authors.add("James Gosling");
//        authors.add("Herbert Schildt");
//        Book book1 = new Book(1, "Java Programming", "Education", 39.99f, authors);
//
//        CompactDisc cd1 = new CompactDisc(2, "Greatest Hits", "Music", 29.95f, 0, "Various Artists", "Queen");
//        Track track1 = new Track("Bohemian Rhapsody", 354);
//        Track track2 = new Track("Another One Bites the Dust", 215);
//        cd1.addTrack(track1);
//        cd1.addTrack(track2);
//
//        store.addMedia(dvd1);
//        store.addMedia(dvd2);
//        store.addMedia(book1);
//        store.addMedia(cd1);
//
//        System.out.println("Contents of the store:");
//        store.printStore();
//
//        cart.addMedia(dvd1);
//        cart.addMedia(book1);
//        cart.addMedia(cd1);
//
//        System.out.println("\nContents of the cart:");
//        cart.displayCart();
//
//        store.removeMedia(dvd2);
//        System.out.println("\nAfter removing a DVD from the store:");
//        store.printStore();
//
//        System.out.println("\nPlaying a CompactDisc:");
//        cd1.play();
//
//        System.out.println("\nTotal cost in cart: $" + cart.totalCost());
    	 // Tạo Store và Cart
        Store store = new Store();
        Cart cart = new Cart();
        ArrayList<String> authors = new ArrayList<>();
        authors.add("James Gosling");

        // Thêm các sản phẩm vào Store
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f));
        store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 14.99f));
        store.addMedia(new CompactDisc(1, "Thriller", "Pop", 9.99f, 42, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new Book(2, "Effective Java", "Programming", 45.00f, authors));

        // Tạo Scanner để lấy đầu vào từ người dùng
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Hiển thị menu chính
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline sau khi người dùng nhập

            switch (choice) {
                case 1:
                    // Xem cửa hàng
                    System.out.println("\n--- Store ---");
                    store.printStore(); // Hiển thị các sản phẩm trong cửa hàng
                    storeMenu(); // Hiển thị menu các tùy chọn trong cửa hàng
                    handleStoreMenu(scanner, store, cart); // Xử lý lựa chọn từ menu cửa hàng
                    break;
                case 2:
                	// Cập nhật cửa hàng
                    System.out.println("\n--- Update Store ---");
                    System.out.println("1. Add a media to the store");
                    System.out.println("2. Remove a media from the store");
                    System.out.println("0. Back");
                    System.out.print("Please choose an option: ");

                    int updateChoice = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ ký tự newline

                    switch (updateChoice) {
                        case 1:
                            // Thêm media vào cửa hàng
                            System.out.println("Select the type of media to add:");
                            System.out.println("1. Book");
                            System.out.println("2. Digital Video Disc (DVD)");
                            System.out.println("3. Compact Disc (CD)");
                            System.out.print("Enter your choice: ");
                            int mediaType = scanner.nextInt();
                            scanner.nextLine(); // Đọc bỏ ký tự newline

                            switch (mediaType) {
                                case 1: // Thêm Book
                                    System.out.print("Enter the title: ");
                                    String bookTitle = scanner.nextLine();
                                    System.out.print("Enter the category: ");
                                    String bookCategory = scanner.nextLine();
                                    System.out.print("Enter the cost: ");
                                    float bookCost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc bỏ ký tự newline
                                    System.out.print("Enter the authors (comma-separated): ");
                                    String authorsInput = scanner.nextLine();
                                    ArrayList<String> authors1 = new ArrayList<>();
                                    authors1.add(authorsInput);
                                    //ArrayList<String> authors1 = new ArrayList<>(List.of(authorsInput.split(",")));

                                    Media newBook = new Book(store.getItems().size() + 1, bookTitle, bookCategory, bookCost, authors1);
                                    store.addMedia(newBook);
                                    System.out.println("Added to store: " + newBook.getTitle());
                                    break;

                                case 2: // Thêm DVD
                                    System.out.print("Enter the title: ");
                                    String dvdTitle = scanner.nextLine();
                                    System.out.print("Enter the category: ");
                                    String dvdCategory = scanner.nextLine();
                                    System.out.print("Enter the cost: ");
                                    float dvdCost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc bỏ ký tự newline
                                    System.out.print("Enter the director: ");
                                    String dvdDirector = scanner.nextLine();
                                    System.out.print("Enter the length: ");
                                    int dvdLength = scanner.nextInt();
                                    scanner.nextLine(); // Đọc bỏ ký tự newline

                                    Media newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                                    store.addMedia(newDVD);
                                    System.out.println("Added to store: " + newDVD.getTitle());
                                    break;

                                case 3: // Thêm CD
                                    System.out.print("Enter the title: ");
                                    String cdTitle = scanner.nextLine();
                                    System.out.print("Enter the category: ");
                                    String cdCategory = scanner.nextLine();
                                    System.out.print("Enter the cost: ");
                                    float cdCost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc bỏ ký tự newline
                                    System.out.print("Enter the artist: ");
                                    String cdArtist = scanner.nextLine();
                                    System.out.print("Enter the director: ");
                                    String cdDirector = scanner.nextLine();

                                    Media newCD = new CompactDisc(store.getItems().size() + 1, cdTitle, cdCategory, cdCost, 0, cdDirector, cdArtist);
                                    store.addMedia(newCD);
                                    System.out.println("Added to store: " + newCD.getTitle());
                                    break;

                                default:
                                    System.out.println("Invalid media type. Returning to update store menu.");
                            }
                            break;

                        case 2:
                            // Xóa media khỏi cửa hàng
                            System.out.print("Enter the title of the media to remove: ");
                            String titleToRemove = scanner.nextLine();
                            Media mediaToRemove = store.findMediaByTitle(titleToRemove);
                            if (mediaToRemove != null) {
                                store.removeMedia(mediaToRemove);
                                System.out.println("Removed from store: " + mediaToRemove.getTitle());
                            } else {
                                System.out.println("Media not found.");
                            }
                            break;

                        case 0:
                            // Quay lại menu chính
                            System.out.println("Going back to main menu...");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 3:
                    // Xem giỏ hàng hiện tại
                    System.out.println("\n--- Current Cart ---");
                    cart.displayCart(); // Hiển thị các mục trong giỏ hàng
                    handleCartMenu(scanner, cart); // Gọi phương thức xử lý menu của giỏ hàng
                    break;
                case 0:
                    // Thoát khỏi chương trình
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Hiển thị menu chính
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Hiển thị menu của cửa hàng
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }
    
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }


    // Xử lý lựa chọn từ menu cửa hàng
    public static void handleStoreMenu(Scanner scanner, Store store, Cart cart) {
        int storeChoice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự newline

        switch (storeChoice) {
            case 1:
            	 // Xem chi tiết một media
                System.out.print("Enter the title of the media to see details: ");
                String titleToView = scanner.nextLine();
                Media mediaToView = store.findMediaByTitle(titleToView);
                if (mediaToView != null) {
                    System.out.println(mediaToView.toString());
                    handleMediaDetailsMenu(scanner, mediaToView, cart); // Gọi menu chi tiết media
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 2:
            	 // Thêm media vào giỏ hàng
                System.out.print("Enter the title of the media to add to cart: ");
                String titleToAdd = scanner.nextLine();
                Media mediaToAdd = store.findMediaByTitle(titleToAdd);
                if (mediaToAdd != null) {
                    cart.addMedia(mediaToAdd);
                    System.out.println("Added to cart: " + mediaToAdd.getTitle());
                    
                    // Hiển thị số lượng DVD trong giỏ hàng
                    long dvdCount = cart.getItems().stream()
                                      .filter(item -> item instanceof DigitalVideoDisc)
                                      .count();
                    System.out.println("Number of DVDs in the cart: " + dvdCount);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 3:
                // Phát một media
                System.out.print("Enter the title of the media to play: ");
                String titleToPlay = scanner.nextLine();
                Media mediaToPlay = store.findMediaByTitle(titleToPlay);
                if (mediaToPlay != null && mediaToPlay instanceof Playable) {
                    ((Playable) mediaToPlay).play();
                } else {
                    System.out.println("Media not found or media is not playable.");
                }
                break;
            case 4:
                // Xem giỏ hàng
                System.out.println("\n--- Current Cart ---");
                cart.displayCart();
                break;
            case 0:
                // Quay lại menu chính
                System.out.println("Going back to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
      }
    public static void handleMediaDetailsMenu(Scanner scanner1, Media media, Cart cart1) {
        while (true) {
            mediaDetailsMenu();
            int mediaChoice = scanner1.nextInt();
            scanner1.nextLine(); // Đọc bỏ ký tự newline

            switch (mediaChoice) {
                case 1:
                    // Thêm Media vào giỏ hàng
                    cart1.addMedia(media);
                    System.out.println("Added to cart: " + media.getTitle());
                    break;
                case 2:
                    // Phát Media (chỉ áp dụng với Playable)
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
                case 0:
                    // Quay lại menu trước
                    System.out.println("Going back...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    public static void handleCartMenu(Scanner scanner, Cart cart) {
        while (true) {
            cartMenu();
            int cartChoice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự newline

            switch (cartChoice) {
                case 1: // Filter medias in cart
                    System.out.println("Filter by:");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.print("Choose an option: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (filterChoice) {
                        case 1: // Filter by ID
                            System.out.print("Enter the ID to filter: ");
                            int idToFilter = scanner.nextInt();
                            scanner.nextLine();
                            Media mediaById = cart.findMediaById(idToFilter);
                            if (mediaById != null) {
                                System.out.println("Filtered Media: " + mediaById.toString());
                            } else {
                                System.out.println("No media found with this ID.");
                            }
                            break;
                        case 2: // Filter by Title
                            System.out.print("Enter the Title to filter: ");
                            String titleToFilter = scanner.nextLine();
                            Media mediaByTitle = cart.findMediaByTitle(titleToFilter);
                            if (mediaByTitle != null) {
                                System.out.println("Filtered Media: " + mediaByTitle.toString());
                            } else {
                                System.out.println("No media found with this Title.");
                            }
                            break;
                        default:
                            System.out.println("Invalid filter option.");
                    }
                    break;

                case 2: // Sort medias in cart
                    System.out.println("Sort by:");
                    System.out.println("1. Title");
                    System.out.println("2. Cost");
                    System.out.print("Choose an option: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (sortChoice) {
                        case 1: // Sort by Title
                            cart.sortByTitleThenCost();
                            System.out.println("Cart sorted by Title.");
                            break;
                        case 2: // Sort by Cost
                            cart.sortByCostThenTitle();
                            System.out.println("Cart sorted by Cost.");
                            break;
                        default:
                            System.out.println("Invalid sort option.");
                    }
                    break;

                case 3: // Remove media from cart
                    System.out.print("Enter the Title of the media to remove: ");
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.findMediaByTitle(titleToRemove);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                        System.out.println("Removed from cart: " + mediaToRemove.getTitle());
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;

                case 4: // Play a media
                    System.out.print("Enter the Title of the media to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.findMediaByTitle(titleToPlay);
                    if (mediaToPlay != null && mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("Media not found or media is not playable.");
                    }
                    break;

                case 5: // Place order
                    System.out.println("An order has been created. The cart is now empty.");
                    cart.clear(); // Xóa tất cả 
                    break;

                case 0: // Back
                    System.out.println("Returning to main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
