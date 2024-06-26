
public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirinth";
    public static void main(String[] args) {
        // Create a small train line and add a few stations to it with names
        // drawn from a String[]
        TrainLine redLineSB = new TrainLine();
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        for (String name : stationNames) {
            redLineSB.addStation(name);
        }
        // Test sequence
        boolean sequence = true;
        for (int i = 0; i < stationNames.length; i++) {
            sequence = sequence && (redLineSB.indexOf(stationNames[i]) == i);
        }
        System.out.printf("\n\nSequence test: %s", (sequence ? PASS : FAIL));
        // Test non existent
        boolean nonExisting = (redLineSB.indexOf(NON_EXISTENT) == -1);
        System.out.printf("\n\nSequence test: %s%n", (nonExisting ? PASS : FAIL));

        //Append Testing
        TrainLine redLineSB2 = new TrainLine();
        String[] stationNames2 = { "Bryn Mawr", "Argyle", "Wilson",
                "Sheridan", "Addison", "Belmont" };
        for (String name : stationNames2) {
            redLineSB2.addStation(name);
        }

        System.out.printf("%nRedLine pt1: %s%n",redLineSB);
        System.out.printf("RedLine pt2: %s%n",redLineSB2);
        redLineSB.append(redLineSB2);
        System.out.printf("RedLine: %s%n",redLineSB);
    }
}
