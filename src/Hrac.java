public class Hrac extends Herniobjekt {

    private int vJakejeMistnosti;

    public Hrac(String jmeno, String popis, int vJakejeMistnosti) {
        super(jmeno, popis);
        this.vJakejeMistnosti = vJakejeMistnosti;
    }

    public int getvJakejeMistnosti() {

        return vJakejeMistnosti;
    }

    public void setvJakejeMistnosti(int vJakejeMistnosti) {

        this.vJakejeMistnosti = vJakejeMistnosti;
    }

}

