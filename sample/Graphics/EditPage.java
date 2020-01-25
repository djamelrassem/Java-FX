package sample.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Agence.Agence;
import sample.Agence.Proprietaire;
import sample.Bien.*;
import sample.Main;


public class EditPage extends VBox {
    public EditPage(Bien bien , HBox body , Scrolling scroller, Agence agence){

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25,100,200,100));
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        Label lbladresse = new Label("Adresse");
        final TextField txtadresse = new TextField(bien.getAdresse());
        Label lblsup = new Label("Superficie");
        final TextField txtsup = new TextField(String.valueOf(bien.getSuperficie()));
        Label lbldate = new Label("Date");
        final TextField txtdate = new TextField(bien.getDate());
        Label lblpr = new Label("Prix");
        final TextField txtpr = new TextField(String.valueOf(((int) bien.calculeprix())));
        Label lblwilaya = new Label("Wilaya");
        CheckBox checkbox = new CheckBox();
        Label lblarchive = new Label("Archive");
        Button submit = new Button("Appliquer");
        ChoiceBox<Transaction> choice = new ChoiceBox<Transaction>();
        choice.getItems().addAll(Transaction.Location,Transaction.Vente,Transaction.Echange);
        ChoiceBox<Proprietaire> props = new ChoiceBox<Proprietaire>();
        props.getItems().addAll(agence.getUsers());
        ChoiceBox<Wilaya> wilayas = new ChoiceBox<Wilaya>();
        wilayas.getItems().addAll(Main.wilayas);
        wilayas.setValue(bien.getWilaya());
        choice.setValue(bien.getTransaction());
        props.setValue(bien.getProprietaire());
//information communes entre tous les types des biens
        gridPane.add(lbladresse, 0, 3);
        gridPane.add(txtadresse, 1, 3);
        gridPane.add(lblsup, 0, 4);
        gridPane.add(txtsup, 1, 4);
        gridPane.add(lbldate, 0, 5);
        gridPane.add(txtdate, 1, 5);
        gridPane.add(lblpr, 0, 7);
        gridPane.add(txtpr, 1, 7);
        gridPane.add(lblwilaya, 0,12);
        gridPane.add(wilayas, 1, 12);
        gridPane.add(new Label("Propietaire"), 0, 14);
        gridPane.add(props, 1, 14);
        gridPane.add(lblarchive,0,16);
        gridPane.add(checkbox,1,16);
        gridPane.add(new Label("Transaction" ),0,17);
        gridPane.add(choice,1,17);
        gridPane.add(submit, 2,22);
        checkbox.setSelected(bien.getArchive());
        submit.setPrefWidth(100);
        if(bien.getClass().getTypeName().equals("sample.Bien.Maison")){
            Maison maison = (Maison)bien;
            gridPane.add(new Label("Nombre de pieces"), 0,18);
            final TextField nbpieces= new TextField(String.valueOf(maison.getNbPiecdes()));
            gridPane.add(nbpieces,1,18);
            CheckBox meuble = new CheckBox();
            gridPane.add(new Label("Meublé"), 0,19);
            gridPane.add(meuble, 1,19);
            gridPane.add(new Label("Numero d'etage"), 0,20);
            final TextField nbetages= new TextField(String.valueOf(maison.getNbEtages()));
            gridPane.add(nbetages,1,20);
            HBox extra = new HBox();
            CheckBox garage = new CheckBox();
            CheckBox piscine = new CheckBox();
            CheckBox jardin = new CheckBox();
            garage.setSelected(maison.isGarage());
            piscine.setSelected(maison.isPicine());
            jardin.setSelected(maison.isJardin());
            meuble.setSelected(maison.isMeuble());
            extra.getChildren().addAll(new Label("Garage"), garage, new Label("piscine"), piscine , new Label("jardin"), jardin);
            extra.setSpacing(20);
            gridPane.add(extra, 0, 21);

            submit.setOnAction(e->{

                if(Double.parseDouble(txtpr.getText()) <1 || Double.parseDouble(txtsup.getText()) <10 ){
                    Stage alert = new Stage();
                    Label alertMessage = new Label("Entrez a nouveau le prix ou la superficie");
                    alertMessage.setAlignment(Pos.CENTER);
                    Scene alertScene = new Scene(alertMessage , 300,100);
                    alert.setScene(alertScene);
                    alert.show();
                }else{
                    maison.modify(txtadresse.getText(),
                            wilayas.getValue() , Double.parseDouble(txtsup.getText().toString()),
                            props.getValue(),
                            choice.getValue(),
                            txtdate.getText(),
                            Double.parseDouble(txtpr.getText()),
                            checkbox.isSelected(),Integer.parseInt(nbpieces.getText()), meuble.isSelected(),Integer.parseInt(nbetages.getText()),garage.isSelected(),
                            piscine.isSelected(), jardin.isSelected());
                    body.getChildren().remove(this);
                    scroller.refresh();
                    body.getChildren().add(scroller);
                }

            });
        }else if(bien.getClass().getTypeName().equals("sample.Bien.Appartement")){
            Appartement appartement = (Appartement)bien ;
            gridPane.add(new Label("Nombre de pieces"), 0,18);
            final TextField nbpieces= new TextField(String.valueOf(appartement.getNbPiecdes()));
            gridPane.add(nbpieces,1,18);
            CheckBox meuble = new CheckBox();
            meuble.setSelected(appartement.isMeuble());
            gridPane.add(new Label("Meublé"), 0,19);
            gridPane.add(meuble, 1,19);
            gridPane.add(new Label("Nombre de pieces"), 0,20);
            final TextField numetage= new TextField(String.valueOf(appartement.getNumEtages()));
            gridPane.add(numetage,1,20);
            submit.setOnAction(event-> {
                        if (Double.parseDouble(txtpr.getText()) < 1 || Double.parseDouble(txtsup.getText()) < 10) {
                            Stage alert = new Stage();
                            Label alertMessage = new Label("Entrez a nouveau le prix ou la superficie");
                            alertMessage.setAlignment(Pos.CENTER);
                            Scene alertScene = new Scene(alertMessage, 300, 100);
                            alert.setScene(alertScene);
                            alert.show();
                        } else
                        {
                            appartement.modify( txtadresse.getText(),
                                    wilayas.getValue() , Double.parseDouble(txtsup.getText().toString()),
                                    props.getValue(),
                                    choice.getValue(),
                                    txtdate.getText(),
                                    Double.parseDouble(txtpr.getText()),
                                    checkbox.isSelected(),Integer.parseInt(nbpieces.getText()),  meuble.isSelected(),Integer.parseInt(numetage.getText()) );
                            body.getChildren().remove(this);
                            scroller.refresh();
                            body.getChildren().add(scroller);
                        }


            });

        }else{
            Terrain terrain = (Terrain)bien;
            submit.setOnAction(e->{

                if(Double.parseDouble(txtpr.getText()) <1 || Double.parseDouble(txtsup.getText()) <10 ){
                    Stage alert = new Stage();
                    Label alertMessage = new Label("Entrez a nouveau le prix ou la superficie");
                    alertMessage.setAlignment(Pos.CENTER);
                    Scene alertScene = new Scene(alertMessage , 300,100);
                    alert.setScene(alertScene);
                    alert.show();
                }
                else{
                    terrain.modify(txtadresse.getText(),
                            wilayas.getValue() , Double.parseDouble(txtsup.getText().toString()),
                            props.getValue(),
                            choice.getValue(),
                            txtdate.getText(),
                            Double.parseDouble(txtpr.getText()),
                            checkbox.isSelected());
                    body.getChildren().remove(this);
                    scroller.refresh();
                    body.getChildren().add(scroller);
                }

            });
        }


        Text text = new Text("Modifier le Bien");
        text.setFont(Font.font ("Roboto", 35));
        hb.getChildren().add(text);
        bp.setTop(hb);
        bp.setCenter(gridPane);
        this.getChildren().add(bp);
    }
}
