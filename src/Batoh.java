import java.util.ArrayList;

public class Batoh extends Herniobjekt {

    private static final int MAX_HMOTNOST = 100;
    private int soucasnaHmotnost;

    private boolean jePrazdny;
    private boolean jePlny;

    ArrayList<Veci> batoh = new ArrayList<>();

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

    public void pridejDoxBatohu(Veci vec) throws Exception {
        if (soucasnaHmotnost + vec.getHmotnost() > MAX_HMOTNOST) {
            throw new Exception("Přidáním této věci by byl překročen limit hmotnosti batohu.");
        }
        batoh.add(vec);
        soucasnaHmotnost += vec.getHmotnost();
        jePrazdny = false;
        jePlny = soucasnaHmotnost >= MAX_HMOTNOST;
    }

    public void odeberZBatohu(Veci vec) {
        if (batoh.contains(vec)) {
            batoh.remove(vec);
            soucasnaHmotnost -= vec.getHmotnost();
            jePlny = false;
            jePrazdny = batoh.isEmpty();
        }
    }

    public ArrayList<Veci> getBatoh() {
        return batoh;
    }

    public void vypisObsah() {
        System.out.println("Obsah batohu:");
        for (Veci vec : batoh) {
            System.out.println("- " + vec.getJmeno() + " (" + vec.getHmotnost() + " kg)");
        }
    }
}