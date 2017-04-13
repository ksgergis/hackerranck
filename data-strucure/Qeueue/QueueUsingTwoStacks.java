//Question id:  https://www.hackerrank.com/challenges/queue-using-two-stacks
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner console = new Scanner(new File("C:\\Users\\ksger\\workspace\\Test\\src\\test.in"));
        int size = console.nextInt();
        MyQueue<Integer> queue = new MyQueue<>(size);
        for(int x=0; x< size; x++){
            int command = console.nextInt();
            switch(command){
                case 1:
                    queue.enqueue(console.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
        }
    }
}

class MyQueue<T> {
	Stack<T> pushStack;
	Stack<T> popStack;
	int size;
	int location;

	public MyQueue(int queueSize) {
		pushStack = new Stack<>(queueSize);
		popStack = new Stack<>(queueSize);
		size = queueSize;
		location = 0;
	}

	public void enqueue(T element) {
		if (location < size) {
			pushStack.push(element);
			location++;
		} else {
			throw new RuntimeException("Queue is full");
		}
	}

	public T peek() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.peek();
	}

	public T dequeue() {
		T element = peek();
		popStack.pop();
		return element;
	}

}

class Stack<T> {
	T[] elements;
	int location;

	public Stack(int stackSize) {
		elements = (T[]) new Object[stackSize];
		location = 0;
	}

	public void push(T element) {
		if (location < elements.length) {
			elements[location++] = element;
		} else {
			throw new RuntimeException("Stack is full");
		}
	}

	public T pop() {
		T element = peek();
		location--;
		return element;
	}

	public T peek() {
		if (location - 1 >= 0) {
			return elements[location - 1];
		} else {
			throw new RuntimeException("Stack is empty");
		}
	}

	public boolean isEmpty() {
		return location == 0 ? true : false;
	}
}