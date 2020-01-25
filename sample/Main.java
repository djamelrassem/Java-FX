package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import sample.Graphics.*;
import sample.Agence.*;
import sample.Bien.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application{

    Scene scene1 ;
    Scene scene2 ;
    Stage stage = new Stage(StageStyle.UNDECORATED);

    public static Scene homePage;
    static Scene logIn;
    static Scene search;
    public static Wilaya wilaya1 = new Wilaya("wilaya1", 100000);
    public static Wilaya wilaya2 = new Wilaya("wilaya2", 30000);
    public static Wilaya wilaya3 = new Wilaya("wilaya3", 60000);
    public static List<Wilaya> wilayas = new ArrayList<Wilaya>();
    @Override
    public void start(Stage primaryStage) throws Exception {

        wilayas.add(wilaya1);
        wilayas.add(wilaya2);
        wilayas.add(wilaya3);
        Agence agence = new Agence();

        agence.logIn("admin", "admin");
        Proprietaire prop1 = new Proprietaire("prop", "1", "prop1@abc.com", 01234, "---");
        agence.addUser(prop1);
        Proprietaire prop2 = new Proprietaire("prop", "2", "prop2@abc.com", 7894, "---");
        agence.addUser(prop2);
        Proprietaire prop3 = new Proprietaire("prop", "3", "prop3@abc.com", 4220, "---");
        agence.addUser(prop3);
        Proprietaire prop4 = new Proprietaire("prop", "4", "prop3@abc.com", 4948, "---");
        agence.addUser(prop4);


        Maison maison1 = new Maison("wilaya3 , Rue 15 , Cite 2", wilaya3, 200, prop1, "01/01/2020", "lorem ipsum", 10000000.0, "images/1.jpg",
                Transaction.Vente, 4, true, 3, false, false, true);
        agence.ajouterBien(prop1, maison1);

        Appartement appartement1 = new Appartement("wilaya2 , Rue 15 , Batiment 4", wilaya2, 120, prop2, "31/12/2019", "lorem ipsum",
                4000000, "images/2.jpg", Transaction.Vente, 4, true, 1, true);
        agence.ajouterBien(prop2, appartement1);

        Terrain terrain1 = new Terrain("wilaya1, Route 45", wilaya1, 500, prop1, "03/02/2018", "lorem ipsum", 20000000,"images/3.jpg",
                Transaction.Vente, "asd", 3);
        agence.ajouterBien(prop1, terrain1);

        Appartement appartement2 = new Appartement("wilaya3 , Rue 08 , Batiment 45", wilaya3, 100, prop2, "02/11/2019", "lorem ipsum",
                40000, "images/4.jpg", Transaction.Location, 3, true, 1, true);
        agence.ajouterBien(prop2, appartement2);

        Maison maison2 = new Maison("wilaya2 , Rue 01 , Cite 7", wilaya2, 160, prop3, "01/01/2020", "lorem ipsum", 150000, "images/5.jpg",
                Transaction.Location, 4, true, 3, false, true, true);
        agence.ajouterBien(prop3, maison2);

        Appartement appartement3 = new Appartement("wilaya3 , Rue 15 , Batiment 09", wilaya3, 50, prop2, "02/11/2019", "lorem ipsum",
                600000, "images/6.jpg", Transaction.Location, 3, true, 6, true);
        agence.ajouterBien(prop2, appartement3);

        Terrain terrain2 = new Terrain("wilaya1", wilaya1, 650, prop1, "03/02/2018", "lorem ipsum", 18000000, "images/7.jpg",
                Transaction.Echange, "asd", 1);
        agence.ajouterBien(prop1, terrain2);
        terrain2.setWilaya(wilaya3);

        Maison maison3 = new Maison("wilaya2 , Rue 78 , Cite 4", wilaya2, 200, prop2, "01/01/2020", "lorem ipsum", 14000000,"images/8.jpg",
                Transaction.Echange, 4, true, 3, true, false, true);
        agence.ajouterBien(prop2, maison3);
        maison3.setWilaya(wilaya2);

        agence.copyToNewList();
        HBox body = new HBox();
        int row=0 , column = 0;
        agence.logIn("0","0");
        /////homepage elements

        /////this vbox is the main one

        VBox mainLayer = new VBox();
        mainLayer.setStyle("-fx-background-color : #ffffff");

        ///The top bar
        TopBar topBar = new TopBar(stage);
        ///The body
        Scrolling scroller = new Scrolling(agence , body);
        body.setMinSize(720*1.6,680);
        body.setStyle("-fx-background-color : #ffffff");
            ///menu on the left
            SideBarMenu leftMenu = new SideBarMenu(stage );
        body.getChildren().addAll(leftMenu,scroller);
        SearchPage searchPage = new SearchPage(agence,scroller, stage);
        mainLayer.getChildren().addAll(topBar , body );
        homePage = new Scene(mainLayer , 720*1.6 ,720 );
        LogIn loginPage = new LogIn(agence , stage, homePage,scroller, leftMenu,body,mainLayer);
        logIn = new Scene(loginPage,720*1.6,720);
        search=new Scene(searchPage, 200,200);
        leftMenu.setScene1(stage,logIn);
        leftMenu.setScene2(stage,homePage,body,mainLayer,agence,scroller);
        leftMenu.setScene3(stage, homePage, body, mainLayer, scroller);

        homePage.getStylesheets().add("file:///C:/Users/pc/IdeaProjects/javafx/src/sample/Graphics/style.css");
        stage.setScene(homePage);
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }


}
