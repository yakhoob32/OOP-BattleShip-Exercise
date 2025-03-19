import java.util.ArrayList;
import java.util.Random;

public class AttackComputer {
    static Random rand = new Random();
    static int super1AttackComputer = 0;
    static int super2AttackComputer = 0;
    static void setAttackComputer(int gridSize) {
        if (gridSize==10) {
            super1AttackComputer = 2;
            super2AttackComputer = 7;
        }
        else if (gridSize==15) {
            super1AttackComputer = 4;
            super2AttackComputer = 19;
        }
        else if (gridSize==20) {
            super1AttackComputer = 6;
            super2AttackComputer = 35;
        }
    }


    public void kindOfAttackcomputer(char[][] player1Grid, char[][] player2TrackingGrid, int gridSize) {
        int kindOfAttackcomputer = rand.nextInt(8);// 0==> normal attack || 1, 2, 3==> super 1 attack || 4, 5, 6, 7==> super 2 attack
        boolean bool = false;
        if (kindOfAttackcomputer == 0 || bool)
            normalAttackComputer(player1Grid, player2TrackingGrid);
        else if ((kindOfAttackcomputer == 1 || kindOfAttackcomputer == 2 || kindOfAttackcomputer == 3) && super1AttackComputer != 0)
            super1AttackComputer(gridSize, player1Grid, player2TrackingGrid);
        else if ((kindOfAttackcomputer == 4 || kindOfAttackcomputer == 5 || kindOfAttackcomputer == 6 || kindOfAttackcomputer == 7) && super2AttackComputer != 0)
            super2AttackComputer(player1Grid, gridSize, player2TrackingGrid);
        else if (super1AttackComputer == 0)
            super2AttackComputer(player1Grid, gridSize, player2TrackingGrid);
        else if (super2AttackComputer == 0)
            super1AttackComputer(gridSize, player1Grid, player2TrackingGrid);
        else if (super1AttackComputer == 0 && super2AttackComputer == 0)
            normalAttackComputer(player1Grid, player2TrackingGrid);
    }


    public void normalAttackComputer(char[][] player1Grid, char[][] player2TrackingGrid) {
        int row = rand.nextInt(9);
        int column = rand.nextInt(9);
        boolean bool = false;
        if (player1Grid[row][column] == 'S') {
            player1Grid[row][column] = 'X';
            player2TrackingGrid[row][column] = 'X';
            char ch = (char)((char)'A'+column);
            System.out.println("the computer attacked your ship in (" + ch + row + ") place!!");
            System.out.println("another chance ... ... .. .. . .");
            System.out.println();
            System.out.println();
            bool = true;
        }
        else if (player1Grid[row][column] == '~') {
            player2TrackingGrid[row][column] = 'O';
            player1Grid[row][column] = 'O';
            System.out.println("the coputer missed it's attack!!");
        }
        else if (player1Grid[row][column] == 'X' || player1Grid[row][column] == 'O')
            normalAttackComputer(player1Grid, player2TrackingGrid);
        if (bool)
            normalAttackComputer(player1Grid, player2TrackingGrid);
    }


    public void super1AttackComputer(int gridSize, char[][] player1Grid, char[][] player2TrackingGrid) {
        int rc = rand.nextInt(2); // 0==> row || 1==> column
        int row = 0;
        int column = 0;
        ArrayList<Integer> arrRow = new ArrayList<>();
        boolean boolRow = false;
        ArrayList<Integer> arrColumn = new ArrayList<>();
        boolean boolColumn = false;
        if (rc == 0) {
            do {
                row = rand.nextInt(9);                
                boolRow = true;
                for (int i=0; i<arrRow.size(); i++) {
                    if (arrRow.get(i) == row)
                        boolRow = false;
                }
                if (boolRow) {
                    arrRow.add(row);
                }
            } while (!boolRow);
            for (int i=0; i<gridSize; i++) {
                if (player1Grid[row][i] == 'S') {
                    player1Grid[row][i] = 'X';
                    player2TrackingGrid[row][i] = 'X';
                }
                else if (player1Grid[row][i] == '~') {
                    player2TrackingGrid[row][i] = 'O';
                    player1Grid[row][i] = 'O';
                }
            }
            System.out.println("computer attacked to " + row + " (row)!!");
        }
        if (rc == 1) {
            do {
                column = rand.nextInt(9);                
                boolColumn = true;
                for (int i=0; i<arrColumn.size(); i++) {
                    if (arrColumn.get(i) == row)
                        boolColumn = false;
                }
                if (boolColumn) {
                    arrColumn.add(column);
                }
            } while (!boolColumn);
            for (int i=0; i<gridSize; i++) {
                if (player1Grid[i][column] == 'S') {
                    player1Grid[i][column] = 'X';
                    player2TrackingGrid[i][column] = 'X';
                }
                else if (player1Grid[i][column] == '~') {
                    player1Grid[i][column] = 'O';
                    player2TrackingGrid[i][column] = 'O';
                }
            }
            char ch = (char)((char)'A'+column);
            System.out.println("computer attacked to " + ch + " (column)!!");
        }
        super1AttackComputer--;
    }


    public void super2AttackComputer(char[][] player1Grid, int gridSize, char[][] player2TrackingGrid) {
        boolean bool = false;
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                if (player1Grid[i][j] == 'S') {
                    player1Grid[i][j] = 'X';
                    player2TrackingGrid[i][j] = 'X';
                    char ch = (char)((char)'A'+j);
                    System.out.println("the computer attacked to \"" + ch + i + "\" place");
                    bool = true;
                    break;
                }
            }
            if (bool)
                break;
        }
        super2AttackComputer--;
        normalAttackComputer(player1Grid, player2TrackingGrid);
    }
}
