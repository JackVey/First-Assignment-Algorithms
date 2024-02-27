import java.lang.reflect.Array;
import java.util.*;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the anwer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int[] returns = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    returns[0] = i;
                    returns[1] = j;
                }
            }
        }
        return returns;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        var sum = 0;
        for (var i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    break;
            }
        }
        for (var i = 1; i < s.length(); i++) {
            if ((s.charAt(i) == 'V' && s.charAt(i - 1) == 'I') || (s.charAt(i) == 'X' && s.charAt(i - 1) == 'I')) {
                sum -= 2;
            } else if ((s.charAt(i) == 'L' && s.charAt(i - 1) == 'X') || (s.charAt(i) == 'C' && s.charAt(i - 1) == 'X')) {
                sum -= 20;
            } else if ((s.charAt(i) == 'D' && s.charAt(i - 1) == 'C') || (s.charAt(i) == 'M' && s.charAt(i - 1) == 'C')) {
                sum -= 200;
            }
        }
        return sum;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int x = nums.length - 1;
        permutations(res, nums, 0, x);
        return res;
    }

    static void swap(int nums[], int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

    static void permutations(List<List<Integer>> res, int[] nums, int l, int h)
    {
        if (l == h) {
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                a.add(nums[i]);
            }
            res.add(new ArrayList(a));
            return;
        }

        for (int i = l; i <= h; i++) {
            swap(nums, l, i);
            permutations(res, nums, l + 1, h);
            swap(nums, l, i);
        }
    }


    public static void main(String[] args) {

    }
}