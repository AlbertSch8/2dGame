
public class StitPredmet extends Veci {

    private double stitEfektivita;

    /**
     * Konstruktor pro vytvoření instance třídy StitPredmet.
     *
     * @param jmeno         Jméno štítu.
     * @param popis         Popis štítu.
     * @param jeSebratelny  Určuje, zda je štít možno sebrat.
     * @param cisloMistnosti Identifikátor místnosti, kde se štít nachází.
     * @param hmotnost      Hmotnost štítu.
     * @throws Exception    Výjimka vyvolaná při problémech s inicializací předmětu.
     */

    public StitPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost,50);
        this.stitEfektivita = 50.0;
    }

    /**
     * Vrací efektivitu štítu.
     *
     * @return Hodnota efektivity štítu.
     */

    public double getStitEfektivita() {
        return stitEfektivita;
    }

    /**
     * Aktivuje štít a přidá hráči životy podle efektivity štítu.
     *
     * @param hrac Hráč, který aktivuje štít.
     */

    public void aktivovatStit(Hrac hrac) {
        hrac.pridatZivoty((int)stitEfektivita);
    }
}

