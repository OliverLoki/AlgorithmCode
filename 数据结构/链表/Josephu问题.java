package 链表;

//使用单向环形链表来实现约瑟夫问题
public class Josephu问题 {

    public static void main(String[] args) {
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(5);//加入五个小孩
        c.showBoy();

        //测试一把小孩出圈是否正确
        c.countBoy(10, 20, 125); // 2->4->1->5->3
    }
}

//创建一个单项环形列表
class CircleSingleLinkedList {
    //创建一个first结点
    private Boy first = null;

    //添加小孩结点，构建环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形列表
        //使用for来创建环形列表
        for (int i = 1; i < nums; i++) {
            //根据编号创建小孩结点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    //遍历打印链表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //使用辅助指针完成遍历
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", cur.getNo());
            if (cur.getNext() == first) {//遍历结束
                break;
            }
            cur = cur.getNext();
        }
    }
    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明 helper 指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时 的移动 m - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
        //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
        //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
        //这时将 first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

//创建一个结点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}