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
}
