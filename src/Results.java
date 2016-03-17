import java.util.ArrayList;
import java.util.Date;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Results {
	private String firstname, lastname;
	private Date birthdate;
	
	public Results(String firstname, String lastname, Date birthdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public static ArrayList<TableColumn<Results,?>> getColumn(TableView table) {
		
		int i;
		
		ArrayList<TableColumn<Results,?>> columns = new ArrayList<TableColumn<Results,?>>();
		
		String[] columnNames = {"First Name", "Last Name", "Birthdate"};
		String[] variableNames = {"firstname", "lastname", "birthdate"};
		Integer[] column_width = { 33,33,33 };
		
		i = 0;
		TableColumn<Results, String> firstnameCol = new TableColumn<>(columnNames[i++]);
		TableColumn<Results, String> lastnameCol = new TableColumn<>(columnNames[i++]);
		TableColumn<Results, Date> birthdateCol = new TableColumn<>(columnNames[i++]);
		
		i =0;
		firstnameCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));
		lastnameCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));
		birthdateCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));

		i=0;
		firstnameCol.setCellValueFactory(new PropertyValueFactory<Results, String>(variableNames[i++]));
		lastnameCol.setCellValueFactory(new PropertyValueFactory<Results, String>(variableNames[i++]));
		birthdateCol.setCellValueFactory(new PropertyValueFactory<Results, Date>(variableNames[i++]));
		
		columns.add(firstnameCol);
		columns.add(lastnameCol);
		columns.add(birthdateCol);
		
		return columns;
		
	}
}
