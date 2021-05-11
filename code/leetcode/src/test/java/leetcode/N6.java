package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class N6 {

    public String convert(String s, int numRows) {
        ArrayList<Character[]> list = new ArrayList<>();

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        int i = 0;
        int n = 0;
        while (i < length) {
            Character[] nums = new Character[numRows];
            if (n == 0) {
                while (n < numRows && i < length) {
                    nums[n] = charArray[i];
                    n++;
                    i++;
                }
                list.add(nums);
                n = numRows - 2;
            } else {
                if (n < 0) {
                    n = 0;
                } else {
                    nums[n] = charArray[i];
                    n--;
                    i++;
                    list.add(nums);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int j = 0; j < list.size(); j++) {
                Character[] characters = list.get(j);
                Character character = characters[k];
                if (character == null) {
                    sb.append(" ");
                } else {
                    sb.append(character);
                }
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }


    @Test
    void t() {
        String s = "PAYPALISHIRING";
//        String convert = convert(s, 3);
        String convert = convert("AB", 1);

        System.out.println(convert);
    }


}

/*

P   A   H   N
A P L S I I G
Y   I   R


 */