package Interviews;

public class CodeBat {


    private static int countHi(String str){
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("hi")) return 1+countHi(str.substring(2, str.length()));
        return countHi(str.substring(1, str.length()));
    }
    public static void main(String args[]){
        countHi("xxhixx");
    }
}
