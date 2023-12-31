
package tictactoe;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Game extends JFrame{
    
    public JPanel table;
    public JButton box[] = new JButton[9], turnImage;
    public ImageIcon xImage, oImage;
    public JLabel title, message;
    boolean circlesTurn = true;
    int gameStatus[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int count = 0;
    
    
    //Crea la ventana de juego
    
     public Game(){
        setSize(615, 720);
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        startComponents();
       
    }
    
    //Agrega los componentes a la ventana
     
    public void startComponents(){
        createTable();
        addBoxes();
        addTitle();
        addText();
        addImage();
    }
    
    
    // Crea el panel de juego
   
    public void createTable(){
        table = new JPanel();
        table.setLayout(null);
        getContentPane().add(table);
    }
    
    //Agrega el titulo del juego
    
    public void addTitle(){
        title = new JLabel();
        title.setText("TIC TAC TOE");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(180 , 10, 250, 30);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 28));
        
        table.add(title);
    }
    
    //Agrega mensaje de turno
    
    public void addText(){
        message = new JLabel();
        message.setText("Turno de: ");
        message.setBounds(0 , 50, 100, 30);
        message.setFont(new Font("Lucida Fax", Font.BOLD, 14));
        
        table.add(message);
    }
    
    //Agrega imagen de turno
    
    public void addImage(){ 
        turnImage = new JButton();
        oImage = new ImageIcon("O.png");
        xImage = new ImageIcon("X.png"); 
        turnImage.setBounds(80, 55, 20, 20);
        turnImage.setEnabled(false);
        turnImage.setIcon(new ImageIcon(oImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        turnImage.setBorderPainted(false);
        table.add(turnImage);  
    }
    
    //Plantilla para crear las casillas
    
    public void createBoxes(int x, int y, int index){
        box[index] = new JButton();
        box[index].setBounds(x,y,200,200);
        playGame(index);
        
        table.add(box[index]);
    }
   
    //Crea las 9 casillas
    
    public void addBoxes(){
        createBoxes(0, 100, 0);
        createBoxes(200, 100, 1);
        createBoxes(400, 100, 2);
        createBoxes(0, 300, 3);
        createBoxes(200, 300, 4);
        createBoxes(400, 300, 5);
        createBoxes(0, 500, 6);
        createBoxes(200, 500, 7);
        createBoxes(400, 500, 8);
    }
    
    //Agrega X, O dependiendo el caso
    
    public void playGame(int boxIndex){
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(circlesTurn){
                    playerO(boxIndex);
                    circlesTurn = false;
                    box[boxIndex].setEnabled(false);
                    turnImage.setIcon(new ImageIcon(xImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
                    
                } else {
                    playerX(boxIndex);
                    circlesTurn = true;   
                    box[boxIndex].setEnabled(false);
                    turnImage.setIcon(new ImageIcon(oImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
                }
            }
        };      
       
       box[boxIndex].addActionListener(click);
    }
    
    //Agrega la O al tablero
    
    public void playerO(int boxIndex){
        oImage = new ImageIcon("O.png");
        box[boxIndex].setIcon(new ImageIcon(oImage.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH)));
        gameStatus[boxIndex] = 1;
        count++;
    }
        
    //Agrega la X al tablero
    
    public void playerX(int boxIndex){
        xImage = new ImageIcon("X.png");
        box[boxIndex].setIcon(new ImageIcon(xImage.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH)));
        gameStatus[boxIndex] = 2;
        count++;
    }
    
    //Comprueba la situacion del juego
    
    public boolean checkBoxes(){
        if(count == 9){
            return false;
        } else if (checkCircle() || checkX()){
            return false;
        } else {
            return true;
        }
    }
    
    
    // Comprueba las posiciones del circulo
    public boolean checkCircle(){
        if (gameStatus[0] == 1 && gameStatus[1] == 1 && gameStatus[2] == 1 ||
            gameStatus[3] == 1 && gameStatus[4] == 1 && gameStatus[5] == 1 ||  
            gameStatus[6] == 1 && gameStatus[7] == 1 && gameStatus[8] == 1 ||
            gameStatus[0] == 1 && gameStatus[3] == 1 && gameStatus[6] == 1 ||
            gameStatus[1] == 1 && gameStatus[4] == 1 && gameStatus[7] == 1 ||
            gameStatus[2] == 1 && gameStatus[5] == 1 && gameStatus[8] == 1 ||
            gameStatus[0] == 1 && gameStatus[4] == 1 && gameStatus[8] == 1 ||
            gameStatus[6] == 1 && gameStatus[4] == 1 && gameStatus[2] == 1){
            return true;
        } else {
            return false;  
        }
    }
    
    //Comprueba las posiciones de la X
    
    public boolean checkX(){
        if (gameStatus[0] == 2 && gameStatus[1] == 2 && gameStatus[2] == 2 ||
            gameStatus[3] == 2 && gameStatus[4] == 2 && gameStatus[5] == 2 ||  
            gameStatus[6] == 2 && gameStatus[7] == 2 && gameStatus[8] == 2 ||
            gameStatus[0] == 2 && gameStatus[3] == 2 && gameStatus[6] == 2 ||
            gameStatus[1] == 2 && gameStatus[4] == 2 && gameStatus[7] == 2 ||
            gameStatus[2] == 2 && gameStatus[5] == 2 && gameStatus[8] == 2 ||
            gameStatus[0] == 2 && gameStatus[4] == 2 && gameStatus[8] == 2 ||
            gameStatus[6] == 2 && gameStatus[4] == 2 && gameStatus[2] == 2){
            return true;
        } else {
            return false;  
        }
    }
    
    //Indica el ganador
    
    public int whoWins(){
       if(checkCircle()){
           return 1;
       } else if(checkX()){
           return 2;
       } else {
           return 3;
       }
    }
    
    //Cierra el juego
    
    public void closeTable(){
        dispose();
    }
}
