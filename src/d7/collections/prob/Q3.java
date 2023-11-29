package d7.collections.prob;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
어떤 가게의 메뉴 `<메뉴명> <가격>`형태로 계속 입력된다.
`"order"`가 입력되었을 때,
사용자의 단일 주문을 받고 금액을 출력하시오.

예시 입출력
입력1:
```text
Americano 1500
Cappuccino 2000
Latte 2500
Mocha 3000
order
Latte
```
출력1:
```text
2500
```

 */
public class Q3 {
    public static void main(String[] args) {
//        String americano = "americano 1500";
//        String[] menuLine = americano.split(" ");
//        System.out.println(Arrays.toString(menuLine));
        Scanner scanner = new Scanner(System.in);
        // 메뉴 저장용 Map
        Map<String, Integer> menu = new HashMap<>();
        while (true) {
            String line = scanner.nextLine();
            if ("order".equals(line))
                break;
            // split을 쓰면
            // menuLine[0]에 메뉴명
            // menuLine[1]에 (문자열로 저장된) 가격
            String[] menuLine = line.split(" ");
            // 이름과 가격을 분리한다.
            String menuName = menuLine[0];
            Integer menuPrice = Integer.parseInt(menuLine[1]);
            menu.put(menuName, menuPrice);
        }
        // 주문받을 준비
        String order = scanner.nextLine();
        System.out.println(menu.get(order));
    }
}















