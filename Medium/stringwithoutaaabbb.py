class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        output = ""
        num_of_a, num_of_b = 0, 0

        for i in range(a + b):
            if (a < b and num_of_b < 2) or num_of_a == 2:
                output += "b"
                num_of_a, num_of_b = 0, num_of_b + 1
                b -= 1
            else:
                output += "a"
                num_of_a, num_of_b = num_of_a + 1, 0
                a -= 1
        return output