package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;

public class Controller implements Initializable{

    @FXML
    private WebView webView;
    @FXML
    private Hyperlink hlBackward;
    @FXML
    private Hyperlink hlForward;
    @FXML
    private Hyperlink hlReload;
    @FXML
    private Hyperlink hlHome;
    @FXML
    private Hyperlink hlSearch;
    @FXML
    private Hyperlink hlZoomIn;
    @FXML
    private Hyperlink hlZoomOut;
    @FXML
    private Hyperlink hlFontSizeUp;
    @FXML
    private Hyperlink hlFontSizeDown;
    @FXML
    private Hyperlink hlAbout;
    @FXML
    private Hyperlink hlYoutube;
    @FXML
    private TextField tfSearch;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //create a webEngine object
        WebEngine webEngine = webView.getEngine();
        //load a default web page
        webEngine.load("https://www.google.com");
        //get useragent http header
        System.out.println(webEngine.getUserAgent());
        //Create web history
        WebHistory webHistory =webEngine.getHistory();
        //Go backward link
        hlBackward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //webHistory.go(-1);
                webEngine.executeScript("history.back()");
            }
        });
        //Go forward link
        hlForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webHistory.go(1);
            }
        });
        //Home link
        hlHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.load("https://www.google.com");
            }
        });

        //Reload link
        hlReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.reload();
            }
        });

        //Search link
        hlSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.load(tfSearch.getText());
            }
        });
        //Zoom In link
        hlZoomIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size= 1.0;
                size =webView.getZoom() +0.1;
                webView.setZoom(size);
            }
        });
        //Zoom out link
        hlZoomOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size= 1.0;
                size =webView.getZoom() - 0.1;
                webView.setZoom(size);
            }
        });
        //Font + link
        hlFontSizeUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size=1.0;
                size =webView.getFontScale() + 0.1;
                webView.setFontScale(size);
            }
        });
        //Font - link
        hlFontSizeDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size=1.0;
                size =webView.getFontScale() - 0.1;
                webView.setFontScale(size);
            }
        });
        //About link
        hlAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             String content = "this is my frist try of a web browser";

             webEngine.loadContent(content,"text/html");
            }
        });
        //Youtube link
        hlYoutube.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            String script ="window.location=\"https://www.youtube.com\"";

            webEngine.executeScript(script);
            }
        });
    }

}
