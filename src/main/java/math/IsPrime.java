package math;

/**
 * Created by bhuvneshk on 9/3/18.
 */
public class IsPrime {

    public int isPrime(int A) {


        if(A == 1){
            return 0;
        }

        for(int i = 2; i <A; i++){

            if(A % i == 0){


                return 0;

            }

        }
        return 1;
    }

    public static void main(String[] args) {

        System.out.println(new IsPrime().isPrime(53));
    }
}
