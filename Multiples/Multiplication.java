package Multiples;

import java.math.BigInteger;

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
            int halfLength = num1.length;


            return null;
        }
    }


}

class MultipleTesters
{

    public static void main(String[] afgsgs)
    {
        System.out.println(Long.MAX_VALUE);


        int[] num1 = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0,5,8,2,0,9,7,4,9,4,4,5,9,2};
        int[] num2 = {2,7,1,8,2,8,1,8,2,8,4,5,9,0,4,5,2,3,5,3,6,0,2,8,7,4,7,1,3,5,2,6,6,2,4,9,7,7,5,7,2,4,7,0,9,3,6,9,9,9,5,9,5,7,4,9,6,6,9,6,7,6,2,7};

        int[] testNum1 = {1};
        int[] testNum2 = {2};

        Multiplication mult = new Multiplication(testNum1, testNum2);

        int[] answer = mult.multiply(mult.num1, mult.num2);




    }
}
