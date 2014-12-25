package com.stackoverflow.ques;

import java.io.*;

public class Quitz{
    public static BufferedReader v = new BufferedReader(new InputStreamReader(System.in));
    public static int s;
    public static void main(String[] args) throws Exception{
        System.out.println("Enter an integer  : ");
        s = Integer.parseInt(v.readLine());

            System.out.println(x(s));



    }

    public static int x(int s){
        if(s <= 0)
            return s;
        else{
            System.out.println("Electric!");
            return x (s - 1);
        }
    }
}