package level2.homeWork4.exampleadd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Random;

public class Controller {
    @FXML
    public VBox vbox;
    Random random = new Random();

    public void onClickBtnAdd(ActionEvent actionEvent) {
        int x = random.nextInt(20) + 1;
        Button button = new Button("Button " + x);
        vbox.getChildren().add(button);

        button.setOnAction(e->{
            System.out.println(x);
            vbox.getChildren().remove(button);
        });

    }
}
