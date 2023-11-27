package d6.vehicles;

/*
연료가 얼마나 들었는지에 대한 정보 (속성)
연료가 얼마나 남았는지에 대한 정보를 반환하는 메서드
연료를 설정하는 메서드
운전하는 메서드, 실행시 주행거리 / 10 (정수) 만큼 연료 소모
경적을 울리는 `beep`
 */
// 운전할 수 있다.
public class Car implements Beeper, Drivable {
    @Override
    public void beep() {
        System.out.println("빵빵");
    }

    // private 접근 제어자는 나, 그리고 오로지 나
    // protected 접근 제어자는 우리 자식 자손
//    private int fuel;
    protected int fuel;

    public Car() {}
    public Car(int fuel) {this.fuel = fuel;}

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void drive(int kilos) {
        System.out.println("drive car");
        this.fuel -= kilos / 10;
        System.out.println(String.format(
                "moved: %d, current fuel: %d",
                kilos, this.fuel));
    }
}
