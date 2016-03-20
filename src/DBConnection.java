import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import javax.xml.stream.events.Characters;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class DBConnection {	
	// JDBC driver name and database URL and database credentials
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost:3306/Vole_DB";
	private final String USER = "root";
	private final String PASS = "Mi1ch2ae7l92";
	
    private String sql;
	private String behavior;
	
	ArrayList<String> actorStrings = new ArrayList<String>();
	ArrayList<String> sexStrings = new ArrayList<String>();
	ArrayList<String> parentageStrings = new ArrayList<String>();
	
	String actor_id;
	String sex;
	String parentage;
	BigDecimal binvalue;
	BigDecimal center_duration;
	BigDecimal stay_hide_duration;
	BigDecimal social_contact_duration;
	BigDecimal three_contact_duration;
	BigDecimal five_contact_duration;
	BigDecimal seven_contact_duration;
	BigDecimal one_contact_duration;
	BigDecimal two_contact_duration;
	BigDecimal four_contact_duration;
	BigDecimal six_contact_duration;
	BigDecimal approach_duration;
	BigDecimal leave_duration;
	BigDecimal follow_duration;
	BigDecimal sniff_duration;
	BigDecimal mount_duration;
	BigDecimal compete_duration;

	public void connect(ArrayList<CheckBox> actorList, ArrayList<CheckBox> sexList, ArrayList<CheckBox> parentageList, ArrayList<CheckBox> behaviorList, TextField binsize){		
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
		    
	    	for (CheckBox element: behaviorList) {
	    		if(element.isSelected()){
	    			behavior=element.getId();
	    		}
	    	}
			for (CheckBox element: actorList) {
	    		if(element.isSelected()){
	    			actorStrings.add("'"+ element.getText() + "'");
	    		}
	    	}
	    	for (CheckBox element: sexList) {
	    		if(element.isSelected()){	
	    			sexStrings.add("'"+ element.getId() + "'");
	    		}
	    	}
	    	for (CheckBox element: parentageList) {
	    		if(element.isSelected()){	    			
	    			parentageStrings.add("'"+ element.getText() + "'");
	    		}
	    	}
		    
//	    	behavior = "center_duration";
	    	
		    sql = "SELECT Actor.actor_id, sex, parentage, " + behavior + " FROM Bin INNER JOIN Actor "
		    		+ "ON Actor.actor_id in ("+ listToString(actorStrings) +") ORDER BY Actor.actor_id";
		    
//		    sql = "SELECT Actor.actor_id, sex, parentage, " + behavior + " FROM Bin INNER JOIN Actor "
//		    		+ "ON sex in ("+ listToString(sexStrings) +") ORDER BY Actor.actor_id";
		    
//		    sql = "SELECT Actor.actor_id, sex, parentage, " + behavior + " FROM Bin INNER JOIN Actor "
//		    		+ "ON parentage in ("+ listToString(parentageStrings) +") ORDER BY Actor.actor_id";
		    
//		    sql = "SELECT Actor.actor_id, sex, parentage, " + behavior + " FROM Bin INNER JOIN Actor "
//		    		+ "ON (sex in (" + listToString(sexStrings) + ") and parentage in (" + listToString(parentageStrings)
//		    		+ ")) order by Actor.actor_id";
		    ResultSet rs = stmt.executeQuery(sql);
		    
//		    (sex in ("m") and parentage in ("EXP10-C3"))
		    
		    int i = 1;
		    
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		    	actor_id = rs.getString("actor_id");
		    	sex = rs.getString("sex");
		    	parentage = rs.getString("parentage");
		    	binvalue = rs.getBigDecimal(behavior);

		    	//Display values
		    	if (behavior=="center_duration"){
			    	System.out.println("Actor ID: " + actor_id + ":" + behavior +":" + binvalue + " | # " +i);
			    	i++;
		    	}
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
		actorStrings.clear();
		sexStrings.clear();
		parentageStrings.clear();
	}//end method
	
	private String listToString(ArrayList<String> list) {
		char[] charList = list.toString().toCharArray();
		for (int i=0; i < charList.length; i++){
			if((charList[i]=='[')||(charList[i]==']')) {
				charList[i]=' ';
			}
		}
		String text = String.valueOf(charList);	
	    return text;
	}
}
