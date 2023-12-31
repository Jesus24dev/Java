
package tictactoe;

public class Main {
    public static void main(String[] args) {
       
    int nextGame;
        int winner;
        
        do {
            Game ticTacToe = new Game();
            // Comprueba el estado del juego
            while (ticTacToe.checkBoxes()) {
                ticTacToe.setVisible(true);
            } 
            
            ticTacToe.closeTable();
            winner = ticTacToe.whoWins();
            Finish finish = new Finish(winner);
            finish.setVisible(true);
     
            for (int i = 0; i < 9; i++) {
                ticTacToe.gameStatus[i] = 0;
            }
           
            // Espera a que el botón sea presionado
            while (finish.gameContinue == 1) {
                try {
                    Thread.sleep(100); // Evita un uso intensivo de la CPU
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            finish.dispose(); // Cierra la ventana Finish antes de iniciar un nuevo juego
            nextGame = finish.gameContinue;
           
        } while (nextGame == 0);
       
    }
}
