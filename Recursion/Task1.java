import java.util.*;
public class Task1 {
    static void decreasing(int n){
        System.out.println(n);
        if(n>1){
            decreasing(n-1);
        }else{
            return;
        }
    }

    static void increasing(int n){
        if(n>=1){
            increasing(n-1);
        }else{
            return;
        }
        System.out.println(n);
    }

    static void inc_dec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        inc_dec(n-1);
        System.out.println(n);
    }

    static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    static int power(int a, int n){
        if(n==0){
            return 1;
        }
        return a*power(a,n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        //decreasing(sc.nextInt());
        //increasing(sc.nextInt());
        //inc_dec(sc.nextInt());
        //System.out.println(factorial(sc.nextInt()));
        System.out.println(power(sc.nextInt(), sc.nextInt()));

    }
}
