import java.util.Scanner;

public class AttackPlayer extends InitializeGrid{
    static Scanner input = new Scanner(System.in);
    static String attackPlace = "";
    public static int super1AttackP1 = 0;
    public static int super2AttackP1 = 0;
    public static int super1AttackP2 = 0;
    public static int super2AttackP2 = 0;

    public void setAttack(int gridSize) {       
        if (gridSize == 10) {
            super1AttackP1 = 2; // attack in a row or a column (player1)
            super2AttackP1 = 1; // scan 2 row or 2 column befor attack (player1)
            super1AttackP2 = 2;
            super2AttackP2 = 1;
        }
        else if (gridSize == 15) {
            super1AttackP1 = 4;
            super2AttackP1 = 2;
            super1AttackP2 = 4;
            super2AttackP2 = 2;
        }
        else if (gridSize == 20) {
            super1AttackP1 = 6;
            super2AttackP1 = 4;
            super1AttackP2 = 6;
            super2AttackP2 = 4;
        }
    }


    public void kindOfAttackPlayer(char[][] player1Grid, char[][] player2TrackingGrid, int gridSize, int playerNumber) {
        boolean bool1 = false;
        int choose = 0;
        while (!bool1) {
            try {
                System.out.println("1. normal attack.");
                if (super1AttackP1 != 0 && playerNumber == 1)
                    System.out.println("2. super attack 1 \"attack in a row or a column\" (you have " + super1AttackP1 + " chance).");
                else if (super1AttackP1 == 0 && playerNumber == 1)
                    System.out.println("2. super attack 1 \"attack in a row or a column\" (you have no chance).");
                if (super2AttackP1 != 0 && playerNumber == 1)
                    System.out.println("3. super attack 2 \"scan 2 row or column befor a normal attck\" (you have " + super2AttackP1 + " chance).");                
                else if (super2AttackP1 == 0 && playerNumber == 1)
                    System.out.println("3. super attack 2 \"scan 2 row or column befor a normal attck\" (you have no chance).");


                else if (super1AttackP2 != 0 && playerNumber == 2)
                    System.out.println("2. super attack 1 \"attack in a row or a column\" (you have " + super1AttackP2 + " chance).");
                else if (super1AttackP2 == 0 && playerNumber == 2)
                    System.out.println("2. super attack 1 \"attack in a row or a column\" (you have no chance).");
                if (super2AttackP2 != 0 && playerNumber == 2)
                    System.out.println("3. super attack 2 \"scan 2 row or column befor a normal attck\" (you have " + super2AttackP2 + " chance).");                
                else if (super2AttackP2 == 0 && playerNumber == 2)
                    System.out.println("3. super attack 2 \"scan 2 row or column befor a normal attck\" (you have no chance).");
                System.out.println();
                System.out.print("choose a kind of attack : ");
                choose = input.nextInt();
                bool1 = true;
                if (choose != 1 && choose != 2 && choose != 3) {
                    bool1 = false;
                    System.out.println("choose a number of this list (1 - 2 - 3)");
                }
                if (choose == 2 && super1AttackP1 == 0 && playerNumber == 1) {
                    System.out.println("you can't choose \"super attack 1\"!! choose somthing else");
                    bool1 = false;
                }
                else if (choose == 3 && super2AttackP1 == 0 && playerNumber == 1) {
                    System.out.println("you can't choose \"super attack 2\"!! choose somthing else");
                    bool1 = false;
                }

                if (choose == 2 && super1AttackP2 == 0 && playerNumber == 2) {
                    System.out.println("you can't choose \"super attack 1\"!! choose somthing else");
                    bool1 = false;
                }
                else if (choose == 3 && super2AttackP2 == 0 && playerNumber == 2) {
                    System.out.println("you can't choose \"super attack 2\"!! choose somthing else");
                    bool1 = false;
                }

            }
            catch (Exception e) {
                System.out.println("invalid input!! (enter integer)");
                input.next();
            }
        }
        switch (choose) {
            case 1 -> {
                normalAttackPlayer(player1Grid, player2TrackingGrid, gridSize);
            }
            case 2 -> {
                super1AttackPlayer(player1Grid, player2TrackingGrid, gridSize);
                if (playerNumber == 1)
                    super1AttackP1--;
                else if (playerNumber == 2)
                    super1AttackP2--;
            }
            case 3 -> {
                super2AttackPlayer(player1Grid, player2TrackingGrid, gridSize);
                if (playerNumber == 1)
                    super2AttackP1--;
                else if (playerNumber == 2)
                    super2AttackP2--;
                
            }

        }
    }
    

    public void normalAttackPlayer(char[][] playerGrid, char[][] playerTrackingGrid, int gridSize) {
        System.out.print("choose a place (e.g., A2) : ");
        boolean bool1 = false;
        while (!bool1) {
            attackPlace = input.next();
            boolean validInput = isValidInput(attackPlace, gridSize);
            int row = 0;
            if (gridSize == 10 || attackPlace.length() == 2)            
                row = Character.getNumericValue(attackPlace.charAt(1));
            else if (attackPlace.length() == 3)
                row = Character.getNumericValue(attackPlace.charAt(1) + attackPlace.charAt(2));
            int column = attackPlace.charAt(0) - 'A';
            if (!validInput)
                System.out.print("invalid input!! try again (e.g., A2) : ");
            else if (playerTrackingGrid[row][column] == 'X' || playerTrackingGrid[row][column] == 'O')
                System.out.print("Invalid input (you have already attacked this location), try again!! : ");
            else 
                bool1 = true;
        }
        int row = 0;
        if (gridSize == 10 || attackPlace.length() == 2)
            row = Character.getNumericValue(attackPlace.charAt(1));
        else if (attackPlace.length() == 3)
            row = Character.getNumericValue(attackPlace.charAt(1) + attackPlace.charAt(2));
        int column = attackPlace.charAt(0) - 'A';
        boolean isHit = false;
        if (playerGrid[row][column] == 'S') {
            System.out.println("Hit!!");
            playerGrid[row][column] = 'X';
            playerTrackingGrid[row][column] = 'X';
            isHit = true;
        }
        else {
            System.out.println("Missed!!");
            playerTrackingGrid[row][column] = 'O';
        }
        if (isHit && !isGameOver(playerGrid, playerGrid, gridSize))
            normalAttackPlayer(playerGrid, playerTrackingGrid, gridSize);
    }


    public void super1AttackPlayer(char[][] player1Grid, char[][] player2TrackingGrid, int gridSize) {
        String rc = "";
        String rowS = "";
        String columnS = "";
        boolean bool1 = false;
        System.out.print("you want to attack to a row(r) or column(c) : ");
        do {
            rc = input.next();
            if (rc.equals("r") || rc.equals("c"))
                bool1 = true;
            else
                System.out.print("Invalid input!! (enter \"r\" or \"c\") : ");
        } while (!bool1);
        boolean bool2 = false;
        switch (rc) {
            case "r" -> {
                if (gridSize == 10)
                    System.out.print("enter a row to attack it's all places(0-9) : ");
                else if (gridSize == 15)
                    System.out.print("enter a row to attack it's all places(0-14) : ");
                else if (gridSize == 20)
                    System.out.print("enter a row to attack it's all places(0-19) : ");
                do {
                    rowS = input.next();
                    if (gridSize == 10 || rowS.length() == 1) {
                        if (Character.getNumericValue(rowS.charAt(0)) >= 0 && Character.getNumericValue(rowS.charAt(0)) <=9)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-9) : ");
                    }
                    if (gridSize == 15 && rowS.length() == 2) {
                        if (Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1)) >= 0 && Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1)) <=14)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-14) : ");
                    }
                    if (gridSize == 20 && rowS.length() == 2) {
                        if (Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1)) >= 0 && Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1)) <=19)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-19) : ");
                    }
                } while (!bool2);
                int row = 0;
                if (gridSize == 10 || rowS.length()==1)
                    row = Character.getNumericValue(rowS.charAt(0));
                else if (gridSize != 10 && rowS.length()==2)
                    row = Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1));
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[row][i] == 'S') {
                        player1Grid[row][i] = 'X';
                        player2TrackingGrid[row][i] = 'X';
                    }
                    else if (player1Grid[row][i] == '~')
                        player2TrackingGrid[row][i] = 'O';
                }
            }
            case "c" -> {
                if (gridSize == 10)
                    System.out.print("enter a column to attack it's all places(A-J) : ");
                else if (gridSize == 15)
                    System.out.print("enter a column to attack it's all places(A-O) : ");
                else if (gridSize == 20)
                    System.out.print("enter a column to attack it's all places(A-T) : ");
                do {
                    columnS = input.next();
                    if (gridSize == 10) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=9)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(A-J) : ");
                    }
                    if (gridSize == 15) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=14)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(A-O) : ");
                    }
                    if (gridSize == 20) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=19)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(A-T) : ");
                    }
                } while (!bool2);
                int column = columnS.charAt(0) - 'A';
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[i][column] == 'S') {
                        player1Grid[i][column] = 'X';
                        player2TrackingGrid[i][column] = 'X';
                    }
                    else if (player1Grid[i][column] == '~')
                        player2TrackingGrid[i][column] = 'O';
                }
            }
        }
    }


    public void super2AttackPlayer(char[][] player1Grid, char[][] player2TrackingGrid, int gridSize) {
        String rc = "";
        String rowS = "";
        String columnS = "";
        boolean bool1 = false;
        System.out.print("you want to scan a row(r) or column(c) : ");
        do {
            rc = input.next();
            if (rc.equals("r") || rc.equals("c"))
                bool1 = true;
            else
                System.out.print("Invalid input!! (enter \"r\" or \"c\") : ");
        } while (!bool1);
        boolean bool2 = false;
        switch (rc) {
            case "r" -> {
                if (gridSize == 10)
                    System.out.print("enter a row to attack it's all places(0-8) : ");
                else if (gridSize == 15)
                    System.out.print("enter a row to attack it's all places(0-13) : ");
                else if (gridSize == 20)
                    System.out.print("enter a row to attack it's all places(0-18) : ");
                do {
                    rowS = input.next();
                    if (gridSize == 10 || rowS.length()==1) {
                        if (Character.getNumericValue(rowS.charAt(0)) >= 0 && Character.getNumericValue(rowS.charAt(0)) <=8)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-8) : ");
                    }
                    if (gridSize == 15 && rowS.length()==2) {
                        // rowS = input.next();
                        if (Character.getNumericValue(rowS.charAt(0)+rowS.charAt(1)) >= 0 && Character.getNumericValue(rowS.charAt(0)+rowS.charAt(1)) <=13)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-13) : ");
                    }
                    if (gridSize == 20 && rowS.length()==2) {
                        // rowS = input.next();
                        if (Character.getNumericValue(rowS.charAt(0)+rowS.charAt(1)) >= 0 && Character.getNumericValue(rowS.charAt(0)+rowS.charAt(1)) <=18)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an integer in range(0-18) : ");
                    }
                } while (!bool2);
                int row = 0;
                if (gridSize == 10 || rowS.length()==1)
                    row = Character.getNumericValue(rowS.charAt(0));
                else if (gridSize != 10 || rowS.length()==2)
                    row = Character.getNumericValue(rowS.charAt(0) + rowS.charAt(1));
                char ch = ' ';
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[row][i] == 'S') {
                        ch = (char) ((char)'A'+i);
                        System.out.println("there is a ship in (" +ch + ", " + row + ")");
                    }
                }
                row++;
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[row][i] == 'S') {
                        ch = (char) ((char)'A'+i);
                        System.out.println("there is a ship in (" +ch + ", " + row + ")");
                    }
                }
            }
            case "c" -> {
                if (gridSize == 10)
                    System.out.print("enter a column to scan it's all places(A-I) : ");
                else if (gridSize == 15)
                    System.out.print("enter a column to scan it's all places(A-N) : ");
                else if (gridSize == 20)
                    System.out.print("enter a column to scan it's all places(A-S) : ");
                do {
                    columnS = input.next();
                    if (gridSize == 10) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=8)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an character in range(A-I) : ");
                    }
                    if (gridSize == 15) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=13)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an character in range(A-N) : ");
                    }
                    if (gridSize == 20) {
                        if (columnS.charAt(0)-'A' >= 0 && columnS.charAt(0)-'A' <=18)
                            bool2 = true;
                        else 
                            System.out.print("Invalid input!! enter an character in range(A-S) : ");
                    }
                } while (!bool2);
                int column = columnS.charAt(0) - 'A';
                char ch = ' ';
                int t = 0;
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[i][column] == 'S') {
                        ch = (char) ((char)'A'+column);
                        System.out.println("there is a ship in (" + ch + ", " + i +")");
                        t++;
                    }
                }
                column++;
                for (int i=0; i<gridSize; i++) {
                    if (player1Grid[i][column] == 'S') {
                        ch = (char) ((char)'A'+column);
                        System.out.println("there is a ship in (" + ch + ", " + i +")");
                        t++;
                    }
                }
                if (t==0)
                    System.out.println("there wasn' any ship! X-X !");
            }
        }
        // normalAttackPlayer(player1Grid, player2TrackingGrid, gridSize);
    }
}
