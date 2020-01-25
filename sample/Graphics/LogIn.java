package sample.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Agence.Agence;

public class LogIn extends VBox {
    Agence agence;
    public LogIn(Agence agence , Stage stage, Scene scene,Scrolling scroller,SideBarMenu menu , HBox body2, VBox mainLayer){
        VBox body = new VBox();
        body.setStyle("-fx-background-color: #ffffff");
        body.setPadding(new Insets(150, 300,300,300));
        this.agence= agence;
        body.setSpacing(20);
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        txtUserName.setStyle("-fx-border : none");
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Log in");
        body.setAlignment(Pos.CENTER);
        final Label lblMessage = new Label();
        btnLogin.setStyle("-fx-background-color:  #3C005E;" +
                "    -fx-background-radius: 0;" +
                "    -fx-background-insets: 0;" +
                "    -fx-text-fill: white;");
        txtUserName.setStyle("-fx-background-color: #a9a9a9 , white , white;" + "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1");
        pf.setStyle("-fx-background-color: #a9a9a9 , white , white;" + "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1");


        Text text = new Text("ImmoEsi");
        text.setFont(Font.font ("Roboto", 35));
        body.getChildren().addAll(text,lblUserName,txtUserName,lblPassword,pf,btnLogin,lblMessage);
        this.getChildren().addAll(new TopBar(stage) , body);
        btnLogin.setOnMouseClicked(e->{
            if(agence.logIn(txtUserName.getText() , pf.getText())){
                txtUserName.clear();
                pf.clear();
                menu.getChildren().remove(0,2);
                menu.getChildren().remove(1);
                Button logOut = new Button("Log out");
                Button ajouter = new Button("Ajouter");
                Button messages = new Button("Boite");
                menu.getChildren().add(0,logOut);
                menu.getChildren().add(1,ajouter);
                menu.getChildren().add(3,messages);
                ajouter.setOnAction(event->{
                    Add page = new Add(agence, scroller);
                    body2.getChildren().remove(1);
                    body2.getChildren().add(page);
                    mainLayer.getChildren().remove(body2);
                    mainLayer.getChildren().add(body2);
                    stage.setScene(scene);
                    stage.show();
                });
                logOut.setOnAction(event->{
                    body2.getChildren().remove(1);
                    menu.getChildren().remove(0,2);
                    menu.getChildren().remove(1);
                    menu.getChildren().add(0,SideBarMenu.logIn);
                    menu.getChildren().add(1,SideBarMenu.search);
                    menu.getChildren().add(3,SideBarMenu.message);
                    agence.logIn("0","0");
                    scroller.refresh();
                    body2.getChildren().add(scroller);
                    stage.setScene(scene);
                    stage.show();
                });

                scroller.refresh();
                stage.setScene(scene);
                stage.show();
            }else{
                Stage alert = new Stage();
                Label alertmessage = new Label("Access Denied");
                alertmessage.setAlignment(Pos.CENTER);
                Scene alertScene = new Scene(alertmessage, 200,150);
                agence.copyToNewList();
                scroller.refresh();
                stage.setScene(scene);
                stage.show();
                alert.setScene(alertScene);
                alert.show();
            }
        });
    }
}
