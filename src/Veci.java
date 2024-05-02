public class Veci extends Herniobjekt {
    private boolean jeSebratelny;
    private int cisloMistnosti;
    private boolean jeUkoncujici;

    public Veci(String jmeno, String popis, boolean jeSebratelny, int cisloMistnosti, boolean jeUkocujici) {
        super(jmeno, popis);
        this.jeSebratelny = jeSebratelny;
        this.cisloMistnosti = cisloMistnosti;
        this.jeUkoncujici = jeUkocujici;
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
    public boolean isUkoncujici() {
        return jeUkoncujici;
    }

    public void setUkoncujici (boolean jeUkoncujici) {
        this.jeUkoncujici = jeUkoncujici;
    }
}

