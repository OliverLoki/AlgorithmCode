package 队列;

public class 用数组模拟环形队列 {

    private int maxsize;//表示最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器
    public 用数组模拟环形队列(int arrMaxSize) {
        this.maxsize = arrMaxSize;
        arr = new int[maxsize];
        front = 0;//跟输出有关
        rear = 0;//跟输入有关
    }

    //判断队列是否已满 (rear+1) % maxSize == front ==>队列满
    public boolean isFull() {
        return (rear+1) % maxsize == front;
    }

    //判断队列是否为空 rear == front
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        //******
        rear = (rear+1)%maxsize;
    }

    //获取队列数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空不能取出");
        }
        //先保存front中保存的临时变量
        int value = arr[front];
        //相当于数组越界后取整
        front = (front+1)%maxsize;
        return value;
    }

    //求出环形队列有效数据
    public int siza(){
        return (rear +maxsize -front)%maxsize;
    }

    //打印队列
    public void printQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        //从front开始遍历，需要遍历多少个？
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
