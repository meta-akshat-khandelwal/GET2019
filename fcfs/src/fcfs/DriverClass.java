package fcfs;
import java.util.Scanner;

public class DriverClass {

	
		public void showMenu()
		{
			System.out.println("Press 1 for completion time ");
			System.out.println("Press 2 for waiting time ");
			System.out.println("Press 3 for turn around time");
			System.out.println("Press 4 avg waiting time");
			System.out.println("Press 5 for max waiting time");
			System.out.println("Press 0 to exit ");
		}
		
		
		public static void main(String[] args)
		{
			
			Scanner scanner = new Scanner(System.in);
			int columnNumber = 2;
			System.out.println("Enter the number of process ");
			int processNumber = scanner.nextInt();
			int[][] arrivalBurstTime = new int[processNumber][columnNumber];
			
			int[] burstTime = new int[processNumber];
			int[] arrivalTime = new int[processNumber];
			int[] completionTime = new int[processNumber];
			int[] turnAroundTime = new int[processNumber];
			int[] waitingTime = new int[processNumber];
			int avgWaitTime = 0;
			int maxWaitTime = 0;
			
			JobSchedulerTask jobSchedularTask = new JobSchedulerTask();
			DriverClass driverClass= new DriverClass();
			
			
			
			for(int outerCount=0 ; outerCount<processNumber ; outerCount++)
		    {
		    	System.out.println("Enter process " + (outerCount+1) + " Arrival Time and Burst Time");
		    	for(int innerCount=0 ; innerCount<columnNumber ; innerCount++)
		    	{
		    		int temp = scanner.nextInt();
		    		arrivalBurstTime[outerCount][innerCount] = temp;
		    	}
		    }
			
			
		
			
			for(int count=0;count<processNumber;count++)
			{
				int column = 0;
				arrivalTime[count] = arrivalBurstTime[count][column];
				burstTime[count] = arrivalBurstTime[count][column+1];
			}
		
			driverClass.showMenu();
			waitingTime = jobSchedularTask.calculateWaitingTime(processNumber,arrivalTime,burstTime);
			
	    	int choice = scanner.nextInt();
	    	switch(choice)
	    	{
	    		case 1: turnAroundTime = jobSchedularTask.calculateTurnAroundTime(processNumber,waitingTime,burstTime);
		                completionTime = jobSchedularTask.calculateCompletionTime(processNumber, turnAroundTime, arrivalTime);
		                jobSchedularTask.displayTime(processNumber, completionTime);
	    			    
	    			
	    			     break;
	    		case 2: jobSchedularTask.displayTime(processNumber, waitingTime);
				
				        
	    			    break;
	    		case 3:  turnAroundTime = jobSchedularTask.calculateTurnAroundTime(processNumber,waitingTime,burstTime);
		                 jobSchedularTask.displayTime(processNumber, turnAroundTime);
				       
	    			
	    			    break;
	    		case 4: avgWaitTime = jobSchedularTask.calculateAvgWaitingTime(processNumber,waitingTime);
	    			    System.out.println(avgWaitTime);
				        
	    			
	    			    break;
	    		case 5:  maxWaitTime = jobSchedularTask.calculateMaxWaitingTime(processNumber, waitingTime);
		                 System.out.println(maxWaitTime);   
				         
	    			
	    			     break;
	    		
	    		case 0: System.exit(0);
	    				break;
	    		default:  System.out.println("Invalid Choice");
	    			
	    			
	    	}
	    	scanner.close();
		}
		
		
		
	
}
