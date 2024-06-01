public class Hrac extends Herniobjekt {

    private int vJakejeMistnosti;
    private int zivoty;
    private boolean jeAktivniStit;

    /**
     * Konstruktor pro vytvoření instance třídy Hrac.
     *
     * @param jmeno             Jméno hráče.
     * @param popis             Popis hráče.
     * @param vJakejeMistnosti  Číslo místnosti, ve které se hráč nachází.
     * @param pocatecniZivoty   Počáteční počet životů hráče.
     */

    public Hrac(String jmeno, String popis, int vJakejeMistnosti, int pocatecniZivoty) {
        super(jmeno, popis);
        this.vJakejeMistnosti = vJakejeMistnosti;
        this.zivoty = pocatecniZivoty;
        this.jeAktivniStit = false;
    }

    /**
     * Vrací číslo místnosti, ve které se hráč aktuálně nachází.
     *
     * @return Číslo místnosti.
     */

    public int getvJakejeMistnosti() {
        return vJakejeMistnosti;
    }

    /**
     * Nastavuje číslo místnosti, ve které se hráč aktuálně nachází.
     *
     * @param vJakejeMistnosti Nové číslo místnosti.
     */

    public void setvJakejeMistnosti(int vJakejeMistnosti) {
        this.vJakejeMistnosti = vJakejeMistnosti;
    }

    /**
     * Vrací aktuální počet životů hráče.
     *
     * @return Počet životů hráče.
     */

    public int getZivoty() {
        return zivoty;
    }

    /**
     * Přidává hráči životy.
     *
     * @param zivoty Počet životů k přidání.
     */

    public void pridatZivoty(int zivoty) {
        this.zivoty += zivoty;
    }

    /**
     * Vrací informaci, zda je štít aktivní.
     *
     * @return True, pokud je štít aktivní, jinak false.
     */

    public boolean isJeAktivniStit() {
        return jeAktivniStit;
    }

    /**
     * Aktivuje štít hráče.
     *
     * @param stitEfektivita Efektivita štítu (nepoužitý parametr).
     */

    public void aktivovatStit(double stitEfektivita) {
        this.jeAktivniStit = true;
    }

    /**
     * Deaktivuje štít hráče.
     */

    public void deaktivovatStit() {
        this.jeAktivniStit = false;
    }

    /**
     * Nastavuje počet životů hráče.
     *
     * @param zivoty Nový počet životů.
     */

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    /**
     * Ubere hráči životy.
     *
     * @param zivoty Počet životů k ubrání.
     */

    public void ubratZivoty(int zivoty) {
        this.zivoty -= zivoty;
    }

    /**
     * Vypisuje aktuální počet životů hráče do konzole.
     */

    public void zobrazZivoty() {
        System.out.println("Aktuální počet životů hráče: " + zivoty);
    }
}


