import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class GUIElements {
	static DBConnection db = new DBConnection();
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
    
    private CheckBox[] boxes = {Q398, Q399, Q521, Q522, Q531, Q532, Q573, Q574,
    	    Q606, Q607, Q680, Q681, Q685, Q686, Q690, Q691, Q693point1, Q693point2,
    	    Q693point4, Q693point5, Q694, Q695, Q696, Q697, Q698, Q699, Q703,
    	    Q704, Q704point1, Q704point2, Q708, Q709, male, female, negative12, negative7,
    	    exp104, exp10c3, exp10c6, exp113, exp11c1, exp11c3, exp11c5, exp11c6,
    	    exp11c7, pvb5, pvb7, pvc13, center, stayhide, socialcontact, contactless3,
    	    contactless5, contactless7, contactless1, contactless2, contactless4, contactless6,
    	    approach, leave, follow, sniff, mount, compete};
    
    //When you press the clear button on the GUI this section of code runs
    //Lines 34 and 35 should be printing the same value but instead I get an error and I can't find out why
    @FXML
    void clearOnAction(ActionEvent event) {
    	System.out.println("Clear");
    	System.out.println(Q398.isSelected());
    	System.out.println(boxes[0].isSelected());
//    	for (CheckBox element: boxes) {
//    		System.out.println(element.isSelected());
//    	}
//    	Q398.setSelected(false);
//    	Q399.setSelected(false);
//    	Q521.setSelected(false);
//    	Q522.setSelected(false);
//    	Q531.setSelected(false);
//    	Q532.setSelected(false);
//    	Q573.setSelected(false); 
//    	Q574.setSelected(false);
//        Q606.setSelected(false); 
//        Q607.setSelected(false); 
//        Q680.setSelected(false); 
//        Q681.setSelected(false); 
//        Q685.setSelected(false); 
//        Q686.setSelected(false); 
//        Q690.setSelected(false); 
//        Q691.setSelected(false); 
//        Q693point1.setSelected(false);
//        Q693point2.setSelected(false);
//        Q693point4.setSelected(false); 
//        Q693point5.setSelected(false);
//        Q694.setSelected(false);
//        Q695.setSelected(false);
//        Q696.setSelected(false);
//        Q697.setSelected(false);
//        Q698.setSelected(false); 
//        Q699.setSelected(false); 
//        Q703.setSelected(false);
//        Q704.setSelected(false); 
//        Q704point1.setSelected(false); 
//        Q704point2.setSelected(false); 
//        Q708.setSelected(false); 
//        Q709.setSelected(false); 
//        male.setSelected(false);
//        female.setSelected(false); 
//        negative12.setSelected(false); 
//        negative7.setSelected(false);
//        exp104.setSelected(false); 
//        exp10c3.setSelected(false); 
//        exp10c6.setSelected(false); 
//        exp113.setSelected(false); 
//        exp11c1.setSelected(false); 
//        exp11c3.setSelected(false); 
//        exp11c5.setSelected(false); 
//        exp11c6.setSelected(false);
//        exp11c7.setSelected(false); 
//        pvb5.setSelected(false); 
//        pvb7.setSelected(false); 
//        pvc13.setSelected(false); 
//        center.setSelected(false); 
//        stayhide.setSelected(false); 
//        socialcontact.setSelected(false); 
//        contactless3.setSelected(false);
//        contactless5.setSelected(false);
//        contactless7.setSelected(false); 
//        contactless1.setSelected(false); 
//        contactless2.setSelected(false); 
//        contactless4.setSelected(false); 
//        contactless6.setSelected(false);
//        approach.setSelected(false); 
//        leave.setSelected(false); 
//        follow.setSelected(false); 
//        sniff.setSelected(false); 
//        mount.setSelected(false); 
//        compete.setSelected(false);
    }

    @FXML
    void exportOnAction(ActionEvent event) {
		db.connect();
    }

}
