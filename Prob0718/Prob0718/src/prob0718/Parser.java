package prob0718;

/**
 * The direct code implementation of a finite state machine to parse a hexadecimal
 * number.
 *
 * <p>
 * File: <code>Parser.java</code>
 *
 * @author
 */
public class Parser {
    private boolean valid = false;
    private int number = 0;

    public boolean getValid() {
        return valid;
    }

    public int getNumber() {
        return number;
    }

    private boolean isHexDigit(char ch) {

        return ('0' <= ch) && (ch <= '9') || ('a' <= ch) && (ch <= 'f') || ('A' <= ch) && (ch <= 'F');
        // Why would we want to check for a space in the above?
//        if ('0' <= ch) && (ch <= '9') {
//            return True;
//        } else if ('a' <= ch) && (ch <= 'f') {
//            return True;
//        } else if ('A' <= ch) && (ch <= 'F') {
//            return True;
//        } else {
//            return False;
//        }

    }
    public int HexToDec(char hex) {
        if (('0' <= hex) && (hex <= '9')) {
            return hex - '0';
        } else if (('a' <= hex) && (hex <= 'f')) {
            return hex - 'a' + 10;
        } else {
            return hex -'A' + 10;
        }
    }
    public void parseNum (String line) {
        line = line + '\n';
        int lineIndex = 0;
        char nextChar;
        valid = true;
        State state = State.S_G;
        do {
            nextChar = line.charAt(lineIndex++);
            switch(state) {
                case S_G:
                    if (isHexDigit(nextChar)) {
                        number = HexToDec(nextChar);
                        state = State.S_B;
                    } else {
                        valid = false;
                    }
                    break;
                case S_B:
                    if (isHexDigit(nextChar)) {
                        number = 16 * number + HexToDec(nextChar);
                    } else if (nextChar == '\n') {
                        if (number > 65535) {
                            valid = false;
                        } else {
                            state = State.S_STOP;
                        }
                    } else {
                        valid = false;
                    }
                    break;

            }

        } while ((state != State.S_STOP) && valid);



    }
}
