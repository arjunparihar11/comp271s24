package Assignments.Assignment_04;
import TrainLine;

public class TrainStationTester{
	public static void main(String[] args) {
        //RedLine
        TrainLine redLine = new TrainLine("Red Line");
        redLine.addStation("Howard");
        redLine.addStation("Jarvis");
        redLine.addStation("Morse");
        redLine.addStation("Loyola");
        redLine.addStation("Granville");
        redLine.addStation("Bryn Mawr");
        redLine.addStation("Argyle");
        redLine.addStation("Wilson");
        //Purple Line
        TrainLine purpleLine = new TrainLine("Purple Line");
        purpleLine.addStation("Linden");
        purpleLine.addStation("Central");
        purpleLine.addStation("Noyes");
        purpleLine.addStation("Foster");
        purpleLine.addStation("Davis");
        purpleLine.addStation("Dempster");
        purpleLine.addStation("Main");
        purpleLine.addStation("South Blvd");
        purpleLine.addStation("Howard");
        purpleLine.addStation("Wilson");

        System.out.println(redLine);
        System.out.println("\n");
        System.out.println(purpleLine);
        System.out.println("\n");
        System.out.println(redLine.contains("Howard"));
        System.out.println(purpleLine.contains("Howard"));
        System.out.println("\n");
        System.out.println(redLine.contains("Wilson"));
        System.out.println(purpleLine.contains("Wilson"));
        System.out.println("\n");
        System.out.println(redLine.contains("Noyes"));
        System.out.println(purpleLine.contains("Noyes"));
    }
}