// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("№1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("№2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("№3");
        int[] array1 = {44, 32, 86, 19};
        int[] array2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(array1));
        System.out.println(differenceEvenOdd(array2));
        System.out.println("№4");
        int[] array3 = {1, 2, 3, 4, 5};
        int[] array4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(array3));
        System.out.println(equalToAvg(array4));
        System.out.println("№5");
        int[] array5 = {1, 2, 3};
        int[] array6 = {3, 3, -2, 408, 3, 31};
        System.out.println((Arrays.toString(indexMult(array5))));
        System.out.println((Arrays.toString(indexMult(array6))));
        System.out.println("№6");
        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox"));
        System.out.println("№7");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("№8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("№9");
        System.out.println(botHelper("help"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("№10");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String x){
            String[] word = x.split("");
            boolean result = false;
            for (int i=0; i < word.length; i++){
                if (result) break;
                for (int j=i+1; j < word.length; j++){
                    if (word[i]. equalsIgnoreCase(word[j])){
                        result = true;
                        break;
                    }
                }
            }
            return result;
    }

    public static String getInitials(String x){
        String[] words = x.split("");
        String y = "";
        for (int i=0; i<words.length; i++){
            if ((!words[i].equals("\s")) && (words[i].equals(words[i].toUpperCase()))){
                y = y + words[i];
            }
        }
        return y;
    }

    public static int differenceEvenOdd(int[] array){
        int chet = 0;
        int nchet = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2 == 0){
                chet = chet + array[i];
            } else {nchet = nchet + array[i];}
        }
         return  Math.abs(chet-nchet);
    }

    public static boolean equalToAvg(int[] array){
        double n =0;
        boolean result = false;
        for (int i=0;i<array.length; i++){
            n=n+array[i];
        }
        n=n/array.length;
        for (int i=0; i<array.length; i++){
            if (array[i]==n){
                result = true;
                break;
            }
        }
        return result;
    }

    public static int[] indexMult(int[] array){
        int[] arrayn = new int[array.length];
        for (int i=0; i<array.length; i++){
            arrayn[i]=array[i]*i;
        }
        return arrayn;
    }

    public static String reverse(String x){
        String[] words = x.split("");
        String y = "";
        for (int i = words.length-1; i>-1; i--){
            y=y+words[i];
        }
        return y;
    }

    public static int Tribonacci(int x){
        if (x==0 || x==1){
            return 0;
        }
        else if (x==2){
            return 1;
        }
        int x1=0;
        int x2=0;
        int x3=1;
        int x4=0;
        for (int i=4;i<=x;i++){
            x4=x1+x2+x3;
            x1=x2;
            x2=x3;
            x3=x4;
        }
        return x4;
    }

    public static String pseudoHash(int length){
        String a = "abcdefghijklmnopqrstuvwxyz0123456789";

        String result = "";
        for (int i = 0; i < length; i++){
            result = result + a.charAt((int) (Math.random() * a.length()));
        }
        return result;
    }

    public static String botHelper(String string){
        String x="Calling for a staff member";
        if (string.indexOf("help")==-1){
            x="Keep waiting";
        }
        String a = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = new char[a.length()];
        a.getChars(0, a.length(), chars, 0);
        for (int i=0; i<a.length(); i++){
            String n = "help"+chars[i];
            if (string.contains(n)){
                x="Keep waiting";
            }
        }
        return x;

    }

    public static String botHelper1(String s){
        String x="Keep waiting";
        String[] chars = new String[]{" ",".",",","!","?"};
        int length = chars.length;
        for (int i=0; i<=length-1; i++){
            String n= "help" + chars[i];
            if (s.contains(n)){
                x= "Calling for a staff member";
            }
        }
        return x;

    }

    public static boolean isAnagram(String firstString, String secondString){

        int firstLengthOfString = firstString.length();
        int secondLengthOfString = secondString.length();

        if (firstLengthOfString != secondLengthOfString)
            return false;

        char[] firstArrayOfChars = new char[firstLengthOfString];
        firstString.getChars(0, firstLengthOfString, firstArrayOfChars, 0);
        Arrays.sort(firstArrayOfChars);


        char[] secondArrayOfChars = new char[secondLengthOfString];
        secondString.getChars(0, secondLengthOfString, secondArrayOfChars, 0);
        Arrays.sort(secondArrayOfChars);

        boolean result = true;
        for (int i = 0; i < firstLengthOfString; i++){
            if (firstArrayOfChars[i] != secondArrayOfChars[i]) {
                result = false;
                break;
            }

        }
        return result;

    }
}
