package 栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * > 输入一个算式 , 将其转换为后缀表达式，计算其结果
 * > 1、支持小数
 * > 2、支持小括号和多位数整数
 * > 3、使用数据结构 -- 栈
 * <p>
 * 输入样例
 * <p>
 * 9+(3-1)*3+10/2
 * <p>
 * 输出样例
 * <p>
 * 逆波兰表达式为 ：`9 3 1-3 * + 1 0 2 / +`
 * <p>
 * 计算结果为 ：20
 */


public class PolandNotationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //从键盘输入获取中缀表达式
        String expression = sc.nextLine();
        //输出后缀表达式
        List<String> strings = toSuffixExpression(expression);
        //计算机对后缀表达式进行求值
        int calculate = calculate(strings);
        System.out.println("逆波兰表达式为 :" + strings);
        System.out.println("计算结果为" + calculate);
    }


    //中缀表达式转后缀表达式
    public static List<String> toSuffixExpression(String str) {
        //得到中缀表达式
        List<String> list = toListString(str);
        System.out.println("中缀表达式为" + list);
        //后缀表达式
        List<String> suffixString = new ArrayList<>();
        //符号栈
        Stack<String> stack = new Stack<String>();
        /**
         * 从左到右遍历中缀表达式的每个数字和符号，若是数字就输出，即成为后缀表达式的一部分;
         * 若是符号，则判断其与栈顶符号的优先级，
         * 是右括号或优先级低于栈顶符号(乘除优先加减)
         * 则栈顶元素依次出栈并输出，并将当前符号进栈，一直到最终输出后缀表达式为止
         */
        for (String item : list) {
            if (item.matches("\\d+")) {//如果是一个数，进入后缀表达式
                suffixString.add(item);
            } else if (item.equals("(")) {//左括号入栈
                stack.push(item);
            } else if (item.equals(")")) {
                //如果是右括号，则持续出栈操作，知道碰到左括号为止
                while (!stack.peek().equals("(")) {//栈顶元素!=(
                    suffixString.add(stack.pop());
                }
                stack.pop();
            } else {//判断item优先级
                //小于等于栈顶元素优先级，弹栈并存入后缀表达式
                while (stack.size() != 0 && Operation.getValue(stack.peek()) >= Operation.getValue(item)) {
                    suffixString.add(stack.pop());
                }
                //将item压入栈中
                stack.push(item);
            }
        }
        //遍历中缀表达式完成后，将栈中剩余的数据弹出栈加入后缀表达式
        while (stack.size() != 0) {
            suffixString.add(stack.pop());
        }
        return suffixString;
    }

    //判断是不是一个运算符
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //String转为一个List<String>
    public static List<String> toListString(String expression) {
        String[] s = expression.split("");
        //获得了一个数组，但是两位数的还没进去
        ArrayList<String> strings = new ArrayList<>();
        for (String ele : s) {
           strings.add(ele);
        }
        for(String temp:strings){

        }
        return strings;
    }

    //计算后缀表达式
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();

        for (String item : list) {
            if (item.matches("\\d+")) {//如果是一个数字
                stack.push(item);
            } else {
                int res = -1;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);

            }
        }

        return Integer.parseInt(stack.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;

        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("非法运算符");
                break;
        }
        return result;
    }
}
