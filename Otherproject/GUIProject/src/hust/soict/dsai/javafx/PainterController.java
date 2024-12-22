package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class PainterController {
    @FXML
    private Pane drawingAreaPane; // Khu vực vẽ
    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    /**
     * Xử lý sự kiện khi chuột được kéo trên khu vực vẽ.
     * Vẽ một hình tròn nhỏ (điểm) tại vị trí chuột.
     * 
     * @param event Sự kiện kéo chuột (MouseEvent)
     */
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Tạo một hình tròn tại tọa độ chuột
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        // Thêm hình tròn vào Pane
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    void eraser(MouseEvent event) {
        // Tạo một hình tròn tại tọa độ chuột
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        // Thêm hình tròn vào Pane
        drawingAreaPane.getChildren().add(newCircle);
    }

    /**
     * Xử lý sự kiện khi nhấn nút "Clear".
     * Xóa tất cả các đối tượng con trong khu vực vẽ.
     * 
     * @param event Sự kiện nhấn nút (ActionEvent)
     */
    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa tất cả các phần tử trong Pane
        drawingAreaPane.getChildren().clear();
    }
}

