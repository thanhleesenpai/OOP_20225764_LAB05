package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Sắp xếp theo chiều dọc

        // Tiêu đề
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Giá
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Container cho các nút
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nút "Add to cart"
        JButton addToCartButton = new JButton("Add to cart");
        buttonContainer.add(addToCartButton);

        // Nút "Play" (chỉ hiển thị nếu Media hỗ trợ Playable)
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            buttonContainer.add(playButton);

            // Xử lý sự kiện "Play"
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
        }

        // Xử lý sự kiện "Add to cart"
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        // Thêm các thành phần vào MediaStore
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(buttonContainer);
        this.add(Box.createVerticalGlue());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Phát Media trong một cửa sổ thoại (JDialog).
     */
    private void playMedia() {
        if (media instanceof Playable) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing Media");
            playDialog.setSize(300, 200);
            playDialog.setLayout(new BorderLayout());

            JLabel message = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
            playDialog.add(message, BorderLayout.CENTER);

            playDialog.setVisible(true);
        }
    }

    /**
     * Thêm Media vào giỏ hàng (hiển thị trong console).
     */
    private void addToCart() {
        System.out.println("Added to cart: " + media.getTitle());
    }
}
