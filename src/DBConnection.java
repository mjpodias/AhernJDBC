import java.sql.*;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class DBConnection {	
	public void connect(ArrayList<CheckBox> actor, ArrayList<CheckBox> gender, ArrayList<CheckBox> parentage, ArrayList<CheckBox> behavior, TextField binsize){
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost:3306/Vole_DB";

		//  Database credentials
		final String USER = "root";
		final String PASS = "Mi1ch2ae7l92";
		
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
		    Class.forName(JDBC_DRIVER);
		    
		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql;
		    
			for (CheckBox element: actor) {
	    		if(element.isSelected()){
	    			System.out.println(element.getText());
	    		}
	    	}
	    	for (CheckBox element: gender) {
	    		if(element.isSelected()){
	    			System.out.println(element.getText());
	    		}
	    	}
	    	for (CheckBox element: parentage) {
	    		if(element.isSelected()){
	    			System.out.println(element.getText());
	    		}
	    	}
	    	for (CheckBox element: behavior) {
	    		if(element.isSelected()){
	    			System.out.println(element.getText());
	    		}
	    	}
		    
		    sql = "SELECT actor_id, sex FROM Actor";
		    ResultSet rs = stmt.executeQuery(sql);
	
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
//		       String actor_id = rs.getString("actor_id");
//		       String sex = rs.getString("sex");
//	
//		       //Display values
//		       System.out.print("Actor ID: " + actor_id);
//		       System.out.println(", Sex: " + sex + " | ");
		    }
		    
		    //STEP 6: Clean-up environment
		    rs.close();
		    stmt.close();
		    conn.close();
		}
			
		catch(SQLException se){
			//Handle errors for JDBC
		    se.printStackTrace();
		}
		
		catch(Exception e){
			//Handle errors for Class.forName
		    e.printStackTrace();
		}
		
		finally{
			//finally block used to close resources
		    try{
		    	if(stmt!=null)
		    		stmt.close();
		    }
		    
		    catch(SQLException se2){
		    
		    }// nothing we can do
		    
		    try{
		    	if(conn!=null)
		        conn.close();
		    }
		    
		    catch(SQLException se){
		         se.printStackTrace();
		    }//end finally try
		}
		System.out.println("Goodbye!");
	}//end method
}
