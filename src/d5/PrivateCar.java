package d5;

// 속성들의 접근 제어자를 private으로 설정한
// 클래스 입니다.
public class PrivateCar {
    // 총 도로를 달리고 있는 자동차의 갯수
    // 정적 속성: 객체 각각이 아닌 클래스가 가지고 있는 속성
    private static int count = 0;
    private final String brand;
    private final String name;
    private int fuel;

    // 생성자: 객체를 만들때 호출되는 메서드
    public PrivateCar() {
        count++;
        this.name = "Sonata";
        this.brand = "Hyundai";
        this.fuel = 72;
    }

    public PrivateCar(String name, String brand, int fuel) {
        count++;
        this.name = name;
        this.brand = brand;
        this.fuel = fuel;
    }

    // 경적을 울리는 기능
    public void beep() {
        System.out.println("빠아아아앙");
    }

    // 가진 정보를 출력하는 기능
    public void printInfo() {
        System.out.println(String.format("name:\t%s", name));
        System.out.println(String.format("brand:\t%s", brand));
        System.out.println(String.format("fuel:\t%d", fuel));
    }

    // 특정 거리를 이동하는 기능
    public void drive(int kilo) {
        fuel -= kilo / 2;
        System.out.println(
                String.format("Moved: %d km, Fuel: %d", kilo, fuel));
    }

    public static int getCount() {
        return count;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
