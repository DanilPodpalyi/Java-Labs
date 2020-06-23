package Lab1;

public class Lab1a {

  public static void main(String[] args) {
    System.out.println("Простые числа:");
    /** Цикл, отправляет число в метод IsPrimes и выводит его если оно является простым  */
    for (int i = 2; i < 100; i++) {
      if (IsPrimes(i) == true) {
        System.out.println(i);
      }
    }
  }
  /** метот проверяет число на правильность (если число делится без остатка только на себя) */
  public static boolean IsPrimes(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}