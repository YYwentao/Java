package 每日一题;

/**
 * ClassName: Day24
 * Description:
 * date: 2021/7/16 10:09
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day24 {
    /**
     *  年终奖
      */

    public int getMost(int[][] board) {
        // 行
        int row = board.length;
        //列
        int col = board[0].length;
        //处理第一行
        for(int i = 1; i < col; i++) {
            board[0][i] += board[0][i-1];
        }
        for(int j = 1; j < row; j++) {
            board[j][0] += board[j-1][0];
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                board[i][j] += Math.max(board[i-1][j],board[i][j-1]);
            }
        }
        return board[row-1][col-1];
    }


}
