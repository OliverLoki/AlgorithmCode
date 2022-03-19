package 队列;

//使用数组模拟队列
public class ArrayQueueDemo {

    private int maxsize;//表示最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueueDemo(int arrMaxSize) {
        this.maxsize = arrMaxSize;
        arr = new int[maxsize];
        front = -1;//指向队列头，指向队列头的前一个位置 跟输出有关
        rear = -1;//指向队列尾，指向队列尾的数据（包含队列尾）跟输入有关
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空不能取出");
        }
        front++;
        return arr[front];
    }

    //打印队列
    public void printQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
