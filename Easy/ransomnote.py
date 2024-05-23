class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        word_map_magazine = {}
        for i in list(magazine):
            if (i not in word_map_magazine.keys()):
                word_map_magazine.update({i:1})
            else:
                counter = word_map_magazine.get(i)
                counter += 1
                word_map_magazine.update({i:counter})

        word_map_ransomNote = {}
        for i in list(ransomNote):
            if (i not in word_map_ransomNote.keys()):
                 word_map_ransomNote.update({i:1})
            else:
                counter = word_map_ransomNote.get(i)
                counter += 1
                word_map_ransomNote.update({i:counter})

        for key in word_map_ransomNote.keys():
            if (key not in word_map_magazine.keys()):
                return False
            else:
                if (word_map_magazine.get(key) < word_map_ransomNote.get(key)):
                    return False

        return True

    if __name__ == '__main__':
        print(canConstruct("ds","ab","aab"))


            
            