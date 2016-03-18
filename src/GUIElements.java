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
    Q704, Q704point1, Q704point2, Q708, Q709, male, female, negative12, negative7,
    exp104, exp10c3, exp10c6, exp113, exp11c1, exp11c3, exp11c5, exp11c6,
    exp11c7, pvb5, pvb7, pvc13, center, stayhide, socialcontact, contactless3,
    contactless5, contactless7, contactless1, contactless2, contactless4, contactless6,
    approach, leave, follow, sniff, mount, compete;
    
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
        gender.add(male);
        gender.add(female); 
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
        behavior.add(center); 
        behavior.add(stayhide); 
        behavior.add(socialcontact); 
        behavior.add(contactless3);
        behavior.add(contactless5);
        behavior.add(contactless7); 
        behavior.add(contactless1); 
        behavior.add(contactless2); 
        behavior.add(contactless4); 
        behavior.add(contactless6);
        behavior.add( approach); 
        behavior.add(leave); 
        behavior.add(follow); 
        behavior.add(sniff); 
        behavior.add(mount); 
        behavior.add(compete);
    }

}
