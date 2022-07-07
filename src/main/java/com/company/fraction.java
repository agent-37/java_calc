package com.company;

import static java.lang.Math.*;

public class fraction {
    private double num, denom;

    public fraction() {
        num = 0;
        denom = 1;
    }

    public fraction(String s1, String s2) {
        num = Integer.parseInt((s1));
        denom = Integer.parseInt(s2);
    }

    public double get_num() {
        return num;
    }

    public double get_denom() {
        return denom;
    }

    public void set_num(double a) {
        num = a;
    }

    public void set_denom(double a) {
        denom = a;
    }

    public void set_num_str(String a) {
        num = Integer.parseInt(a);
    }

    public void set_denom_str(String a) {
        denom = Integer.parseInt(a);
    }

    public void normal() {
        if (denom != 0)
            if (num == 0)
                denom = 1;
            else {
                double help1 = abs(num), help2 = denom;
                while (help1 % help2 != 0 && help2 % help1 != 0) {
                    if (help1 > help2)
                        help1 = help1 % help2;
                    else
                        help2 = help2 % help1;
                }
                num = num / min(help1, help2);
                denom = denom / min(help1, help2);
            }
    }

    public void add(fraction fr) {
        if (fr.get_denom() == 0 || denom == 0) {
            num = 0;
            denom = 0;
        } else {
            num = (num * fr.get_denom()) + (denom * fr.get_num());
            denom = (denom * fr.get_denom());
            normal();
        }
    }

    public void dif(fraction fr) {
        if (fr.get_denom() == 0 || denom == 0) {
            num = 0;
            denom = 0;
        } else {
            num = (num * fr.get_denom()) - (denom * fr.get_num());
            denom = (denom * fr.get_denom());
            normal();
        }
    }

    public void mult(fraction fr) {

        if (fr.get_denom() == 0 || denom == 0) {
            num = 0;
            denom = 0;
        } else {
            num = num * fr.get_num();
            denom = (denom * fr.get_denom());
            normal();
        }
    }

    public void div(fraction fr) {

        if (fr.get_num() == 0 || denom == 0) {
            num = 0;
            denom = 0;
        } else {
            num = num * fr.get_denom();
            denom = (denom * fr.get_num());
            normal();
        }
    }

    public void print() {
        if (denom != 0) {
            System.out.print((int) (num));
            if (denom != 1) {
                System.out.print(('/'));
                System.out.print((int) (denom));
            }
        } else
            System.out.print("Деление на 0");
    }

    public String return_str() {
        String str;
        str = String.valueOf((int) (num));
        if (denom == 0)
            return "Деление на 0";
        else {
            if (denom != 1)
                str = str + '/' + String.valueOf((int) (denom));
            return str;
        }
    }

}
