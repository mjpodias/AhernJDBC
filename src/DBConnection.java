import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class DBConnection {	
	// JDBC driver name and database URL and database credentials
	private final String JDBC_DRIVER = "org.h2.Driver";  
	private final String DB_URL = "jdbc:h2:./lib/h2/database";
	private final String USER = "sa";
	private final String PASS = "";
	
    private String sql;
	
	ArrayList<String> actorStrings = new ArrayList<String>();
	ArrayList<String> sexStrings = new ArrayList<String>();
	ArrayList<String> parentageStrings = new ArrayList<String>();
	ArrayList<String> behaviorIDs = new ArrayList<String>();
	
	String actor_id;
	String sex;
	String parentage;
	String dataKey;
	String currentKey = "init";
	Double binvalue;
	int binSize = 1;
	
	ArrayList<Double> voleData = new ArrayList<Double>();
	ArrayList<Double> alteredVoleData = new ArrayList<Double>();

	public void connect(ArrayList<CheckBox> actorList, ArrayList<CheckBox> sexList, ArrayList<CheckBox> parentageList, ArrayList<CheckBox> behaviorList, TextField binsize) throws IOException{
		if (!binsize.getText().isEmpty()){
			binSize = Integer.parseInt(binsize.getText());
		}
		CSVWriter writer = new CSVWriter(new FileWriter("QueryData.csv"), CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_QUOTE_CHARACTER);
		writer.flush();
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
		    Class.forName(JDBC_DRIVER);
		    
		    //STEP 3: Open a connection
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
		    //STEP 4: Execute a query
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
		    		if (!actorStrings.isEmpty()){
			    		sql = "SELECT actor_id, sex, parentage, " + element.getId() + " FROM VOLEDB.Bin INNER JOIN VOLEDB.Actor "
					    		+ "ON actor_id=qid WHERE actor_id IN ("+ listToString(actorStrings) +") ORDER BY actor_id";
			    	}
			    	else if (!sexStrings.isEmpty()&&!parentageStrings.isEmpty()){
					    sql = "SELECT actor_id, sex, parentage, " + element.getId() + " FROM VOLEDB.Bin INNER JOIN VOLEDB.Actor "
					    		+ "ON actor_id=qid WHERE (sex IN (" + listToString(sexStrings) + ")) AND (parentage IN (" + listToString(parentageStrings)
					    		+ ")) order by actor_id";
			    	}
			    	
			    	else if (!sexStrings.isEmpty()){
					    sql = "SELECT actor_id, sex, parentage, " + element.getId() + " FROM VOLEDB.Bin INNER JOIN VOLEDB.Actor "
					    		+ "ON actor_id=qid WHERE sex IN ("+ listToString(sexStrings) +") ORDER BY actor_id";
			    	}
			    	
			    	else if (!parentageStrings.isEmpty()){
					    sql = "SELECT actor_id, sex, parentage, " + element.getId() + " FROM VOLEDB.Bin INNER JOIN VOLEDB.Actor "
					    		+ "ON actor_id=qid WHERE parentage IN ("+ listToString(parentageStrings) +") ORDER BY actor_id";
			    	}
		    		binQuery(stmt, writer, element.getId(), element.getText());
	    		}		    	
	    	}	    	
		    //STEP 6: Clean-up environment
			writer.close();
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
	
	private void binQuery(Statement stmt, CSVWriter writer, String behaviorID, String behaviorText) throws SQLException, IOException {
	    ResultSet rs = stmt.executeQuery(sql);
	    if (!rs.next() ) {
	        System.out.println("There is no data here.");
	    }
	    //STEP 5: Extract data from result set
	    while(rs.next()){
	    	//Retrieve by column name
	    	actor_id = rs.getString("actor_id");
	    	sex = rs.getString("sex");
	    	parentage = rs.getString("parentage");
	    	binvalue = rs.getDouble(behaviorID);
			dataKey = actor_id + "," + sex + "," + parentage + "," + behaviorText + ",";
			//Enter values into CSV
			if (currentKey.equals("init")){
				currentKey=dataKey;
			}
			else if (!currentKey.equals(dataKey)){
				voleData.trimToSize();
				binSizeFunction();
				truncateDecimal(alteredVoleData);
				String[] entries = {currentKey + alteredVoleData.toString().replace('[',' ').replace(']',' ')};
			    writer.writeNext(entries);
			    voleData.clear();
			    alteredVoleData.clear();
			    currentKey=dataKey;
			}
			voleData.add(binvalue);
			if (rs.isLast()){
				voleData.trimToSize();
				binSizeFunction();
				truncateDecimal(alteredVoleData);
				String[] entries = {currentKey + alteredVoleData.toString().replace('[',' ').replace(']',' ')};
			    writer.writeNext(entries);
			    voleData.clear();
			    alteredVoleData.clear();
			}
	    }
	    currentKey="init";
	    voleData.clear();
	    rs.close();
	}
	
	private void binSizeFunction() {
		int newArraySize = voleData.size()/binSize;
		if (voleData.size()%binSize!=0){
			newArraySize++;
		}
		for (int i=0; i<newArraySize; i++){
			int position = i*binSize;
			alteredVoleData.add(0.0);
			for (int j=0; (j<binSize)&&(position+j<voleData.size()); j++){
				alteredVoleData.set(i, alteredVoleData.get(i)+voleData.get(position+j));
			}
		}
	}
	
	private void truncateDecimal(ArrayList<Double> list){
		for (int i=0; i<list.size(); i++){
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.CEILING);
			double datum = Double.parseDouble(df.format(list.get(i)));
			list.set(i, datum);
		}
	}
}
