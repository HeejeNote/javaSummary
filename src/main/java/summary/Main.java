package summary;

public class Main {
    public static void main(String[] args) {
        int a= 3;
        Main test = new Main();
        System.out.println("test.hi(a) = " + test.hi(a));
        System.out.println("hello(a) = " + hello(a));
        System.out.println("a = " + a);
    }

    public static int hello(int a){
        a = 7;
        return a;
    }

    public int hi(int a){
        a = 8;
        return a;
    }


}