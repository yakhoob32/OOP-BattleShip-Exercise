public class IsGameOver {

    
    public boolean isGameOver(char[][] player1Grid, char[][] player2Grid, int gridSize) {
        int t = 0;
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                if (player1Grid[i][j] == 'S')
                    t++;
            }
        }
        int k = 0;
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                if (player2Grid[i][j] == 'S')
                    k++;
            }
        }
        if (t == 0 || k == 0)
            return true;
        else 
            return false;
    }

    public boolean allShipSunk(char[][] playerGrid, int gridSize) {
        boolean bool = false;
        int t=0;
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                if (playerGrid[i][j] == 'S')
                    t++;
            }
        }
        if (t == 0)
            bool = true;
        return bool;
    }
}
