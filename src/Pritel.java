import java.util.Scanner;

public class Pritel extends Herniobjekt{

    private boolean jePratelsky;

    private boolean jeNepritel;

    private int cisloMistnosti;
    private int zivoty;

    public Pritel(String jmeno, String popis, boolean jePratelsky, boolean jeNepritel, int cisloMistnosti, int zivoty) {
        super(jmeno, popis);
        this.jePratelsky = jePratelsky;
        this.jeNepritel = jeNepritel;
        this.cisloMistnosti = cisloMistnosti;
        this.zivoty = zivoty;
    }

    public boolean isJePratelsky() {
        return jePratelsky;
    }

    public void setJePratelsky(boolean jePratelsky) {
        this.jePratelsky = jePratelsky;
    }

    public boolean isJeNepritel() {
        return jeNepritel;
    }

    public void setJeNepritel(boolean jeNepritel) {
        this.jeNepritel = jeNepritel;
    }

    public int getCisloMistnosti() {
        return cisloMistnosti;
    }

    public void setCisloMistnosti(int cisloMistnosti) {
        this.cisloMistnosti = cisloMistnosti;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

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
