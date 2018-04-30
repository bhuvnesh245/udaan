package math;

import java.util.ArrayList;

/**
 * Created by bhuvneshk on 8/3/18.
 */
public class FindFactor {

    public static void main(String[] args) {
        System.out.println(new FindFactor().allFactors(36));
    }


    public ArrayList<Integer> allFactors(int A) {

        ArrayList<Integer> factors = new ArrayList<Integer>();
        ArrayList<Integer> factors2 = new ArrayList<Integer>();

        double sqrt = Math.sqrt(A);
        for(int i = 1; i <= sqrt; i++){

            if(A % i == 0){
                factors.add(i);

                if(i != sqrt){
                    factors2.add((A / i));
                }
            }

        }

        for (int j = factors2.size()-1; j >= 0 ; j--){

            factors.add(factors2.get(j));
        }

        return factors;
    }
}

