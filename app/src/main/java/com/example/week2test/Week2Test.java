package com.example.week2test;

public class Week2Test {
    public static void main(String[] args) {
        int[] values = {50,32,13,65,34,22,3,76,90};

        // Problem 1
        // 1. Convert a given string to a linkedList of characters in the String.
        // Do not use LinkedList class in Java but create it from scratch.
        // Should also add and remove elements from the list.
        System.out.println("\n---------- Problem 1 -----------");
        String problem1 = "This is a long string";
        Problem1.TailoredArrayList list = new Problem1.TailoredArrayList(problem1);
        list.printList();
        list.add('G');
        list.printList();
        list.add('D', 10);
        list.printList();
        list.remove(10);
        list.remove(21);
        list.remove(0);
        list.printList();


        // 2. Implement a Queue using Stack. Queue should have enqueue and dequeue methods
        System.out.println("\n---------- Problem 2 -----------");
        Problem2.Queue queue = new Problem2.Queue();
        for (int val : values) {
            queue.enqueue(val);
        }
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(56);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(40);
        queue.printQueue();

        // 3. Create a custom arraylist using generics.
        // The size of the array would be doubled when array limit is reached.
        System.out.println("\n--------------- Problem 3 ---------------------");
        Problem3.ArrayList<Integer> arrayList = new Problem3.ArrayList<>();
        for (int value : values) {
            arrayList.add(value);
        }
        arrayList.printList();
        arrayList.remove(2);
        arrayList.printList();
        arrayList.add(54);
        arrayList.printList();
        arrayList.get(50);// index out of bounds
        System.out.println(arrayList.get(4));
        arrayList.set(4, 109);
        arrayList.printList();
        System.out.println("\nTotal items: " + arrayList.size());
        arrayList.clear();
        arrayList.printList();

        // 4. Create and Binary Search tree with Add
        // and print(preorder) method.
        Problem4.BinarySearchTree tree = new Problem4.BinarySearchTree(values[0]);
        for (int i = 1; i < values.length; i++) {
            tree.add(values[i]);

        }
        System.out.println("---------------- Problem 4 --------------");
        tree.print();
    }
}
