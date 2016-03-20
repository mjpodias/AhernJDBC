import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class GUIElements {
	private static DBConnection db = new DBConnection();
    @FXML
    private TextField binsize;
    @FXML
    private CheckBox Q398, Q399, Q521, Q522, Q531, Q532, Q573, Q574,
    Q606, Q607, Q680, Q681, Q685, Q686, Q690, Q691, Q693point1, Q693point2,
    Q693point4, Q693point5, Q694, Q695, Q696, Q697, Q698, Q699, Q703,
    Q704, Q704point1, Q704point2, Q708, Q709, m, f, negative12, negative7,
    exp104, exp10c3, exp10c6, exp113, exp11c1, exp11c3, exp11c5, exp11c6,
    exp11c7, pvb5, pvb7, pvc13, center_duration, stay_hide_duration, social_contact_duration, 
    three_contact_duration, five_contact_duration, seven_contact_duration, one_contact_duration, 
    two_contact_duration, four_contact_duration, six_contact_duration, approach_duration, leave_duration, 
    follow_duration, sniff_duration, mount_duration, compete_duration;
    
    private ArrayList<CheckBox> actor = new ArrayList<CheckBox>();
    private ArrayList<CheckBox> gender = new ArrayList<CheckBox>();
    private ArrayList<CheckBox> parentage = new ArrayList<CheckBox>();
    private ArrayList<CheckBox> behavior = new ArrayList<CheckBox>();
    
    @FXML
    private void clearOnAction(ActionEvent event) {
    	System.out.println("Clear");
    	for (CheckBox element: actor) {
    		element.setSelected(false);
    	}
    	for (CheckBox element: gender) {
    		element.setSelected(false);
    	}
    	for (CheckBox element: parentage) {
    		element.setSelected(false);
    	}
    	for (CheckBox element: behavior) {
    		element.setSelected(false);
    	}
    }

    @FXML
    private void exportOnAction(ActionEvent event) {
		db.connect(actor, gender, parentage, behavior, binsize);
    }
    
    public void populate() {
		actor.add(Q398);
		actor.add(Q399);
		actor.add(Q521);
		actor.add(Q522);
		actor.add(Q531);
		actor.add(Q532);
		actor.add(Q573); 
		actor.add(Q574);
		actor.add(Q606); 
		actor.add(Q607); 
		actor.add(Q680); 
        actor.add(Q681); 
        actor.add(Q685); 
        actor.add(Q686); 
        actor.add(Q690); 
        actor.add(Q691); 
        actor.add(Q693point1);
        actor.add(Q693point2);
        actor.add(Q693point4); 
        actor.add(Q693point5);
        actor.add(Q694);
        actor.add(Q695);
        actor.add(Q696);
        actor.add(Q697);
        actor.add(Q698); 
        actor.add(Q699); 
        actor.add(Q703);
        actor.add(Q704); 
        actor.add(Q704point1); 
        actor.add(Q704point2); 
        actor.add(Q708); 
        actor.add(Q709); 
        gender.add(m);
        gender.add(f); 
        parentage.add(negative12); 
        parentage.add(negative7);
        parentage.add(exp104); 
        parentage.add(exp10c3); 
        parentage.add(exp10c6); 
        parentage.add(exp113); 
        parentage.add(exp11c1); 
        parentage.add(exp11c3); 
        parentage.add(exp11c5); 
        parentage.add(exp11c6);
        parentage.add(exp11c7); 
        parentage.add(pvb5); 
        parentage.add(pvb7); 
        parentage.add(pvc13); 
        behavior.add(center_duration); 
        behavior.add(stay_hide_duration); 
        behavior.add(social_contact_duration); 
        behavior.add(three_contact_duration); 
        behavior.add(five_contact_duration); 
        behavior.add(seven_contact_duration); 
        behavior.add(one_contact_duration); 
        behavior.add(two_contact_duration); 
        behavior.add(four_contact_duration); 
        behavior.add(six_contact_duration);
        behavior.add(approach_duration); 
        behavior.add(leave_duration); 
        behavior.add(follow_duration); 
        behavior.add(sniff_duration); 
        behavior.add(mount_duration); 
        behavior.add(compete_duration);
    }

}
