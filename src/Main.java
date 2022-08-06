/**
 * This is my driver method to show the outputs for the SortedSet and SortedsetUtils classes.
 *
 * @author: Bruck Negash,CIN: 305603706,CS-2013,Sections 03 & 04
 *
 */


public class Main {
    public static void main(String[] args){
        SortedSet<Integer> intSet = new SortedSet<>();
        SortedSet<Integer> intSet2 = new SortedSet<>();
        SortedSet<String> strSet = new SortedSet<>();
        SortedSet<String> strSet2 = new SortedSet<>();

        /**
         * Outputs for add method
         */
        System.out.println("Adding values to intSet....");
        intSet.add(12);
        intSet.add(40);
        intSet.add(87);
        intSet.add(71);
        System.out.println("Here is the intSet after adding the value: " + intSet);
        System.out.println();

        System.out.println("Adding values to intSet2....");
        intSet2.add(100);
        intSet2.add(15);
        intSet2.add(27);
        intSet2.add(61);
        intSet2.add(30);
        System.out.println("Here is the intSet2 after adding the value: " + intSet2);
        System.out.println();

        System.out.println("Adding values to strSet....");
        strSet.add("CompSci");
        System.out.println("Here is the strSet after adding element: " + strSet);
        System.out.println();

        System.out.println("Adding values to strSet2....");
        strSet2.add("CompSci");
        System.out.println("Here is the strSet after adding element: " + strSet2);
        System.out.println("------------------------------------------------");

        /**
         * Outputs for exists method
         */
        System.out.println("Does the value '40' exist in the intSet?: " + intSet.exists(40));
        System.out.println("Does the value '29' exist in the intSet2?: " + intSet2.exists(29));
        System.out.println("------------------------------------------------");

        /**
         * Output for addAll method
         */
        intSet.addAll(27,87,47);
        System.out.println("Here is the intSet after addAll: " + intSet);

        intSet2.addAll(1,2,3);
        System.out.println("Here is the intSet2 after addAll: " + intSet2);

        strSet.addAll("History", "Math", "English","Art","Engineering");
        System.out.println("Here is the strSet after addAll: " + strSet);

        strSet2.addAll("History", "Math", "English","Art","Engineering");
        System.out.println("Here is the strSet after addAll: " + strSet2);
        System.out.println("-----------------------------------------------");

        /**
         * Output for remove method
         */
        intSet.remove(30);
        System.out.println("Here is the set after removing '30' from intSet: " + intSet);

        intSet2.remove(2);
        System.out.println("Here is the set after removing '2' from intSet2: " + intSet2);

        strSet.remove("English");
        System.out.println("Here is the strSet after removing 'English': " + strSet);

        strSet2.remove("English");
        System.out.println("Here is the strSet2 after removing 'English': " + strSet2);
        System.out.println("------------------------------------------------");

        /**
         * Output for get method
         */
        System.out.println("Getting value from index '3' from intSet: " + intSet.get(3));
        System.out.println("Getting value from index '1' from intSet2: " + intSet2.get(1));
        System.out.println("Getting value from index '2' from strSet: " + strSet.get(2));
        System.out.println("------------------------------------------------");

        /**
         * Outputs for size method
         */
        System.out.println("Here is the size of intSet: " + intSet.size());
        System.out.println("Here is the size of intSet2: " + intSet2.size());
        System.out.println("Here is the size of strSet: " + strSet.size());
        System.out.println("------------------------------------------------");

        /**
         * Outputs for equals method
         */
        System.out.println("Does intSet and intSet2 equal?: ");
        intSet.equals(intSet2);
        System.out.println();

        System.out.println("Do both string sets equal?: ");
        strSet.equals(strSet2);
        System.out.println("------------------------------------------------");

        /**
         * Output for the union method
         */
        intSet = SortedSetUtils.union(intSet,intSet2);
        System.out.println("Here is the union of both sets: " + intSet);

        strSet = SortedSetUtils.union(strSet,strSet2);
        System.out.println("Here is the union of both sets: " + strSet);
        System.out.println("------------------------------------------------");

        /**
         * Output for the intersection method
         */
        intSet2 = SortedSetUtils.intersection(intSet,intSet2);
        System.out.println("Here is the intersection of both sets: " + intSet2);
        System.out.println();

        strSet2 = SortedSetUtils.intersection(strSet,strSet2);
        System.out.println("Here is the intersection of both sets: " + strSet2);
        System.out.println("------------------------------------------------");

    }

}
