package sameDifferentPercentage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class App {
	
	public static void main(String[] args)  {
		App application = new App();
		String file = args[0];
		String file1 = args[1];
		try {
			application.readCsv(file, file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println("                                                                         ");
			System.out.println("Cannot locate file! Check if file exist and if it is in right location. ");
			System.out.println("                                                                         ");
			System.out.println("                                                                         ");
			System.out.println("------------------------------------------------------------------------");
			
		}
	}
	
	public void readCsv(String file,String file1) throws IOException{
	    CSVReader reader = new CSVReader(new FileReader(file));
	    CSVWriter writer = new CSVWriter(new FileWriter(file1));
	     List<String[]> allRowsInList = reader.readAll();
	     int nrOfRows = allRowsInList.size();
	     int nrOfRowsDecrease = nrOfRows;
	     System.out.println("Processing of comparasion started...");
	     for(int i=0;i<nrOfRowsDecrease;i++){
	    	
	    	 for (int j=0;j<nrOfRows;j++){
	    		 String row1 = allRowsInList.get(i)[0];
		    	 String row2 = allRowsInList.get(j)[0];
		    	 Comparer comparer = new Comparer();
		    	 Double percentage = comparer.compare(row1,row2);
		    	 String[] s = new String[5]; 
		    	 s[1]="Percentage higher 80 percent "+percentage+" on row "+(j+1);
		    	 if (percentage>=0.8&&i!=j){
		    		 writer.writeNext(allRowsInList.get(i));
		    		 writer.writeNext(s);
		    	 }
	    	 }
	     }
	     reader.close();
	     writer.close();
	     System.out.println("Processing of comparasion ended - you can now check exported file");
	}
	
}
