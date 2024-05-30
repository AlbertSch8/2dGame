public class Hrac extends Herniobjekt {

    private int vJakejeMistnosti;
    private int zivoty;
    private boolean jeAktivniStit;

    public Hrac(String jmeno, String popis, int vJakejeMistnosti, int pocatecniZivoty) {
        super(jmeno, popis);
        this.vJakejeMistnosti = vJakejeMistnosti;
        this.zivoty = pocatecniZivoty;
        this.jeAktivniStit = false;
    }

    public int getvJakejeMistnosti() {
        return vJakejeMistnosti;
    }

    public void setvJakejeMistnosti(int vJakejeMistnosti) {
        this.vJakejeMistnosti = vJakejeMistnosti;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void pridatZivoty(int zivoty) {
        this.zivoty += zivoty;
    }

    public boolean isJeAktivniStit() {
        return jeAktivniStit;
    }

    public void aktivovatStit(double stitEfektivita) {
        this.jeAktivniStit = true;
    }

    public void deaktivovatStit() {
        this.jeAktivniStit = false;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public void ubratZivoty(int zivoty) {
        this.zivoty -= zivoty;
    }

    public void zobrazZivoty() {
        System.out.println("Aktuální počet životů hráče: " + zivoty);
    }
}


