package d6.prac.q4;

public class Megaphone implements NoiseMaker {
    public void siren() {
        System.out.println("삐이이이익");
    }

    @Override
    public void makeNoise() {
        this.siren();
    }
}
