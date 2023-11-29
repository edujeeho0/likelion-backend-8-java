package d6.prac.q3;

public class Induction implements Switchable, CookingUtensil {
    private boolean power;

    @Override
    public void cook() {
        System.out.println("Cooking Something...");
    }

    @Override
    public boolean hitSwitch() {
        this.power = !this.power;
        return this.power;
    }
}
