package level2.homeWork4.exampleSceneBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField textField;
    @FXML
    private TextArea textArea;

    public void onClickBtnHello(ActionEvent actionEvent) {
        textArea.appendText("Hello!\n");
        System.out.println(((Button) actionEvent.getSource()).getText());
        System.out.println(actionEvent.getSource().getClass().getName());
    }


    public void onClickBtnSend(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.requestFocus();
    }
}
