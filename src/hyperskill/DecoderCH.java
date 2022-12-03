package hyperskill;

public class DecoderCH {

    private String phrase;
    private static String errorMessage = "Encoded string is not valid.\n\n";
//    private static boolean verification = true;

    public DecoderCH(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    private static boolean verification(String phrase) {
        String[] values = phrase.split(" ");
        boolean verification = true;
        if (values[0].length() > 2 || values.length % 2 != 0 || getBinary(phrase).toCharArray().length % 7 != 0) {
            verification = false;
        } else {
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length(); j++) {
                    if (values[i].charAt(j) != '0') {
                        verification = false;
                        break;
                    }
                }
            }
        }
        return verification;
    }
    private static String getBinary(String phrase) {
        String[] values = phrase.split(" ");
        StringBuilder binary = new StringBuilder();
        // 0 0 00 0000 0 000 00 0000 0 00
        for (int i = 0; i < values.length; i += 2) {
            for (int j = 0; j < values[i+1].toCharArray().length; j++) {
                if (values[i].equals("0")) {
                    binary.append("1");
                } else if (values[i].equals("00")) {
                    binary.append("0");
                }
            }
            if (i >= values.length - 2) {
                break;
            }
        }
        return binary.toString();
    }

    private static String getDecode(String binary) {
        int length = binary.toCharArray().length;
        char[] charCode = new char[length / 7];
        for (int i = 0; i < length / 7; i++) {
            String s = binary.substring(i * 7, i * 7 + 7);
            charCode[i] = (char) Integer.parseInt(s, 2);
            //System.out.println("\n" + charCode[i]);
        }
        return String.valueOf(charCode);
    }

    public void message() {
        if (verification(phrase)) {
            System.out.print("Decoded string:\n"+ getDecode(getBinary(phrase)) + "\n\n");
        } else {
            System.out.print(errorMessage);
        }
    }
}
