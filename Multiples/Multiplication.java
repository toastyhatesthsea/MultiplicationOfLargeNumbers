package Multiples;

import java.util.Arrays;

public class Multiplication
{

    public int[] num1;
    public int[] num2;

    public Multiplication(int[] num1, int[] num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int[] multiply(int[] num1, int[]num2)
    {
        if (num1.length == 1)
        {
            Integer rawrs;
            int[] answer;

            int product = num1[0] * num2[0];
            if (product > 2)
            {
                answer = new int[2];
                answer[0] = product / 10;
                answer[1] = product % 10;
            }
            else
            {
                answer = new int[1];
                answer[0] = product;
            }
            return answer;
        }
        else
        {
            int halfLength = num1.length / 2;
            int fullLength = num1.length;

            int[] num1FirstHalf = Arrays.copyOf(num1, halfLength);
            int[] num1SecondHalf = Arrays.copyOfRange(num1, halfLength, num1.length);
            int[] num2FirstHalf = Arrays.copyOf(num2, halfLength);
            int[] num2SecondHalf = Arrays.copyOfRange(num2, halfLength, num2.length);

            int[] ac = multiply(num1FirstHalf, num2FirstHalf);
            int[] ad = multiply(num1FirstHalf, num2SecondHalf);
            int[] bc = multiply(num1SecondHalf, num2FirstHalf);
            int[] bd = multiply(num1SecondHalf, num2SecondHalf);

            return recIntMult(ac, ad, bc, bd, fullLength);
        }
    }

    public int[] recIntMult(int[] ac, int[] ad, int[] bc, int[] bd, int length)
    {
        int[] tenToPowerOfLength = Arrays.copyOf(ac, ac.length + length);
        int[] additionOfADandBC = arrayAddition(ad, bc);
        additionOfADandBC = Arrays.copyOf(additionOfADandBC, additionOfADandBC.length + length / 2);

        int[] sum = arrayAddition(tenToPowerOfLength, additionOfADandBC);
        sum = arrayAddition(sum, bd);

        return sum;

    }

    public int[] arrayAddition(int[] num1, int[] num2)
    {
        if (num1.length > num2.length)
        {
            num2 = arrayCopyWithLeadingZeroes(num2, num1.length - num2.length);
        } else if (num2.length > num1.length)
        {
            num1 = arrayCopyWithLeadingZeroes(num1, num2.length - num1.length);
        }

        int[] answer = new int[num1.length];
        for (int i = num1.length - 1; i >= 0; i--)
        {
            int sum = num1[i] + num2[i];
            answer[i] = sum % 10 + answer[i];

            if (sum >= 10)
            {
                //Adding Function is at last digit and needs more space
                if (i == 0)
                {
                    answer = this.arrayCopyWithLeadingZeroes(answer, 1);
                    answer[0] = sum / 10;
                }
                else
                {
                    answer[i - 1] = sum / 10 + answer[i - 1];
                }
            }
        }
        return answer;
    }

    public int[] arrayCopyWithLeadingZeroes(int[] num1, int zeroes)
    {
        int[] answer = new int[num1.length + zeroes];
        //answer[0] = 0;

        for (int i = zeroes; i < answer.length; i++)
        {
            answer[i] = num1[i-zeroes];
        }
        return answer;
    }


}

class MultipleTesters
{

    public static void main(String[] afgsgs)
    {
        System.out.println(Long.MAX_VALUE);


        int[] num1 = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2};
        int[] num2 = {2,7,1,8,2,8,1,8,2,8,4,5,9,0,4,5,2,3,5,3,6,0,2,8,7,4,7,1,3,5,2,6,6,2,4,9,7,7,5,7,2,4,7,0,9,3,6,9,9,9,5,9,5,7,4,9,6,6,9,6,7,6,2,7};

        int[] testNum1 = {1, 3, 3, 4};
        int[] testNum2 = {9, 4, 3, 4};

        int[] firstHalfnum = {1};
        int[] secondHalfNum = {3};
        int[] firstHalfNum2 = {9};
        int[] secondHalfNum2 = {4};

        int[] ac = {9};
        int[] ad = {4};
        int[] bc = {2, 7};
        int[] bd = {1, 2};

        Multiplication mult = new Multiplication(testNum1, testNum2);

        int[] answer = mult.multiply(mult.num1, mult.num2);

        //int[] product = mult.recIntMult(ac, ad, bc, bd, 2);


        //int[] rawrs = mult.arrayCopyWithLeadingZeroes(num1, 2);

        //int[] sum = mult.arrayAddition(testNum1, testNum2);


    }
}
