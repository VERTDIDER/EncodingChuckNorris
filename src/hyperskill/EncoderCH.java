package hyperskill;

public class EncoderCH {

    private String phrase;

    public EncoderCH(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    private String getBinary(String phrase) {
        StringBuilder binaryPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            String old_s = Integer.toBinaryString(phrase.charAt(i));
            int binary = Integer.parseInt(old_s);
            String s = String.format("%07d", binary);
            binaryPhrase.append(s);
        }
        return binaryPhrase.toString();
    }

    private String getEncode(String binaryPhrase) {
        // System.out.println(binaryPhrase);
        StringBuilder encoding = new StringBuilder();
        for (int i = 0; i < binaryPhrase.length(); i++) {
            int sameDigits = 1;
            for (int j = i + 1; j < binaryPhrase.length(); j++) {
                if (binaryPhrase.charAt(j) == binaryPhrase.charAt(i)) {
                    sameDigits++;
                    i++;
                } else {
                    break;
                }
            }
            switch (binaryPhrase.charAt(i)) {
                case '0' -> encoding.append("00 ");//System.out.print("00 ");
                case '1' -> encoding.append("0 ");
                default -> System.out.print("error");
            }
            for (int t = 0; t < sameDigits; t++) {
                encoding.append("0");;
            }
            encoding.append(" ");
            //System.out.print(" | ");
            //System.out.printf("\n%s = %07d", phrase.charAt(i), binary);
        }
        return encoding.toString();
    }

    public void message() {
        System.out.print("Encoded string:\n"+ getEncode(getBinary(phrase)) + "\n\n");
    }

}
