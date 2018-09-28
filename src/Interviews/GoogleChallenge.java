package Interviews;

public class GoogleChallenge {

    public static int answer(String s){

        for (int i = 1; i <= s.length()/2; i++){
            if (s.charAt(i) == s.charAt(0) &&
                    verifySubString(s.substring(0, i), s.substring(i, s.length()))){
                if (i == 1) return s.length();
                return s.length()/i;
            }
        }
        return 1;
    }

    public static boolean verifySubString(String sub, String s){
        if (s.length() < 1) return true;
        if (s.length() >= sub.length() && s.indexOf(sub) == 0)
            return verifySubString(sub, s.substring(sub.length(), s.length()));
        return false;
    }

    public static void printAllCombinations(String s, String newString){
        if (s.length() < 1) {
            System.out.println(newString);
        }
        for (int i = 0; i < s.length(); i++){
            //choose
            char temp = s.charAt(i);
            //explore
            printAllCombinations(s.substring(1, s.length()), newString+=temp);
            //unchoose
            newString = newString.substring(0, newString.length()-1);
        }
    }
    public static void main(String args[]){
        //System.out.println(answer("abcaabca"));
        printAllCombinations("abcd", "");
    }
}
