package d7.collections;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        // 핸드폰 - 연락처
        // 연락처를 검색하는 기준?
        // 이름 - 전화번호
        // Key - Value
        // 메뉴 - 가격
        // 이름 - 성적
        // 전공 - 전공생들
        Map<String, String> contactBook = new HashMap<>();
        // Map에 연락처 저장
        contactBook.put("Alex", "010-ALEX-ALEX");
        contactBook.put("Brad", "010-BRAD-BRAD");
        contactBook.put("Chad", "010-CHAD-CHAD");
        contactBook.put("Eric", "010-ERIC-ERIC");
        // Map에서 연락처 찾아오기
        System.out.println(contactBook.get("Alex"));
        System.out.println(contactBook.get("Chad"));
        System.out.println(contactBook.get("Brad"));
        // 1. 없는걸 가져올때는 null이 된다.
        System.out.println(contactBook.get("Dave"));
        // 2. 있는걸 넣을때는 덮어씌운다.
        contactBook.put("Eric", "010-00IM-GONE");
        // 전공생 수
        // CSE - 10
        // EE - 20
        // ME - 15
        // BA - 30
        Map<String, Integer> majorCount = new HashMap<>();
        majorCount.put("CSE", 10);
        majorCount.put("EE", 20);
        majorCount.put("ME", 15);
        majorCount.put("BA", 30);
        System.out.println(majorCount);

        // 만약 데이터를 넣어야 되는 상황에, 새로운 전공이 생기면?
        // 1. majorCount.get("major") == null
        String newMajor = "ENG";
        if (majorCount.get(newMajor) == null) {
            majorCount.put(newMajor, 1);
        } else {
            int before = majorCount.get(newMajor);
            majorCount.put(newMajor, before + 1);
        }

        // 2. putIfAbsent
        Integer before = majorCount.putIfAbsent(newMajor, 1);
        if (before != null) {
            majorCount.put(newMajor, before + 1);
        }

        Map<String, List<String>> majorStudents = new HashMap<>();
        majorStudents.put("CSE", new ArrayList<>());
        List<String> cseStudents = majorStudents.get("CSE");
        cseStudents.add("Alex");
        cseStudents.add("Brad");
        cseStudents.add("Chad");
        System.out.println(majorStudents);

        // keySet(), entrySet()
        // Map을 순회하고 싶으면 둘중 하나 선택할 수 있다.
        // keySet() - Key 로만 구성된 Set
        Set<String> keySet = contactBook.keySet();
        for (String key : keySet) {
            System.out.println(key);
            System.out.println(contactBook.get(key));
        }

        // entrySet() - Key - Value 쌍(Entry)으로 구성된 Set
        // Entry는 Key와 Value를 조회할 수 있는 메서드를 가지고 있다.
        for (Map.Entry<String, String> entry : contactBook.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // git config user.email 이메일
        // git config user.name 아이디



        // 사람 한명에 대한 정보
        // name - 박지호
        // age - "40"
        // major - CSE




    }
}
