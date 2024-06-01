import java.util.ArrayList;

public class Batoh extends Herniobjekt {

    private static final int MAX_HMOTNOST = 100;
    private int soucasnaHmotnost;

    private boolean jePrazdny;
    private boolean jePlny;

    ArrayList<Veci> batoh = new ArrayList<>();

    /**
     * Konstruktor pro vytvoření instance třídy Batoh.
     * Inicializuje batoh jako prázdný a neplný.
     */

    public Batoh() {
        super("", "");
        this.jePrazdny = true;
        this.jePlny = false;
    }

    /**
     * Vrací informaci, zda je batoh prázdný.
     *
     * @return True, pokud je batoh prázdný, jinak false.
     */

    public boolean isJePrazdny() {
        return jePrazdny;
    }

    /**
     * Nastavuje, zda je batoh prázdný.
     *
     * @param jePrazdny Nová hodnota indikující, zda je batoh prázdný.
     */

    public void setJePrazdny(boolean jePrazdny) {
        this.jePrazdny = jePrazdny;
    }

    /**
     * Vrací informaci, zda je batoh plný.
     *
     * @return True, pokud je batoh plný, jinak false.
     */

    public boolean isJePlny() {
        return jePlny;
    }

    /**
     * Nastavuje, zda je batoh plný.
     *
     * @param jePlny Nová hodnota indikující, zda je batoh plný.
     */

    public void setJePlny(boolean jePlny) {
        this.jePlny = jePlny;
    }

    /**
     * Přidává věc do batohu.
     *
     * @param vec Věc, která má být přidána do batohu.
     * @throws Exception Vyvolána v případě, že přidání věci překročí maximální hmotnost batohu.
     */

    public void pridejDoxBatohu(Veci vec) throws Exception {
        if (soucasnaHmotnost + vec.getHmotnost() > MAX_HMOTNOST) {
            throw new Exception("Přidáním této věci by byl překročen limit hmotnosti batohu.");
        }
        batoh.add(vec);
        soucasnaHmotnost += vec.getHmotnost();
        jePrazdny = false;
        jePlny = soucasnaHmotnost >= MAX_HMOTNOST;
    }


    /**
     * Odebírá věc z batohu.
     *
     * @param vec Věc, která má být odebrána z batohu.
     */

    public void odeberZBatohu(Veci vec) {
        if (batoh.contains(vec)) {
            batoh.remove(vec);
            soucasnaHmotnost -= vec.getHmotnost();
            jePlny = false;
            jePrazdny = batoh.isEmpty();
        }
    }

    /**
     * Vrací seznam věcí v batohu.
     *
     * @return Seznam věcí v batohu.
     */

    public ArrayList<Veci> getBatoh() {
        return batoh;
    }

    /**
     * Vypisuje obsah batohu do konzole.
     */

    public void vypisObsah() {
        System.out.println("Obsah batohu:");
        for (Veci vec : batoh) {
            System.out.println("- " + vec.getJmeno() + " (" + vec.getHmotnost() + " kg)");
        }
    }
}