class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        wordSet = set(wordList)
        if not endWord in wordSet:return 0
        q = [beginWord]
        step = 0
        while len(q):
            l = len(q)
            step +=1
            for i in range(l):
                w = q.pop(0)
                for j in range(len(w)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c == w[j]:continue
                        newWord = w[:j] + c + w[j+1:]
                        if not newWord in wordSet: continue
                        if newWord == endWord:return step+1
                        wordSet.remove(newWord)
                        q.append(newWord)
        return 0
        
s = Solution()
s.ladderLength("hit","cog",["hot","dot","dog","lot","log","cog"])