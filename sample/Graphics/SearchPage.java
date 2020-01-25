package sample.Graphics;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Agence.Agence;
import sample.Bien.Transaction;
import sample.Main;

import java.util.Arrays;
import java.util.List;

public class SearchPage extends VBox {
    public SearchPage(Agence agence, Scrolling scroller, Stage stage) {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(25,100,200,100));


        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);


        Label lblprmin = new Label("Prix Minimale");
        final TextField txtprixmin = new TextField("0");
        Label lblprmax = new Label("Prix Maximale");
        final TextField txtprimax = new TextField("10000000000000000000000000");
        Label lblsupmin = new Label("Superficie Minimale");
        final TextField txtsupmin = new TextField("0");
        ChoiceBox<Transaction> choice = new ChoiceBox<Transaction>();
        choice.getItems().addAll(Transaction.Location,Transaction.Vente,Transaction.Echange);
        choice.setValue(Transaction.Vente);
        Label lblwilaya = new Label("Wilaya");
        final TextField txtwilaya = new TextField("");
        Label lblsupmax = new Label("Superficie Maximale");
        final TextField txtsupmax = new TextField("1000000000000000000000000");
        Button btn =new Button("Filtrer");
        btn.setOnAction(e->{
            List<String> wilayas = Arrays.asList(txtwilaya.getText().split(" ,"));
            String photo;
            agence.recherche( wilayas , choice.getValue() , Double.parseDouble(txtprixmin.getText()) ,Double.parseDouble(txtprimax.getText())
                    , Double.parseDouble(txtsupmin.getText()), Double.parseDouble(txtsupmax.getText()) );
            scroller.refresh();
            stage.setScene(Main.homePage);
            stage.show();
        });
        gridPane.add(lblprmin, 0, 5);
        gridPane.add(txtprixmin, 1, 5);
        gridPane.add(lblprmax, 0, 6);
        gridPane.add(txtprimax, 1, 6);
        gridPane.add(lblsupmin, 0, 7);
        gridPane.add(txtsupmin, 1, 7);
        gridPane.add(lblsupmax, 0, 8);
        gridPane.add(txtsupmax, 1, 8);
        gridPane.add(lblwilaya, 0,9);
        gridPane.add(txtwilaya, 1, 9);
        gridPane.add(new Label("Transaction"),0,10);
        gridPane.add(choice,1,10);
        gridPane.add(btn, 1, 20);
        Text text = new Text("Ajouter Bien");
        text.setFont(Font.font ("Roboto", 35));
        hb.getChildren().add(text);
        bp.setTop(hb);
        bp.setCenter(gridPane);
        this.getChildren().add(gridPane);
    }
}
