package com.java101.minesweeper;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Rows: ");
        int row = input.nextInt();
        System.out.print("Number of Columns: ");
        int col = input.nextInt();

        MineSweeper board = new MineSweeper(row, col);

        board.createBoard();
        board.run();

    }
}
