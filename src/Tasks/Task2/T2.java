package Tasks.Task2;

import java.util.Arrays;

public class T2 {
    public static void main(String[] args){

        System.out.println(boxSeq(5));
    }

    //Задание  1
    public static String Repeat(String s, int a){
        String k = null;
        for (int i=0;i<s.length();i++){
            for(int j=0;j<a;j++) k+=s.charAt(i);
        }
        return k;
    }

    //Задание  2
    public static int DifferenceMaxMin(int ... a){
        int max=a[1];
        int min=a[1];
        for (int k:a){
            if (k>max) max=k;
            if (k<min) min=k;
        }
        return (max-min);
    }

    //Задание  3
    public static boolean SsAvgWhole(int ... a){
        int k=0;
        int sum =0;
        for (int b:a){
            sum+=b;
            k++;
        }
        return (sum%k)==0;
    }

    //Задание  4
    public static String CumuSum(int ... a){
        int [] res = new int[a.length];
        int i=0;
        int s=0;
        for (int b:a){
            s+=b;
            res[i++]=s;
        }
        return Arrays.toString(res);
    }

    //Задание  5
    public static String GetDecPlaces(String a){
        int b = a.indexOf(".");
        return b==-1 ? "0" :String.valueOf(a.substring(b+1).length());
    }

    //Задание 6
    public static int Fibonachi(int a){
        int a1=1;
        int a2=1;
        int a3;
        while (a>0){
            a3=a2+a1;
            a1=a2;
            a2=a3;
            a--;
        }
        return a1;
    }

    //Задание  7
    public static boolean SsValid(String a){
        if (a.length()!=5){
            return false;
        }
        for (char c:a.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    //Задание  8
    public static boolean IsStrPair(String a, String b){
        return (a.charAt(0)==b.charAt(b.length()-1))&(a.charAt(a.length()-1)==b.charAt(0));
    }

    //Задание  9
    public static boolean IsPrefix(String a, String b){
        return a.startsWith(b.substring(0,b.length()-1));

    }
    public static boolean isSuffix(String a, String b){
        return a.endsWith(b.substring(1));
    }

    //Задание  10
    public static int boxSeq(int a){
        int sum=0;
        for (int i=0;i<a;i++){
            if (i%2==0){
                sum+=3;
            }
            if (i%2!=0){
                sum-=1;
            }
        }
        return sum;

    }
}