public class SortedSetUtils {

    /**
     * No arg constructor
     */
    private SortedSetUtils() {}

    /**
     * The union method shall take two SortSet class instances
     * and combine both sets into one set
     *
     * @param setA      represents the first set
     * @param setB      represents the second set
     * @return setA
     */
    public static SortedSet union(SortedSet setA,SortedSet setB){
        for(int i = 0; i< setB.size(); i++){
            if(!(setA.exists(setB.get(i)))){
                setA.add(setB.get(i));
            }
        }
        return setA;
    }

    /**
     * The intersection method will take two SortedSet objects and return one
     * SortedSet object, consisting only of the shared values between sets
     */

    public static SortedSet intersection(SortedSet setA, SortedSet setB){
        for(int i = 0; i < setB.size(); i++){
            if(!(setA.exists(setB.get(i)))){
                setB.remove(setB.get(i));
            }
        }
        return setB;
    }
}
