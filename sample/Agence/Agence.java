package sample.Agence;

import java.util.*;

import sample.Bien.*;

public class Agence {

    private List<Proprietaire> users;
    private String adminUsername;
    private String adminPassword;
    private boolean modify = false;
    private List<Bien> bienss;
    private List<Bien> bienss1;
    private List<Bien> bienss2;
    private List<Bien> bienss3;

    private List<Bien> bienAffiche;
    private List<String> listemessage;

    public List<Bien> getBiensAdmin() {
        return bienss;
    }

    public void setListemessage(List<String> listemessage) {
        this.listemessage = listemessage;
    }

    public Agence() {
        this.adminPassword = "admin";
        this.adminUsername = "admin";
        users = new ArrayList<Proprietaire>();
        bienss = new ArrayList<Bien>();
        bienss1 = new ArrayList<Bien>();
        bienss2 = new ArrayList<Bien>();
        bienss3 = new ArrayList<Bien>();
        bienAffiche = new ArrayList<Bien>();
        this.listemessage = new ArrayList<String>();
    }

    public boolean getAccess() {
        return this.modify;
    }

    public void addUser(Proprietaire user) {
        if (modify) {
            users.add(user);
        } else {
            System.out.println("Vous n'avez pas le droit de modifier !!");
        }
    }

    public List<Bien> getBien() {
        return this.bienAffiche;
    }

    public boolean logIn(String username, String password) {
        if (this.adminUsername.equals(username) && this.adminPassword.equals(password)) {
            this.modify = true;
            return modify;
        } else {
            modify = false;
            return modify;
        }
    }

    public boolean ajouterBien(Proprietaire user, Bien bien) {
        boolean found = false;
        for (Bien bien_ : bienss) {
            if (bien_.compareTo(bien) == 1) {
                found = true;
            }
        }
        if (!found) {
            this.bienss.add(bien);
            user.ajouterBien(bien);
            this.bienAffiche.add(bien);
            bien.setInsere(true);
        }
        return !found;
    }

    public void archiver(int n) {
        if (this.modify) {
            this.bienss.get(n).setArchive(true);
        } else {
            System.out.println("Il n y'a pas du bien dans cette indice");
        }
    }



    public List<Proprietaire> getUsers() {
        return users;
    }

    public void remove(Bien bien) {
        bien.getProprietaire().getBiens().remove(bien);
        this.bienss.remove(bien);
        this.bienAffiche.remove(bien);
    }

    public void Organisation() {
        System.out.println("Choisisez :");
        System.out.println("Affichage a partir la nouvelle date : 1");
        System.out.println("Affichage a partir l'ancienne date : 2");
        Scanner i = new Scanner(System.in);
        if (i.nextInt() == 1) {
            i.close();
            for (int k = 0; k < bienss.size(); k++) {
                for (int c = 0; c < bienss.size(); c++) {
                    int d;
                    if (c < bienss.size() - 1) {
                        d = c + 1;

                        if ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) < 0) {
                            Collections.swap(bienss, c, d);
                        }
                        if (((bienss.get(c).getDate().substring(3, 5)
                                .compareTo(bienss.get(d).getDate().substring(3, 5))) < 0)
                                && ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) == 0)) {
                            Collections.swap(bienss, c, d);
                        }

                        if (((bienss.get(c).getDate().substring(0, 2)
                                .compareTo(bienss.get(d).getDate().substring(0, 2))) < 0)
                                && ((bienss.get(c).getDate().substring(3, 5)
                                .compareTo(bienss.get(d).getDate().substring(3, 5))) == 0)
                                && ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) == 0)) {
                        }
                        Collections.swap(bienss, c, d);
                    }

                }

            }
        } else {
            for (int k = 0; k < bienss.size(); k++) {
                for (int c = 0; c < bienss.size(); c++) {
                    int d;
                    if (c < bienss.size() - 1) {
                        d = c + 1;
                        if ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) > 0) {
                            Collections.swap(bienss, c, d);
                        }
                        if (((bienss.get(c).getDate().substring(3, 5)
                                .compareTo(bienss.get(d).getDate().substring(3, 5))) > 0)
                                && ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) == 0)) {
                            Collections.swap(bienss, c, d);
                        }

                        if (((bienss.get(c).getDate().substring(0, 2)
                                .compareTo(bienss.get(d).getDate().substring(0, 2))) > 0)
                                && ((bienss.get(c).getDate().substring(3, 5)
                                .compareTo(bienss.get(d).getDate().substring(3, 5))) == 0)
                                && ((bienss.get(c).getDate().substring(6, 9)
                                .compareTo(bienss.get(d).getDate().substring(6, 9))) == 0)) {
                        }
                        Collections.swap(bienss, c, d);
                    }

                }

            }
        }

    }

    public void recherche(List<String> wilayas ,Transaction trans , double minPrix , double maxPrix , double minSup , double maxSup ) {
        bienAffiche.clear();
        bienss1.clear();
        bienss2.clear();
        bienss3.clear();

        for (Bien bien : bienss) {
            for (String m : wilayas) {
                if (!bien.getArchive()) {
                    if (bien.getWilaya().getName().equals(m)) {
                        bienss1.add(bien);
                    }
                }
            }
        }


        for (Bien bien1 : bienss1) {


            if (bien1.getTransaction()==trans) {
                bienAffiche.add(bien1);
            }


        }

        for (Bien b : bienss2) {
            if (b.calculeprix() > minPrix) {
                if (b.calculeprix() < maxPrix) {
                    bienss3.add(b);
                }
            }

        }
        for (Bien bb : bienss3) {
            if (bb.getSuperficie() > minSup) {


                if (bb.getSuperficie() < maxSup) {
                    bienAffiche.add(bb);
                }
            }

        }

    }

    public void copyToNewList() {
        this.bienAffiche.clear();
        for (Bien bien : bienss) {
            if (bien.getArchive() == false) {
                this.bienAffiche.add(bien);
            }
        }

    }

    public Proprietaire getProp(int i) {
        if (modify) {
            return this.users.get(i);
        } else {
            return null;
        }
    }

    public void afficherProps() {
        if (modify) {
            int i = 0;
            System.out.println("\n");
            for (Proprietaire prop : users) {
                System.out.print(i + ":" + prop.getNom() + " " + prop.getPrenom() + " |");
                i++;
            }
        }
    }

    public void affichagesansdetail2(Proprietaire prop) {
        for (int i = 0; i < prop.getBiens().size(); i++) {
            System.out.print(prop.getBiens().get(i).getClass().getName() + " | ");
        }
    }

    public void affichagesansdetail1() {
        for (int i = 0; i < bienAffiche.size(); i++) {
            System.out.print(bienAffiche.get(i).getClass().getName() + " | ");
        }
    }

    public void message(String messg) {
        this.listemessage.add(messg);

    }

    public List<String> getListemessage() {
        return listemessage;
    }

    public void prixfinale() {

        for (int i = 0; i < bienss.size(); i++) {
            System.out.println(
                    "Prix final de " + bienss.get(i).getClass().getName() + " est " + bienss.get(i).calculeprix());
        }

    }

}
