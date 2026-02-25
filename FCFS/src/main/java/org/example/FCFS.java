package org.example;
import java.util.Scanner;
public class FCFS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create Scanner object
        int n = 0; // Number of processes

        try {
            // Prompt user to enter number of processes
            System.out.print("Enter number of processes: ");
            n = input.nextInt();

            // If 0 is entered, show message and exit
            if (n == 0) {
                throw new Exception();
            }

            // Arrays to hold burst times, waiting times, and turnaround times
            int[] burstTime = new int[n];
            int[] waitingTime = new int[n];
            int[] turnAroundTime = new int[n];

            // Input burst time for each process
            for (int i = 0; i < n; i++) {
                System.out.print("Enter burst time for Process " + (i + 1) + ": ");
                burstTime[i] = input.nextInt();
            }

            // First process has 0 waiting time
            waitingTime[0] = 0;

            // Calculate waiting time for each process
            for (int i = 1; i < n; i++) {
                waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
            }

            // Calculate turnaround time for each process
            for (int i = 0; i < n; i++) {
                turnAroundTime[i] = burstTime[i] + waitingTime[i];
            }

            // Display Gantt chart
            System.out.println("\nGantt Chart:");
            int time = 0;
            for (int i = 0; i < n; i++) {
                System.out.print("P" + (i + 1) + " (" + time + ") → ");
                time += burstTime[i];
            }
            System.out.println("(" + time + ")");

            // Display process information table
            System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
            int totalWT = 0, totalTAT = 0;

            for (int i = 0; i < n; i++) {
                System.out.println("P" + (i + 1) + "\t\t\t" + burstTime[i] + "\t\t\t" + waitingTime[i] + "\t\t\t" + turnAroundTime[i]);
                totalWT += waitingTime[i];       // Accumulate total waiting time
                totalTAT += turnAroundTime[i];   // Accumulate total turnaround time
            }

            // Calculate and print average waiting and turnaround times
            System.out.printf("\nAverage Waiting Time: %.2f\n", (float) totalWT / n);
            System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTAT / n);

        } catch (Exception e) {
            // Handle invalid input (e.g., non-integer)
            System.out.println("Invalid option, you need to enter an integer greater than 0");
        }
    }
}