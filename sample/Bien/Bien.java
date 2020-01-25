package sample.Bien;

import sample.Agence.*;

public abstract class Bien implements Comparable<Bien> {
    protected String adresse;
    protected Wilaya wilaya;
    protected Wilaya wilayaDechange;
    protected double superficie;
    protected Proprietaire proprietaire;
    protected Transaction transaction;
    protected String date;
    protected String photoURL;
    protected String descriptif;
    protected double prix;
    protected boolean insere = false;
    protected boolean archive = false;

    // Constructeur
    public Bien(String adr, Wilaya w, double sup, Proprietaire prop, String dat, String desc, double pr, String photo,
            Transaction trans) {
        this.adresse = adr;
        this.date = dat;
        this.descriptif = desc;
        this.photoURL = photo;
        this.prix = pr;
        this.proprietaire = prop;
        this.wilaya = w;
        this.superficie = sup;
        this.transaction = trans;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public void setInsere(boolean insere) {
        this.insere = insere;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    public double getPrix() {
        return prix;
    }

    public double getSuperficie() {
        return superficie;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public Boolean getInsere() {
        return insere;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setWilayaEchange(Wilaya wilaya) {
        this.wilayaDechange = wilaya;
    }

    abstract public double calculeprix();

    @Override
    public int compareTo(Bien bien) {
        if (this.proprietaire.getNom() == bien.proprietaire.getNom()
                && this.proprietaire.getPrenom() == bien.proprietaire.getPrenom()
                && this.wilaya.getName() == bien.wilaya.getName() && this.superficie == bien.getSuperficie()) {
            return 1;
        }
        return 0;
    }


    abstract public String getInfos();
}
