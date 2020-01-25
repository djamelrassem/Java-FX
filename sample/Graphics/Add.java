package sample.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Agence.Agence;
import sample.Agence.Proprietaire;
import sample.Bien.*;

import java.io.File;


public class Add extends ScrollPane {
    static String photo = "file:///F:/Téléchargements/patrick-perkins-3wylDrjxH-E-unsplash.jpg";
    Scene scene1,scene2,scene3;
    public Add(Agence agence , Scrolling scroller ){
        this.setStyle("-fx-background-color : #ffffff");
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        Stage primaryStage = new Stage();
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25,100,200,100));


        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);



        final FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        final Button openButton = new Button("Clicker ici pour Ajouer une image");
        final StackPane stac = new StackPane();

        openButton.setOnAction( e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                photo = file.toURI().toString();
            }
        });




        Label lblmaison = new Label("Maison");
        Label lblapp = new Label("Appartement");
        Label lblterr = new Label("Terrain");
        final CheckBox maisoncheck = new CheckBox();
        final CheckBox appartementcheck = new CheckBox();
        final CheckBox terraincheck = new CheckBox();
        Label lbladresse = new Label("Adresse");
        final TextField txtadresse = new TextField();
        Label lblsup = new Label("Superficie");
        final TextField txtsup = new TextField();
        Label lbldate = new Label("Date");
        final TextField txtdate = new TextField();
        Label lbldesc = new Label("Déscription");
        final TextField txtdesc = new TextField();
        Label lblpr = new Label("Prix");
        final TextField txtpr = new TextField();
        Label lblphoto = new Label("Photos url");
        ChoiceBox<Transaction> choice = new ChoiceBox<Transaction>();
        choice.getItems().addAll(Transaction.Location,Transaction.Vente,Transaction.Echange);

        Label lblwilaya = new Label("Wilaya");
        final TextField txtwilaya = new TextField();
        Label lblwilayaprix = new Label("Prix wilaya");
        final TextField txtwilayaprix = new TextField();
        Button btn =new Button("Continue");
        Label lblname = new Label("Name");
        final TextField txtname = new TextField();
        Label lblfirstname = new Label("First name");
        final TextField txtfirstname = new TextField();
        Label lblmail = new Label("Mail");
        final TextField txtmail = new TextField();
        Label lblnum = new Label("Numéro");
        final TextField txtnum = new TextField();
        Label lbladd = new Label("Adresse de prop");
        final TextField txtadd = new TextField();
        choice.setValue(Transaction.Vente);






//information communes entre tous les types des biens
        gridPane.add(lblmaison,0,0);
        gridPane.add(maisoncheck, 1, 0);
        gridPane.add(lblapp,0,1);
        gridPane.add(appartementcheck, 1, 1);
        gridPane.add(lblterr,0,2);
        gridPane.add(terraincheck, 1, 2);


        gridPane.add(lbladresse, 0, 3);
        gridPane.add(txtadresse, 1, 3);
        gridPane.add(lblsup, 0, 4);
        gridPane.add(txtsup, 1, 4);
        gridPane.add(lbldate, 0, 5);
        gridPane.add(txtdate, 1, 5);
        gridPane.add(lbldesc, 0, 6);
        gridPane.add(txtdesc, 1, 6);
        gridPane.add(lblpr, 0, 7);
        gridPane.add(txtpr, 1, 7);
        gridPane.add(lblphoto, 0, 8);
        gridPane.add(openButton, 1, 8);
        gridPane.add(new Label("Transaction"), 0, 9);
        gridPane.add(choice, 1, 9);

        gridPane.add(lblwilaya, 0,12);
        gridPane.add(txtwilaya, 1, 12);
        gridPane.add(lblwilayaprix, 0, 13);
        gridPane.add(txtwilayaprix, 1, 13);
        gridPane.add(lblname, 0, 14);
        gridPane.add(txtname, 1, 14);
        gridPane.add(lblfirstname, 0, 15);
        gridPane.add(txtfirstname, 1, 15);
        gridPane.add(lblmail, 0, 16);
        gridPane.add(txtmail, 1, 16);
        gridPane.add(lblnum, 0, 17);
        gridPane.add(txtnum, 1, 17);
        gridPane.add(lbladd, 0, 18);
        gridPane.add(txtadd, 1, 18);





        gridPane.add(btn, 1, 20);






        Text text = new Text("Ajouter Bien");
        text.setFont(Font.font ("Roboto", 35));

        btn.setOnAction(event -> {if(Double.parseDouble(txtpr.getText()) <1 || Double.parseDouble(txtsup.getText()) <10 ){
            Stage alert = new Stage();
            Label alertMessage = new Label("Entrez a nouveau le prix ou la superficie");
            alertMessage.setAlignment(Pos.CENTER);
            Scene alertScene = new Scene(alertMessage , 300,100);
            alert.setScene(alertScene);
            alert.show();
        }else{
            if(maisoncheck.isSelected()){
                BorderPane bpa = new BorderPane();
                bpa.setPadding(new Insets(25,100,200,100));


                HBox hbo = new HBox();
                hbo.setPadding(new Insets(20,20,20,30));

                GridPane  grid = new GridPane();
                grid.setPadding(new Insets(20,20,20,20));
                grid.setHgap(5);
                grid.setVgap(5);
                Label lblnbpieces = new Label("Nombre de piéces");
                final TextField txtnbpieces = new TextField();
                Label lblnbetage = new Label("Nombre d'étages");
                final TextField txtnbetage = new TextField();
                Label lblmeuble = new Label("Meublé");
                Label lblgarage = new Label("Garage");
                Label lbljardin = new Label("Jardin");
                Label lblpiscine = new Label("Piscine");
                final Button btnm1=new Button("Retour");
                final Button btnm2=new Button("Valider");

                final  CheckBox checkmeuble=new CheckBox();
                final  CheckBox checkgarage=new CheckBox();
                final  CheckBox checkejardin=new CheckBox();
                final  CheckBox checkepiscine=new CheckBox();

                grid.add(lblnbpieces, 0, 0);
                grid.add(txtnbpieces, 1, 0);
                grid.add(lblnbetage, 0, 1);
                grid.add(txtnbetage, 1, 1);
                grid.add(lblmeuble, 0, 2);
                grid.add(checkmeuble, 1, 2);
                grid.add(lblgarage, 0, 3);
                grid.add(checkgarage, 1, 3);
                grid.add(lbljardin, 0, 4);
                grid.add(checkejardin, 1, 4);
                grid.add(lblpiscine, 0, 5);
                grid.add(checkepiscine, 1, 5);
                grid.add(btnm1, 0, 7);
                grid.add(btnm2, 1, 7);

                Text  text1 = new Text("Type maison");
                text1.setFont(Font.font ("Roboto", 35));
                hbo.getChildren().add(text1);


                bpa.setId("bpa");
                grid.setId("root2");
                //btnLogin.setId("btnLogin");
                text1.setId("text1");




                bpa.setTop(hbo);
                bpa.setCenter(grid);

                scene2 = new Scene(bpa);
                primaryStage.setScene(scene2);
                primaryStage.setResizable(false);
                primaryStage.show();
                btnm1.setOnAction(event1 -> {
                    primaryStage.setScene(scene1);
                });
                btnm2.setOnAction(event1 -> {
                    Transaction trans = choice.getValue();
                    Proprietaire prop = new Proprietaire(txtname.getText().toString(),txtfirstname.getText().toString(),txtmail.getText().toString(),Integer.parseInt(txtnum.getText().toString()),txtadd.getText().toString());
                    agence.addUser(prop);
                    Wilaya wilaya=new Wilaya(txtwilaya.getText().toString(),Long.parseLong(txtwilayaprix.getText().toString()));
                    Maison maison =new Maison(txtadresse.getText().toString(),
                            wilaya,Long.parseLong(txtsup.getText().toString()),prop,txtdate.getText().toString(),
                            txtdesc.getText().toString(),Long.parseLong(txtpr.getText().toString()),
                            photo,trans,
                            Integer.parseInt(txtnbpieces.getText().toString()),checkmeuble.isSelected(),
                            Integer.parseInt(txtnbetage.getText().toString()),checkgarage.isSelected(),
                            checkepiscine.isSelected(),checkejardin.isSelected());
                    agence.ajouterBien(prop,maison);
                    scroller.refresh();
                });


            }

            if(appartementcheck.isSelected()){
                BorderPane bpan = new BorderPane();
                GridPane gridd = new GridPane();
                gridd.setPadding(new Insets(20,20,20,20));
                gridd.setHgap(5);
                gridd.setVgap(5);
                Label lblnbpiecess = new Label("Nombre de piéces");
                final TextField txtnbpiecess = new TextField();
                Label lblnbetagee = new Label("Nombre d'étage");
                final TextField txtnbetagee = new TextField();
                Label lblmeublee = new Label("Meublé");
                Label lbltp = new Label("Type");
                final Button btn1=new Button("Retour");
                final Button btn2=new Button("Valider");
                bpan.setPadding(new Insets(25,100,200,100));


                HBox hbox = new HBox();
                hbox.setPadding(new Insets(20,20,20,30));


                final  CheckBox checkmeublee=new CheckBox();
                final  CheckBox txttp=new CheckBox();

                gridd.add(lblnbpiecess, 0, 0);
                gridd.add(txtnbpiecess, 1, 0);
                gridd.add(lblnbetagee, 0, 1);
                gridd.add(txtnbetagee, 1, 1);
                gridd.add(lblmeublee, 0, 2);
                gridd.add(checkmeublee, 1, 2);
                gridd.add(lbltp, 0, 3);
                gridd.add(txttp, 1, 3);
                gridd.add(btn1, 0, 5);
                gridd.add(btn2, 1, 5);


                Text text2 = new Text("Type appartement");
                text2.setFont(Font.font ("Roboto", 35));
                hbox.getChildren().add(text2);


                bpan.setId("bpa");
                gridd.setId("root2");
                //btnLogin.setId("btnLogin");
                text2.setId("text1");




                bpan.setTop(hbox);
                bpan.setCenter(gridd);

                scene3 = new Scene(bpan);
                primaryStage.setScene(scene3);
                primaryStage.setResizable(false);
                primaryStage.show();
                btn1.setOnAction(event1 -> {
                    primaryStage.setScene(scene1);

                    btn2.setOnAction(event2 -> {

                        Transaction trans = choice.getValue();

                        Proprietaire prop1 = new Proprietaire(txtname.getText().toString(),txtfirstname.getText().toString(),txtmail.getText().toString(),Integer.parseInt(txtnum.getText().toString()),txtadd.getText().toString());
                        agence.addUser(prop1);
                        Wilaya wilaya1=new Wilaya(txtwilaya.getText().toString(),Long.parseLong(txtwilayaprix.getText().toString()));

                        Appartement app =new Appartement(txtadresse.getText().toString(),wilaya1,Long.parseLong(txtsup.getText().toString()),prop1,txtdate.getText().toString(),txtdesc.getText().toString(),Long.parseLong(txtpr.getText().toString()),photo,trans,Integer.parseInt(txtnbpiecess.getText().toString()),checkmeublee.isSelected(),Integer.parseInt(txtnbetagee.getText().toString()),txttp.isSelected());

                        agence.ajouterBien(prop1,app);
                        scroller.refresh();
                    });
                });


            }
            if(terraincheck.isSelected()){

                BorderPane bpaz = new BorderPane();
                bpaz.setPadding(new Insets(25,100,200,100));


                HBox hboz = new HBox();
                hboz.setPadding(new Insets(20,20,20,30));

                GridPane gridz = new GridPane();
                gridz.setPadding(new Insets(20,20,20,20));
                gridz.setHgap(5);
                gridz.setVgap(5);
                Label lblnbpr = new Label("Nombre de facades");
                final TextField txtnbr = new TextField();
                Label lblst = new Label("Statut Juridique");
                final TextField txtst = new TextField();
                final Button btnt=new Button("Retour");
                final Button btnt1=new Button("Valider");



                gridz.add(lblnbpr, 0, 0);
                gridz.add(txtnbr, 1, 0);
                gridz.add(lblst, 0, 1);
                gridz.add(txtst, 1, 1);
                gridz.add(btnt, 0, 3);

                gridz.add(btnt1, 1, 3);


                Text text3 = new Text("Type terrain");
                text3.setFont(Font.font ("Roboto", 35));
                hboz.getChildren().add(text3);


                bpaz.setId("bpaz");
                gridz.setId("root3");
                //btnLogin.setId("btnLogin");
                text3.setId("text12");




                bpaz.setTop(hboz);
                bpaz.setCenter(gridz);

                Scene scene3 = new Scene(bpaz);
                primaryStage.setScene(scene3);
                primaryStage.setResizable(false);
                primaryStage.show();
                btnt1.setOnAction(event1 -> {
                    primaryStage.setScene(scene1);
                });

                btnt1.setOnAction(event3 -> {

                    Transaction trans = choice.getValue();
                    Proprietaire prop2 = new Proprietaire(txtname.getText().toString(),txtfirstname.getText().toString(),txtmail.getText().toString(),Integer.parseInt(txtnum.getText().toString()),txtadd.getText().toString());
                    agence.addUser(prop2);
                    Wilaya wilaya2=new Wilaya(txtwilaya.getText().toString(),Long.parseLong(txtwilayaprix.getText().toString()));
                    Terrain terrain =new Terrain(txtadresse.getText().toString(),wilaya2,Long.parseLong(txtsup.getText().toString()),prop2,txtdate.getText().toString(),txtdesc.getText().toString(),Long.parseLong(txtpr.getText().toString()),photo,trans,txtst.getText().toString(),Integer.parseInt(txtnbr.getText().toString()));
                    agence.ajouterBien(prop2,terrain);
                    scroller.refresh();
                });
            }
        }});


        hb.getChildren().add(text);


        bp.setId("bp");




        bp.setTop(hb);
        bp.setStyle("-fx-background-color: #ffffff");
        bp.setCenter(gridPane);



        this.setContent(bp);
    }
}
