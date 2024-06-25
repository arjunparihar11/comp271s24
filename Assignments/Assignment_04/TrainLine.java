package Assignments.Assignment_04;

public class TrainLine {
    
    private String lineColor;//Name of Line used for toString
    private Station head;
    private Station tail;
    private int numOfStations;//Current Number of Stations

    /**
     * A simple constructor to instantiate a TrainLine object with a color
     * (name)
     * @param color
     */
    public TrainLine(String color){
        head = null;
        tail = null;
        lineColor = color;
        numOfStations = 0;
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
        numOfStations++;//add to count of total stations
    } // method addStation

    /**
     * Returns true if a station with a specified name exists in the TrainLine
     * object and false otherwise.
     * @param station Specified name we are searching for in the TrainLine
     */
    public boolean contains(String station){
        boolean contained=false;//boolean checking if String exists in TrainLine
        Station currentStation = this.head;//Station to iterate through TrainLine
        //loop through each station until we find the string or have run out of stations
        while (!contained && currentStation != null) {
            //if station is equal to station in TrainLine, contained true, break out of loop
            if(currentStation.equals(station)){
                contained = true;
            }
            currentStation = currentStation.getNext();//iterate to next station
        }
        return contained;
    }//method contains

    /**
     * When printed station prints its name followed by a list of eevry station
     * in the TrainLine
     * @return String representation of TrainLine
     */
    public String toString(){
        //start String with name/color
        String stations = this.lineColor;
        //iterate through stations
        Station currentStation = this.head;
        while (currentStation != null) {
            //space between lines
            stations += "\n";
            //name of station
            stations += currentStation.toString();
            //next station
            currentStation = currentStation.getNext();
        }
        //returns string starting with color followed by list of stations
        return stations;
    }

    /**
     * accessor for numofStations
     * @return numOfStations, numbe of stations in line
     */
    public int length(){
        return this.numOfStations;
    }
}
