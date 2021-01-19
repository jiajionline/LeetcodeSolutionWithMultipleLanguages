from typing import List

class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        # length of rows
        rowLen = len(matrix) 
        # length of column
        colLen = len(matrix[0])
        # calculate how many 1's of each col based on current row
        for col in range(colLen):
            for row in range(1,rowLen):
                if matrix[row][col] > 0:
                    matrix[row][col] += matrix[row-1][col]
        
        ans = 0
        for row in range(rowLen):
            newList = sorted(matrix[row],reverse=True)
            for col in range(len(newList)):
                ans = max(ans, newList[col] * (col+1))
        
        return ans