import hyperskill.DecoderCH;
import hyperskill.EncoderCH;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean verification = true;
        while (verification) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = new Scanner(System.in).nextLine();
            switch (operation) {
                case "encode":
                    System.out.println("Input string:");
                    EncoderCH encoder = new EncoderCH(new Scanner(System.in).nextLine());
                    encoder.message();
                    break;
                case  "decode":
                    System.out.println("Input encoded string:");
                    DecoderCH decoder = new DecoderCH(new Scanner(System.in).nextLine());
                    decoder.message();
                    break;
                case "exit":
                    verification = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("There is no " + "'" + operation + "'" +  " operation\n");
                    break;
            }
        }
    }
}