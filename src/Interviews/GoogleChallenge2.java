package Interviews;
import java.util.ArrayList;
import java.util.Collections;


public class GoogleChallenge2 {

        public static int answer2(int[] l) {
            //initalize vars
            ArrayList<Integer> L1 = new ArrayList<>();
            ArrayList<Integer> L2 = new ArrayList<>();
            ArrayList<Integer> L3 = new ArrayList<>();

            //divide up the numbers into their mod3 categories
            for(int i  = 0; i < l.length; i++){
                switch (l[i]%3){
                    case 0:
                        L3.add(l[i]);
                        break;
                    case 1:
                        L1.add(l[i]);
                        break;
                    case 2:
                        L2.add(l[i]);
                        break;
                }
            }
            //sort the lists
            Collections.sort(L1);
            Collections.sort(L2);

            //take care of case when either list is empty
            if ((L1.isEmpty() && L2.size() > 2)|| (L2.isEmpty() && L1.size() > 2)){
                while (L1.size() > 2){
                    MultiAddToList(L3, L1, 3);
                }
                while (L2.size() > 2){
                    MultiAddToList(L3, L2, 3);
                }
            }
            //take care of case when one list is slightly larger
            while (Math.abs(L1.size()-L2.size()) > 1){
                if (L1.size() > L2.size() && L1.size() >= 3) MultiAddToList(L3, L1, 3);
                else if (L2.size() > L1.size() && L2.size() >= 3) MultiAddToList(L3, L2, 3);
                else break;
            }
            //add all pairs to list
            while (!L1.isEmpty() && !L2.isEmpty()){
                AddToList(L3, L1);
                AddToList(L3, L2);
            }

            if (L3.isEmpty()) return 0;

            //convert list to string
            Collections.sort(L3);
            return ListToInt(L3);
        }
        //convert list to int
        public static int ListToInt(ArrayList<Integer> list){
            if (list.isEmpty()) return 0;
            String temp = "";
            for (int i = list.size()-1; i >= 0; i--){
                temp+=list.get(i);
            }
            return Integer.parseInt(temp);
        }
        //add multiple values from one list to another
        public static void MultiAddToList(ArrayList<Integer> to, ArrayList<Integer> from, int amount){
            if (from.size() < amount) return;
            for (int i = 0; i < amount; i++){
                AddToList(to , from);
            }
        }
        //add single value from one list to another
        public static void AddToList(ArrayList<Integer> to, ArrayList<Integer> from){
            if (from.isEmpty()) return;
            to.add(from.get(from.size()-1));
            from.remove(from.size()-1);
        }

    //answer 2 part 2
    public static int answer3(String s){
        int count = 0, answer = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '>') count++;
            else if (s.charAt(i) == '<') answer+=count*2;
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(answer2(new int[]{2, 2,1, 1,2, 2, 2, 1}));
    }

}
