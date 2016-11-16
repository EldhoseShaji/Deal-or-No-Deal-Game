package deal_or_no_deal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * The Controller for deal window 
 * @author ELDHOSE SHAJI
 */
public class DealWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    //Label for displaying the Bankers Offer
    @FXML
    private Label text;
    
    //The Button for deal
    @FXML
    private Button deal;
    
    //The Button for No deal
    @FXML
    private Button noDeal;
    
    /**
     * The on load function to set the bakers offer from logic class
     */
    public void onLoad(){
        text.setText("The Banker is making an offer of : "+LogicClass.bankersOffer);
    }
    
    /**
     * The Button action method for deal;
     * @param event 
     */
    @FXML
    private void handleButtonActionTrue(ActionEvent event) {
       //GameController.deal=true;
        LogicClass.win=LogicClass.bankersOffer;
        Stage stage = (Stage) deal.getScene().getWindow();
        stage.close();
        DEAL_OR_NO_DEAL.showScore();
    }
    
    /**
     * The Button action method for No deal;
     * @param event 
     */
    @FXML
    private void handleButtonActionFalse(ActionEvent event) {
        //GameController.deal=false;
        Stage stage = (Stage) noDeal.getScene().getWindow();
        stage.close();
    }
}
