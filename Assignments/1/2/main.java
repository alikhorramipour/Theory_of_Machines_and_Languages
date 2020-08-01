/*
 * NFA
 * Ali Khorramipour - 9631407
 */

import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        NdFA ndfa = new NdFA();
        ndfa.checkChar(scanner.nextLine());
    }
}

/*
 * Output:
 *      q0,010:valid
 * 		q0,011:invalid
 * 		q0,111:invalid
 * 		q0,0:valid
 * 		q0,1:invalid
 */