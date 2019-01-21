package fcfs;

public class JobSchedulerTask {

	

		
		 public int[] calculateWaitingTime(int processNumber,int[] arrivalTime, int[] burstTime)
		{
			int[] runTime = new int[processNumber];
			int[] waitingTime = new int[processNumber]; 
			runTime[0] = 0;
			waitingTime[0] = 0;
			
			
			for(int count = 1;count<processNumber;count++)
			{
				runTime[count] = runTime[count-1] + burstTime[count-1]; 
				waitingTime[count] = runTime[count] - arrivalTime[count];
				
				if(waitingTime[count] < 0)
					waitingTime[count] = 0;
			}
			
			return waitingTime;
		}
		
		
		public int[] calculateTurnAroundTime(int processNumber,int[] waitingTime,int[] burstTime)
		{
			int[] turnAroundTime = new int[processNumber];
			for (int i = 0; i < processNumber ; i++)  
			{
				turnAroundTime[i] = burstTime[i] + waitingTime[i]; 
			}
			
			return turnAroundTime;
		}
		
		
		public int[] calculateCompletionTime(int processNumber,int[] turnAroundTime,int[] arrivalTime)
		{
			int[] completionTime = new int[processNumber];
			for(int count=0;count<processNumber;count++)
			{
				completionTime[count] = turnAroundTime[count]+arrivalTime[count];
			}
			return completionTime;
		}
		
		
		public int calculateAvgWaitingTime(int processNumber,int[] waitingTime)
		{
			int avgWaitingTime = 0;
			for(int count = 0;count<processNumber;count++)
				{
				avgWaitingTime =avgWaitingTime+ waitingTime[count];
				}
			return avgWaitingTime/processNumber;
		}
		
		
		public int calculateMaxWaitingTime(int processNumber,int[] waitingTime)
		{
			int maxWaitingTime = 0;
			for(int count = 0;count<processNumber;count++)
			{
				if(maxWaitingTime > waitingTime[count])
					maxWaitingTime = waitingTime[count];
			}
				
			return maxWaitingTime;
		}
		
		
		public void displayTime(int processNumber,int[] time)
		{
			for(int count = 0;count<processNumber;count++)
			{
				System.out.println(time[count]);
			}
		}
		 
	
}
