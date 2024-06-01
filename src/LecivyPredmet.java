public class LecivyPredmet extends Veci {
    private int leciveBody;

    /**
     * Konstruktor pro vytvoření instance třídy LecivyPredmet.
     *
     * @param jmeno         Jméno léčivého předmětu.
     * @param popis         Popis léčivého předmětu.
     * @param jeSebratelny  Určuje, zda je předmět možno sebrat.
     * @param cisloMistnosti Identifikátor místnosti, kde se předmět nachází.
     * @param hmotnost      Hmotnost předmětu.
     * @throws Exception    Výjimka vyvolaná při problémech s inicializací předmětu.
     */

    public LecivyPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost, 40);
        this.leciveBody = 40; // Nastavuje léčivé body na 40
    }

    /**
     * Vrací počet léčivých bodů.
     *
     * @return Hodnota léčivých bodů.
     */

    public int getLeciveBody() {
        return leciveBody;
    }

    /**
     * Léčí hráče přidáním léčivých bodů k jeho životům.
     *
     * @param hrac Hráč, který bude léčen.
     */

    public void lecit(Hrac hrac) {
        hrac.pridatZivoty(leciveBody);
    }
}