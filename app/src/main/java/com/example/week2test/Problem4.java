package com.example.week2test;

public class Problem4 {
    public static class BinarySearchTree {
        Node root;

        public BinarySearchTree(int value) {
            root = new Node(value);
        }

        public void add(int value){
            root.add(value);
        }

        public void print() {
            root.printPreOrder();
        }

        private class Node {
            Node left, right;
            int data;

            public Node(int data) {
                this.data = data;
            }

            public void add(int value) {
                if (value <= data) {
                    if (left == null) {
                        left = new Node(value);
                    } else {
                        left.add(value);
                    }
                } else {
                    if (value > data) {
                        if (right == null) {
                            right = new Node(value);
                        } else {
                            right.add(value);
                        }
                    }
                }
            }

            public void printPreOrder() {
                if (left != null) {
                    System.out.print(data + ", ");
                    left.printPreOrder();
                } else {
                    System.out.print(data + ", ");
                }
                if (right != null) {
                    right.printPreOrder();
                }
            }
        }
    }
}
