package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return (x == y);
    }

    public boolean isGreater(int x, int y) {
        return (x > y);
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return ((xLeft <= x && x <= xRight) && (yTop <= y && y <= yBottom));

    }

    public int sum(int[] array) {
        int summ = 0;
        for (int i : array) {
            summ += i;
        }
        return summ;
    }

    public int mul(int[] array) {
        if (array.length != 0) {
            int mull = 1;
            for (int i : array)
                mull *= i;
            return mull;
        } else
            return 0;
    }

    public int min(int[] array) {
        if (array.length != 0) {
            int min = array[0];
            for (int i : array) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        } else
            return Integer.MAX_VALUE;
    }

    public int max(int[] array) {
        if (array.length != 0) {
            int max = array[0];
            for (int i : array) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        } else
            return Integer.MIN_VALUE;
    }

    public double average(int[] array) {
        double aver = 0;
        if (array.length != 0) {
            aver = (double) sum(array) / (double) array.length;
        }
        return aver;
    }

    public boolean isSortedDescendant(int[] array) {
        boolean flag = true;
        if (array.length != 0) {
            for (int i = 0; i < array.length - 1; i++) {
                if (isGreater(array[i], array[i + 1]))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 3);
        }
    }

    public boolean find(int[] array, int value) {
        boolean flag = false;
        if (array.length != 0) {
            for (int i : array) {
                if (i == value) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {

            int item = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = item;
        }
    }

    public boolean isPalindrome(int[] array) {
        boolean flag = true;
        if (array.length != 0) {
            for (int i = 0; i < array.length / 2; i++) {
                if (array[i] != array[array.length - 1 - i]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public int sum(int[][] matrix) {
        int lineSumm = 0;
        if (matrix.length != 0) {
            for (int[] i : matrix) {
                lineSumm += sum(i);
            }
        }
        return lineSumm;
    }

    public int max(int[][] matrix) {
        if (matrix[0].length != 0) {
            int maxItem = matrix[0][0];
            for (int[] i : matrix) {
                for (int k : i) {
                    if (maxItem < k) {
                        maxItem = k;
                    }
                }
            }
            return maxItem;
        } else
            return Integer.MIN_VALUE;
    }

    public int diagonalMax(int[][] matrix) {
        if (matrix[0].length != 0) {
            int maxItem = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (maxItem < matrix[i][i]) {
                    maxItem = matrix[i][i];
                }
            }
            return maxItem;
        } else
            return Integer.MIN_VALUE;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        if (matrix[0].length != 0)
            for (int[] i : matrix) {
                if (!isSortedDescendant(i))
                    return false;
            }
        return true;
    }
}
