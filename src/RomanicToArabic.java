import java.util.Scanner;

public class RomanicToArabic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("""
                ( I=1.  V=5.  X=10. L=50.)
                ( C=100. D=500.  M=1000. )
                                
                Type romanic num:\s""");
        String s = scan.nextLine().toUpperCase();
        Code c = new Code();
        System.out.println(c.romanToInt(s));
    }
}

class Code {
    public int romanToInt(String s) {
        char[] arr;
        int res = 0;
        int[] arr2 = new int[s.length()];
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c == 'I') {
                res = 1;
            } else if (c == 'V') {
                res = 5;
            } else if (c == 'X') {
                res = 10;
            } else if (c == 'L') {
                res = 50;
            } else if (c == 'C') {
                res = 100;
            } else if (c == 'D') {
                res = 500;
            } else if (c == 'M') {
                res = 1000;
            }
        } else {
            arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'I') {
                    arr2[i] = 1;
                } else if (arr[i] == 'V') {
                    arr2[i] = 5;
                } else if (arr[i] == 'X') {
                    arr2[i] = 10;
                } else if (arr[i] == 'L') {
                    arr2[i] = 50;
                } else if (arr[i] == 'C') {
                    arr2[i] = 100;
                } else if (arr[i] == 'D') {
                    arr2[i] = 500;
                } else if (arr[i] == 'M') {
                    arr2[i] = 1000;
                }
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr2[i - 1] < arr2[i]) {
                    res += arr2[i] - arr2[i - 1];
                    i++;
                } else {
                    res += arr2[i - 1];
                }
            }
            if (arr2[arr2.length - 1] < arr2[arr.length - 2] || arr2[arr2.length - 1] == arr2[arr.length - 2]) {
                res += arr2[arr2.length - 1];
            }
        }
        return res;
    }
}
