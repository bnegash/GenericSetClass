import java.util.Arrays;

/**
 * This is a generic class that only allows data types which implement the Comparable interface.
 * In this class, I used generics and lists to create a Generic Set class. A set is a data structure which does
 * not allow duplicate values.
 *
 *
 * <url>
 *  https://calstatela.instructuremedia.com/embed/a0e090da-b3ca-424d-aeee-ef96e684b26e
 *</url>
 *
 * @author: Bruck Negash
 *
 */

public class SortedSet<E extends Comparable<E>> {

    /**
     * @param size  represents the number of actual elements in the set.
     * @param set   represents the array of generic values.
     */
    private int size;
    private E[] set;


    /**
     * Default constructor which creates an empty set with an initial capacity of 10.
     */
    public SortedSet() {
        this.size = 0;
        set = (E[]) (new Comparable[10]);
    }

    /**
     * Param constructor with accepts one integer as an argument. It is the initial capacity of the set and
     * will be used to initialize the size of the internal array.
     * @param capacity
     */
    public SortedSet(int capacity) {
        this.size = 0;
        set = (E[]) (new Comparable[capacity]);
    }

    /**
     * This constructor accepts a comma seperated list of generic values as a parameter.
     *
     *  @param values   generic value of comma seperated list
     */
    public SortedSet(E... values) {
        this.set = values;
        this.size = values.length;
    }

    /**
     * This constructor is a copy constructor that will make a deep copy of the SortedSet
     *
     */
    public SortedSet(SortedSet<E> set) {
        this.set = (E[]) new Comparable[size];
        this.size = set.size;
        /**
         * Used to copy one set to another
         */
        System.arraycopy(set, 0, set, 0, 10);

    }


    /**
     * This method uses a linear search to loop through the array sequentially to check if the given
     * value is in the array. The method receives a parameter as a value to search the array for.
     * <p>
     * Runtime O(n)
     **/
    public boolean exists(E value) {
        /**
         * Loops through array and if value is found returns true
         */
        for (int i = 0; i < size; i++) {
            if (value.equals(set[i])) {
                return true;
            }
        }
        return false;

    }

    /**
     * Add method will add the value to the set.
     * <p>
     * This method takes a parameter as a value to add into the array. Uses the exists method to check if value
     * already exists in array. If value does not exist, it will then check if the array is full and call the
     * resize method and double the size of the array.
     * <p>
     *
     **/
    public void add(E value) {
        /**
         * Checks exists method to validate
         */
        if (!this.exists(value)) {
            /**
             * Checks if there is room in the set, if yes then will resize the capacity of array
             */
            if (size == set.length) {
                resize();
            }
            set[size] = value;
            size++;
        }

    }

    /**
     * This method takes a comma separated list of generic values as a parameter to add to the array.
     * It shall then add all of the given values from the set, provided the value is to be added is not
     * a duplicate. This method will also resize the set as necessary.
     *
     * @param values    Value of comma separated list of generic values
     */
    public void addAll(E... values) {
        for (E value : values) {
            if (!this.exists(value)) {
                if (size == set.length) {
                    resize();
                }
                set[size] = value;
                size++;
            }

        }

    }

    /**
     * This method will take the user inputted value as a parameter and shall remove the given value from
     * the set provided the value currently exists in the set.
     *
     * @param value     Generic value to be removed from array
     */
    public void remove(E value) {
        for (int i = 0; i < size; i++) {
            /**
             * Checks if value x is in the set
             */
            if (set[i].equals(value)) {
                if (size - 1 - i >= 0) {
                    /**
                     * Using arraycopy to shift elements post removal
                     */
                    System.arraycopy(set, i + 1, set, i, size - i);
                }
                size--;
            }
        }

    }

    /**
     * This method takes a parameter that is the index of the array and returns the element at the given index.
     *
     * @param index: User chosen index from array to retrieve value stored at the index
     * @return index:   The value stored at the chosen index in the array
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid");
        }
        return set[index];
    }

    /**
     * This method takes no parameters and returns the size in the set.
     *
     * @return size:    actual number of elements in the set
     */
    public int size() {
        return size;
    }

    /**
     * Equals method takes a SortedSet object as a parameter and will return true if two sets are equal,
     * false if they are not and output the respective message.
     *
     * @return true     if both sets are equal
     * @return false    if both sets are not equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SortedSet)) {
            return false;
        }
        SortedSet<E> o = (SortedSet<E>) obj;
        /**
         * Checks if the current instance is the same as the
         * MyArray object
         */
        if (this == o) {
            return true;
        }
        /**
         * Checks if new object is empty
         */
        if (o == null) {
            return false;
        }
        if(Arrays.equals(set, o.set)){
            System.out.println("These objects are equal");
            return true;
        }else {
            System.out.println("These objects are not equal");
            return false;
        }
    }

    /**
     * This method is the string representation the set.
     *
     */
    @Override
    public String toString() {
        String str = "{";


        for (int i = 0; i < size; i++) {
            str = str + set[i] + ",";
        }
        /**
         * Checks if set is empty and will output "{}"
         */
        if (set[size] == null) {
            return str + "}";
        } else {
            str += set[size - 1] + "}";
            return str;
        }
    }


    /**
     * Resize method will increase and double the capacity of the set.
     * By using the arraycopy method it will copy values from old set
     * and transfer it to the new set. Then sets the new array capacity to the old.
     *
     */
    private void resize() {
        /**
         * Creates new set with double the current capacity
         */
        E[] newArr = (E[]) new Comparable[set.length * 2];

        if (size >= 0) System.arraycopy(set, 0, newArr, 0, size);

        set = newArr;
    }
}

