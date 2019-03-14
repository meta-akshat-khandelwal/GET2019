//package Question4;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import jxl.Cell;
//import jxl.CellType;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//
//public class Conselling {
//	Queue queue = new QueueImplementation();
//	HashMap<String, Integer> programsMap = new HashMap<String, Integer>();
//	HashMap<String, String> studentPrefernece = new HashMap<String, String>();
//	
//	
//	public final static int noOfPreference = 5;
//	public final static int initialColumn = 0;
//	public final static int initialSheetnumber = 0;
//	
//	/**
//	 * Method to read the input file excel sheet which contains list of program with capacity
//	 * @param filePath
//	 */
//	private void readProgramCapacity(String filePath)
//	{
//		File file = new File(filePath);
//		Workbook workbook;
//		try 
//		{
//			workbook = Workbook.getWorkbook(file);
//			Sheet sheet = workbook.getSheet(initialSheetnumber);
//			for(int index=1;index<sheet.getRows();index++)
//			{
//				Cell cell = sheet.getCell(initialColumn, index);
//				
//				CellType type = cell.getType();
//				if (type == CellType.LABEL)
//				{
//					String programName = cell.getContents();
//					cell = sheet.getCell(initialColumn+1, index);
//					int capacity=Integer.parseInt(cell.getContents());
//					programsMap.put(programName, capacity);
//				}
//			}
//		}
//		catch (BiffException | IOException e) 
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * method reads the excel sheet which contains the students sorted according to rank  
//	 * @param filePath
//	 */
//	private void readStudentPrefernece(String filePath)
//	{
//		File file = new File(filePath);
//		Workbook workbook;
//		try 
//		{
//			workbook = Workbook.getWorkbook(file);
//			Sheet sheet = workbook.getSheet(initialSheetnumber);
//			for(int index=1;index<sheet.getRows();index++)
//			{
//				Cell cell = sheet.getCell(initialColumn, index);
//				
//				CellType type = cell.getType();
//				if (type == CellType.LABEL)
//				{
//					String studentName = cell.getContents();
//					queue.Enqueue(studentName);
//					cell = sheet.getCell(initialColumn+1, index);
//					String preference=cell.getContents();
//					studentPrefernece.put(studentName, preference);
//				}
//			}
//		}
//		catch (BiffException | IOException e) 
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 *to do the conselling
//	 * @param path, where output file has to be created
//	 * @param studentPrefernce,  student preference file location as string
//	 * @param programCapacity, Program capacity file location as string 
//	 * @throws WriteException
//	 */
//	public void studentCouncil(String path , String studentPrefernce, String programCapacity) throws WriteException
//	{
//		readProgramCapacity(programCapacity);
//		readStudentPrefernece(studentPrefernce);
//		WritableWorkbook workbook;		
//		try 
//		{
//			workbook = Workbook.createWorkbook(new File(path+"/output.xls"));
//			 WritableSheet sheet = workbook.createSheet("Output",initialSheetnumber);
//			 int count=1;
//			while(!queue.isEmpty()) 
//			{
//				//gets the student name from the queue
//		        String student=queue.Dequeue();
//		        //gets the student preference given in input
//		        String pref = studentPrefernece.get(student);
//		        //splits the student preferences 
//		        String[] preference = new String[noOfPreference];
//		        
//		        preference=pref.split(",");
//		        
//		        boolean assign=false;
//		        
//		        //assigns the student to a particular program
//		        for(int index=0;index<preference.length;index++)
//		        {
//		        	if(assign)
//		                break;
//		        	String subject=preference[index];
//		        	int capacity=programsMap.get(subject);
//		        	if(capacity>0)
//		        	{
//		        		Label label = new Label(initialColumn, count, student);
//		        		sheet.addCell(label);
//		        		Label label1 = new Label(initialColumn+1, count, preference[index]);
//		        		sheet.addCell(label1);
//		        		count++;
//		        		assign=true;
//		                capacity--;
//		                programsMap.put(subject,capacity);
//		        	}
//		        }
//			}
//			workbook.write();
//			workbook.close();
//			
//		}
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public static void main(String args[]) throws Exception
//	{
//	 Conselling conselling= new Conselling();
//	 
//	 conselling.studentCouncil("C:/Users/admin/Desktop/he","C:/Users/admin/Desktop/he/lar.xls", "C:/Users/admin/Desktop/he/lars.xls");
//	 
//	}
//
//}
