package Tasks.Task5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Pattern;

public class T5 {
    public static void main(String[] args) {

        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
    }

    //Задание 1
    public static String Encrypt(String s) {
        int[] res = new int[s.length()];
        int cc = res[0] = (int) s.charAt(0);
        int i = 1;
        s = s.substring(1);
        for (char c : s.toCharArray()) {
            res[i] = (int) c - cc;
            i++;
            cc = (int) c;
        }
        return Arrays.toString(res);
    }
    public static String Decrypt(int[] a) {
        String res = "";
        int o = 0;
        for (int i : a) {
            if (i == a[0]) {
                res += (char) i;
                o = i;
            } else {
                res += (char) (i + o);
                o = i + o;
            }
        }

        return res;
    }

    //Задание 2
    public static boolean CanMove(String s, String start, String end) {
        int posstarta = start.charAt(0);
        int posstart1 = start.charAt(1);
        int posenda = end.charAt(0);
        int posend1 = end.charAt(1);
        switch (s) {
            case "Pawn": {
                if (posstarta == (int) 'A') {
                    return posenda - posstart1 <= 2;
                } else {
                    return posenda - posstart1 == 1;
                }
            }
            case "Rook": {
                System.out.println(1);
                return posend1 == posstart1 | posenda == posstarta;
            }
            case "Knight": {
                return (Math.abs(posstarta - posenda) == 2 & Math.abs(posstart1 - posend1) == 1) |
                        (Math.abs(posstarta - posenda) == 1 & Math.abs(posstart1 - posend1) == 2);
            }
            case "Bishop": {
                return Math.abs(posstarta - posenda) == Math.abs(posstart1 - posend1);
            }
            case "Queen": {
                System.out.println(4);
                return posend1 == posstart1 | posenda == posstarta |
                        Math.abs(posstarta - posenda) == Math.abs(posstart1 - posend1);
            }
            case "King": {
                return Math.abs(posstarta - posenda) <= 1 & Math.abs(posstart1 - posend1) <= 1;
            }
        }
        return false;
    }

    //Задание 3
    public static boolean CanComplete(String s, String word) {
        char[] w = s.toCharArray();
        int i = 0;
        for (char c : word.toCharArray()) {
            if (w[i] == c) {
                i++;
            }
        }
        return i == w.length;
    }

    //Задание 4
    public static int SumDProd(int... mas) {
        int sum = 0;
        for (int s : mas) {
            sum += s;
        }
        return rec(sum);
    }
    private static int rec(int a) {
        int sum = 1;
        if (a / 10 == 0) {
            return a;
        } else {
            do {
                sum *= (a % 10);
                a = a / 10;
            } while (a != 0);
        }
        return rec(sum);
    }

    //Задание 5
    public static StringBuilder SameVowelGroup(String... s) {
        String regex = "";
        String regexG = "aeiuyo";
        StringBuilder res = new StringBuilder();
        res.append(s[0] + " ");
        for (char reg : s[0].toCharArray()) {
            if (Pattern.compile(String.valueOf(reg)).matcher(regexG).find() &
                    !Pattern.compile(String.valueOf(reg)).matcher(regex).find()) {
                regex += reg;
            }
        }
        for (int i = 1; i < s.length; i++) {
            int j = 0;
            for (char c : regex.toCharArray()) {
                if (Pattern.compile(String.valueOf(c)).matcher(s[i]).find()) j++;
            }
            if (j == regex.length()) res.append(s[i] + " ");
        }
        return res;
    }

    //Задание 6
    public static boolean ValidateCard(BigInteger a) {
        long b= a.longValue();
        int digit = (int) b%10;
        b=b/10; int i=0; long num=0;
        int sum=0;
        while (b!=0){
            num= num*10+ b%10;
            b=b/10;
            i++;
        }
        while (num!=0){
            if(i--%2==1){
                if(num%10*2>=10){
                    sum+=num%10*2%10+num%10*2/10;
                } else {
                    sum+=num%10*2;
                }
            } else {
                sum+=num%10;
            }
            num=num/10;
        }
        return digit==10-sum%10;
    }

    //Задание 7
    public static String NumToEng(int a) {
        String res =

                "";
        if (a == 0) {
            res = "zero";
        } else {
            if (a / 100 > 0) {
                switch (a / 100) {
                    case (1):
                        res += "One";
                        break;
                    case (2):
                        res += "Two";
                        break;
                    case (3):
                        res += "Three";
                        break;
                    case (4):
                        res += "Four";
                        break;
                    case (5):
                        res += "Five";
                        break;
                    case (6):
                        res += "Six";
                        break;
                    case (7):
                        res += "Seven";
                        break;
                    case (8):
                        res += "Eight";
                        break;
                    case (9):
                        res += "Nine";
                        break;
                }
                res += " Hundred ";
            }
            if (a / 10 % 10 == 1) {
                switch (a % 100) {
                    case (11):
                        res += "Eleven";
                        break;
                    case (12):
                        res += "Twelve";
                        break;
                    case (13):
                        res += "Thirteen";
                        break;
                    case (14):
                        res += "Fourteen";
                        break;
                    case (15):
                        res += "Fifteen";
                        break;
                    case (16):
                        res += "Sixteen";
                        break;
                    case (17):
                        res += "Seventeen";
                        break;
                    case (18):
                        res += "Eighteen";
                        break;
                    case (19):
                        res += "Nineteen";
                        break;
                }
            } else {
                switch (a / 10 % 10) {
                    case (1):
                        res += "Ten ";
                        break;
                    case (2):
                        res += "Twenty ";
                        break;
                    case (3):
                        res += "Thirty ";
                        break;
                    case (4):
                        res += "Forty ";
                        break;
                    case (5):
                        res += "Fifty ";
                        break;
                    case (6):
                        res += "Sixty ";
                        break;
                    case (7):
                        res += "Seventy ";
                        break;
                    case (8):
                        res += "Eighty ";
                        break;
                    case (9):
                        res += "Ninety ";
                        break;
                }
                switch (a % 10) {
                    case (1):
                        res += "One";
                        break;
                    case (2):
                        res += "Two";
                        break;
                    case (3):
                        res += "Three";
                        break;
                    case (4):
                        res += "Four";
                        break;
                    case (5):
                        res += "Five";
                        break;
                    case (6):
                        res += "Six";
                        break;
                    case (7):
                        res += "Seven";
                        break;
                    case (8):
                        res += "Eight";
                        break;
                    case (9):
                        res += "Nine";
                        break;
                }
            }
        }
        return res;
    }

    //Задание 8
    public static String GetSha256Hash(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(s.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //Задание 9
    static String correctTitle(String s) {
        String result = "";
        for (String c : s.split(" ")) {
            if (!c.toLowerCase().equals("in") & !c.toLowerCase().equals("and") & !c.toLowerCase().equals("of") & !c.toLowerCase().equals("the"))
                result += Character.toUpperCase(c.charAt(0)) + c.substring(1).toLowerCase() + " ";
            else
                result+=c.toLowerCase() + " ";
        }
        return result;
    }

    //Задание 10
    public static void HexLattice(int res) {
        boolean state = false;
        int i = 1;
        int k = 1;
        while (i < res) {
            i += (6 * k++);
        }
        int arri=k*2-1;
        String ress[] = new String[arri];
        String strres = "";
        int kk = k;
        if (res == i) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <=k - j; m++) strres += " ";
                String strr = strres;
                for (int m = 1; m <= kk; m++) strres += " o";
                strres += strr + " ";
                kk++;
                ress[j-1]=strres;
                ress[arri-j]=strres;
                strres = "";
            }
            for (String s:ress){
                System.out.println(s);
            }
        } else {
            System.out.print("Неправильное значение. Ближайшее корректное число равно = " + i);
        }
    }
}
