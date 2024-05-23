
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        word_map = {}
        lst = s.split()
        if (len(lst) != len(list(pattern))):
            return False
            
        for index, i  in enumerate(pattern):
            if (i not in word_map):
                if (lst[index] in word_map.values()):
                    return False
                else:
                    word_map.update({i:lst[index]})
            else:
                if (lst[index] != word_map.get(i)):
                    return False

        return True

    if __name__ == '__main__':
        pattern = "abba"
        s = "dog dog dog dog"
        print(wordPattern("", pattern, s))