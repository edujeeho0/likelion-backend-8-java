package d7.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<String> skillSet = new HashSet<>();
        // add를 사용해 원소를 추가하는건 동일
        skillSet.add("md");
        skillSet.add("git");
        skillSet.add("java");
        skillSet.add("oop");
        // 하지만 중복되는 데이터는 추가가 안됨
        skillSet.add("java");
        // 또한 데이터의 순서를 보장하지 않음
        System.out.println(skillSet);

        List<String> skillList = new ArrayList<>();
        skillList.add("java");
        skillList.add("kotlin");
        skillList.add("android");
        skillList.add("flutter");
        skillList.add("react");
        skillList.add("git");
        // 다른 Collection의 원소를 전부 추가 시도
        // 내가 없는 원소들을 선별해 추가한다.
        // 하나라도 추가하면 true
        skillSet.addAll(skillList);  // true
        System.out.println(skillList);
//        System.out.println(skillSet.addAll(skillList));
        System.out.println(skillSet.addAll(skillList));  // false
        System.out.println(skillSet);

        List<Pigeon> listHoles = new ArrayList<>();
        Set<Pigeon> setHoles = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            Pigeon pigeon = new Pigeon(i % 10);
            listHoles.add(pigeon);
            setHoles.add(pigeon);
        }

        System.out.println("리스트의 비둘기: " + listHoles.size());
        System.out.println("집합의 비둘기: " + setHoles.size());
    }
}
