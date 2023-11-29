package d6.prac.q3;

public class Television implements Switchable, PlaySound, Display{
    private boolean power;

    @Override
    public void playMedia() {
        System.out.println("Playing Netflix...");
    }

    @Override
    public void playSound() {
        System.out.println("Switch to Music Channel...");
    }

    @Override
    public boolean hitSwitch() {
        this.power = !this.power;
        return this.power;
    }
}
