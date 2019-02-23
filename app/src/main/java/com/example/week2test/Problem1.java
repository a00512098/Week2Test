package com.example.week2test;


import android.support.annotation.NonNull;

// 1. Convert a given string to a linkedList of characters in the String.
// Do not use LinkedList class in Java but create it from scratch.
// Should also add and remove elements from the list.
public class Problem1 {
    public static class TailoredArrayList {
        private String fullString;
        private Node firstNode, lastNode;

        public TailoredArrayList(String string) {
            fullString = string;
            convertStringToArrayList();
        }

        public void printList() {
            Node node = firstNode;
            System.out.println();
            do {
                System.out.print(node.data);
                node = node.next;
            } while (node != null);
        }

        private void convertStringToArrayList() {
            Node aux = null;
            for (int i = 0; i < fullString.length(); i++) {
                Node node = new Node(fullString.charAt(i));
                setNode(node, i);
                if (i == 0) {
                    firstNode = node;
                    node.setPrev(null);
                    node.setNext(null);
                } else {
                    node.setPrev(aux);
                    aux.setNext(node);
                }
                aux = node;
                System.out.println(node.toString());
            }
        }

        private void setNode(Node node, int index) {
            node.setIndex(index);
            lastNode = node;
        }

        public Node getFirstNode() {
            System.out.println(firstNode.toString());
            return firstNode;
        }

        public Node getLastNode() {
            System.out.println(lastNode.toString());
            return lastNode;
        }

        private Node getNodeAtIndex(Node node, int index) {
            if (node.getIndex() == index) {
                return node;
            }

            return getNodeAtIndex(node.next, index);
        }

        public char getIndex(int index) {
            return getNodeAtIndex(firstNode, index).data;
        }

        public void add(char val) {
            Node node = new Node(val);
            lastNode.next = node;
            node.prev = lastNode;
            setNode(node, lastNode.index + 1);
        }

         public void add(char val, int index) {
            if (index > lastNode.index || index < firstNode.index)
                return;

            Node node = new Node(val);
            Node oldNode = getNodeAtIndex(firstNode, index);
            node.next = oldNode;
            node.prev = oldNode.prev;

            if (node.prev != null)
                node.prev.next = node;

            oldNode.prev = node;
            node.setIndex(index);
            incrementIndexesAfter(node);
            if (node.next == null) {
                lastNode = node;
            }
         }

         public void remove(int index) {
             if (index > lastNode.index || index < firstNode.index)
                 return;

             Node removed = getNodeAtIndex(firstNode, index);

             if (removed.prev == null) {
                 firstNode = removed.next;
                 removed.next.prev = null;
                 return;
             }
             if (removed.next == null) {
                 lastNode = removed.prev;
                 removed.prev.next = null;
                 return;
             }

             removed.prev.next = removed.next;
             removed.next.prev = removed.prev;

             decrementIndexesAfter(removed);
             removed = null;
         }

         private void decrementIndexesAfter(Node index) {
            if (index.next == null)
                return;

            Node node = index.next;
             do {
                 node.setIndex(node.index - 1);
                 node = node.next;
             } while (node != null);
         }

         private void incrementIndexesAfter(Node index) {
            if (index.next == null)
                return;
            Node node = index.next;
            do {
                node.setIndex(node.index + 1);
                node = node.next;
            } while (node != null);
        }

        // Node class
        private class Node {
            char data;
            int index;
            Node next, prev;

            public Node(char data) {
                this.data = data;
            }

            public char getData() {
                return data;
            }

            public void setData(char data) {
                this.data = data;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            @NonNull
            @Override
            public String toString() {
                return "index: " + index + " || data: " + data;
            }
        }
    }
}
