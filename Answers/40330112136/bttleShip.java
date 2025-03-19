import java.util.Scanner;

public class bttleShip {
    static Scanner input = new Scanner(System.in);

    

    public static void main(String[] args) {
        AttackPlayer playerAttack = new AttackPlayer();
        AttackComputer computerAttack = new AttackComputer();
        InitializeGrid initialize = new InitializeGrid();
        IsGameOver gameOver = new IsGameOver();
        PrintGrid print = new PrintGrid();
        System.out.println("enter the size of board (10 - 15 - 20)");
        System.out.println("pay attention !!");
        System.out.println("size of ships for each size of board : ");
        System.out.println("size of board : 10x10 ==> size of ships : {2, 2, 3, 4, 5}");
        System.out.println("size of board : 15x15 ==> size of ships : {2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}");
        System.out.println("size of board : 20x20 ==> size of ships : {2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6}");
        System.out.print("choose : ");
        int gridSize = 0;
        boolean boolgrid = false;
        while (!boolgrid) {
            try {
                gridSize = input.nextInt();
                boolgrid = true;
                if (gridSize != 10 && gridSize != 15 && gridSize != 20) {
                    boolgrid = false;
                    System.out.print("choose a number of this list (10 - 15 - 20) : ");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.print("Invalid input!! (enter integer) : ");
                input.next();
            }
        }
            
        char[][] player1Grid = new char[gridSize][gridSize];
        char[][] player2Grid = new char[gridSize][gridSize];
        char[][] player1TrackingGrid = new char[gridSize][gridSize];
        char[][] player2TrackingGrid = new char[gridSize][gridSize];


        
        initialize.initialize(player1TrackingGrid, gridSize);
        initialize.initialize(player2TrackingGrid, gridSize);

        // PrintGrid.pringGrid(player1Grid, gridSize);
        // PrintGrid.pringGrid(player2Grid, gridSize);

        boolean bool3 = false;
        String isPlayAI = "";
        System.out.print("do you want to play whit computer(1) or human(2) : ");
        while (!bool3) {
            isPlayAI = input.next();
            bool3 = true;
            if (!isPlayAI.equals("1") && !isPlayAI.equals("2")) {
                bool3 = false;
                System.out.print("Invalid input!! try again (enter '1' or '2') : ");
            }
        }

        playerAttack.setAttack(gridSize);
        if (isPlayAI.equals("2")) {
            initialize.initialize(player1Grid, gridSize);
            boolean bool = false;
            String choose = "";
            System.out.print("\"player 1 ==> \"choose wheter to manually(m) arrange the ships or randomly(r) : ");
            do {
                choose = input.next();
                if (choose.equals("m") || choose.equals("r"))
                    bool = true;
                else 
                    System.out.print("Invalid input!! (enter \"m\" or \"r\") : ");
            } while (!bool);
            if (choose.equals("m")) {        
                print.pringGrid(player1Grid, gridSize);
                for (int i=0; i<5; i++) {
                    initialize.placeShipManually(player1Grid, gridSize);
                    print.pringGrid(player1Grid, gridSize);
                }
            }
            else if (choose.equals("r"))
                initialize.placeShipsRandomly(player1Grid, gridSize);
            
            
            initialize.initialize(player2Grid, gridSize);
            bool = false;
            System.out.print("\"player 2 ==>\" choose wheter to manually(m) arrange the ships or randomly(r) : ");
            do {
                choose = input.next();
                if (choose.equals("m") || choose.equals("r"))
                    bool = true;
                else
                    System.out.print("Invalid input!! (enter \"m\" or \"r\") : ");
            } while (!bool);
            if (choose.equals("m")) {
                print.pringGrid(player2Grid, gridSize);
                for (int i=0; i<5; i++) {
                    initialize.placeShipManually(player2Grid, gridSize);
                    print.pringGrid(player2Grid, gridSize);
                }
            }
            else if (choose.equals("r"))
                initialize.placeShipsRandomly(player2Grid, gridSize);
            
            boolean player1Turn = true;

            while (!gameOver.isGameOver(player1Grid, player2Grid, gridSize)) {
                if (player1Turn) {
                    System.out.println("Player 1's turn : ");
                    print.pringGrid(player2TrackingGrid, gridSize);
                    playerAttack.kindOfAttackPlayer(player1Grid, player2TrackingGrid, gridSize, 1);
                }
                else {
                    System.out.println("player 2's turn : ");
                    print.pringGrid(player1TrackingGrid, gridSize);
                    playerAttack.kindOfAttackPlayer(player2Grid, player1TrackingGrid, gridSize, 2);
                }
                player1Turn = !player1Turn;
            }
            System.out.println("Game Overrrr!!!");
            if (gameOver.allShipSunk(player1Grid, gridSize))
                System.out.println("player 2 wins!!!!");
            else if (gameOver.allShipSunk(player2Grid, gridSize))
                System.out.println("player 1 wins!!!!");
        }

        else if (isPlayAI.equals("1")) {
            AttackComputer.setAttackComputer(gridSize);
            initialize.initialize(player1Grid, gridSize);
            boolean bool = false;
            String choose = "";
            System.out.print("\"player 1 ==> \"choose wheter to manually(m) arrange the ships or randomly(r) : ");
            do {
                choose = input.next();
                if (choose.equals("m") || choose.equals("r"))
                    bool = true;
                else 
                    System.out.print("Invalid input!! (enter \"m\" or \"r\") : ");
            } while (!bool);
            if (choose.equals("m")) {        
                print.pringGrid(player1Grid, gridSize);
                for (int i=0; i<5; i++) {
                    initialize.placeShipManually(player1Grid, gridSize);
                    print.pringGrid(player1Grid, gridSize);
                }
            }
            else if (choose.equals("r"))
                initialize.placeShipsRandomly(player1Grid, gridSize);
                
            initialize.initialize(player2Grid, gridSize);
            initialize.placeShipsRandomly(player2Grid, gridSize);


            while (!gameOver.isGameOver(player1Grid, player2Grid, gridSize)) {
                System.out.println("Player 1's turn : ");
                print.pringGrid(player1TrackingGrid, gridSize);
                playerAttack.kindOfAttackPlayer(player2Grid, player1TrackingGrid, gridSize, 1);


                System.out.println("player 2's turn : ");
                print.pringGrid(player2TrackingGrid, gridSize);
                computerAttack.kindOfAttackcomputer(player1Grid, player2TrackingGrid, gridSize);
            }
            System.out.println("Game Overrrr!!!");
            if (gameOver.allShipSunk(player1Grid, gridSize))
                System.out.println("player 2 wins!!!!");
            else if (gameOver.allShipSunk(player2Grid, gridSize))
                System.out.println("player 1 wins!!!!");


        }
    }
}