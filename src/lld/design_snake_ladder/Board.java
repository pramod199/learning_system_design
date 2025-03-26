package lld.design_snake_ladder;

public class Board {
    Cell[][] cells;

    int boardSize;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = boardSize;
        initialiseCells();

        addSnakes(numberOfSnakes);
        addLadders(numberOfLadders);
    }

    private void addLadders(int numberOfLadders) {
        while (numberOfLadders > 0) {
            int start = (int) (Math.random() * (boardSize * boardSize - 1) + 1);
            int end = (int) (Math.random() * (boardSize * boardSize - start) + start);

            Cell cell = getCell(start);

            if (cell.getJump() == null) {
                cell.setJump(new Jump(start, end));
                numberOfLadders--;
            }
        }
    }

    private void addSnakes(int numberOfSnakes) {
        while (numberOfSnakes > 0) {
            int start = (int) (Math.random() * (boardSize * boardSize - 1) + 1);
            int end = (int) (Math.random() * (start - 1) + 1);

            Cell cell = getCell(start);

            if (cell.getJump() == null) {
                cell.setJump(new Jump(start, end));
                numberOfSnakes--;
            }
        }
    }


    private void initialiseCells() {
        this.cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i % 2 == 0) {
                    cells[i][j] = new Cell(i * boardSize + j + 1);
                } else {
                    cells[i][boardSize - j - 1] = new Cell(i * boardSize + j + 1);
                }
            }
        }
    }

    public Cell getCell(int playerPosition) {
        int row = (playerPosition - 1) / boardSize;
        int col;
        if (row % boardSize == 0) {
            col = (playerPosition - 1) % boardSize;
        } else {
            col = boardSize - 1 - (playerPosition - 1) % boardSize;
        }
        return cells[row][col];
    }

    public void printBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(cells[i][j].getNumber() + " ");
            }
            System.out.println();
        }
    }
}
