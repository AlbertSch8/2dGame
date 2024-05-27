public class Veci extends Herniobjekt {
    private boolean jeSebratelny;
    private int cisloMistnosti;
    private int hmotnost;

    private static int celkovaHmotnost = 0;

    public Veci(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, int hmotnost) throws Exception{
        super(jmeno, popis);
        this.jeSebratelny = jeSebratelny;
        this.cisloMistnosti = cisloMistnosti;

        if (hmotnost != 10 && hmotnost != 20 && hmotnost != 30) {
            throw new IllegalArgumentException("Hmotnost musí být 10, 20 nebo 30.");
    }

        if (celkovaHmotnost + hmotnost > 100) {
            throw new Exception("Přidáním této věci by byl překročen limit hmotnosti 100.");
        }
        this.hmotnost = hmotnost;
        celkovaHmotnost += hmotnost;
    }

    public int getHmotnost() {
        return hmotnost;
    }


    public boolean isJeSebratelny() {
        return jeSebratelny;
    }

    public void setJeSebratelny(boolean jeSebratelny) {
        this.jeSebratelny = jeSebratelny;
    }

    public int getCisloMistnosti() {
        return cisloMistnosti;
    }

    public void setCisloMistnosti(int cisloMistnosti) {
        this.cisloMistnosti = cisloMistnosti;
    }
}

