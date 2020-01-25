package sample.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Agence.Agence;
import sample.Bien.Bien;

public class Description extends VBox {
    public Description(HBox body,Agence agence , Bien bien , Scrolling scroller){
        this.setPadding(new Insets(10));
        this.getChildren().clear();
        this.setStyle("-fx-background-color : white");

        Button button = new Button("Envoyer");
        final TextField message = new TextField();
        button.setOnAction(event->{
            agence.message(message.getText());
            message.clear();
        });
        HBox messageArea = new HBox();
        message.setStyle("-fx-background-color: #a9a9a9 , white , white;" + "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1");
        HBox content = new HBox();
        HBox icons = new HBox();
        Button edit = new Button("Editer");
        Button remove = new Button("Supprimer");
        edit.setOnAction(e->
        {
            if(agence.getAccess()){
                EditPage editPage = new EditPage(bien, body,scroller,agence);
                body.getChildren().remove(this);
                body.getChildren().add(editPage);
            }else{
                Stage alert = new Stage();
                Label alertMessage = new Label("You are not Admin");
                alertMessage.setAlignment(Pos.CENTER);
                Scene alertScene = new Scene(alertMessage , 250,100);
                alert.setScene(alertScene);
                alert.show();
            }

        });
        remove.setOnAction(e->
        {
            if(agence.getAccess()){
                agence.remove(bien);
                scroller.refresh();
                body.getChildren().remove(this);
                body.getChildren().add(scroller);
            }else{
                Stage alert = new Stage();
                Label alertMessage = new Label("You are not Admin");
                alertMessage.setAlignment(Pos.CENTER);
                Scene alertScene = new Scene(alertMessage , 250,100);
                alert.setScene(alertScene);
                alert.show();
            }

        });
        icons.setPadding(new Insets(0,0,0,40));
        icons.getChildren().addAll(edit, remove);
        messageArea.getChildren().addAll(message,button, icons);
        message.setMinWidth(550);
        messageArea.setSpacing(20);
        messageArea.setPadding(new Insets(0,20,0,20));
        content.setMinHeight(550);
        content.setPadding(new Insets(40));
        content.setSpacing(30);
        ImageView imageClicked = new ImageView();
        Image imageSource = new Image(bien.getPhotoURL() , 480 , 480 , true , true);
        imageClicked.setImage(imageSource);
        imageClicked.setFitWidth(480);
        Rectangle clip2 = new Rectangle(
                410,310
        );
        clip2.setArcWidth(30);
        clip2.setArcHeight(30);
        imageClicked.setClip(clip2);

        Label info = new Label(bien.getInfos());
        info.setStyle("-fx-font-size:20px;");
        Circle cancel = new Circle();
        cancel.setRadius(10);
        cancel.setFill(Color.RED);
        cancel.setOnMouseClicked(event->{
            body.getChildren().remove(this);
            body.getChildren().add(scroller);
        });
        VBox infos = new VBox();

        this.setMinSize(720*1.6 ,720);
        infos.getChildren().addAll(info);
        content.getChildren().addAll(imageClicked, infos);
        this.getChildren().addAll(cancel,content ,messageArea);
    }
}
