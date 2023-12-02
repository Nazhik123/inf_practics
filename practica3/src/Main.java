import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("№1");
        System.out.println(repl("apple"));
        System.out.println(repl("even if i did"));
        System.out.println("№2");
        System.out.println(Double("apple"));
        System.out.println(Double("bookkeeper"));
        System.out.println("№3");
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println(doesBlockFit(1,8,1,1,1));
        System.out.println(doesBlockFit(1,2,2,1,1));
        System.out.println("№4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("№5");
        double[] ex1 = new double[]{1, -3, 2};
        double[] ex2 = new double[]{2, 5, 2};
        double[] ex3 = new double[]{1, -6, 9};
        System.out.println(countRoots(ex1));
        System.out.println(countRoots(ex2));
        System.out.println(countRoots(ex3));
        System.out.println("№6");
        String[][] ex4 = new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                                        {"Banana", "Shop2", "Shop3", "Shop4"},
                                        {"Orange", "Shop1", "Shop3", "Shop4"},
                                        {"Pear", "Shop2", "Shop4"}};
        String[][] ex5 = new String[][]{{"Fridge", "Shop2", "Shop3"},
                                        {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                                        {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        System.out.println(salesData(ex4));
        System.out.println(salesData(ex5));
        System.out.println("№7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("№8");
        int[] ex6= new int[]{3, 1, 4, 2, 7, 5};
        int[] ex7= new int[]{1, 2, 3, 4, 5};
        int[] ex8= new int[]{1, 2, -6, 10, 3};
        System.out.println(waveForm(ex6));
        System.out.println(waveForm(ex7));
        System.out.println(waveForm(ex8));
        System.out.println("№9");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("№10");
        int[][] firstMatrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        int[][] secondMatrix = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println((Arrays.deepToString(dataScience(firstMatrix))));
        System.out.println(Arrays.deepToString(dataScience(secondMatrix)));
    }

    public static String repl(String s){
        String[] gl= new String[]{"a","e","i","o","u","y"};
        for (int i=0; i<gl.length;i++){
            s=s.replace(gl[i],"*");
        }
        return s;
    }

    public static String Double(String s){
        String[] chars = new String[s.length()];
        String result ="";
        for (int i = 0; i < s.length(); i++) {
            chars[i] = String.valueOf(s.charAt(i));
        }
        for (int i=0; i<chars.length-1; i++){
            if (Objects.equals(chars[i], chars[i + 1])){
                chars[i]="Double";
                chars[i+1]=chars[i+1].toUpperCase();
            }
        }
        for (int i=0; i<chars.length; i++){
            result=result+chars[i];
        }
        return result;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        boolean result = false;
        if ((a<=w) && ((b<=h)||(c<=h))){
            result = true;
        } else if ((b<=w) && ((a<=h)||(c<=h))){
            result=true;
        } else if ((c<=w) && ((a<=h)||(b<=h))) {
            result = true;
        }
        return result;
    }

    public static boolean numCheck(int a){
        String ch1="nchet";
        String ch2="nchet";
        int sum=0;
        boolean result=false;
        if (a%2==0){
            ch1="chet";
        }

        while(a != 0){
            sum += (a % 10)^2;
            a/=10;
        }
        if (sum%2==0){
            ch2="chet";
        }
        if (ch1==ch2){
            result=true;
        }
        return result;
    }

    public static int countRoots(double[] k){
        int s=0;
        double D=k[1]*k[1]-4*k[0]*k[2];
        if (D<0){
            s=0;
        } else if (D>0) {
            double x1 = (-k[1] + Math.sqrt(D))/(2*k[0]);
            double x2 = (-k[1] - Math.sqrt(D))/(2*k[0]);
            if (x1 == (int) x1) {
                s += 1;
            }
            if (x2 == (int) x2) {
                s += 1;
            }
        } else {
            double x = -k[1]/(2*k[0]);
            if (x == (int) x) {
                s += 1;
            }
        }
        return s;
    }
    public static ArrayList<String> salesData(String[][] s){
        int max=0;
        for (int i=0; i< s.length; i++){
            if (s[i].length>max){
                max=s[i].length;
            }
        }
        ArrayList<String> r = new ArrayList<String>();
        for (int i=0; i<s.length; i++){
            if (s[i].length==max){
                r.add(s[i][0]);
            }
        }

        return r;
    }

    public static boolean validSplit(String s){
        boolean result = false;
        int k=0;
        String[] arr = s.split(" ");
        for (int i=0; i<arr.length-1; i++){
                if (arr[i + 1].substring(0, 1).equals(arr[i].substring(arr[i].length() - 1))){
                    k+=1;
                }
        }
        if (k==arr.length-1){
            result=true;
        }
        return result;
    }
    public static boolean waveForm(int[] s){
        int chet=0;
        int p;
        boolean result=false;
        int k=0;
        if (s.length%2==0){
            chet=1;
        }
        if (chet==0){
            for (int i=0; i<s.length-2; i+=2){
                if (s[0]>s[1]){
                    if (s[i]>s[i+1]&& s[i+1]<s[i+2]) {
                        k+=1;
                    }
                } else if (s[0]<s[1]){
                    if (s[i]<s[i+1]&& s[i+1]>s[i+2]) {
                        k+=1;
                    }
                } else  {break;}
            }

            if (k==(s.length-1)/2){
                result=true;
            }
        } else {
            for (int i=0; i<s.length-3; i+=2){
                if (s[0]>s[1]){
                    if (s[i]>s[i+1]&& s[i+1]<s[i+2]) {
                        k+=1;
                    }
                } else if (s[0]<s[1]){
                    if (s[i]<s[i+1]&& s[i+1]>s[i+2]) {
                        k+=1;
                    }
                } else  {break;}
            }
            if (s[0]>s[1]){
                if (s[s.length-2]>s[s.length-1]){
                    k+=1;
                }
            } else {
                if (s[s.length-2]<s[s.length-1]){
                    k+=1;
                }
            }
            if (k==s.length/2){
                result=true;
            }
        }

        return result;
    }

    public static String commonVovel(String s){
        s=s.toLowerCase();
        Map<String , Integer> gl = new HashMap<>();
        int a=0;
        int e=0;
        int i=0;
        int o=0;
        int u=0;
        int y=0;
        for (int q=0; q<s.length(); q++){
            if (s.charAt(q)=='a'){
                a+=1;
            } else if (s.charAt(q)=='e'){
                e+=1;
            } else if (s.charAt(q)=='i'){
                i+=1;
            } else if (s.charAt(q)=='o'){
                o+=1;
            } else if (s.charAt(q)=='u'){
                u+=1;
            } else if (s.charAt(q)=='y'){
                y+=1;
            }
        }
        gl.put("a",a);
        gl.put("e",e);
        gl.put("i",i);
        gl.put("o",o);
        gl.put("u",u);
        gl.put("y",y);
        int max = Collections.max(gl.values());
        String z="";
        for (Map.Entry<String, Integer> entry : gl.entrySet()){
            if (entry.getValue()==max){
                z=z+entry.getKey()+" ";
            }
        }

        return z;
    }

    public static int[][] dataScience(int[][] matrix){
        int n = matrix[0].length;
        for (int mainRow = 0; mainRow < n; mainRow++){
            int newElement = 0;
            for (int sideRow = 0; sideRow < n; sideRow++) if (sideRow != mainRow) newElement += matrix[sideRow][mainRow];
            matrix[mainRow][mainRow] = (int) Math.round((double) newElement / (n - 1));
        }
        return matrix;
    }
}
