package com.company;

import java.util.Scanner;

public class program{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input size of array: ");
        int n = in.nextInt();
        System.out.print("Input array elements: ");
        int[] a = new int[n];
        for (int i=0; i<n; ++i)
        {
            a[i] = in.nextInt();
        }
        sort_tanos(a,0, n);
        System.out.print("Sorted array: ");
        for (int i=0; i<n; ++i)
        {
            System.out.print(a[i] + " ");
        }
    }
    static void sort_tanos(int[]  a, int begin, int end){
        if(begin + 1 >= end)
            return;
        double sum = 0;
        int[] res = new int[end-begin];
        boolean same = false;
        for (int i = begin; i < end; i++)
        {
            if(i != begin)
                if(a[i] != a[i-1])
                    same = true;
            sum += a[i];
        }
        if(same == false)
            return;
        sum /= end - begin;
        int l = 0, r = end - begin - 1;
        for (int i = begin; i < end; i++)
        {
            if(a[i] <= sum)
            {
                res[l] = a[i];
                ++l;
            }
            else
            {
                res[r] = a[i];
                --r;
            }
        }
        int length = res.length;
        for (int i = begin; i < begin + length; i++)
        {
            a[i] = res[i-begin];
        }
        sort_tanos(a,begin,begin + l);
        sort_tanos(a,begin + l, end);
        return;

    }
}
