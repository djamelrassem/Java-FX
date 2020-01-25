package sample.Bien;

import sample.Agence.*;

import java.util.Scanner;

public class Terrain extends NonHabitable {
    final private String typee = "Terrain";

    public Terrain(String adr, Wilaya w, double sup, Proprietaire p, String dat, String desc, double prx,
            String photo, Transaction trans, String stjur, int nbr) {
        super(adr, w, sup, p, dat, desc, prx, photo, trans, stjur, nbr);
    }

    public String getTypee() {
        return typee;
    }

    @Override
    public void setWilaya(Wilaya wilaya) {
        super.setWilaya(wilaya);
    }

    @Override
    public void setTransaction(Transaction transaction) {
        super.setTransaction(transaction);
    }

    @Override
    public void setSuperficie(double superficie) {
        super.setSuperficie(superficie);
    }

    @Override
    public void setProprietaire(Proprietaire proprietaire) {
        super.setProprietaire(proprietaire);
    }

    @Override
    public void setPrix(double prix) {
        super.setPrix(prix);
    }

    @Override
    public void setPhotoURL(String photoURL) {
        super.setPhotoURL(photoURL);
    }

    @Override
    public void setInsere(boolean insere) {
        super.setInsere(insere);
    }

    @Override
    public void setDescriptif(String descriptif) {
        super.setDescriptif(descriptif);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public void setArchive(boolean archive) {
        super.setArchive(archive);
    }

    @Override
    public void setAdresse(String adresse) {
        super.setAdresse(adresse);
    }

    @Override
    public void setNbrFacades(int nbrFacades) {
        super.setNbrFacades(nbrFacades);
    }

    @Override
    public void setStatutJuridique(String statutJuridique) {
        super.setStatutJuridique(statutJuridique);
    }

    @Override
    public Wilaya getWilaya() {
        return super.getWilaya();
    }

    @Override
    public Transaction getTransaction() {
        return super.getTransaction();
    }

    @Override
    public String getPhotoURL() {
        return super.getPhotoURL();
    }

    @Override
    public String getDescriptif() {
        return super.getDescriptif();
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public String getAdresse() {
        return super.getAdresse();
    }

    @Override
    public Proprietaire getProprietaire() {
        return super.getProprietaire();
    }

    @Override
    public double getSuperficie() {
        return super.getSuperficie();
    }

    @Override
    public double getPrix() {
        return super.getPrix();
    }

    @Override
    public Boolean getInsere() {
        return super.getInsere();
    }

    @Override
    public Boolean getArchive() {
        return super.getArchive();
    }

    @Override
    public int getNbrFacades() {
        return super.getNbrFacades();
    }

    @Override

    public String getStatutJuridique() {
        return super.getStatutJuridique();
    }

    @Override

    public double calculeprix() {
        double price = this.prix;
        if (this.transaction == Transaction.Location) {
            if (this.superficie < 60) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + this.prix * 0.01;

                } else {
                    price = price +this.prix * 0.015;

                }
            } else if (this.superficie >= 60 && this.superficie <= 150) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + this.prix * 0.02;

                } else {
                    price = price + this.prix * 0.025;

                }
            } else {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price +this.prix * 0.03;

                } else {
                    price = price + this.prix * 0.035;

                }
            }

        } else {
            if (this.prix < 5000000) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + (this.prix * 0.03);
                } else {
                    price = price + (this.prix * 0.035);
                }
                if (this.nbrFacades > 1) {
                    price = price + (this.prix * 0.005) * this.nbrFacades;
                }
            }

            if ((price >= 5000000) && (price < 15000000)) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + (this.prix * 0.02);
                } else {
                    price = price + (this.prix * 0.025);
                }
                if (this.nbrFacades > 1) {
                    price = price + (this.prix * 0.005) * this.nbrFacades;
                }

            }
            if (price > 15000000) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + (this.prix * 0.01);
                } else {
                    price = price + (this.prix * 0.02);
                }
                if (this.nbrFacades > 1) {
                    price = price + (this.prix * 0.005) * this.nbrFacades;
                }

            }
        }
        return price;
    }



    public void modify( String adresse,
                        Wilaya wilaya ,
                        double superficie,
                        Proprietaire proprietaire,
                        Transaction transaction,
                        String date,
                        double prix,
                        boolean archived ) {
        this.setAdresse(adresse);
        setWilaya(wilaya);
        setSuperficie(superficie);
        setProprietaire(proprietaire);
        setTransaction(transaction);
        setDate(date);
        setPrix(prix);
        setArchive(archived);
    }
    @Override
    public String getInfos(){
        String infos;
        infos=("Propietaire : "+this.proprietaire.getPrenom() + this.proprietaire.getPrenom() +"\n" + "Wilaya : "+this.wilaya.getName() +"\n"+
                "Prix : "+ ((int) calculeprix()) + "\n"+"Superficie : "+this.superficie +"\n"+"Date d'ajout : "+this.date+"\n"+"Adresse : "+this.adresse+"\n"+"Transaction :"+
                this.transaction.name()
        );
        return infos;
    }
}
