// LINK: https://neetcode.io/problems/valid-sudoku/question?list=neetcode150


class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for(row in board) {
            if(!isValidRowColumn(row)) return false
        }

        for (i in 0 until 9) {
            val column = CharArray(9)
            for (j in 0 until 9) {
                column[j] = board[j][i]
            }
            if(!isValidRowColumn(column)) return false
        }
        
        
        for(j in 0 until 9 step 3) {
            for(k in 0 until 9 step 3) {
                if(!isValidBox(i,j,board)) return false
            }
        }
        

        return true
    }

    fun isValidRowColumn(arr: Array<Char>): Boolean {
        val present = BooleanArray(9)
        for(c in arr) {
            if (c != '.') {
                val num = c.digitToInt()
                if(present[num]) retrun false
                present[num] = true
            }
        }
        retrun true
    }


    fun isValidBox(startRow: Int, startCol: Int, board: Array<CharArray>): Boolean {
        val present = BooleanArray(9)
        for (i in listOf(startRow, startRow+1, startRow+2)) {
            for(j in listOf(startCol, startCol+1, startCol+2)) {
                val c = board[i][j]
                if(c != '.') {
                    val num = c.digitToInt()
                    if(present[num]) return false
                    present[num] = true
                }
                
            }
        }
        return true
    }
}