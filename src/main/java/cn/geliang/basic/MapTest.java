package cn.geliang.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Classname MapTest
 * @Description TODO
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class MapTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        Iterator<Integer> hashSetIter = hashSet.iterator();
        while (hashSetIter.hasNext()) {
            System.out.print(hashSetIter.next() + " ");
        }
        System.out.println();

        linkedHashSet.add(3);
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        Iterator<Integer> linkedIter = linkedHashSet.iterator();
        while (linkedIter.hasNext()) {
            System.out.print(linkedIter.next() + " ");
        }
        System.out.println();
    }
}
