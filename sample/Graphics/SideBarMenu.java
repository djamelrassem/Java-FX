package sample.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.*;
import sample.Agence.Agence;

import java.awt.*;

public class SideBarMenu extends VBox {
    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;

    public static Button logIn = new Button("Log in");
    public static Button search= new Button("Rechercher");
    public static Button home= new Button("Accueil");
    public static Button message= new Button("Messages");

    public SideBarMenu(Stage stage){
        this.scene2 = scene1;
        this.scene2= scene2;
        this.scene3=scene3;
        this.scene4= scene4;
        this.setMinWidth(200);
        this.setStyle("-fx-background-color : #d0d0d0");
        this.setPadding(new Insets(40,40,0,40));
        this.setSpacing(90);

        this.getChildren().addAll(logIn , search, home , message);
        this.setAlignment(Pos.CENTER);
        ///menu options

    }

    public void setScene1(Stage stage, Scene scene1) {
        this.scene1 = scene1;
        logIn.setOnMouseClicked(e->{
            stage.setScene(scene1);
            stage.show();
        });
    }

    public void setScene2(Stage stage, Scene scene2 , HBox body , VBox mainLayer , Agence agence,Scrolling scroller, SearchPage searchPage) {
        this.scene2 = scene2;
        search.setOnMouseClicked(e->{

            body.getChildren().remove(1);
            body.getChildren().add(searchPage);
            mainLayer.getChildren().remove(body);
            mainLayer.getChildren().add(body);
            stage.setScene(scene2);
            stage.show();
        });
    }

    public void setScene3(Stage stage ,Scene scene3,HBox body , VBox mainLayer , Scrolling scroller) {
        this.scene3 = scene3;
        home.setOnMouseClicked(e->{
            body.getChildren().remove(1);
            scroller.refresh();
            body.getChildren().add(scroller);
            mainLayer.getChildren().remove(body);
            mainLayer.getChildren().add(body);
            stage.setScene(scene3);
            stage.show();
        });
    }

    public void setScene4(Stage stage , Scene scene3,HBox body , VBox mainLayer , Scrolling scroller, Agence agence) {
        this.scene4 = scene4;
        message.setOnMouseClicked(e->{
            body.getChildren().remove(1);
            body.getChildren().add(new Label(agence.getListemessage().get(0)));
            mainLayer.getChildren().remove(body);
            mainLayer.getChildren().add(body);
            stage.setScene(scene3);
            stage.show();
        });
    }
}
