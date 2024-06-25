package Assignments.Assignment_04;

/**
 * Object that simulates a simple train station. These objects are used by
 * class TrainLine to simulate a train route.
 */
public class Station {

    /** The name of the train station */
    private String name; 
    /** The station immediately after */
    private Station next;

    /**
     * A simple constructor to instantiate a Station object with a given name
     * but unknown (null) next station.
     * @param name
     */
    public Station(String name) {
        this.name = name;
        this.next = null;
    } // simple constructor

    /**
     * Mutator for next
     * 
     * @param next
     */
    public void setNext(Station next) {
        this.next = next;
    } // method setNext

    /**
     * Predicate accessor for next
     * 
     * @return true if this station points to another station indicated by
     *         this.next; false if this.next==null.
     */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /**
     * Accessor for next
     * 
     * @return Station object after this object. May return a null.
     */
    public Station getNext() {
        return this.next;
    } // method getNext()
    
    /**
     * When printed station prints its name
     * @return Name of station
     */
    public String toString(){
        return this.name;
    }

    /**
     * Checks if given String is the same as the name of a station
     * returns true or false based on if it is the same
     * @param other String checking against this.name
     */
    public boolean equals(String other){
        boolean equals = false;
        if(other.equals(this.toString())){
            equals = true;
        }
        return equals;
    }
} // class Station