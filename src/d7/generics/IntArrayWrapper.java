package d7.generics;

/*
정수 배열을 가지고 있고,
그 정수 배열에 대한 정보를 제공하는 목적의 배열 편의성 클래스
 */
public class IntArrayWrapper {
    private final int[] intArray;

    public IntArrayWrapper(int[] intArray) {
        this.intArray = intArray;
    }

    // 1. intArray의 길이를 반환하는 메서드
    public int length() {
        return this.intArray.length;
    }

    // 2. 주어진 int target이 intArray에 존재하는지 반환하는 메서드
    public boolean contains(int target) {
        for (int number : this.intArray) {
            if (target == number) return true;
        }
        return false;
    }

    // 3. intArray의 원소 중 최댓값
    public int max() {
        int max = this.intArray[0];
        for (int number : this.intArray) {
            // Math: 여러 수학 작업이 존재하는 클래스
            max = Math.max(number, max);
        }
        return max;
    }
}







