package com.techno;

public class Main {

    public static void main(String[] args) {
        MyList<MyList<Integer>> myList = new MyList<MyList<Integer>>();

        for (int i = 0; i < 10; i++)
            myList.add(new MyList<>(12, 14));
        System.out.println(myList.toString());
    }

}
