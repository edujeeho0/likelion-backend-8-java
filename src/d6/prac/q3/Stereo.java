package d6.prac.q3;

public class Stereo implements Switchable, PlaySound{
    private boolean power;

    @Override
    public void playSound() {
        System.out.println("Playing CD...");
    }

    @Override
    public boolean hitSwitch() {
        this.power = !this.power;
        return this.power;
    }
}
