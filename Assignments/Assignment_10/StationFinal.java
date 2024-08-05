/**
 * Object that simulates a simple train station. These objects are used by
 * class TrainLine to simulate a train route.
 */
public class StationFinal {

    /** The name of the train station */
    private String name;
    /** The station immediately after */
    private StationFinal next;

    /**
     * A simple constructor to instantiate a Station object with a given name
     * but unknown (null) next and prev(ious) stations.
     * 
     * @param name
     */
    public StationFinal(String name) {
        this.name = name;
        this.next = null;
    } // simple constructor

    /** Mutator for next */
    public void setNext(StationFinal next) {
        this.next = next;
    } // method setNext

    /** Predicate accessor for next */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /** Accessor for next */
    public StationFinal getNext() {
        return this.next;
    } // method getNext()

    /** Mutator for Name */
    public String getName() {
        return this.name;
    } // method getName

} // class Station