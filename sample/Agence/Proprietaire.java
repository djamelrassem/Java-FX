package sample.Agence;
import java.util.*;
import sample.Bien.*;
public class Proprietaire  {
 
    private String nom;
    private String prenom;
    private String email;
    private int ntel;
    private String adresse;
    private List<Bien> biens;

    public Proprietaire(String name, String firstname, String emaill, int ntelephone, String adr) {
      
        this.nom = name;
        this.prenom = firstname;
        this.email = emaill;
        this.ntel = ntelephone;
        this.adresse = adr;
        biens = new ArrayList<Bien>();
    }

    public void ajouterBien(Bien bien) {
        biens.add(bien);
    }

    public List<Bien> getBiens(){
        return this.biens;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNtel(int ntel) {
        this.ntel = ntel;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    

    public String getAdresse() {
        return adresse;
    }

    public int getNtel() {
        return ntel;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }


    public Bien getBien(int index){
        return biens.get(index);
    }



}
