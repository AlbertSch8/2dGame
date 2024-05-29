
public class StitPredmet extends Veci {

    private double stitEfektivita;

    public StitPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost,50);
        this.stitEfektivita = 50.0;
    }

    public double getStitEfektivita() {
        return stitEfektivita;
    }

    public void aktivovatStit(Hrac hrac) {
        hrac.pridatZivoty((int)stitEfektivita);
    }
}

