package sample.Graphics;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TopBar extends HBox {
    public TopBar(Stage stage){
        
        this.setMaxHeight(40);
        this.setMinHeight(40);
        this.setStyle("-fx-background-color : #f0f0f0");
        ///the buttons of the top bar
        Circle closeButton = new Circle(10);
        Circle minimizeButton = new Circle(10);
        closeButton.setFill(Color.RED);
        minimizeButton.setFill(Color.YELLOW);
        closeButton.setOnMouseClicked(e->stage.close());
        //adding the children
        this.setPadding(new Insets(10,0,0,10));
        this.setSpacing(15);
        this.getChildren().addAll(closeButton , minimizeButton);
    }
}
