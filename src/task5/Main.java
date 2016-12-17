package task5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //test with 1000 iterations
        System.out.println("List with integer");
        System.out.println("add");
        System.out.println(runtimeAdd(new ArrayList<Integer>(), 1000));
        System.out.println(runtimeAdd(new LinkedList<Integer>(), 1000));
        System.out.println("set");
        System.out.println(runtimeSet(new ArrayList<Integer>(), 1000));
        System.out.println(runtimeSet(new LinkedList<Integer>(), 1000));
        System.out.println("get");
        System.out.println(runtimeGet(new ArrayList<Integer>(), 1000));
        System.out.println(runtimeGet(new LinkedList<Integer>(), 1000));
        System.out.println("remove");
        System.out.println(runtimeRemove(new ArrayList<Integer>(), 1000));
        System.out.println(runtimeRemove(new LinkedList<Integer>(), 1000));

        //test with 10000 iterations
        System.out.println("add");
        System.out.println(runtimeAdd(new ArrayList<Integer>(), 10000));
        System.out.println(runtimeAdd(new LinkedList<Integer>(), 10000));
        System.out.println("set");
        System.out.println(runtimeSet(new ArrayList<Integer>(), 10000));
        System.out.println(runtimeSet(new LinkedList<Integer>(), 10000));
        System.out.println("get");
        System.out.println(runtimeGet(new ArrayList<Integer>(), 10000));
        System.out.println(runtimeGet(new LinkedList<Integer>(), 10000));
        System.out.println("remove");
        System.out.println(runtimeRemove(new ArrayList<Integer>(), 10000));
        System.out.println(runtimeRemove(new LinkedList<Integer>(), 10000));

        System.out.println("List with string");
        System.out.println("add");
        System.out.println(runtimeAdd(new ArrayList<String>(), 1000));
        System.out.println(runtimeAdd(new LinkedList<String>(), 1000));
        System.out.println("set");
        System.out.println(runtimeSet(new ArrayList<String>(), 1000));
        System.out.println(runtimeSet(new LinkedList<String>(), 1000));
        System.out.println("get");
        System.out.println(runtimeGet(new ArrayList<String>(), 1000));
        System.out.println(runtimeGet(new LinkedList<String>(), 1000));
        System.out.println("remove");
        System.out.println(runtimeRemove(new ArrayList<String>(), 1000));
        System.out.println(runtimeRemove(new LinkedList<String>(), 1000));

        System.out.println("add");
        System.out.println(runtimeAdd(new ArrayList<String>(), 10000));
        System.out.println(runtimeAdd(new LinkedList<String>(), 10000));
        System.out.println("set");
        System.out.println(runtimeSet(new ArrayList<String>(), 10000));
        System.out.println(runtimeSet(new LinkedList<String>(), 10000));
        System.out.println("get");
        System.out.println(runtimeGet(new ArrayList<String>(), 10000));
        System.out.println(runtimeGet(new LinkedList<String>(), 10000));
        System.out.println("remove");
        System.out.println(runtimeRemove(new ArrayList<String>(), 10000));
        System.out.println(runtimeRemove(new LinkedList<String>(), 10000));



    }

    public static long runtimeAdd(List list, int numberOfIterations) {
        long start = System.nanoTime();
        int i = 0;
        while (i < numberOfIterations) {
            list.add(i);
            i++;
        }
        long end = System.nanoTime();
        return  end - start;
    }

    public static long runtimeSet(List list, int numberOfIterations) {
        listFilling(list, numberOfIterations);
        long start = System.nanoTime();
        int i = 0;
        while (i < numberOfIterations) {
            list.set(i, i);
            i++;
        }
        long end = System.nanoTime();
        return  end - start;
    }
    public static long runtimeGet(List list, int numberOfIterations) {
        listFilling(list, numberOfIterations);
        long start = System.nanoTime();
        int i = 0;
        while (i < numberOfIterations) {
            list.get(i);
            i++;
        }
        long end = System.nanoTime();
        return  end - start;
    }
    public static long runtimeRemove(List list, int numberOfIterations) {
        listFilling(list, numberOfIterations);
        Iterator<Integer> iter = list.iterator();
        long start = System.nanoTime();

        while (iter.hasNext()) {
            if (!iter.next().equals(-1)) {
                iter.remove();
            }
        }
        long end = System.nanoTime();
        return  end - start;
    }
    private static void listFilling(List list, int numberOfIterations) {
        int i = 0;
        while (i < numberOfIterations) {
            list.add(i);
            i++;
        }
    }

}
