package deal_or_no_deal;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * controller class for score board
 * @author ELDHOSE SHAJI
 */
public class ScoreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Label to store the amount thats won
    @FXML
    Label win;
    //Labels for High scores
    @FXML
    Label highScore1;
    @FXML
    Label highScore2;
    @FXML
    Label highScore3;
    @FXML
    Label highScore4;
    @FXML
    Label highScore5;
    @FXML
    Label highScore6;
    @FXML
    Label highScore7;
    @FXML
    Label highScore8;
    @FXML
    Label highScore9;
    @FXML
    Label highScore10;
    
    //array to store strings
    String[][] scores = new String[10][3];
    
    public void onLoad(){
        //Setting up win amounts
        win.setText("Congrats "+LogicClass.userName+"your win is :"+LogicClass.win);
        //Reading high scores from file
        try{
            File file = new File("highScore.txt");
            if (!file.exists())
            {
                throw new FileNotFoundException("File does not exist");
            }
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            
            String sample;
            
            int row = 0;
            
            while((sample=br.readLine())!= null){
             
             String[] parts = sample.trim().split(":");
             
             for(int col = 0; col<parts.length;col++){
                 scores[row][col] = parts[col];
             }
             row++;
             
            }
            br.close();
            
            //Adding any new high score amount if any
            if((LogicClass.win) > (Integer.parseInt(scores[8][2]))){
                scores[8][1]=(""+LogicClass.userName);
                scores[8][2]=(""+LogicClass.win);
            }
            
            //Rearranging array
            for (int i=0;i<10;i++){
                for(int j=0;j<9;j++){
                    if ((Integer.parseInt(scores[j][2])) < (Integer.parseInt(scores[j+1][2])) ){
                        String[] temp=new String[2];
                        temp[0] = scores[j][1];
                        temp[1] = scores[j][2];
                        scores[j][1] = scores[j+1][1];
                        scores[j][2] = scores[j+1][2];
                        scores[j+1][1] = temp[0];
                        scores[j+1][2] = temp[1];
                    }
            }
            }
                //Writing new high score to file
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for(int l=0;l<10;l++){
                    for(int m=0;m<3;m++){
                        bw.write(scores[l][m]+":");
                    }
                    bw.newLine();
                }
                bw.close();
            
        }
        catch(IOException ie){
            System.out.println("Failed");
        }
            highScore1.setText(""+scores[0][0]+". "+scores[0][1]+"  "+scores[0][2]);
            highScore2.setText(""+scores[1][0]+". "+scores[1][1]+"  "+scores[1][2]);
            highScore3.setText(""+scores[2][0]+". "+scores[2][1]+"  "+scores[2][2]);
            highScore4.setText(""+scores[3][0]+". "+scores[3][1]+"  "+scores[3][2]);
            highScore5.setText(""+scores[4][0]+". "+scores[4][1]+"  "+scores[4][2]);
            highScore6.setText(""+scores[5][0]+". "+scores[5][1]+"  "+scores[5][2]);
            highScore7.setText(""+scores[6][0]+". "+scores[6][1]+"  "+scores[6][2]);
            highScore8.setText(""+scores[7][0]+". "+scores[7][1]+"  "+scores[7][2]);
            highScore9.setText(""+scores[8][0]+". "+scores[8][1]+"  "+scores[8][2]);
            highScore10.setText(""+scores[9][0]+". "+scores[9][1]+"  "+scores[9][2]);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
