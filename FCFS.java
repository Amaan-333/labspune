import java.util.*;
/**
 * FCFS
 */
public class FCFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        float totalTAT = 0,totalWT = 0;

        System.out.println("FCFS Scheduling");
        System.out.println("Enter Number of Processes");
        n = scanner.nextInt();

        String processes[] = new String[n];
        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int turnAboutTime[] = new int[n];
        int waitingTime[] = new int[n];
        int completionTime[] = new int[n];

        for (int i = 0; i < n; i++) {
            processes[i] = "P" + (i+1);
            System.out.println("Enter arrival time for process " + (i+1) + ":0");
            arrivalTime[i] = scanner.nextInt();
            System.out.println("Enter burst time for process "+(i+1)+":");
            burstTime[i] = scanner.nextInt();
        }

        completionTime[0] = burstTime[0];
        for (int i = 0; i < n-1; i++) {
            completionTime[i+1] = completionTime[i] + burstTime[i+1];            
        }

        System.out.println("Process\t|Arrival Time|\tBurst Time|\tCompletion Time|\tTurn Around Time|\t Waiting Time");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            turnAboutTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnAboutTime[i] - burstTime[i];
            totalTAT+=turnAboutTime[i];
            totalWT += waitingTime[i];
            System.out.println(processes[i] + "\t\t" + arrivalTime[i] +"\t\t" + burstTime[i]+ "\t\t" +completionTime[i] +"\t\t"+
            turnAboutTime[i] + "\t\t" + waitingTime[i]);

        }
        System.out.println("Average turn around time :"+ (totalTAT/n));
        System.out.println("Avg waiting time : "+ (totalWT/n));
    }   
}