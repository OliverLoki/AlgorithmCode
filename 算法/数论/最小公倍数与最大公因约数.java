package 数论;

public class 最小公倍数与最大公因约数 {
    public static void main(String[] args) {

        int a = 225;
        int b = 15;

        System.out.println("最大公约数："+gcd(a,b));
        System.out.println("最小公倍数："+lcm(a,b));
    }


    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    //性质：gcd(x,y) * lcm(x,y) = x * y;
    static int lcm(int a,int b){
        return  a*b/gcd(a, b);
    }

}
