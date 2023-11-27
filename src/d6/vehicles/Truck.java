package d6.vehicles;

// 가장 먼저 자동차의 모든 기능을 가지게 만들자.
public class Truck extends Car {
    // 짐을 실을 수 있는 한도
    private final int maxLoad;
    // 현재 실린 짐
    private int load;

    public Truck(int maxLoad) {
        super(100);
        this.maxLoad = maxLoad;
        this.load = 0;
    }

    @Override
    public void drive(int kilos) {
        System.out.println("drive truck");
        this.fuel -= load / (maxLoad / 10);
        super.drive(kilos);
    }

    // 짐을 인자로 받아,
    // 추가했을 때 총 짐이 `maxLoad` 이하면은 추가하고
    // 아니면은 추가하지 않은 다음
    // 추가 성공 여부를 boolean으로 반환하는 메서드
    public boolean addLoad(int load) {
        if (this.load + load > this.maxLoad) {
            return false;
        }
        this.load += load;
        return true;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public int getLoad() {
        return load;
    }
}
