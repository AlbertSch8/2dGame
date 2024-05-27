public class LecivyPredmet extends Veci{

    private int leciveBody;

    public LecivyPredmet(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost, int leciveBody) throws Exception {
        super(jmeno, popis, jeSebratelny, cisloMistnosti, hmotnost);
        this.leciveBody = leciveBody;
    }

    public int getLeciveBody() {
        return leciveBody;
    }

    public void lecit(Hrac hrac) {
        hrac.pridatZivoty(leciveBody);
    }
}