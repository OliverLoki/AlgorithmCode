package 栈;

/**
 * 使用数组模拟栈
 */
public class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组模拟栈
    private int top = -1; //指向栈顶的元素，初始化为 -1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈操作
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况
    public void print() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        //打印栈从栈顶打印
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[top]);
        }
    }
}