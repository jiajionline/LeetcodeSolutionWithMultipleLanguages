import collections
class MagicDictionary(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
    def buildDict(self, words):
        """
        Build a dictionary through a list of words
        :type dict: List[str]
        :rtype: None
        """
        self.dict = collections.defaultdict(set)
        for word in words:
            for i in xrange(len(word)):
                self.dict[word[:i] + '*' + word[i+1:]].add(word[i])
    
    def search(self, word):
        """
        Returns if there is any word in the trie that equals to the given word after modifying exactly one character
        :type word: str
        :rtype: bool
        """
        for i in xrange(len(word)):
            w = word[:i] + '*' + word[i+1:]
            if w in self.dict and (len(self.dict[w]) > 1 or word[i] not in self.dict[w]): return True        
        return False
            