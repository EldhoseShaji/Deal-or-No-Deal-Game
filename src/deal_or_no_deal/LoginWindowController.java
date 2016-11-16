package deal_or_no_deal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 * Controller class for login window
 * @author ELDHOSE SHAJI
 */
public class LoginWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Text Field for name;
    @FXML
    private TextField Name;
    
    //Radio button to select the theme
    @FXML
    RadioButton original;
    
    @FXML
    RadioButton pokemon;
    
    @FXML
    RadioButton cars;
    
    //Choice box for the currency
    @FXML
    ChoiceBox cb;
    
    /**
     * On load method
     */
    public void onLoad(){
        
        ToggleGroup theme = new ToggleGroup();
        original.setToggleGroup(theme);
        pokemon.setToggleGroup(theme);
        cars.setToggleGroup(theme);
        
        cb.getItems().addAll("USD", "CAD");
        cb.getSelectionModel().select(0);
        
        pokemon.setOnAction(e -> {
            LogicClass.theme="pokemon";
        });
        cars.setOnAction(e -> {
            LogicClass.theme="cars";
        });
    }
    
    
    @FXML
    public void playGame() {
        
        LogicClass.userName = Name.getText();
        
        DEAL_OR_NO_DEAL.showGame();
        
    }
    
}
