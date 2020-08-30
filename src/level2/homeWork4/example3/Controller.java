package level2.homeWork4.example3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public WebView webView;
    @FXML
    public Button btnYandex;

    private WebEngine webEngine;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //        webView.getEngine().getDocument().

        webEngine = webView.getEngine();
        webEngine.getDocument();
        webEngine.loadContent(
                "<!DOCTYPE html> \n" +
                        "<html lang=\"en\"> \n" +
                        "<head> \n" +
                        "<meta charset=UTF-8> \n" +

                        "<style> \n" +
                        "body { \n" +
                        "font-size: 20pt; \n" +
                        "margin: 0; \n" +
                        "color: #55635A; \n" +
                        "background: #BCDCC9; \n" +
                        "border-radius: 10px; \n" +
                        "padding: 5px 10px; \n" +
                        "} \n" +
                        "</style> \n" +
                        "</head> \n" +

                        "<body>" +
                        "<h1 align=\"center\">Привет</h1>" +
                        "Это пример работы компонента WebView" +
                        "</br> Внизу кнопки для просмотра сайтов" +
                        "</br> Думаю без проблем сможете добавить функционал для этого простейшего браузера" +
                        "</body> \n" +

                        "</html> \n");


    }

    public void ClickBtnYandex() {
        webEngine.load("http://yandex.ru");
    }

    public void ClickBtnGoogle() {
        webEngine.load("http://google.com");
    }

    public void ClickBtnTutorial(  ) {
        webEngine.load("https://o7planning.org/ru/11151/javafx-webview-and-webengine-tutorial");
    }
}
