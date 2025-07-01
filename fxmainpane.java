//Name:Michael Antigua
//Cmsc203
//description: fx main

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;

public class FXMainPane extends VBox {
    private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
    private Label feedbackLabel;
    private TextField feedbackTextField;
    private HBox buttonBox, feedbackBox;
    private DataManager dataManager;

    public FXMainPane() {
        
        dataManager = new DataManager();

        
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        feedbackLabel = new Label("Feedback:");
        feedbackTextField = new TextField();

        buttonBox = new HBox();
        feedbackBox = new HBox();

       
        buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);

       
        feedbackBox.getChildren().addAll(feedbackLabel, feedbackTextField);

       
        this.getChildren().addAll(feedbackBox, buttonBox);

        
        buttonBox.setAlignment(Pos.CENTER);
        feedbackBox.setAlignment(Pos.CENTER);

        HBox.setMargin(helloButton, new Insets(10));
        HBox.setMargin(howdyButton, new Insets(10));
        HBox.setMargin(chineseButton, new Insets(10));
        HBox.setMargin(clearButton, new Insets(10));
        HBox.setMargin(exitButton, new Insets(10));

        HBox.setMargin(feedbackLabel, new Insets(10));
        HBox.setMargin(feedbackTextField, new Insets(10));

      
        ButtonHandler handler = new ButtonHandler();
        helloButton.setOnAction(handler);
        howdyButton.setOnAction(handler);
        chineseButton.setOnAction(handler);
        clearButton.setOnAction(handler);
        exitButton.setOnAction(handler);
    }

    
    private class ButtonHandler implements EventHandler<ActionEvent> {
        
        public void handle(ActionEvent event) {
            Object source = event.getTarget();
            if (source == helloButton) {
                feedbackTextField.setText(dataManager.getHello());
            } else if (source == howdyButton) {
                feedbackTextField.setText(dataManager.getHowdy());
            } else if (source == chineseButton) {
                feedbackTextField.setText(dataManager.getChinese());
            } else if (source == clearButton) {
                feedbackTextField.setText("");
            } else if (source == exitButton) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
