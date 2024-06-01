import java.util.Scanner;

public class Pritel extends Herniobjekt{

    private boolean jePratelsky;

    private boolean jeNepritel;

    private int cisloMistnosti;
    private int zivoty;

    /**
     * Konstruktor pro vytvoření instance třídy Pritel.
     *
     * @param jmeno           Jméno postavy.
     * @param popis           Popis postavy.
     * @param jePratelsky     Určuje, zda je postava přátelská.
     * @param jeNepritel      Určuje, zda je postava nepřátelská.
     * @param cisloMistnosti  Číslo místnosti, ve které se postava nachází.
     * @param zivoty          Počet životů postavy.
     */

    public Pritel(String jmeno, String popis, boolean jePratelsky, boolean jeNepritel, int cisloMistnosti, int zivoty) {
        super(jmeno, popis);
        this.jePratelsky = jePratelsky;
        this.jeNepritel = jeNepritel;
        this.cisloMistnosti = cisloMistnosti;
        this.zivoty = zivoty;
    }

    /**
     * Vrací informaci, zda je postava přátelská.
     *
     * @return True, pokud je postava přátelská, jinak false.
     */

    public boolean isJePratelsky() {
        return jePratelsky;
    }

    /**
     * Nastavuje, zda je postava přátelská.
     *
     * @param jePratelsky Nová hodnota indikující, zda je postava přátelská.
     */

    public void setJePratelsky(boolean jePratelsky) {
        this.jePratelsky = jePratelsky;
    }

    /**
     * Vrací informaci, zda je postava nepřátelská.
     *
     * @return True, pokud je postava nepřátelská, jinak false.
     */

    public boolean isJeNepritel() {
        return jeNepritel;
    }

    /**
     * Nastavuje, zda je postava nepřátelská.
     *
     * @param jeNepritel Nová hodnota indikující, zda je postava nepřátelská.
     */

    public void setJeNepritel(boolean jeNepritel) {
        this.jeNepritel = jeNepritel;
    }

    /**
     * Vrací číslo místnosti, ve které se postava nachází.
     *
     * @return Číslo místnosti.
     */

    public int getCisloMistnosti() {
        return cisloMistnosti;
    }

    /**
     * Nastavuje číslo místnosti, ve které se postava nachází.
     *
     * @param cisloMistnosti Nové číslo místnosti.
     */

    public void setCisloMistnosti(int cisloMistnosti) {
        this.cisloMistnosti = cisloMistnosti;
    }

    /**
     * Vrací počet životů postavy.
     *
     * @return Počet životů postavy.
     */

    public int getZivoty() {
        return zivoty;
    }

    /**
     * Nastavuje počet životů postavy.
     *
     * @param zivoty Nový počet životů.
     */

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    /**
     * Metoda pro boj hráče s nepřátelskou postavou.
     *
     * @param scanner Scanner pro čtení vstupu od uživatele.
     * @param hrac    Instance třídy Hrac, reprezentující hráče.
     * @return True, pokud hráč vyhrál boj, jinak false.
     */

    public boolean bojSNepritelem(Scanner scanner, Hrac hrac) {
        while (true) {
            int utocnaSilaHrace = 10;
            int utocnaSilaNepritele = 10;
            this.zivoty -= utocnaSilaHrace;
            System.out.println("Útočíte na " + this.getJmeno() + " a ubíráte mu " + utocnaSilaHrace + " životů.");
            if (this.zivoty <= 0) {
                System.out.println("Vítězství! " + this.getJmeno() + " byl poražen.");
                return true;
            }
            hrac.ubratZivoty(utocnaSilaNepritele);
            System.out.println(this.getJmeno() + " útočí na vás a ubírá vám " + utocnaSilaNepritele + " životů.");
            // Pokud hráč zemře
            if (hrac.getZivoty() <= 0) {
                System.out.println("Prohra! " + this.getJmeno() + " tě zabil.");
                return false;
            }
            System.out.println("Stav životů - " + this.getJmeno() + ": " + this.zivoty + ", " + hrac.getJmeno() + ": " + hrac.getZivoty());
            System.out.println("Chcete pokračovat v útoku? (ano/ne)");
            String odpoved = scanner.nextLine().toLowerCase();
            if (odpoved.equals("ne")) {
                System.out.println("Rozhodl jste se ukončit útok.");
                return false;
            }
        }
    }
}
