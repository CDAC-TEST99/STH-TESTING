package new_opd.DAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTimeExample1 {
	public static void main(String[] args) {    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd MMMM uuuu" );  
		   LocalDateTime now = LocalDateTime.now();  
		   String currDate= dtf.format(now);
		   
		   LocalDate currDt = LocalDate.parse( currDate , dtf );
		   LocalDate prevDt = LocalDate.parse( "10 August 2024" , dtf );
		   
		   Boolean isequal=currDt.equals(prevDt);
		 //  System.out.println("isequal>>>>" + isequal);
		    
	}    
	
	
}
