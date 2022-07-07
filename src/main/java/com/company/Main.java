package com.company;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st1 = in.next();
        String st = in.next();
        String st2 = in.next();
        String result = calculate(st1, st, st2);
        System.out.print(result);
    }

    public static String calculate(String st1, String st, String st2) {
        String[] parts = st1.split("/");
        String[] parts1 = st2.split("/");
        fraction fr1 = new fraction(), fr2 = new fraction();
        List<Integer> l = new ArrayList<Integer>();
        fr1.set_num_str((parts[0]));
        l.add(Integer.parseInt(parts[0]));
        if (parts.length == 2) {
            fr1.set_denom_str(parts[1]);
            l.add(Integer.parseInt(parts[1]));
        } else {
            fr1.set_denom(1);
            l.add(1);
        }
        fr2.set_num_str(parts1[0]);
        l.add(Integer.parseInt(parts[1]));
        if (parts1.length == 2) {
            fr2.set_denom_str(parts1[1]);
            l.add(Integer.parseInt(parts1[1]));
        } else {
            fr2.set_denom(1);
            l.add(1);
        }
        switch (st) {
            case ("+"): {
                fr1.add(fr2);
                return fr1.return_str();
            }
            case ("-"): {
                fr1.dif(fr2);
                return fr1.return_str();
            }
            case ("*"): {
                fr1.mult(fr2);
                return fr1.return_str();
            }
            case ("/"): {
                fr1.div(fr2);
                return fr1.return_str();
            }
        }
        return "   ";
    }

}


/*
 class calculatortest{
 @test
 void addition(){
 assertEquals("2",calc("1","+","1"));
 }*/