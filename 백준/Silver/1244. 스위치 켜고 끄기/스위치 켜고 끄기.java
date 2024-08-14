import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalSwitches = Integer.parseInt(br.readLine());
        String[] switchesStr = br.readLine().split(" ");

        boolean[] switches = new boolean[totalSwitches+1]; // "1": on "0": off
        for (int s = 0; s < totalSwitches; s++) {
            if (Objects.equals(switchesStr[s], "1")) switches[s+1] = true;
//            if (switchesStr[s] == "1") switches[s+1] = true;

            else switches[s+1] = false;
        }

        int numberOfStudents = Integer.parseInt(br.readLine());
        int[][] students = new int[numberOfStudents][2];
        for (int student = 0; student < numberOfStudents; student++) {
            // [gender, switchIdx]
            String[] studentSwitch = br.readLine().split(" ");
            int gender = Integer.parseInt(studentSwitch[0]); // "1": boy, "2": girl
            int switchIdx = Integer.parseInt(studentSwitch[1]);

            // boy
            if (gender == 1) {
                for (int i = switchIdx; i <= totalSwitches; i += switchIdx) {
                    switches[i] = clickSwitch(switches[i]);
                }
            }
            //girl
            else {
                switches[switchIdx] = clickSwitch(switches[switchIdx]);
                for (int i = 1; (switchIdx - i) > 0 && (switchIdx + i) <= totalSwitches; i++) {
                    if(switches[switchIdx - i] != switches[switchIdx + i]) break;
                    switches[switchIdx - i] = clickSwitch(switches[switchIdx - i]);
                    switches[switchIdx + i] = clickSwitch(switches[switchIdx + i]);
                }
            }
        }
        for(int i = 1; i <= totalSwitches; i++){
            System.out.print(switches[i]? "1 ": "0 ");
            if(i % 20 == 0) System.out.println();
        }


    }

    public static boolean clickSwitch(boolean s){
        return !s;
    }
}
