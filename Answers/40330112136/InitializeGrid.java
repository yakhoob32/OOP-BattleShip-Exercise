import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InitializeGrid extends IsGameOver{
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> size2 = new ArrayList<>();
    public static int[] size1;


    public void initialize(char[][] grid, int gridSize) {
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                grid[i][j] = '~';
            } 
        }
    }

    
    public void placeShipManually(char[][] grid, int gridSize) { // bayad dorost she!!!!!!!!!!!
        if (gridSize == 10) 
            size1 = new int[]{2, 2, 3, 4, 5};
        else if (gridSize == 15)
            size1 = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5};
        else if (gridSize == 20)
            size1 = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 8, 8, 8};
        int sizeOfShip = 0;
        boolean validSize = false;

        do {
            try {
            System.out.print("enter size of the ship : ");
            sizeOfShip = input.nextInt();
            boolean boolsize2 = true;
            int k = 0;
            for (int i=0; i<size2.size(); i++) {
                if (sizeOfShip == size2.get(i))
                    k++;
            }
            int t = 0;
            boolean boolsize1 = true;
            for (int i=0; i<size1.length; i++) {
                if (sizeOfShip == size1[i])
                    t++;
            }
            if (t == 0)
                boolsize1 = false;
            if (t-k == 0)
                boolsize2 = false;
            if (boolsize2 && boolsize1) {
                size2.add(sizeOfShip);
                validSize = true;
            }
            if (!validSize) {
                System.out.println("this size has already been placed or doesn't exist!!");
            }
    
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input!! (enter integer)");
                input.next();
            }
        } while (!validSize);
        


        char position = ' ';
        System.out.print("How should the ship be arranged(horizontally='h' - vertically='v') : ");
        while (position != 'h' && position != 'v') {
            position = input.next().charAt(0);
            if (position != 'h' && position != 'v')
                System.out.print("Invalid input!! (enter \"h\" or \"v\") : ");
        }
        boolean validInput = false;
        String place = "";
        while (!validInput) {
            System.out.print("choose the first place for ship (e.g., A2) : ");
            place = input.next();
            validInput = isValidInput(place, gridSize);

            if (validInput) {
                if (position == 'v' && (Character.getNumericValue(place.charAt(1)) - 1 + sizeOfShip > 10))
                    validInput = false;
                else if (position == 'h' && (place.charAt(0) - 'A' + sizeOfShip > 10))
                    validInput = false;
            }
            if (validInput && !placedOrNot(place, position, sizeOfShip, grid)) {
                validInput = false;
                System.out.println("this place(s) detected whit another ship, try again!!");
            }
            if (!validInput) {
                System.out.println("Invalid input!! try again!! (out of range)");
            }
        }

        int row = place.charAt(0) - 'A';
        int column = Character.getNumericValue(place.charAt(1));

        switch (position) {
            case 'v' -> {
                for (int i=column; i<column+sizeOfShip; i++) {
                    grid[i][row] = 'S';
                }
            }

            case 'h' -> {
                for (int i=row; i<row+sizeOfShip; i++) {
                    grid[column][i] = 'S';
                }
            }
        }
    }


    public void placeShipsRandomly(char[][] grid, int gridSize) {        
    if (gridSize == 10) 
        size1 = new int[]{2, 2, 3, 4, 5};
    else if (gridSize == 15)
        size1 = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5};
    else if (gridSize == 20)
        size1 = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6};
    Random rand = new Random();
    for (int size : size1) { 
        boolean placed = false;
        String str1 = rand.nextBoolean() ? "ofoghy" : "amodi";
        String str2 = rand.nextBoolean() ? "manfi" : "mothbat";
        while (!placed) {
            switch (str1) {
                case "ofoghy" -> {
                    int randRow = rand.nextInt(gridSize);
                    int randColumn = rand.nextInt(gridSize+1 - size);
                    boolean canPlace = true;
                    switch (str2) {
                        case "mothbat" -> {
                            for (int i=0; i<size; i++) {
                                if (grid[randRow][randColumn + i] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=0; i<size; i++) 
                                    grid[randRow][randColumn + i] = 'S';
                                placed = true;
                            }
                        }

                        case "manfi" -> {
                            for (int i=0; i<size; i++) {
                                if (randColumn - i < 0 || grid[randRow][randColumn - i] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=size-1; i>=0; i--) 
                                    grid[randRow][randColumn - i] = 'S';
                                placed = true;
                            }
                        }
                    } 
                }
                case "amodi" -> {
                    int randRow = rand.nextInt(gridSize+1 - size);
                    int randColumn = rand.nextInt(gridSize);
                    boolean canPlace = true;
                    switch (str2) {
                        case "mothbat" -> {
                            for (int i=0; i<size; i++) {
                                if (grid[randRow + i][randColumn] == 'S') {
                                    canPlace = false;
                                    break;
                                } 
                            }
                            if (canPlace) {
                                for (int i=0; i<size; i++) {
                                    grid[randRow + i][randColumn] = 'S';
                                }
                                placed = true;
                            }
                        }
                        case "manfi" -> {
                            for (int i=0; i<size; i++) {
                                if (randRow - i < 0 || grid[randRow - i][randColumn] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=size-1; i>=0; i--) {
                                    grid[randRow - i][randColumn] = 'S';
                                }
                                placed = true;
                            }
                        }
                    }
                }
            }
        }
    }
}


    public boolean isValidInput(String place, int gridSize) {
        boolean bool = false;
        if (place.length() != 2)
            bool =  false;
        if (gridSize == 10)
            bool = (place.charAt(0) >= 'A' && place.charAt(0) <= 'J' && Character.getNumericValue(place.charAt(1)) >= 0 && Character.getNumericValue(place.charAt(1)) <= 9);
        else if (gridSize == 15 &&  place.length() == 3)
            bool = (place.charAt(0) >= 'A' && place.charAt(0) <= 'O' && Character.getNumericValue(place.charAt(1) + place.charAt(2)) >= 0 && Character.getNumericValue(place.charAt(1) + place.charAt(2)) <= 14);
        else if (gridSize == 15 &&  place.length() == 2)
            bool = (place.charAt(0) >= 'A' && place.charAt(0) <= 'O' && Character.getNumericValue(place.charAt(1)) >= 0 && Character.getNumericValue(place.charAt(1)) <= 14);
        else if (gridSize == 20 && place.length() == 3)
            bool = (place.charAt(0) >= 'A' && place.charAt(0) <= 'T' && Character.getNumericValue(place.charAt(1) + place.charAt(2)) >= 0 && Character.getNumericValue(place.charAt(1) + place.charAt(2)) <= 19);
        else if (gridSize == 20 &&  place.length() == 2)
            bool = (place.charAt(0) >= 'A' && place.charAt(0) <= 'T' && Character.getNumericValue(place.charAt(1)) >= 0 && Character.getNumericValue(place.charAt(1)) <= 14);
        return bool;
    }


    public boolean placedOrNot(String place, char pos, int sizeOfShip, char[][] grid) {
        int column = place.charAt(0) - 'A';
        int row = Character.getNumericValue(place.charAt(1)) - 1;
        boolean result = true;
        if (pos == 'h') {
            for (int i=column; i<column+sizeOfShip; i++) {
                if (grid[row][i] == 'S')
                    result =  false;
            }
        }
        else if (pos == 'v') {
            for (int i=row; i<row+sizeOfShip; i++) {
                if (grid[i][column] == 'S')
                    result =  false;
            }
        }
        return result;
        
    }
}
 
