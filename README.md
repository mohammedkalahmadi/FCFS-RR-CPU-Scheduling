# FCFS-RR-CPU-Scheduling
 Introduction 
This project focuses on simulating two fundamental CPU scheduling algorithms: First-Come, First-Served (FCFS) and Round Robin (RR). These algorithms are part of the core concepts in operating systems, especially in handling multiple processes in a multitasking environment.
The FCFS algorithm is the simplest type of CPU scheduling, where the process that arrives first is executed first without preemption. In contrast, Round Robin scheduling is a preemptive algorithm where each process is given a fixed time slice (quantum) and the CPU switches between processes in a cyclic order, promoting better responsiveness and fairness among processes.




 Explanation of FCFS CPU Scheduling
The implemented Java program simulates the First-Come, First-Served (FCFS) CPU scheduling algorithm. FCFS is a non-preemptive scheduling method where the process that arrives first is executed first, without interruption, until it finishes.
 Program Structure:
1.	Waiting Time Calculation:

○	The waiting time for the first process is always zero.

○	For every other process, the waiting time is calculated by adding the burst times of all the previous processes. This simulates how each process must wait for those before it to complete.

2.	Turnaround Time Calculation:

○	The turnaround time is the total time taken from the arrival of the process to its completion.

○	It is calculated by:
 Turnaround Time = Waiting Time + Burst Time

3.	Average Calculations:

○	The program sums up the waiting and turnaround times of all processes.

○	It then calculates the average waiting time and average turnaround time, which are important metrics for evaluating the efficiency of a scheduling algorithm.

 Example:
If we have 3 processes with burst times of 4, 3, and 5, the program prints a Gantt chart like:
P1 (0) → P2 (4) → P3 (7) → (12)




Explanation of Round Robin CPU Scheduling
This part of the project focuses on simulating the Round Robin (RR) CPU scheduling algorithm. Unlike FCFS, Round Robin is a preemptive scheduling method, which means the CPU switches between processes at regular intervals. Each process gets a fixed time slice, called the time quantum, to execute. If a process doesn’t finish within its time slice, it goes to the end of the queue and waits for the next turn.
Program Structure:
1.	Execution Logic:

○	The program uses a loop to simulate the CPU giving each process a turn to execute.

○	It keeps track of how much remaining time each process has.

○	This cycle continues until all processes have finished.

2.	Turnaround Time and Averages:

○	After scheduling is done, turnaround time for each process is calculated using:
 Turnaround Time = Waiting Time + Burst Time

○	The program then displays a table of each process with:

■	Burst Time

■	Waiting Time

■	Turnaround Time

○	Finally, it calculates and displays the average waiting time and average turnaround time.

 Example:
For 3 processes with burst times of 5, 3, and 6, and a time quantum of 2, the Gantt chart might look like:
P1 (0) → P2 (2) → P3 (4) → P1 (6) → P2 (8) → P3 (9) → P1 (11) → P3 (12) → (14)


