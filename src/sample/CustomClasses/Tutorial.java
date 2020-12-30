package sample.CustomClasses;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tutorial {

    // Method that makes a stage and shows a tutorial.
    public static void tutorialWindow(Stage stage) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tutorial");
        window.setMinWidth(350);

        Label label1 = new Label("Welcome to a tutorial for customising your images.");
        Label label2 = new Label("\nYou choose your image by inputting a URL to a image of your choice and pressing Submit.");
        Label label3 = new Label("\nYou can customise your image by pressing one of 3 buttons.");
        Label label4 = new Label("The first button makes your image smaller by 50 pixels.");
        Label label5 = new Label("The second button makes your image bigger by 50 pixels.");
        Label label6 = new Label("The third button changes the color of your image to a random color.");
        Label label7 = new Label("\nPress Continue when ready.\n");
        Button closeButton = new Button("Continue");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, closeButton);
        layout.setAlignment(Pos.CENTER);

        window.initOwner(stage);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
