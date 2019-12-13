package net.thumbtack.school.base;

import java.text.DecimalFormat;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sum = 0;
        for (String string : strings)
            sum += string.length();
        return sum;
    }

    public static String getFirstAndLastLetterString(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.charAt(0));
        return sb.append(string.charAt(string.length() - 1)).toString();
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
       return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) == string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) == string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder sb = new StringBuilder();
        int minLength = string1.length();
        if (minLength > string2.length())
            minLength = string2.length();
        for (int i = 0; i < minLength; i++) {
            if (isSameCharAtPosition(string1, string2, i)) {
                sb.append(string1.charAt(i)).toString();
            } else break;
        }
        return sb.toString();
    }

    public static boolean isPalindrome(String string) {
        if (string.length() != 0) {
            for (int i = 0; i < string.length() / 2; i++) {
                if (string.charAt(i) != string.charAt(string.length() - 1 - i))
                    return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return isPalindrome(string.toLowerCase());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String max = "";
        for (String str : strings)
            if (isPalindromeIgnoreCase(str) && max.length() < str.length())
                max = str;
        return max;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
       if (!(length > string1.length() - index || length > string2.length() - index))
            return string1.substring(index, index + length).equalsIgnoreCase(string2.substring(index, index + length));
       return false;
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equalsIgnoreCase(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equalsIgnoreCase(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') sb.append(string.charAt(i));
        }
        return isPalindromeIgnoreCase(sb.toString());
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1)
                sb.append(',');
        }
        return sb.toString();
    }


    public static String makeCsvStringFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (int i = 0; i < array.length; i++) {
            sb.append(decimalFormat.format(array[i]));
            if (i != array.length - 1)
                sb.append(',');
        }
        return sb.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        return sb.append(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        return sb.append(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sbResult = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            sbResult.deleteCharAt(positions[i]);
            for (int j = 0; j < positions.length; j++) {
                positions[j] = positions[j] - 1;
            }
        }
        return sbResult;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sbResult = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            sbResult.insert(positions[i], characters[i]);
            for (int j = 0; j < positions.length; j++) {
                positions[j] = positions[j] + 1;
            }
        }
        return sbResult;
    }
}
