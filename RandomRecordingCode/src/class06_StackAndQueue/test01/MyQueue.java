package class06_StackAndQueue.test01;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;//in
    Stack<Integer> stack2;//out
    int size;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        //把2栈的东西倒回来
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        size++;
    }

    public int pop() {
        //把1栈的东西倒到2栈
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        size--;
        return stack2.pop();
    }

    //队头元素
    public int peek() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek(); //2栈栈顶
    }

    public boolean empty() {
        return size == 0;
    }
}