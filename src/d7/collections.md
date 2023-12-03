# Collections Framework

<!-- TOC -->
* [Collections Framework](#collections-framework)
  * [`List<E>`](#liste)
  * [`Set<E>`](#sete)
  * [`Iterable` & `Collection`](#iterable--collection)
    * [`Iterable`](#iterable)
    * [`Collection`](#collection)
    * [`Map<K, V>`](#mapk-v)
<!-- TOC -->

Java에는 Generic을 활용하여 다수의 데이터를 쉽게 관리할 수 있게 해주는 Collections Framework를 제공한다.

## `List<E>`

여러개의 데이터를 순서를 갖추고 정리한다. 중복의 데이터가 허용된다.

```java
List<String> skillList = new ArrayList<>();

skillList.add("Java");
skillList.add("Python");
skillList.add("Kotlin");
skillList.add("Java");  // 중복을 허용한다.
// 배열처럼 index 방식으로 원소를 가져올 수 있다.
System.out.println(skillList.get(2));
```

| 메서드                              | 기능                                                   |
|----------------------------------|------------------------------------------------------|
| `boolean add(E element)`         | 인자로 전달된 element를 List 의 끝에 넣어준다. 성공하면 true를 반환한다.    |
| `void add(int index, E element)` | 인자로 전달된 element를 index 의 위치에 넣어주고, 원래의 원소들을 뒤로 밀어준다. |
| `E get(int index)`               | index 에 있는 원소를 반환한다.                                 |
| `int indexOf(Object o)`          | o 가 있으면 그 index를, 없으면 -1 을 반환한다.                     |
| `E remove(int index)`            | index 에 있는 원소를 제거하고 반환한다. 뒤에 남은 원소들을 앞으로 당겨준다.       |
| `boolean remove(Object o)`       | o 가 있다면 제거한다.                                        |

주로 `ArrayList`와 `LinkedList`를 활용한다.

- `ArrayList` : 배열의 크기를 동적으로 조절하면서 활용. 임의의 위치에서 원소를 가져오는데 유리.
- `LinkedList` : 연결 리스트 형태로 데이터를 관리. 원소를 중간에 자주 추가 또는 제거하는데 유리.

## `Set<E>`

순서를 보장하지 않지만, 중복을 허용하지 않는다.
중복을 허용하지 않기 때문에 유일한 원소들을 남기거나 어떤 원소의 존재 여부를 판단할 때 활용.

```java
Set<String> skillSet = new HashSet<>();

skillSet.add("Java");
skillSet.add("Python");
skillSet.add("Kotlin");
// 중복 원소는 들어가지 않는다.
skillSet.add("Java");  
```

| 메서드                                            | 기능                                                                 |
|------------------------------------------------|--------------------------------------------------------------------|
| `boolean add(E element)`                       | 인자로 전달된 element를 추가한다. 이미 있는 데이터면 false 를 반환한다.                    |
| `boolean addAll(Collection<? extends E> c)`    | 또다른 Collection 인터페이스의 원소들 중 없는 원소를 추가한다. 추가한 원소가 존재하면 true 를 반환한다. |
| `boolean remove(Object o)`                     | o 가 있다면 제거한다. 제거했다면 true 를 반환한다.                                   |
| `boolean removeAll(Collection<? extends E> c)` | 또다른 Collection 인터페이스의 원소들 중 있는 원소를 제거한다. 제거한 원소가 존재하면 true 를 반환한다. |
| `void clear()`                                 | Set 을 비운다.                                                         |

기본적으로 `hashCode`의 결과를 활용하는 `HashSet`을 활용한다.

## `Iterable` & `Collection`

`List`와 `Set`이 상속받는 인터페이스.

### `Iterable`

`Iterable`은 반복가능하다는 의미로, `Iterator`라는 특수한 객체를 통해 원소를 하나씩 살펴볼 수 있다.

```java
// Iterator
Iterator<String> listIter = skillList.iterator();
while (listIter.hasNext()) {
    String element = listIter.next();
    System.out.println(element);
}
```

`Iterator`는 다음의 메서드로 내부의 데이터를 하나씩 살펴본다.

| 메서드                 | 기능                                                                             |
|---------------------|--------------------------------------------------------------------------------|
| `boolean hasNext()` | 다음 원소가 존재하는지 여부를 반환한다.                                                         |
| `T next()`          | 호출할때마다 다음 차례의 원소를 반환한다.                                                        |
| `void remove()`     | 현재 위치의 원소를 제거한다. `next()` 를 사용한 다음 사용해야 하며, `next()` 로 한번 확인할 때마다 한번만 사용 가능하다. |


`Iterable`을 구현하면 `foreach` 내부에서 활용할 수 있다.

```java
List<String> skillList = new ArrayList<>();

// ...

for (String skill : skillList) {
    System.out.println(skill);
}
```

다만 순회중에 원소를 제거할일이 있다면, `foreach`의 경우 예외가 발생할 수 있다.
이때는 `while`과 `iterator`를 활용하는 것을 권장.

### `Collection`

`Iterable`을 상속받는 인터페이스.
`add`, `clear` 등 `List`와 `Set`로 사용하는 메서드는 실제로 이곳에 추상 메서드로 정의되어 있다.

| 메서드                          | 기능                             |
|------------------------------|--------------------------------|
| `int size()`                 | `Collection`의 원소의 갯수를 반환한다.    |
| `boolean isEmpty()`          | `Collection`이 비어있는지 여부를 반환한다.  |
| `boolean contains(Object o)` | `Collection`에 `o` 가 있는지를 반환한다. |

`Collection`을 상속받는 클래스는, 인자를 받지 않는 기본생성자와 다른 `Collection`을 인자로 받는 생성자를 정의할것을 권장하고 있다.
그래서 하나의 `Collection`은 다른 `Collection`으로 변환이 가능하다.

```java
Set<String> skillSet = new HashSet<>();
// 집합에 원서 넣어주기
List<String> listFromSet = new ArrayList<>(skillSet);
```

### `Map<K, V>`

키(Key)와 값(Value)로 쌍을 이루는 데이터로 구성된 인터페이스.
키를 이용해서 쌍이 이뤄진 데이터를 회수할 수 있다.

`List`와 `Set`과는 달리 `Collection` 인터페이스를 구현하지는 않는다.

```java
Map<String, String> gitConfig = new HashMap<>();
gitConfig.put("user.email", "edujeeho@gmail.com");
gitConfig.put("user.name", "edujeeho0");

System.out.println(gitConfig.get("user.name"));
```

| 메서드                                   | 기능                                                     |
|---------------------------------------|--------------------------------------------------------|
| `V put(K key, V value)`               | `key`에 `Value`를 할당한다. 이미 존재하는 `key`면 이전 `value`를 반환한다. |
| `V get(Object key)`                   | `key`에 해당하는 값을 반환하거나 `null`을 반환한다.                     |
| `boolean containsKey(Object key)`     | `key`와 일치하는 `key`가 맵에 존재하면 `true`를 반환한다.               |
| `boolean containsValue(Object value)` | `value`와 일치하는 `value`가 맵에 하나라도 존재하면 `true`를 반환한다.      |
| `V remove(Object key)`                | `key`에 해당하는 값을 제거하고 반환한다. 없으면 `null`을 반환한다.            |
| `Set<K> keySet()`                     | 모든 `key`로 구성된 `Set`을 반환한다.                             |
| `Set<Map.Entry<K, V>> entrySet()`     | 맵의 `key`와 `value`쌍으로 구성된 `Entry`객체의 `Set`을 반환한다.       |

`keySet`이나 `entrySet`을 활용하면 내부 데이터를 순회할 수 있다.

```java
Map<String, String> gitConfig = new HashMap<>();
gitConfig.put("user.email", "edujeeho@gmail.com");
gitConfig.put("user.name", "edujeeho0");

for (String key : gitConfig.keySet()) {
    System.out.println(String.format("key: %s", key));
    System.out.println(String.format("value: %s", gitConfig.get(key)));
}

for(Map.Entry<String, String> entry : gitConfig.entrySet()) {
    System.out.println(String.format("key: %s", entry.getKey()));
    System.out.println(String.format("value: %s", entry.getValue()));
}
```

주로 활용하는 것은 `hashCode`를 활용해 Key를 구분하는 `HashMap`.

