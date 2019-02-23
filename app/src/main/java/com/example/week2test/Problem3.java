package com.example.week2test;

import java.lang.reflect.Array;

public class Problem3 {
    // 3. Create a custom arraylist using generics.
    // The size of the array would be doubled when array limit is reached.
    public static class ArrayList<T> {
        T[] internalArray;
        T[] auxArray;
        int indexOfLastItem;
        int currentSize;

        public ArrayList() {
            indexOfLastItem = -1;
            currentSize = 4;
            this.internalArray = (T[]) new Object[currentSize];
            this.auxArray = this.internalArray;
        }

        public void add(T item) {
            if (indexOfLastItem + 1 >= internalArray.length) {
                duplicateListSize();
            }
            indexOfLastItem++;
            internalArray[indexOfLastItem] = item;
        }

        public T get(int index) {
            if (!indexExists(index)) {
                return null;
            }

            return internalArray[index];
        }

        public void set(int index, T item) {
            if (!indexExists(index))
                return;
            internalArray[index] = item;
        }

        public void remove(int index) {
            if (!indexExists(index)) {
                return;
            }

            if (index == internalArray.length - 1) {
                internalArray[index] = null;
                indexOfLastItem -= 1;
                return;
            }

            for (int i = index; i < internalArray.length - 1; i++) {
                internalArray[i] = internalArray[i+1];
            }
            indexOfLastItem -= 1;

        }

        public void clear() {
            currentSize = 2;
            indexOfLastItem = -1;
            internalArray = (T[]) new Object[currentSize];
            System.out.println("ArrayList cleared");
        }

        public int size() {
            return indexOfLastItem + 1;
        }

        public void printList() {
            System.out.println("");
            for (int i = 0; i <= indexOfLastItem; i++) {
                System.out.print(internalArray[i] + ",");
            }
        }

        private boolean indexExists(int index) {
            if (index >= internalArray.length || index < 0) {
                System.out.println("\nIndex out of bounds");
                return false;
            }
            return true;
        }

        private void duplicateListSize() {
            System.out.println("Size was " + currentSize);
            auxArray = internalArray;
            currentSize *= 2;
            internalArray = (T[]) new Object[currentSize];
            for (int i = 0; i < auxArray.length; i++) {
                internalArray[i] = auxArray[i];
            }
            System.out.println("Size now is " + currentSize);
        }
    }
}
