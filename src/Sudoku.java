import java.util.Arrays;

public class Sudoku {
    private int[][] empty;
    private int[][] game;

    public Sudoku(int[][] game) {
        this.game = game;
        this.empty = game;
    }

    public Sudoku() {
        this.game = new int[9][9];
        this.empty = new int[9][9];
    }

    public void startOver() {
        this.game = this.empty;
    }

    public void insert(int row, int col, int value) {
        this.game[row][col] = value;
    }

    public void remove(int row, int col){
        this.game[row][col] = 0;
    }

    public int getNum(int row, int col){
        return this.game[row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String topBorder = "┏━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━━┓\n";
        String midBorder = "┣━━━━━━━━━╋━━━━━━━━━╋━━━━━━━━━┫\n";
        String bottomBorder = "┗━━━━━━━━━┻━━━━━━━━━┻━━━━━━━━━┛\n";
        String rowSeparator = "┃";

        sb.append(topBorder);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append((j % 3 == 0) ? rowSeparator + " " : " ");
                sb.append(this.game[i][j] == 0 ? "." : this.game[i][j]);
                sb.append(" ");
            }
            sb.append(rowSeparator).append("\n");
            if (i == 8) {
                sb.append(bottomBorder);
            } else if ((i + 1) % 3 == 0) {
                sb.append(midBorder);
            }
        }
        return sb.toString();
    }
}
