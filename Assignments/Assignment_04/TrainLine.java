import Station;

package Assignments.Assignment_04;
public class TrainLine {
    
    private String lineColor;
    private Station head;
    private Station tail;

    public TrainLine(String color){
        lineColor = color;
    }
    /**
     * Add a new station at the end of this trainline. The method creates
     * a new station object, first, with the given name. Then it checks to
     * if this line has a head station yet; if not, the new station becomes
     * the head station. If this line has a head station, the method begins
     * traversing this line from its head station, following the next points
     * untils it finds a station whose next is null. That station, by definition
     * is presently the last station in the line. The new station is added after 
     * that last station. 
     * 
     * @param name String with name of new station to add
     */
    public void addStation(String name) {
        // Create a new station object with the given name
        Station newStation = new Station(name);
        // Check if this trainline has a head station yet or not
        if (this.head == null) {
            // There is no head station in this trainline. Make the 
            // new station, just created, the head station and end.
            this.head = newStation;
            this.tail = newStation;
        } else {
            //The trainine has an existing head station. Therefore,
            //it also has a known last station (this.tail)
            this.tail.setNext(newStation);//add new station after tail station
            this.tail = newStation; //Designate newly added station as tail station
        }
    } // method addStation

    public boolean contains(String station){
        boolean contained=false;
        Station currentStation = this.head;
        if(this.tail.equals(station)){
            contained = true;
        }
        while (!contained && currentStation.hasNext()) {
            if(currentStation.equals(station)){
                contained = true;
            }
            currentStation = currentStation.getNext();
        }
        return contained;
    }//method contains

    public String toString(){
        String stations = this.lineColor;
        Station currentStation = this.head;
        while (currentStation.hasNext()) {
            stations += "\n";
            stations += currentStation.toString();
            currentStation = currentStation.getNext();
        }
        stations += "\n";
        stations += this.tail.toString();
        return stations;
    }
}
