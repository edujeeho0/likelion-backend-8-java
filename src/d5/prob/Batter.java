package d5.prob;

public class Batter {
    private String name;
    private int atBats;
    private int hits;
    private int walks;
    private int numOfBases;

    public Batter(String name) {
        this.name = name;
        this.atBats = 0;
        this.hits = 0;
        this.walks = 0;
        this.numOfBases = 0;
    }

    public void hit(int bases) {
        atBats += 1;
        hits += 1;
        numOfBases += bases;
    }

    public void out() {
        this.atBats += 1;
    }

    public void walk() {
        this.atBats += 1;
        this.walks += 1;
    }

    public double batAvg() {
        return (double) hits / (atBats - walks);
    }

    public double onBasePer() {
        return (double) (hits + walks) / atBats;
    }

    public double slugPer() {
        return (double) numOfBases / (atBats - walks);
    }

    public double ops() {
        return onBasePer() + slugPer();
    }
}
