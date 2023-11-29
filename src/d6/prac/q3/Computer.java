package d6.prac.q3;

public class Computer implements Switchable, PlaySound, Display{
    private boolean power;

    @Override
    public void playMedia() {
        System.out.println("Playing Media File...");
    }

    @Override
    public void playSound() {
        System.out.println("Playing MP3 File...");
    }

    @Override
    public boolean hitSwitch() {
        this.power = !this.power;
        return this.power;
    }
}
