/*
 * DFA
 * Ali Khorramipour - 9631407
 */

import java.util.HashMap;

public class DFA {
    public static HashMap<String, HashMap<Character, String>> table = new HashMap();
    public DFA(){
        table.put("q0", new HashMap<>());
        table.put("q1", new HashMap<>());
        table.put("q2", new HashMap<>());

        table.get("q0").put('0', "q0");
        table.get("q0").put('1', "q1");

        table.get("q1").put('0', "q0");
        table.get("q1").put('1', "q2");

        table.get("q2").put('0', "q2");
        table.get("q2").put('1', "q1");
    }
    public static String state = "q0";
    public static String[] finalStates = {"q1"};
    String input;

    public void checkChar(String input) {
        boolean end = true;
        char[] in = input.toCharArray();

        for (int i = 0 ; i < in.length ; i++) {
            if (table.get(state).containsKey(in[i])) {
                if (!table.get(state).get(in[i]).equals("")) {
                    state = table.get(state).get(in[i]);
                } else {
                    System.out.println("invalid");
                    end = false;
                    break;
                }

            } else {
                System.out.println("invalid");
                end = false;
                break;
            }

        }

        if (end) {
            boolean finalStateExists = false;
            for (String finalState : finalStates){
                if (table.equals(finalState)) {
                    System.out.println(state);
                    finalStateExists = true;
                }
            }
            if (!finalStateExists) {
                System.out.println(state);
            }
        }
    }
}