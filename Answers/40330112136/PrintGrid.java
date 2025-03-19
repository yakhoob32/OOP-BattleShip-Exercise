public class PrintGrid {

    public void pringGrid(char[][] grid, int gridSize) {
        System.out.print("    A" );
        for (char i='B'; i<'B'+gridSize-1; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
        for (int i=0; i<gridSize; i++) {
            System.out.print(i);
            if (i<=9)
                System.out.print(" ");
            System.out.print("| ");
            for (int j=0; j<gridSize; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" | ");
            }

            System.out.println();
            System.out.print("  ");
            for (int j=0; j<gridSize; j++) {
                System.out.print(" - -");
            }
            System.out.println();
            
        }
        System.out.println();
    }
}
