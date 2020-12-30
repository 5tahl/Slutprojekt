package sample;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.CustomClasses.ErrorMessage;
import sample.CustomClasses.Tutorial;

import java.util.Random;

public class Controller {

    public BorderPane mainStage;

    public TextField inputField;
    public AnchorPane imageField;

    public Button btnSubmit;
    public Button btnSmaller;
    public Button btnBigger;
    public Button btnChangeColor;
    public MenuItem btnTutorial;

    ImageView imageView;
    Integer currentSize;

    // Method that makes the image smaller.
    public void makeImageSmaller() {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        if (currentSize <= 50) {
            ErrorMessage.errorWindow(stage, "You can not make this image any smaller.");
            return;
        }
        imageField.getChildren().remove(imageView);

        currentSize = currentSize - 50;
        imageView.setFitWidth(currentSize);
        imageView.setPreserveRatio(true);

        imageField.getChildren().add(imageView);
    }


    // Method that makes the image bigger.
    public void makeImageBigger() {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        if (currentSize >= 900) {
            ErrorMessage.errorWindow(stage, "You can not make this image any bigger.");
            return;
        }
        imageField.getChildren().remove(imageView);

        currentSize = currentSize + 50;
        imageView.setFitWidth(currentSize);
        imageView.setPreserveRatio(true);

        imageField.getChildren().add(imageView);
    }


    // Method that changes the color of the image to a random color.
    public void changeColorOfImage() {
        imageField.getChildren().remove(imageView);

        ColorAdjust colorAdjust = new ColorAdjust();
        Random random = new Random();
        colorAdjust.setContrast(0.4);
        colorAdjust.setHue(-1 + (1 + 1) * random.nextDouble());

        imageView.setEffect(colorAdjust);

        imageField.getChildren().add(imageView);
    }


    // Method that takes intake from inputField and sets the image.
    public void setImage() {
        imageField.getChildren().remove(imageView);

        String path = inputField.getText();
        Image image = new Image(path);
        imageView = new ImageView(image);

        currentSize = 650;
        imageView.setFitWidth(currentSize);
        imageView.setPreserveRatio(true);

        imageField.getChildren().add(imageView);
    }

    // Method that shows the tutorial window.
    public void showTutorial() {
        Stage stage = (Stage) mainStage.getScene().getWindow();
        Tutorial.tutorialWindow(stage);
    }
}
