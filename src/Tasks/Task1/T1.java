package Tasks.Task1;

public class T1 {
    public static void main(String[] args){

        System.out.println(abcmath(5,2,1));
    }

    //Задание 1
    public static int remainder(int a, int b) {

        return (a % b);
    }

    //Задание 2
    public static int triArea(int a, int b) {
        return (a * b / 2);
    }

    //Задание 3
    public static int animals(int chickens, int cows, int pigs) {
        return (chickens * 2 + cows * 4 + pigs * 4);
    }

    //Задание 4
    public static boolean profitableGamble(double prob, double prize, double pay) {
        return (prob * prize > pay);
    }

    //Задание 5
    public static String operation(int s, int b, int a) {
        String res = "none";
        if ((a - b == s) | (b - a == s)) res = "substacted";
        if ((a + b == s)) res = "added";
        if ((a / b == s) | (b / a == s)) res = "division";
        if ((a * b == s)) res = "multiplication";
        return res;
    }

    //Задание 6
    public static int Sta(String s) {

        return ((int) s.charAt(0));
    }

    //Задание 7
    public static int AddUpTo (int a) {
        int s=0;
        for (int i = 0; i<=a; i++) s+=i;
        return (s);
    }

    //Задание 8
    public static int NextEdge(int a, int b) {
        return (a+b-1);
    }

    //Задание 9
    public static int SumOfCubes(int ... a) {
        int s=0;
        for (int i:a){
            s+=Math.pow(i,3);
        }
        return (s);
    }

    //Задание 10
    public static boolean abcmath(int a, int b, int c) {
        int s=a;
        for (int i=0; i<b;i++){
            s+=s;
        }
        return (s%c==0);
    }
}
