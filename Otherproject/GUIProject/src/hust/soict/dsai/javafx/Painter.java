package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Tải file FXML
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/javafx/Painter.fxml"));
        
        // Tạo Scene và thiết lập Stage
        Scene scene = new Scene(root);
        stage.setTitle("Painter"); // Đặt tiêu đề cửa sổ
        stage.setScene(scene);    // Gán Scene cho Stage
        stage.show();             // Hiển thị Stage
    }

    public static void main(String[] args) {
        launch(args); // Khởi chạy ứng dụng JavaFX
    }
}
