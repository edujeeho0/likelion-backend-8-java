package d7.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        // List는 인터페이스다.

        // ArrayList: 배열을 관리해주는 Collection - List
        List<String> names = new ArrayList<>();
        // 리스트에 넣기
        names.add("Alex");  // 비어있고
        names.add("Brad");  // 1칸 차있고
        names.add("Dave");  // 2칸 차있고
        names.add("Eric");
        // 데이터 회수
        System.out.println(names.get(0));
        System.out.println(names.get(2));
        // 중간에 넣기
        names.add(2, "Chad");
        System.out.println(names);
        names.add("Fred");
        // 데이터 위치 찾기
        System.out.println("Chad is at: " + names.indexOf("Chad"));
        // 없을 경우 -1
        System.out.println("Greg is at: " + names.indexOf("Greg"));
        // 데이터 제거하기
        System.out.println(names.remove(3));    // 순서를 기준으로
        System.out.println(names.remove("Eric"));  // 값을 기준으로
        System.out.println(names.remove("Eric"));  // 값을 기준으로 찾는데 실패

        // 원시타입은 못쓴다.
        // List<int> intList = new ArrayList<>();
        // 대신 Wrapper 사용 가능
        List<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(10);
        intList.add(20);
        intList.add(439);
        System.out.println(intList);
        // 순서로 제거할 때
        System.out.println(intList.remove(2));
        // 값으로 제거할 때
        System.out.println(intList.remove(Integer.valueOf(20)));


        // 배열과 비교
        String[] nameArray = new String[16];
        nameArray[0] = "Alex";
        nameArray[1] = "Brad";
        nameArray[2] = "Dave";
        nameArray[3] = "Eric";
//        System.out.println(nameArray[0]);
//        System.out.println(nameArray[2]);
        // 1. 직접 일일히 뒤로 밀어줘야 하며
        // 2. 몇개의 원소가 들어갔는지 확인할 도리가 없어서 따로 변수로 관리해줘야 함
        nameArray[4] = nameArray[3];
        nameArray[3] = nameArray[2];
        nameArray[2] = "Chad";

        ArrayList<Integer> intArrayList = new ArrayList<>();
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        sum(intArrayList);
        sum(intLinkedList);


    }


    // 매개변수로 전달할때는 기능을 중요시하는 interface 기준으로 매개변수 선언
    public static int sum(List<Integer> intList) {
        return 0;
    }

    // 구현을 중시하는 방식으로 요구를 하면 기능적 측면의 차이가 없는
    // 클래스는 하나도 못쓴다.
//    public static int sum(ArrayList<Integer> intList) {
//        return 0;
//    }
}
