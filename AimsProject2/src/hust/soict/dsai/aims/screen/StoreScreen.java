package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store; // Thuộc tính lưu thông tin các sản phẩm trong cửa hàng

//    public StoreScreen(Store store) {
//        this.store = store;
//
//        // Thiết lập Container và Layout
//        Container cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//
//        // Thêm các thành phần giao diện
//        cp.add(createNorth(), BorderLayout.NORTH);
//
//        // Thiết lập JFrame
//        setTitle("Store Screen");
//        setSize(1024, 768);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
    public StoreScreen(Store store) {
        this.store = store; // Lưu trữ cửa hàng

        // Lấy ContentPane của JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout()); // Thiết lập bố cục chính

        // Thêm các thành phần giao diện
        cp.add(createNorth(), BorderLayout.NORTH); // Phần NORTH
        cp.add(createCenter(), BorderLayout.CENTER); // Phần CENTER

        // Thiết lập JFrame
        setTitle("Store"); // Tiêu đề cửa sổ
        setSize(1024, 768); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi tắt cửa sổ
        setVisible(true); // Hiển thị cửa sổ
    }

    /**
     * Tạo phần NORTH cho màn hình, bao gồm menu bar và header.
     */
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    /**
     * Tạo menu bar với các tùy chọn.
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Tạo menu "Options"
        JMenu menu = new JMenu("Options");

        // Sub-menu "Update Store"
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        // Các mục menu khác
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        // Thêm menu vào menu bar
        menuBar.add(menu);
        return menuBar;
    }

    /**
     * Tạo tiêu đề header cho phần NORTH.
     */
    private JPanel createHeader() {
        // Tạo panel header
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        // Tạo tiêu đề
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50)); // Font chữ lớn
        title.setForeground(Color.CYAN); // Màu chữ Cyan

        // Tạo nút "View cart"
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        // Sắp xếp các thành phần trong header
        header.add(Box.createRigidArea(new Dimension(10, 10))); // Khoảng cách trước tiêu đề
        header.add(title); // Thêm tiêu đề
        header.add(Box.createHorizontalGlue()); // Đẩy các thành phần sang 2 bên
        header.add(cart); // Thêm nút "View cart"
        header.add(Box.createRigidArea(new Dimension(10, 10))); // Khoảng cách sau nút

        return header;
    }
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // Bố cục 3x3

        // Lấy danh sách sản phẩm từ cửa hàng
        java.util.ArrayList<hust.soict.dsai.aims.media.Media> mediaInStore = store.getItems();

        // Kiểm tra nếu cửa hàng trống
        if (mediaInStore.isEmpty()) {
            JLabel emptyMessage = new JLabel("The store is empty!");
            emptyMessage.setHorizontalAlignment(SwingConstants.CENTER);
            center.add(emptyMessage);
            return center;
        }

        // Thêm các sản phẩm vào lưới
        int numberOfItemsToDisplay = Math.min(mediaInStore.size(), 9); // Hiển thị tối đa 9 sản phẩm
        for (int i = 0; i < numberOfItemsToDisplay; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        // Khởi tạo StoreScreen với đối tượng Store giả lập
        Store store = new Store(); // Bạn cần triển khai lớp Store trước khi chạy.
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("James Gosling");
        authors.add("Herbert Schildt");
        Book book1 = new Book(1, "Java Programming", "Education", 39.99f, authors);
        new StoreScreen(store);
        store.addMedia(book1);
        store.addMedia(dvd1);
        new StoreScreen(store);
    }
    
}
