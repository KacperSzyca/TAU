package pl.edu.pjwstk;

import java.util.Arrays;
import java.util.List;

public class Lab1 {

    public int sum(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a+b;
    }

    public int sub(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a-b;
    }

    public int mul(int a, int b){
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a*b;
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

    public String[] stringToList(String a){
        List<String> strToList = Arrays.asList(a.split(","));
        return strToList.toArray(new String[0]);
    }
}
