package d6.prac.q4;

public class Ship implements NoiseMaker {
    public void fogHorn() {
        System.out.println("빠아아아아아앙");
    }
    @Override
    public void makeNoise() {
        fogHorn();
    }
}
