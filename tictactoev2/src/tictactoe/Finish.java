
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

public class Finish extends JFrame{
    public JButton button;
    public JPanel table;
    public JLabel title, text, tieText;
    public ImageIcon xImage, oImage;
    public JLabel winnerImage;
    int gameContinue = 1;
    int whoWins;
    
    public Finish(int winner){
        whoWins = winner;
        setSize(615, 720);
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        finishComponents();  
        playAgain();
    }
    
    public void finishComponents(){
        createTable();
        addTitle();
        addText();  
        addImage();
        addButton();
    }
    
    public void createTable(){
        table = new JPanel();
        table.setLayout(null);
        getContentPane().add(table);
    }
    
    public void addTitle(){
        title = new JLabel();
        title.setText("JUEGO FINALIZADO");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100 , 10, 400, 40);
        title.setFont(new Font("Lucida Calligraphy", Font.BOLD, 32));
        
        table.add(title);
    }
    
    public void addText(){
        text = new JLabel();
        text.setText("Ganador:");
        text.setBounds(240, 150, 200, 100);
        text.setFont(new Font("Lucida Fax", Font.BOLD, 24));
        
        table.add(text);
    }
    
    public void addImage(){
        
        switch (whoWins) {
            case 1 -> winO();
            case 2 -> winX();
            default -> tie();
        }
    }
    
    public void addButton(){
        button = new JButton();
        button.setText("Jugar otra vez");
        button.setBounds(200,500, 200, 50);
        button.setFont(new Font("Lucida Fax", Font.ITALIC, 16));
        
        table.add(button);
    }
    
    public void winO(){ 
        winnerImage = new JLabel();
        oImage = new ImageIcon("O.png"); 
        winnerImage.setBounds(200, 250, 200, 200);
        winnerImage.setIcon(new ImageIcon(oImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        
        table.add(winnerImage);  
    }
    
    public void winX(){ 
        winnerImage = new JLabel();
        xImage = new ImageIcon("X.png"); 
        winnerImage.setBounds(200, 250, 200, 200);
        winnerImage.setIcon(new ImageIcon(xImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        
        table.add(winnerImage);  
    }
    
    public void tie(){
        tieText = new JLabel();
        tieText.setText("EMPATE");
        tieText.setBounds(230, 200, 200, 200);
        tieText.setFont(new Font("Lucida Fax", Font.BOLD, 30));
        
       table.add(tieText);
    }
    
    public void playAgain(){
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameContinue = 0;
            }
        };
        button.addActionListener(click);
    }
    
}
