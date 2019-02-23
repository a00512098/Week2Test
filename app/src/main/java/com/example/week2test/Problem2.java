package com.example.week2test;

import java.util.Stack;

public class Problem2 {
    public static class Queue<T> {
        Stack<T> mainStack, auxStack;
        boolean lastOperationWasDequeued;

        public Queue() {
            mainStack = new Stack();
            auxStack = new Stack();
            lastOperationWasDequeued = false;
        }

        public void enqueue(T item) {
            if (lastOperationWasDequeued) {
                lastOperationWasDequeued = false;
                swapQueuesValues(auxStack, mainStack);
            }
            mainStack.push(item);
        }

        public T dequeue() {
            if (lastOperationWasDequeued) {
                if (auxStack.isEmpty()) {
                    System.out.println("The queue is empty");
                    return null;
                } else {
                    return auxStack.pop();
                }
            } else {
                lastOperationWasDequeued = true;
                swapQueuesValues(mainStack, auxStack);
                return auxStack.pop();
            }
        }

        public boolean isEmpty() {
            if (lastOperationWasDequeued)
                return auxStack.isEmpty();
            return mainStack.isEmpty();
        }

        private void swapQueuesValues(Stack full, Stack empty) {
            while (!full.isEmpty()) {
                empty.push(full.pop());
            }
        }

        public void printQueue() {
            Stack<T> stack = new Stack();
            if (auxStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    System.out.print(mainStack.peek() + ", ");
                    stack.push(mainStack.pop());
                }
                swapQueuesValues(stack, mainStack);
            } else {
                swapQueuesValues(auxStack, stack);
                while (!stack.isEmpty()) {
                    System.out.print(stack.peek() + ", ");
                    auxStack.push(stack.pop());
                }
                swapQueuesValues(stack, auxStack);
            }
            System.out.println("");
        }
    }
}
