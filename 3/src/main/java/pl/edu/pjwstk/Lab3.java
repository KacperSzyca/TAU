package pl.edu.pjwstk;

import java.util.Arrays;
import java.util.List;

public class Lab3 {

    public int sum(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a+b;
    }

    public int mul(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a*b;
    }

    public int square(int a){
        if(a == 0 ){
            throw new IllegalArgumentException();
        }
        return a*a;
    }

    public int div(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a/b;
    }

    public int mod(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a%b;
    }

    public Boolean greaterThan(int a, int b) {
        if(a > b){
            return true;
        }else if(b > a) {
            return false;
        }
        return null;
    }

    public Boolean lessThan(int a, int b) {
        if(a < b){
            return true;
        }else if(b < a) {
            return false;
        }
        return null;
    }
}
