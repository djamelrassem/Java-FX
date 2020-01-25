
package sample.Bien;
import sample.Agence.*;
public abstract class Habitable extends Bien {
    protected int nbPieces;
    protected boolean meuble ;


    public Habitable(String adr,Wilaya w,double sup,Proprietaire prop,String dat,String desc,double pr,String photo,Transaction trans,int nbpieces, boolean meuble){
        super( adr, w, sup, prop, dat, desc, pr, photo, trans);
        this.nbPieces = nbpieces;
        this.meuble = meuble;
    }

    @Override
    public void setAdresse(String adresse) {
        super.setAdresse(adresse);
    }

    @Override
    public void setArchive(boolean archive) {
        super.setArchive(archive);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public void setDescriptif(String descriptif) {
        super.setDescriptif(descriptif);
    }

    @Override
    public void setInsere(boolean insere) {
        super.setInsere(insere);
    }

    @Override
    public void setPhotoURL(String photoURL) {
        super.setPhotoURL(photoURL);
    }

    @Override
    public void setPrix(double prix) {
        super.setPrix(prix);
    }

    @Override
    public void setProprietaire(Proprietaire proprietaire) {
        super.setProprietaire(proprietaire);
    }

    @Override
    public void setSuperficie(double superficie) {
        super.setSuperficie(superficie);
    }

    @Override
    public void setTransaction(Transaction transaction) {
        super.setTransaction(transaction);
    }

    @Override
    public void setWilaya(Wilaya wilaya) {
        super.setWilaya(wilaya);
    }

    public void setMeuble(boolean meuble) {
        this.meuble = meuble;
    }

    public void setNbPieces(int nbPiecdes) {
        this.nbPieces = nbPiecdes;
    }

    @Override
    public Boolean getArchive() {
        return super.getArchive();
    }

    @Override
    public Boolean getInsere() {
        return super.getInsere();
    }

    @Override
    public double getPrix() {
        return super.getPrix();
    }

    @Override
    public double getSuperficie() {
        return super.getSuperficie();
    }

    @Override
    public Proprietaire getProprietaire() {
        return super.getProprietaire();
    }

    @Override
    public String getAdresse() {
        return super.getAdresse();
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public String getDescriptif() {
        return super.getDescriptif();
    }

    @Override
    public String getPhotoURL() {
        return super.getPhotoURL();
    }

    @Override
    public Transaction getTransaction() {
        return super.getTransaction();
    }

    @Override
    public Wilaya getWilaya() {
        return super.getWilaya();
    }

    public int getNbPieces() {
        return nbPieces;
    }

}