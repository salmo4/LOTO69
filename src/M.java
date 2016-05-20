import java.util.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



public class M {

    public static void main(String[] a) {

        // 1 prepare the lotto machine and init it
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());
        // 2 generate the lotto numbers
        System.out.print("\n");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 49; i++)
        {
            numbers.add(i+1);
        }

        Collections.shuffle(numbers);
        System.out.print("Numerele mele unice sunt: ");
        for(int j =0; j < 6; j++)
        {
            System.out.print(numbers.get(j) + " ");
        }
        Set setofSix = null;
        setofSix = new HashSet<Integer>();
        int counter = 0;
        Set<Integer> intersection = new TreeSet<Integer>(numbers);
        intersection.retainAll(setofSix);

        System.out.println("\n");
        System.out.print("Numerele agentiei sunt: ");
        do {
            int nr = lottoMachine.nextInt(49) + 1;
            boolean success = setofSix.add(nr);
            if (success) { // nr not already in the set
                counter++;

                System.out.print(nr + " ");

            }
        }
        while (counter < 6);
        System.out.println("\n");
        System.out.println("Tu ai nimerit " + intersection.size()+" numere");
        if (intersection.size() > 0) {
            double prize = 100 * Math.pow(2, intersection.size());
            System.out.println("Numerele nimerite sunt: " +
                    intersection);
            System.out.println("Premiul tau este $" + prize);
        }
    }
}




