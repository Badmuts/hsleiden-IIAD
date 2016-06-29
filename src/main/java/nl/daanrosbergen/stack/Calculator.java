package nl.daanrosbergen.stack;

import java.util.StringTokenizer;

public class Calculator {
    private final String invoerString;
    int resultaat;

    public Calculator(String invoerString) {
        this.invoerString = invoerString;
        evaluate();
    }

    public int getResultaat() {
        return (resultaat);
    }

    private void evaluate() {
        Stack mystack = new ListStack();
        StringTokenizer st = new StringTokenizer(invoerString);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            char eerste = token.charAt(0); // het eerste karakter van elk token
            //we hebben een operand ontvangen
            if ((eerste >= '0') && (eerste <= '9'))
                mystack.push(eerste);  // zie algoritme
                //we hebben een operator ontvangen
            else {
                //twee cijfers voor de operant gebruiken om de som te maken
                int v1 = Integer.parseInt(mystack.pop().toString());  // poppen en omzetten van een String naar int
                int v2 = Integer.parseInt(mystack.pop().toString());// idem
                int result = 0;
                switch (eerste) {
                    case '+':
                        result = v1 + v2;
                        break;
                    case '*':
                        result = v1 * v2;
                        break;
                    case '-':
                        result = v1 - v2;
                        break;
                    case '/':
                        result = v1 / v2;
                        break;
                }
                //resultaat in de stack gooien voor de voortkomende cijfers en operators
                mystack.push(result); // wat doe je met het resultaat? zie algoritme
            }
        }
        resultaat = Integer.parseInt(mystack.pop().toString()); // als alles goed is gegaan resultaat
    }

}
