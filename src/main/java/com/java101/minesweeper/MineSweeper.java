package com.java101.minesweeper;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int row;
    int col;
    String[][] board = new String[row][col];
    String[][] mines = new String[row][col];

    Scanner input = new Scanner(System.in);

    public MineSweeper(int row, int col) {
        board = new String[row][col];
        mines = new String[row][col];
        this.row = row;
        this.col = col;
    }

    public void createBoard() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++ ) {
                mines[i][j] = " ";
            }
        }

        int numberOfMines = (this.row * this.col) / 4;
        Random random = new Random();

        while (numberOfMines > 0) {
            int randomRow = random.nextInt(this.row);
            int randomCol = random.nextInt(this.col);
            mines [randomRow][randomCol] = "*";
            numberOfMines--;
        }
        
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++ ) {
                board[i][j] = "-";
            }
        }
        
    }

    public void printBoard() {

        System.out.println("------------- MINE SWEEPER ----------");

        for  (String i[] : board) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void run() {

        printBoard();
        int r, c;
        do {
            System.out.print("Row: ");
            r = input.nextInt();
            if (r >= 0 && r < mines.length) {
                break;
            }
            System.out.println("Please enter a number within array limits.");
            continue;
        } while(true);

        do {
            System.out.print("Column: ");
            c = input.nextInt();
            if (c >= 0 && c < mines[0].length) {
                break;
            }
            System.out.println("Please enter a number within array limits.");
            continue;
        } while(true);
    
        if (mines[r][c].equals("*")) {
            System.out.println("Boom!");
            printMines();
            System.exit(0);
        } else {
            checkMine(r,c);
        }

        isWin();
        run();
    }

    public void checkMine(int r, int c) {
        int count = 0;
        if (r==0 && c==0) {
            if (mines[0][1].equals("*")) {
                count++;
            }
            if (mines[1][1].equals("*")) {
                count++;
            }
            if (mines[1][0].equals("*")) {
                count++;
            }
        }
        else if (r==0 && c==mines[0].length-1) {
            if (mines[0][c-1].equals("*")) {
                count++;
            }
            if (mines[1][c-1].equals("*")) {
                count++;
            }
            if (mines[1][c].equals("*")) {
                count++;
            }
        }
        else if (r==mines.length-1 && c==0) {
            if (mines[r][1].equals("*")) {
                count++;
            }
            if (mines[r-1][1].equals("*")) {
                count++;
            }
            if (mines[r-1][0].equals("*")) {
                count++;
            }
        }
        else if (r==mines.length-1 && c==mines[r].length-1) {
            if (mines[r][c-1].equals("*")) {
                count++;
            }
            if (mines[r-1][c-1].equals("*")) {
                count++;
            }
            if (mines[r-1][c].equals("*")) {
                count++;
            }
        }
        else if (r==0 && c>0 && c<mines[r].length-1) {
            if (mines[r][c-1].equals("*")) {
                count++;
            }
            if (mines[r][c+1].equals("*")) {
                count++;
            }
            if (mines[r+1][c-1].equals("*")) {
                count++;
            }
            if (mines[r+1][c].equals("*")) {
                count++;
            }
            if (mines[r+1][c+1].equals("*")) {
                count++;
            }
        }
        else if (r==mines.length-1 && c>0 && c<mines[r].length-1) {
            if (mines[r][c-1].equals("*")) {
                count++;
            }
            if (mines[r][c+1].equals("*")) {
                count++;
            }
            if (mines[r-1][c-1].equals("*")) {
                count++;
            }
            if (mines[r-1][c].equals("*")) {
                count++;
            }
            if (mines[r-1][c+1].equals("*")) {
                count++;
            }
        }
        else if (c==0 && r>0 && r<mines.length-1) {
            if (mines[r-1][c].equals("*")) {
                count++;
            }
            if (mines[r+1][c].equals("*")) {
                count++;
            }
            if (mines[r-1][c+1].equals("*")) {
                count++;
            }
            if (mines[r][c+1].equals("*")) {
                count++;
            }
            if (mines[r+1][c+1].equals("*")) {
                count++;
            }
        }
        else if (c==mines[r].length-1 && r>0 && r<mines.length-1) {
            if (mines[r-1][c].equals("*")) {
                count++;
            }
            if (mines[r+1][c].equals("*")) {
                count++;
            }
            if (mines[r-1][c-1].equals("*")) {
                count++;
            }
            if (mines[r][c-1].equals("*")) {
                count++;
            }
            if (mines[r+1][c-1].equals("*")) {
                count++;
            }
        } else {
            if (mines[r-1][c-1].equals("*")) {
                count++;
            }
            if (mines[r-1][c].equals("*")) {
                count++;
            }
            if (mines[r-1][c+1].equals("*")) {
                count++;
            }
            if (mines[r][c-1].equals("*")) {
                count++;
            }
            if (mines[r][c+1].equals("*")) {
                count++;
            }
            if (mines[r+1][c-1].equals("*")) {
                count++;
            }
            if (mines[r+1][c].equals("*")) {
                count++;
            }
            if (mines[r+1][c+1].equals("*")) {
                count++;
            }
        }

        if (count != 0) {
            String mineCount = String.valueOf(count);
            board[r][c]=mineCount;
        } else {
            board[r][c]=" ";
        }
    }


    public void isWin() {
        int boardSize = this.row * this.col;
        int numberOfMines = boardSize/4;
        int count = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++ ) {
                if (board[i][j] != "-") {
                    count++;
                }
            }
        }
        if (count == boardSize - numberOfMines) {
            printMines();
            System.out.println("Congrats! You swept all mines!");
            System.exit(0);
        }
    }

    public void printMines() {
        for  (String i[] : mines) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
