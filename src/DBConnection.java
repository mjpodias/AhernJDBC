import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class DBConnection {	
	// JDBC driver name and database URL and database credentials
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://localhost:3306/Vole_DB";
	private final String USER = "root";
	private final String PASS = "Mi1ch2ae7l92";
	
    private String sql;
	private String behaviorId;
	private String behaviorText;
	
	ArrayList<String> actorStrings = new ArrayList<String>();
	ArrayList<String> sexStrings = new ArrayList<String>();
	ArrayList<String> parentageStrings = new ArrayList<String>();
	
	String actor_id;
	String sex;
	String parentage;
	String dataKey;
	String currentKey = "init";
	BigDecimal binvalue;
	int binSize;
	
	
	ArrayList<BigDecimal> voleData = new ArrayList<BigDecimal>();
	
//	BigDecimal center_duration;
//	BigDecimal stay_hide_duration;
//	BigDecimal social_contact_duration;
//	BigDecimal three_contact_duration;
//	BigDecimal five_contact_duration;
//	BigDecimal seven_contact_duration;
//	BigDecimal one_contact_duration;
//	BigDecimal two_contact_duration;
//	BigDecimal four_contact_duration;
//	BigDecimal six_contact_duration;
//	BigDecimal approach_duration;
//	BigDecimal leave_duration;
//	BigDecimal follow_duration;
//	BigDecimal sniff_duration;
//	BigDecimal mount_duration;
//	BigDecimal compete_duration;

	public void connect(ArrayList<CheckBox> actorList, ArrayList<CheckBox> sexList, ArrayList<CheckBox> parentageList, ArrayList<CheckBox> behaviorList, TextField binsize) throws IOException{
//		binSize = Integer.parseInt(binsize.getText());
		CSVWriter writer = new CSVWriter(new FileWriter("QueryData.csv"), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_QUOTE_CHARACTER);
		writer.flush();		
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
		    
	    	for (CheckBox element: behaviorList) {
	    		if(element.isSelected()){
	    			behaviorId=element.getId();
	    			behaviorText=element.getText();
	    	    	
	    	    	if (!actorStrings.isEmpty()){
	    	    		sql = "SELECT Actor.actor_id, sex, parentage, " + behaviorId + " FROM Bin INNER JOIN Actor "
	    			    		+ "ON Actor.actor_id in ("+ listToString(actorStrings) +") ORDER BY Actor.actor_id";
	    	    	}
	    	    	
	    	    	else if (!sexStrings.isEmpty()&&!parentageStrings.isEmpty()){
	    			    sql = "SELECT Actor.actor_id, sex, parentage, " + behaviorId + " FROM Bin INNER JOIN Actor "
	    			    		+ "ON (sex in (" + listToString(sexStrings) + ") and parentage in (" + listToString(parentageStrings)
	    			    		+ ")) order by Actor.actor_id";
	    	    	}
	    	    	
	    	    	else if (!sexStrings.isEmpty()){
	    			    sql = "SELECT Actor.actor_id, sex, parentage, " + behaviorId + " FROM Bin INNER JOIN Actor "
	    			    		+ "ON sex in ("+ listToString(sexStrings) +") ORDER BY Actor.actor_id";
	    	    	}
	    	    	
	    	    	else if (!parentageStrings.isEmpty()){
	    			    sql = "SELECT Actor.actor_id, sex, parentage, " + behaviorId + " FROM Bin INNER JOIN Actor "
	    			    		+ "ON parentage in ("+ listToString(parentageStrings) +") ORDER BY Actor.actor_id";
	    	    	}
	    			query(stmt, writer);
	    		}
	    	}
		    //STEP 6: Clean-up environment
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
	
	private void query(Statement stmt, CSVWriter writer) throws SQLException, IOException {
	    ResultSet rs = stmt.executeQuery(sql);

		//STEP 5: Extract data from result set
	    while(rs.next()){
	    	//Retrieve by column name
	    	actor_id = rs.getString("actor_id");
	    	sex = rs.getString("sex");
	    	parentage = rs.getString("parentage");
	    	binvalue = rs.getBigDecimal(behaviorId);
	    	
			dataKey = actor_id + "," + sex + "," + parentage + "," + behaviorText + ",";
			//Enter values into CSV
			if (currentKey.equals("init")){
				currentKey=dataKey;
			}
			else if (!currentKey.equals(dataKey)||!rs.next()){
//				voleData.trimToSize();
				String[] entries = {currentKey + voleData.toString().replace('[',' ').replace(']',' ')};
			    writer.writeNext(entries);
			    System.out.println(voleData.size());
			    voleData.clear();
			    currentKey=dataKey;
			}
			else if (!rs.next()){
//				voleData.trimToSize();
				String[] entries = {currentKey + voleData.toString().replace('[',' ').replace(']',' ')};
			    writer.writeNext(entries);
			    System.out.println(voleData.size());
			    voleData.clear();
			    break;
			}
			voleData.add(binvalue);
	    }
	    currentKey="init";
		writer.close();
	    rs.close();
	}
}
