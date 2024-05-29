public class LecivyPredmet extends Veci {
    private int leciveBody;

    public LecivyPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost, 40);
        this.leciveBody = 40; // Nastavuje léčivé body na 40
    }

    public int getLeciveBody() {
        return leciveBody;
    }

    public void lecit(Hrac hrac) {
        hrac.pridatZivoty(leciveBody);
    }
}