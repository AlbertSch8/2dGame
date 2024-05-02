import java.util.ArrayList;

public class Batoh extends Herniobjekt{

    private boolean jePrazdny;
    private boolean jePlny;

    ArrayList<String> batoh = new ArrayList<String>();

    public Batoh() {
        super("", "");
        this.jePrazdny = true;
        this.jePlny = false;
    }

    public boolean isJePrazdny() {
        return jePrazdny;
    }

    public void setJePrazdny(boolean jePrazdny) {
        this.jePrazdny = jePrazdny;
    }

    public boolean isJePlny() {
        return jePlny;
    }

    public void setJePlny(boolean jePlny) {
        this.jePlny = jePlny;
    }
    public void pridejDoBatohu(String predmet) {batoh.add(predmet);}
    public boolean odeberZBatohu(String predmet) {
        return batoh.remove(predmet);
    }
    public void vypisObsah() {
        System.out.println("Obsah batohu:");
        for (String predmet : batoh) {
            System.out.println("- " + predmet);
        }
    }
}
