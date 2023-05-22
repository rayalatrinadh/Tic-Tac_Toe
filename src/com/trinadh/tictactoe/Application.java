package com.trinadh.tictactoe;

import java.util.Scanner;

/*
 * @Author : Trinadh Rayala
 * 
 */

public class Application {
	
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		//creating the 3*3 board
		char[][] board = {
				{'-','-','-'},
				{'-','-','-'},
				{'-','-','-'}
		};
		displayBoard(board);
		for(int i = 0; i < 9; i++) {
			int r,c = 0;
			
			if(i% 2 == 0) {
				System.out.println("Enter X Turn");
				r = input.nextInt();
				c = input.nextInt();
				
				while(board[r][c] == 'x' || board[r][c] == 'o') {
					System.out.println( "this position already exists . please select new position");
					r = input.nextInt();
					c = input.nextInt();
				}
				board[r][c] = 'x';
			}else {
				System.out.println("Enter Y Turn");
				r = input.nextInt();
				c = input.nextInt();
				
				while(board[r][c] == 'x' || board[r][c] == 'o') {
					System.out.println( "this position already exists . please select new position");
					r = input.nextInt();
					c = input.nextInt();
				}
				board[r][c] = 'o';
			}
			displayBoard(board);
			String boardGameStatus = boardStatus(board);
			if(!boardGameStatus.contains("countinue")) {
				System.out.println(boardGameStatus);
				break;
			}
			
			if(i == 9) {
				System.out.println("Game Tied");
			}
		}
		
		
		
	}
	
	
	public static void displayBoard(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static String boardStatus(char[][] board) {
		int count = 0;
		//checking for each row 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == 'x') {
					count++;
				}else if(board[i][j]=='o') {
					count--;
				}
			}
			
			if(count == 3) {
				return  "x wins the game";
			}if(count == -3) {
				return "o wins the game";
			}
		}
		
		//checking for each column
		count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[j][i] == 'x') {
					count++;
				}else if(board[j][i] == 'o') {
					count--;
				}
			}
			if(count == 3) {
				return  "x wins the game";
			}if(count == -3) {
				return "o wins the game";
			}
		}
		
		//checking for left diagonal
		 count = 0;
		for(int i = 0; i < 3; i++) {
			if(board[i][i] == 'x') {
				count++;
			}else if(board[i][i] == 'o') {
				count--;
			}
		}
		if(count == 3) {
			return  "x wins the game";
		}if(count == -3) {
			return "o wins the game";
		}
		
		//checking for right diagonal
		count = 0;
		int rightDiagonalCount = 0;
		for(int i = 2; i >= 0; i--) {
			
			if(board[rightDiagonalCount][i] == 'x') {
				count++;
			}else if(board[rightDiagonalCount][i] == 'o') {
				count--;
			}
			rightDiagonalCount++;
			
			if(count == 3) {
				return  "x wins the game";
			}if(count == -3) {
				return "o wins the game";
			}
		}
		
		return "countinue";
		
	}

}