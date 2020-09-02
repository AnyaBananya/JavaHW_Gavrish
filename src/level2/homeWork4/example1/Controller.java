package level2.homeWork4.example1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public Slider slider;

    public void sliderOnMouseReleased(MouseEvent mouseEvent) {
        Platform.runLater(()->{
            Stage stage = (Stage)slider.getScene().getWindow();
            stage.setTitle("slider : "+slider.getValue());
        });
    }

    public void clickClose(ActionEvent actionEvent) {
        Platform.runLater(()->{
            Stage stage = (Stage)slider.getScene().getWindow();
            stage.close();
        });
    }
}
