
public class DynamicArray implements BasicTools {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 3;

    /** Constant with default scale up */
    private static final double GROWTH_FACTOR = 0.1; // 10%

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensurig there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            this.resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add

    /**
     * Increases the size of the underlying array by a specific factor.
     * A larger temporary array is crated, contents of this.data are
     * copied over up, and the temp then replaces this.data.
     */
    private void resize() {
        // +1 below for safety in case the (int) cancels the increment
        int newSize = 1+(int)((1.0+GROWTH_FACTOR)*this.data.length);
        String[] temp = new String[newSize];
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    } // method resize

    /**
     * Determines if a String value is present in the underlying array
     * @param string String to search for
     * @return true if string found in array; false otherwise.
     */
    public boolean contains(String string) {
        boolean found = false;
        int i = 0;
        while (!found && i < this.position) {
            found = string.equals(this.data[i++]);
        }
        return found;
    } // method contains

    /**
     * Returns the number of times a string appears in the underlying array
     * @param string String to search for
     * @return count of occurrences.
     */
    public int countOf(String string) {
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            count = (this.data[i].equals(string)) ? count+1 : count;
        }
        return count;
    } // method countOf

    /**
     * Adds a string to the underlying array only if the string is not
     * already present.
     * @param string String to add
     * @return true if addition was successful, false otherwise (indicating a duplicate)
     */
    public boolean addUnique(String string) {
        boolean canBeAdded = ! this.contains(string);
        if (canBeAdded) {
            this.add(string);
        }
        return canBeAdded;
    } // method addUnique
    
    /**
     * Accessor for field position
     * @return int current value of position which essentially
     * reports the number of items stored in the dynamci array.
     */
    public int getPosition(){
        return this.position;
    }// method getPosition

    /**
     * Accessor for element of data 
     * @param index int value for index of returning element
     * @return String value of element in data array at index of int index
     * reports the number of items stored in the dynamci array.
     */
    public String getData(int index){
        return this.data[index];
    }// method getData

    /**
     * Function iterates through smaller array between this and other to search for a common
     * String element between the arrays
     * @param other is the other array we are checking against this array
     * @return true if there is a common String element, false otherwise
     */
    public boolean intersects(DynamicArray other){
        boolean intersect = false;//boolean to return if arrays have common string
        int index = 0;//int to iterate through array indexes
        if(other.getPosition() > this.getPosition()){//if this array is smaller iterate through this array
            while(index < this.getPosition() && !intersect){//iterate through this array
                if(other.contains(this.getData(index))){//if other contains element of this
                    intersect = true;//there is an intersection, break from while loop
                }
                index++;//next element
            }
        } else {//otherwise iterate through other array if it is smaller
            while(index < other.getPosition() && !intersect){//iterate through other array
                if(this.contains(other.getData(index))){//if this contains element of other
                    intersect = true;//there is an intersection, break from while loop
                }
                index++;//next element
            }
        }
        return intersect;//return false if none were found, returns true otherwise
    }
} // class DynamicArray
