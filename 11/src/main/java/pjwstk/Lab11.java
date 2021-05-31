package pjwstk;


import org.apache.log4j.Logger;

import java.io.File;

public class Lab11 {

    protected final Logger log = Logger.getLogger(Lab11.class);
    ClassLoader classLoader = getClass().getClassLoader();

    public int sum(int a, int b){
        log.info("Method sum, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();

        }
        return a+b;
    }

    public int mul(int a, int b){
        log.info("Method mul, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a*b;
    }

    public int square(int a){
        log.info("Method square, argument " + a );
        if(a == 0 ){
            throw new IllegalArgumentException();
        }
        return a*a;
    }

    public int div(int a, int b){
        log.info("Method div, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a/b;
    }

    public int mod(int a, int b){
        log.info("Method mod, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a == 0 && b == 0 ){
            throw new IllegalArgumentException();
        }
        return a%b;
    }

    public Boolean greaterThan(int a, int b) {
        log.info("Method greaterThan, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a > b){
            return true;
        }else if(b > a) {
            return false;
        }
        return null;
    }

    public Boolean lessThan(int a, int b) {
        log.info("Method lessThan, arguments " + a + " | " + b);
        if(a == 0 || b == 0){
            log.warn("One of the values is equal to 0!");
        }
        if(a < b){
            return true;
        }else if(b < a) {
            return false;
        }
        return null;
    }

    public Boolean openFile(){
        try{
            File file = new File(classLoader.getResource("blednyPlik.txt").getFile());
            return true;
        }catch (Exception e){
            log.error("Nie znaleziono pliku", e);
        }
        return false;
    }
}
