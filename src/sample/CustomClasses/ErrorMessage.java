package sample.CustomClasses;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorMessage {

    // Method that makes a stage and outputs an error message.
    public static void errorWindow(Stage stage, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.setMinWidth(350);

        Label label1 = new Label(message);
        Label label2 = new Label("\nPress Continue when ready.\n");
        Button closeButton = new Button("Continue");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2, closeButton);
        layout.setAlignment(Pos.CENTER);

        window.initOwner(stage);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
