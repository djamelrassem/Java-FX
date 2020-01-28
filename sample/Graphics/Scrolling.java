package sample.Graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Agence.*;
import sample.Bien.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class Scrolling extends ScrollPane {
    private Agence agence;

    private HBox body;
    private GridPane grid = new GridPane();

    public Scrolling(Agence agence, HBox body) {
        this.agence = agence;
        this.setStyle("-fx-background-color :  #ffffff");

        this.body = body;
        grid.setStyle("-fx-background-color : #ffffff");
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        grid.setHgap(30);
        grid.setVgap(20);
        int row = 0, column = 0;
        List<Bien> biens = new ArrayList<Bien>();
        if (agence.getAccess()) {
            biens = agence.getBiensAdmin();

        } else{
            biens= agence.getBien();
        }
        for (Bien bien : biens) {


            StackPane stack = new StackPane();
            Rectangle rect = new Rectangle();
            rect.setHeight(390);
            rect.setWidth(410);
            rect.setFill(Color.WHITE);
            stack.getChildren().add(rect);
            stack.setStyle("-fx-background-color : #f0f0f0");
            VBox item = new VBox();
            item.setSpacing(10);
            item.getStyleClass().add("image");
            item.setStyle("-fx-background-color : #f0f0f0");
            Image image = new Image(bien.getPhotoURL(), 410, 300, false, true);
            ImageView view = new ImageView();
            view.setImage(image);

            Rectangle clip = new Rectangle(
                    410, 300
            );
            clip.setArcWidth(30);
            clip.setArcHeight(30);
            view.setClip(clip);


            double price = bien.getPrix();
            String adress = bien.getAdresse();
            Label prix = new Label();

            prix.setText(String.valueOf(((int) bien.calculeprix())) + " DA");
            prix.setPadding(new Insets(0, 10, 0, 10));
            Label adr = new Label();
            adr.setText(adress);
            adr.setPadding(new Insets(0, 10, 0, 10));
            prix.getStyleClass().add("price");
            adr.getStyleClass().add("adress");
            item.getChildren().addAll(view, adr, prix);
            stack.getChildren().add(item);
            item.setOnMouseClicked(e -> {
                Description description = new Description(body, agence, bien, this);
                body.getChildren().remove(this);
                body.getChildren().add(description);
            });
            grid.add(stack, column % 2, row);
            column++;
            if (column % 2 == 0) {
                row++;
            }

        }
        this.setContent(grid);
        this.setPadding(new Insets(45));
    }


    public void refresh(){
        grid.getChildren().clear();
        int row = 0, column = 0;
        List<Bien> biens = new ArrayList<Bien>();
        if (agence.getAccess()) {
            biens = agence.getBiensAdmin();
        } else{
            biens= agence.getBien();
        }
        for (Bien bien : biens) {
            StackPane stack = new StackPane();
            stack.setStyle("-fx-background-color : #f0f0f0");
            Rectangle rect = new Rectangle();
            rect.setHeight(390);
            rect.setWidth(410);
            rect.setFill(Color.WHITE);
            stack.getChildren().add(rect);

            VBox item = new VBox();
            item.setSpacing(10);
            item.getStyleClass().add("image");
            item.setStyle("-fx-background-color : #f0f0f0");
            Image image = new Image(bien.getPhotoURL(), 410, 300, false, true);
            ImageView view = new ImageView();
            view.setImage(image);

            Rectangle clip = new Rectangle(
                    410, 300
            );
            clip.setArcWidth(30);
            clip.setArcHeight(30);
            view.setClip(clip);


            double price = bien.getPrix();
            String adress = bien.getAdresse();
            Label prix = new Label();

            prix.setText(String.valueOf(((int) bien.calculeprix())) + " DA");
            prix.setPadding(new Insets(0, 10, 0, 10));
            Label adr = new Label();
            adr.setText(adress);
            adr.setPadding(new Insets(0, 10, 0, 10));
            prix.getStyleClass().add("price");
            adr.getStyleClass().add("adress");
            item.getChildren().addAll(view, adr, prix);
            stack.getChildren().add(item);
            item.setOnMouseClicked(e -> {
                Description description = new Description(body, agence, bien, this);
                body.getChildren().remove(this);
                body.getChildren().add(description);
            });
            grid.add(stack, column % 2, row);
            column++;
            if (column % 2 == 0) {
                row++;
            }

        }
        this.setContent(grid);
    }
}