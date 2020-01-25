package sample.Bien;
public class Wilaya {
    private String name;
    private double prixMetreCarre;


    public Wilaya(String name_ , double prix_){
        this.name= name_;
        this.prixMetreCarre = prix_;
    }

    public String getName() {
        return name;
    }

    public double getPrixMetreCarre() {
        return prixMetreCarre;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrixMetreCarre(double prixMetreCarre) {
        this.prixMetreCarre = prixMetreCarre;
    }

}