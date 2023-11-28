package d7.generics;

import java.io.Serializable;

// <T>를 해주면 T를 타입처럼 쓸 수 있다.
public class ArrayWrapper<T
        extends Number & Comparable<T> & Serializable>
{

    private final T[] array;

    public ArrayWrapper(T[] array) {
        if (array == null)
            throw new IllegalArgumentException(
                    "null array provided");
        this.array = array;
    }

    public int length() {
        return this.array.length;
    }

    public boolean contains(T target) {
        for (T item : this.array) {
            if (item == null) continue;
            if (item.equals(target)) return true;
        }
        return false;
    }

    // 최댓값 최솟값 어떻게 구하지...?
    public T max() {
        T max = this.array[0];
        for (T item : this.array) {
            if (item == null) continue;
            if (max == null) max = item;
            else if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }
}
