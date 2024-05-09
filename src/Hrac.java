public class Hrac extends Herniobjekt {

    private int vJakejeMistnosti;
    private int zivoty;
    private boolean jeAktivniStit;

    public Hrac(String jmeno, String popis, int vJakejeMistnosti, int pocatecniZivoty) {
        super(jmeno, popis);
        this.vJakejeMistnosti = vJakejeMistnosti;
        this.zivoty = 100;
        jeAktivniStit = false;
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

    public void aktivovatStit(double efektivita) {
        this.jeAktivniStit = true;
        // Tuto metodu je možné rozšířit o další logiku související s efektivitou štítu
    }

    public void deaktivovatStit() {
        this.jeAktivniStit = false;
    }
}



