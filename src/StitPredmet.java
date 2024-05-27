public class StitPredmet extends Veci{

    private double stitEfektivita;

    public StitPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost, double stitEfektivita) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost);
        this.stitEfektivita = stitEfektivita;
    }

    public double getStitEfektivita() {
        return stitEfektivita;
    }

    public void aktivovatStit(Hrac hrac) {
        hrac.aktivovatStit(stitEfektivita);
    }
}

