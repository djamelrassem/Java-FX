package sample.Bien;

import sample.Agence.*;

import java.util.Scanner;

public class Maison extends Habitable {

    private int nbEtages;
    private boolean garage;
    private boolean piscine;
    private boolean jardin;

    public Maison(String adr, Wilaya w, double sup, Proprietaire prop, String dat, String desc, double pr,
                  String photo, Transaction trans, int nbpieces, boolean meuble, int nbetages, boolean garage,
                  boolean picin, boolean jardin) {
        super(adr, w, sup, prop, dat, desc, pr, photo, trans, nbpieces, meuble);
        this.setNbEtages(nbetages);
        this.setGarage(garage);
        this.setPicine(picin);
        this.setJardin(jardin);

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

    public void setNbPiecdes(int nbPiecdes) {
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

    public int getNbPiecdes() {
        return nbPieces;
    }

    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public boolean isPicine() {
        return piscine;
    }

    public void setPicine(boolean piscine) {
        this.piscine = piscine;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public int getNbEtages() {
        return nbEtages;
    }

    public void setNbEtages(int nbEtages) {
        this.nbEtages = nbEtages;
    }

    @Override
    public double calculeprix() {
        double price = this.prix;

        if (this.transaction == Transaction.Location) {

            if (this.superficie < 60) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + price * 0.01;

                } else {
                    price = price + price * 0.015;

                }
            } else if (this.superficie >= 60 && this.superficie <= 150) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + price * 0.02;

                } else {
                    price = price + price * 0.025;

                }
            } else {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = price + price * 0.03;

                } else {
                    price = price + price * 0.035;

                }
            }
            if (this.piscine = true) {
                price = price + 50000;
            }

        } else {
            if (this.prix < 5000000) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = this.prix + (this.prix * 0.03);
                } else {
                    price = this.prix + (this.prix * 0.035);
                }
                if (this.jardin) {
                    price = price + this.prix * 0.005;
                }
                if (this.piscine) {
                    price = price + this.prix * 0.005;
                }
                if (this.garage) {
                    price = price + this.prix * 0.005;
                }
            }

            if ((this.prix >= 5000000) && (this.prix < 15000000)) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = this.prix + (this.prix * 0.02);
                } else {
                    price = this.prix + (this.prix * 0.025);
                }
                if (this.jardin) {
                    price = price + this.prix * 0.005;
                }
                if (this.piscine) {
                    price = price + this.prix * 0.005;
                }
                if (this.garage) {
                    price = price + this.prix * 0.005;
                }

            }
            if (this.prix > 15000000) {
                if (this.wilaya.getPrixMetreCarre() < 50000) {
                    price = this.prix + (this.prix * 0.01);
                } else {
                    price = this.prix + (this.prix * 0.02);
                }
                if (this.jardin) {
                    price = price + this.prix * 0.005;
                }
                if (this.piscine) {
                    price = price + this.prix * 0.005;
                }
                if (this.garage) {
                    price = price + this.prix * 0.005;
                }

            }
        }
        return price;
    }



    public boolean isMeuble() {
        return this.meuble;
    }



    public void modify( String adresse,
                        Wilaya wilaya ,
                        double superficie,
                        Proprietaire proprietaire,
                        Transaction transaction,
                        String date,
                        double prix,
                        boolean archive,int nbpieces, boolean meuble, int nbetages, boolean garage,
                        boolean picin, boolean jardin) {

        this.setAdresse(adresse);
        setSuperficie(superficie);
        setWilaya(wilaya);
        setProprietaire(proprietaire);
        setTransaction(transaction);
        setDate(date);
        setPrix(prix);
        setArchive(archive);
        setNbPieces(nbpieces);
        setMeuble(meuble);
        setNbEtages(nbetages);
        setGarage(garage);
        setPicine(picin);
        setJardin(jardin);

    }
    @Override
    public String getInfos(){
        String infos;
        infos=("Propietaire : "+this.proprietaire.getPrenom() + this.proprietaire.getPrenom() +"\n" + "Wilaya : "+this.wilaya.getName() +"\n"+
        "Prix : "+((int) calculeprix()) + "\n"+"Superficie : "+this.superficie +"\n"+"Date d'ajout : "+this.date+"\n"+"Adresse : "+this.adresse+"\n"+"Transaction :"+
                this.transaction.name()+"\nNombre de pieces : "+this.nbPieces +"\nNombre d'etages : "+this.nbEtages+"\nGarage : "+this.garage +"\nPiscine : "+this.piscine+
                "\nJardin : "+this.jardin
        );
        return infos;
    }
}
