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
    
    private ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
    
    public GUIElements() {
		boxes.add(Q398);
//		Q399 = q399;
//		Q521 = q521;
//		Q522 = q522;
//		Q531 = q531;
//		Q532 = q532;
//		Q573 = q573;
//		Q574 = q574;
//		Q606 = q606;
//		Q607 = q607;
//		Q680 = q680;
//		Q681 = q681;
//		Q685 = q685;
//		Q686 = q686;
//		Q690 = q690;
//		Q691 = q691;
//		Q693point1 = q693point1;
//		Q693point2 = q693point2;
//		Q693point4 = q693point4;
//		Q693point5 = q693point5;
//		Q694 = q694;
//		Q695 = q695;
//		Q696 = q696;
//		Q697 = q697;
//		Q698 = q698;
//		Q699 = q699;
//		Q703 = q703;
//		Q704 = q704;
//		Q704point1 = q704point1;
//		Q704point2 = q704point2;
//		Q708 = q708;
//		Q709 = q709;
//		male;
//		female;
//		negative12;
//		negative7;
//		this.exp104 = exp104;
//		this.exp10c3 = exp10c3;
//		this.exp10c6 = exp10c6;
//		this.exp113 = exp113;
//		this.exp11c1 = exp11c1;
//		this.exp11c3 = exp11c3;
//		this.exp11c5 = exp11c5;
//		this.exp11c6 = exp11c6;
//		this.exp11c7 = exp11c7;
//		this.pvb5 = pvb5;
//		this.pvb7 = pvb7;
//		this.pvc13 = pvc13;
//		this.center = center;
//		this.stayhide = stayhide;
//		this.socialcontact = socialcontact;
//		this.contactless3 = contactless3;
//		this.contactless5 = contactless5;
//		this.contactless7 = contactless7;
//		this.contactless1 = contactless1;
//		this.contactless2 = contactless2;
//		this.contactless4 = contactless4;
//		this.contactless6 = contactless6;
//		this.approach = approach;
//		this.leave = leave;
//		this.follow = follow;
//		this.sniff = sniff;
//		this.mount = mount;
//		this.compete = compete;
    	System.out.println("Contructor Has Run");
	}

//	private CheckBox[] boxes = {Q398, Q399, Q521, Q522, Q531, Q532, Q573, Q574,
//    	    Q606, Q607, Q680, Q681, Q685, Q686, Q690, Q691, Q693point1, Q693point2,
//    	    Q693point4, Q693point5, Q694, Q695, Q696, Q697, Q698, Q699, Q703,
//    	    Q704, Q704point1, Q704point2, Q708, Q709, male, female, negative12, negative7,
//    	    exp104, exp10c3, exp10c6, exp113, exp11c1, exp11c3, exp11c5, exp11c6,
//    	    exp11c7, pvb5, pvb7, pvc13, center, stayhide, socialcontact, contactless3,
//    	    contactless5, contactless7, contactless1, contactless2, contactless4, contactless6,
//    	    approach, leave, follow, sniff, mount, compete};
    
    //When you press the clear button on the GUI this section of code runs
    //Lines 106 and 107 should be printing the same value but instead I get an error and I can't find out why
    @FXML
    private void clearOnAction(ActionEvent event) {
    	System.out.println("Clear");
    	System.out.println(Q398.isSelected());
    	System.out.println(boxes.get(0).isSelected());
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
    private void exportOnAction(ActionEvent event) {
		db.connect();
    }

}
