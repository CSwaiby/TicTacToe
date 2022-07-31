import java.util.Scanner;
public class TicTacToe {

// Done by CSwaiby
	
	public static void displayBoard(String[][] board)
	{
		int k = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++) 
			{
				if ((k == 0) || (k == 3) || (k == 6))
				{System.out.println();
				System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
				k++;
			}
		}
	}
	
	public static int winnerCheck(String[][] board)
	{
	     if(board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X") || // 1st row
	        board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X") || // 2nd row
	        board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X") || // 3rd row
	        board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X") || // 1st column
	        board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X") || // 2nd column
	        board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X") || // 3rd column
	        board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X") || // Diagonal \ 
	        board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X")) //   Diagonal /
	        {return 1;}
		
	else if(board[0][0].equals("0") && board[0][1].equals("0") && board[0][2].equals("0") || // 1st row
            board[1][0].equals("0") && board[1][1].equals("0") && board[1][2].equals("0") || // 2nd row
            board[2][0].equals("0") && board[2][1].equals("0") && board[2][2].equals("0") || // 3rd row
            board[0][0].equals("0") && board[1][0].equals("0") && board[2][0].equals("0") || // 1st column
            board[0][1].equals("0") && board[1][1].equals("0") && board[2][1].equals("0") || // 2nd column
            board[0][2].equals("0") && board[1][2].equals("0") && board[2][2].equals("0") || // 3rd column
            board[0][0].equals("0") && board[1][1].equals("0") && board[2][2].equals("0") || // Diagonal \ 
            board[2][0].equals("0") && board[1][1].equals("0") && board[0][2].equals("0")) //   Diagonal /
		{return 2;}
	
	else
		{return 0;}
	}
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int m = 3;
		int n = 3;
		String[][] board = new String [m][n];
		String none = "-";
		for (m = 0; m < 3; m++)
		{
			for (n = 0; n < 3; n++)
			{
			board[m][n] = none;
			}
		}
		displayBoard(board);
		
		String player = "0";
		int draw = 0;
		for (int k = 0;  k < 9; k++)
		{
			if (player == "0")
			{player = "X";}
			else 
			{player = "0";}
			
			System.out.println("\nUSER " + player + ": Enter the line number, then the column number");
			m = in.nextInt() - 1;
			n = in.nextInt() - 1;
			while((m + 1<= 0) || (m + 1 >= 4) || (n + 1 <= 0) || (n + 1 >= 4) || (board[m][n].equals("X")) || (board[m][n].equals("0")))
			{
				System.out.println("Invalid input");
				k--;
				System.out.println("\nUSER " + player + ": Enter the line number, then the column number");
				m = in.nextInt() - 1;
				n = in.nextInt() - 1;
			}
			board[m][n] = player;
			displayBoard(board);
			System.out.println();
			switch (winnerCheck(board))
			{
			case 1 : System.out.println("USER X WINS!"); k = 9; break;
			case 2 : System.out.println("USER 0 WINS!"); k = 9; break;
			default: System.out.println(); draw = 1; break; 
			}
		}
		if (draw == 1)
		{
			System.out.println("It's a draw, Nobody won.");
		}
	in.close();
	}
}
