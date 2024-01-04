public class BitStuffing {
    public static String bitStuff(String input) {
        int consecutiveOnes = 0;
        String stuffedData = "01111110"; 
        for (char bit : input.toCharArray()) {
            if (bit == '1') {
                consecutiveOnes++;
                if (consecutiveOnes == 5) {
                    stuffedData += "0";
                    consecutiveOnes = 0; 
                }
            } else {
                consecutiveOnes = 0;
            }
            stuffedData += bit;
        }
        stuffedData += "01111110";
        return stuffedData;
    }

    public static String bitUnstuff(String stuffedData) {
        String unstuffedData = "";
        int consecutiveOnes = 0;
        boolean inFlag = false;

        for (char bit : stuffedData.toCharArray()) {
            if (bit == '0') {
                if (consecutiveOnes == 5) {
                    consecutiveOnes = 0;
                } else {
                    consecutiveOnes = 0;
                    unstuffedData += bit;
                }
            } else if (bit == '1') {
                consecutiveOnes++;
                unstuffedData += bit;
                if (bit == '1' && inFlag) {
                    inFlag = false;
                    break;
                }
            } else if (bit == '0' && !inFlag) {
                inFlag = true;
            }
        }

        return unstuffedData;
    }

    public static void main(String[] args) {
        String inputData = "011110111001111110";
        String stuffedData = bitStuff(inputData);
        String unstuffedData = bitUnstuff(stuffedData);

        System.out.println("Input Data: " + inputData);
        System.out.println("Stuffed Data: " + stuffedData);
        System.out.println("Unstuffed Data: " + unstuffedData);
    }
}
