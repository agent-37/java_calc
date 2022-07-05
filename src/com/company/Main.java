package com.company;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
        String st1=in.next();
        String st=in.next();
        String st2=in.next();
        String []parts=st1.split("/");
        String []parts1=st2.split("/");

        int  a1,a2;
        int  b1,b2;
        a1=Integer.parseInt(parts[0]);
        if(parts.length==2)
        a2=Integer.parseInt((parts[1]));
        else
            a2=1;
        b1=Integer.parseInt((parts1[0]));
        if(parts1.length==2)
        b2=Integer.parseInt((parts1[1]));
        else
            b2=1;

        if(b2==0||a2==0)
            System.out.print("Деление на 0");
        else {
            int help_a=a1,help_b=a2,gcd;

            if(a1!=0) {
                while (help_a % help_b != 0 && help_b % help_a != 0) {
                    if (help_a > help_b)
                        help_a = help_a % help_b;
                    else
                        help_b = help_b % help_a;
                }
                gcd = min(help_b, help_a);
                a1 = a1 / gcd;
                a2 = a2 / gcd;
            }
            if(b1!=0) {
                help_a = b1;
                help_b = b2;
                while (help_a % help_b != 0 && help_b % help_a != 0) {
                    if (help_a > help_b)
                        help_a = help_a % help_b;
                    else
                        help_b = help_b % help_a;
                }
                gcd = min(help_b, help_a);
                b1 = b1 / gcd;
                b2 = b2 / gcd;
            }



            switch (st) {
                case ("+"): {
                    help_a=b2;
                    help_b=a2;
                    while(help_a%help_b!=0&&help_b%help_a!=0){
                        if(help_a>help_b)
                            help_a=help_a%help_b;
                        else
                            help_b=help_b%help_a;
                    }
                    gcd=min(help_b,help_a);
                    int new_a=(a1*b2)/gcd+(b1*a2)/gcd;
                    int new_b=a2*b2/gcd;
                    if(new_a!=0){
                    help_a=new_a;
                    help_b=new_b;
                    while(help_a%help_b!=0&&help_b%help_a!=0){
                        if(help_a>help_b)
                            help_a=help_a%help_b;
                        else
                            help_b=help_b%help_a;
                    }
                    gcd=min(help_b,help_a);}

                    System.out.print(new_a/gcd);
                    if(new_b/gcd!=1){
                    System.out.print('/');
                    System.out.print(new_b/gcd);
                    }
                    break;
                }
                case ("-"): {

                    help_a=b2;
                    help_b=a2;
                    while(help_a%help_b!=0&&help_b%help_a!=0){
                        if(help_a>help_b)
                            help_a=help_a%help_b;
                        else
                            help_b=help_b%help_a;
                    }
                    gcd=min(help_b,help_a);

                    int new_a=(a1*b2)/gcd-(b1*a2)/gcd;
                    int new_b=a2*b2/gcd;
                    if(new_a!=0) {
                        int sign = new_a;
                        help_a = abs(new_a);
                        help_b = new_b;
                        while (help_a % help_b != 0 && help_b % help_a != 0) {
                            if (help_a > help_b)
                                help_a = help_a % help_b;
                            else
                                help_b = help_b % help_a;
                        }
                        gcd = min(help_b, help_a);
                    }
                    System.out.print(new_a/gcd);
                    if(new_b/gcd!=1){
                        System.out.print('/');
                        System.out.print(new_b/gcd);
                    }
                    break;
                }
                case ("*"): {
                    int help_a1=a1,help_b1=b2,gcd1;
                    int help_a2=b1,help_b2=a2,gcd2;
                    while(help_a1%help_b1!=0&&help_b1%help_a1!=0){
                        if(help_a1>help_b1)
                            help_a1=help_a1%help_b1;
                        else
                            help_b1=help_b1%help_a1;
                    }
                    gcd1=min(help_b1,help_a1);




                    while(help_a2%help_b2!=0&&help_b2%help_a2!=0){
                        if(help_a2>help_b2)
                            help_a2=help_a2%help_b2;
                        else
                            help_b2=help_b2%help_a2;
                    }gcd2=min(help_b2,help_a2);

                    System.out.print((a1*b1)/gcd1/gcd2);
                    if(a2*b2/gcd1/gcd2!=1){
                        System.out.print('/');
                        System.out.print(a2*b2/gcd1/gcd2);
                    }
                    break;
                }
                case ("/"): {
                        if(b1==0)
                            System.out.print("Деление на 0");
                        else
                        {
                            int help_a1=a1,help_b1=b1,gcd1;
                            int help_a2=b2,help_b2=a2,gcd2;
                            while(help_a1%help_b1!=0&&help_b1%help_a1!=0){
                                if(help_a1>help_b1)
                                    help_a1=help_a1%help_b1;
                                else
                                    help_b1=help_b1%help_a1;
                            }
                            gcd1=min(help_b1,help_a1);
                            while(help_a2%help_b2!=0&&help_b2%help_a2!=0){
                                if(help_a2>help_b2)
                                    help_a2=help_a2%help_b2;
                                else
                                    help_b2=help_b2%help_a2;
                            }gcd2=min(help_b2,help_a2);
                            System.out.print((a1*b2)/gcd1/gcd2);
                            if(a2*b1/gcd1/gcd2!=0){
                                System.out.print('/');
                                System.out.print(a2*b1/gcd1/gcd2);
                            }

                        }
                    break;
                }
            }

        }
    }
}
