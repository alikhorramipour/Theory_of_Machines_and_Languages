/*
 * NFA
 * Ali Khorramipour - 9631407
 */

import java.util.HashMap;
import java.util.ArrayList;

public class NdFA {
    public static HashMap<String, HashMap<Character, ArrayList<String>>> table = new HashMap();

    public NdFA() {
        table.put("q0", new HashMap<>());
        table.put("q1", new HashMap<>());
        table.put("q2", new HashMap<>());

        table.get("q0").put('0', new ArrayList<>());
        table.get("q0").get('0').add("q1");

        table.get("q1").put('0', new ArrayList<>());
        table.get("q1").get('0').add("q1");
        table.get("q1").get('0').add("q2");

        table.get("q2").put('1', new ArrayList<>());
        table.get("q2").get('1').add("q0");

    }

    public static String state = "q0";
    String startState = "q0";
    public static String finalState = "q1";
    String input;
    public static char[] in;
    public static boolean valid;
    public static int test = 1;

    public static void checkChar(String input){
        String startState = "q0";
        valid = false;
        in = input.toCharArray();

        tracker(startState, 0);

        if (valid) {
            System.out.println("valid");
        }else{
            System.out.println("invalid");
        }
    }

    public static void tracker(String state, int index) {
        if (valid)
            return;
        if (state.equals(finalState) && (index >= in.length - 1)) {
            valid = true;
            return;
        }
        if (index == in.length)
            return;
        if (table.containsKey(state)) {
            if (table.get(state).containsKey(in[index])) {
                if (table.get(state).get(in[index]).size() > 0) {
                    for (int i = 0; i < table.get(state).get(in[index]).size(); i++) {
                        tracker(table.get(state).get(in[index]).get(i), index + 1);
                    }
                }
            }
        }
    }
}