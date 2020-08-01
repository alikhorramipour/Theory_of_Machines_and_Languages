/*
 * Simplifier Context free grammars
 * Ali Khorramipour - 9631407
 */

import java.io.IOException;

public class main {

    public static void main (String[] args) {
        Parser fileParser = new Parser();
        Grammar parsedGrammar = null;

        try {
            parsedGrammar = fileParser.parseGrammarFromFile("CFG.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if (parsedGrammar != null) {
            System.out.println(parsedGrammar.toString());
            Simplifier simplifier = new Simplifier();
            Grammar simplifiedGrammar = simplifier.simplify(parsedGrammar);
            System.out.println(simplifiedGrammar.toString());
        }
        else {
            System.out.println("The parsed Grammar was null!");
        }
    }
}
/*
Test Case1:
    States: S, A, B, C
    Terminals: a, b
    Start State: S
    Rules:
    S: aA|aBB
    A: aaA|$
    B: bC|bbC
    C: B

Results:
    States: S, A
    Terminals: a
    Start State: S
    Rules:
    S: aA|a
    A: aaA|aa

 */