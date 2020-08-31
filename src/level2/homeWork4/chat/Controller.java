package level2.homeWork4.chat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Date;

public class Controller {
    @FXML
    public TextField textField;
    @FXML
    private TextArea textArea;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
            }
        });
        textField.requestFocus();
    }

    @FXML
    public void onClickBtnSend(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    @FXML
    public void onEnter(ActionEvent actionEvent) {
        onClickBtnSend(actionEvent);
    }
}
