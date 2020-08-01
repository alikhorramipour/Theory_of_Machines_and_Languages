/*
 * DFA
 * Ali Khorramipour - 9631407
 */

import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DFA dfa = new DFA();
        dfa.checkChar(scanner.nextLine());
    }
}

/*
 * Output - testcase 1:
 *      q0:01:q1
 * 		q0:011:invalid
 * 		q0:111:q1
 *		q0:1101:q1
 *		q0:0101:q1
 *
 * Output - testcase 2:
 *      q1:10:q2
 *		q1:111:q2
 * 		
 * Output - testcase 3:
 *      q0:011:q2
 *		q0:111:invalid
 */