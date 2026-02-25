package org.example;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RR {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create Scanner object for user input
        int n = 0; // Number of processes

        try {
            // Prompt user for number of processes
            System.out.print("Enter number of processes: ");
            n = input.nextInt();

            // If 0 processes are entered, exit with a message
            if (n == 0) {
                throw new Exception();
            }

            // Arrays for burst time, remaining time, waiting time, and turnaround time
            int[] burstTime = new int[n];
            int[] remainingTime = new int[n];
            int[] waitingTime = new int[n];
            int[] turnAroundTime = new int[n];

            // Input burst time for each process and initialize remaining time
            for (int i = 0; i < n; i++) {
                System.out.print("Enter burst time for Process " + (i + 1) + ": ");
                burstTime[i] = input.nextInt();
                remainingTime[i] = burstTime[i];
            }

            // Input the time quantum for Round Robin scheduling
            System.out.print("Enter time quantum: ");
            int quantum = input.nextInt();

            int time = 0; // Current time tracker
            boolean done; // Flag to check if all processes are complete
            List<String> gantt = new ArrayList<>(); // To hold Gantt chart steps

            // Round Robin logic loop
            do {
                done = true;

                // Loop through all processes
                for (int i = 0; i < n; i++) {
                    if (remainingTime[i] > 0) {
                        done = false;

                        // Add process info to Gantt chart
                        gantt.add("P" + (i + 1) + " (" + time + ")");

                        if (remainingTime[i] > quantum) {
                            // Execute for full quantum time
                            time += quantum;
                            remainingTime[i] -= quantum;
                        } else {
                            // Execute remaining time (less than or equal to quantum)
                            time += remainingTime[i];
                            waitingTime[i] = time - burstTime[i];
                            remainingTime[i] = 0;
                        }


                        gantt.add("→ (" + time + ")");
                    }
                }
            } while (!done); // Repeat until all processes have completed

            // Calculate turnaround time for each process
            for (int i = 0; i < n; i++) {
                turnAroundTime[i] = burstTime[i] + waitingTime[i];
            }

            // Print Gantt chart
            System.out.println("\nGantt Chart:");
            for (String step : gantt) {
                System.out.print(step + " ");
            }

            // Print table of results
            System.out.println("\n\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
            int totalWT = 0, totalTAT = 0;

            for (int i = 0; i < n; i++) {
                System.out.println("P" + (i + 1) + "\t\t\t" + burstTime[i] + "\t\t\t" + waitingTime[i] + "\t\t\t" + turnAroundTime[i]);
                totalWT += waitingTime[i];
                totalTAT += turnAroundTime[i];
            }

            // Calculate and display average waiting and turnaround times
            System.out.printf("\nAverage Waiting Time: %.2f\n", (float) totalWT / n);
            System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTAT / n);
        }
        catch (Exception e) {
            // Handle non-integer or invalid inputs gracefully
            System.out.println("Invalid option, you need to enter an integer greater than 0");
        }
    }
}
