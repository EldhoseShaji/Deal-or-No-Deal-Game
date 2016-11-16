package deal_or_no_deal;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * The Controller class for the game window 
 * @author ELDHOSE SHAJI
 */
public class GameController implements Initializable {

    //The Label to display the name
    @FXML
    private Label name;
    
    //The Label for Game information
    @FXML
    private Label Text;
    
    //The button for user chosen case
    @FXML
    private Button MyBreifcase;
    
    //The Diiferent ImageViews for different amounts of money
    @FXML
    private ImageView dollar01;
    
    @FXML
    private ImageView dollar1;
    
    @FXML
    private ImageView dollar5;
    
    @FXML
    private ImageView dollar10;
    
    @FXML
    private ImageView dollar25;
    
    @FXML
    private ImageView dollar50;
    
    @FXML
    private ImageView dollar75;
    
    @FXML
    private ImageView dollar100;
    
    @FXML
    private ImageView dollar200;
    
    @FXML
    private ImageView dollar300;
    
    @FXML
    private ImageView dollar400;
    
    @FXML
    private ImageView dollar500;
    
    @FXML
    private ImageView dollar750;
    
    @FXML
    private ImageView dollar1000;
    
    @FXML
    private ImageView dollar5000;
    
    @FXML
    private ImageView dollar10000;
    
    @FXML
    private ImageView dollar25000;
    
    @FXML
    private ImageView dollar50000;
    
    @FXML
    private ImageView dollar75000;
    
    @FXML
    private ImageView dollar100000;
    
    @FXML
    private ImageView dollar200000;
    
    @FXML
    private ImageView dollar300000;
    
    @FXML
    private ImageView dollar400000;
    
    @FXML
    private ImageView dollar500000;
    
    @FXML
    private ImageView dollar750000;
    
    @FXML
    private ImageView dollar1000000;
    
    //The button for store information of last clicked button
    @FXML
    private Button ButtonClicked;
    
    //The anchor pane to set theme
    @FXML
    private AnchorPane pane;
    
    //the integer to count number of turns
    int count = 0;
    //The integer to store the array index
    int ArrayIndex = 0;
    //The store the box number of last clicked box
    String ClickedValue;
    //The list to store all the amounts
    List<Double> AmountList = new ArrayList<Double>();
    //the list to store amounts that are left
    List<Double> AmountLeft;
    int BankersOffer = 0;
    //The variable to store the avreage of amounts left 
    int average = 0;
    //The variable to count the number of offers
    int offerCount = 0;
    //The variable to count the boxes left for next offer
    int boxCount=0;
    
    /**
     * On load method
     */
    public void onLoad(){
        
        //Setting up user name
        name.setText("Hi "+LogicClass.userName+",");
        //calling the theme change method
        themeChange();
        
        //The array to store money
        double money[]={0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
        
        //Adding the amounts to the list
        for(int i=0;i<26;i++){
            AmountList.add(money[i]);
        }
        //Intilizing the amont left list
        AmountLeft = new ArrayList<Double>(AmountList);
        //Randomising the amounts
        Collections.shuffle(AmountList);
    }
     /**
      * The method to handle click on any briefcase
      * @param event 
      */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //incrementing the number of turns
        count++;
        //setting up the button clicked
        ButtonClicked = (Button) event.getSource();
        
        //setting up user box if count is one
        if (count == 1){
        
        ClickedValue=ButtonClicked.getText();
        
        MyBreifcase.setText(ClickedValue);
                
        ButtonClicked.setDisable(true);
        
        ButtonClicked.setOpacity(0.0);
        
        
        
        Text.setText("Now Choose 6 Boxes to open ");
        boxCount=6;
        }
        else {
            
            //randomising the money to each clicked box
            double money = AmountList.get(count-1);
            ButtonClicked.setText(""+money);
            
            boxCount-=1;
            Text.setText("Now Choose "+boxCount+" Boxes to open");
            
            ButtonClicked.setGraphic(null);
            
            ButtonClicked.setDisable(true);
        
            ButtonClicked.setOpacity(0.5);
            
            int amount = AmountList.get(count-1).intValue();
            
            String s = "dollar"+amount;
            
            //switch to remove the amount in box from imageview
            switch (s) {
            case "dollar0":  dollar01.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar1":  dollar1.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar5":  dollar5.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar10":  dollar10.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;    
            case "dollar25":  dollar25.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break; 
            case "dollar50":  dollar50.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar75":  dollar75.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar100":  dollar100.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar200":  dollar200.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar300":  dollar300.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar400":  dollar400.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar500":  dollar500.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar750":  dollar750.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar1000":  dollar1000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar5000":  dollar5000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar10000":  dollar10000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar25000":  dollar25000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar50000":  dollar50000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar75000":  dollar75000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar100000":  dollar100000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar200000":  dollar200000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar300000":  dollar300000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar400000":  dollar400000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar500000":  dollar500000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar750000":  dollar750000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            case "dollar1000000":  dollar1000000.setOpacity(0.5);
                             AmountLeft.remove(money);
                     break;
            default: 
                     break;
        }
            
            if (count == 7){
                boxCount=5;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                //method call to calculate bankers offer based on number of offers yet displayed
                offer(15);
            }
            else if (count == 12){
                boxCount=4;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(24); 
            }  
            else if (count == 16){
                boxCount=3;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(34); 
            }
            else if (count == 19){
                boxCount=2;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(43); 
            }
            else if (count == 21){
                boxCount=1;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(53); 
            }
            else if (count == 22){
                boxCount=1;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(62); 
            }
            else if (count == 23){
                boxCount=1;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(72); 
            }
            else if (count == 24){
                boxCount=1;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(81); 
            }
            else if (count == 25){
                boxCount=1;
                Text.setText("Now Choose "+boxCount+" Boxes to open");
                offer(91); 
            }
            else if (count == 26){
                LogicClass.win=AmountList.get(0).intValue();
                //calling score card
                DEAL_OR_NO_DEAL.showScore();
            }
            
        }
        
    }
    
    /**
     * Theme change method
     */
    @FXML
    private void themeChange(){
        
        //calling specific css according to the radio button chosen
        
        if (LogicClass.theme=="pokemon"){
          Scene scene = (Scene) pane.getScene();
          scene.getStylesheets().addAll(this.getClass().getResource("pokemon.css").toExternalForm());  
        }
        else if(LogicClass.theme=="cars"){
            Scene scene = (Scene) pane.getScene();
          scene.getStylesheets().addAll(this.getClass().getResource("cars.css").toExternalForm());
        }
        else {
            Scene scene = (Scene) pane.getScene();
          scene.getStylesheets().addAll(this.getClass().getResource("original.css").toExternalForm());
        }
        
    }
    
    /**
     * The method to calculate bankers offer
     * @param n The % depending on number of times offer has been placed
     */
    @FXML
    private void offer(int n){
            average=0;
                
            for (int j=0;j<AmountLeft.size();j++){
                average+=AmountLeft.get(j);
            }
            average/=AmountLeft.size();

            BankersOffer = average*n/100;

            LogicClass.bankersOffer=BankersOffer;
            DEAL_OR_NO_DEAL.showDeal();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
