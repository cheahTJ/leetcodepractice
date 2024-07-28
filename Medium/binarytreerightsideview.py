# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# This approach uses BFS and taking always the last item in the list
# as that last item is always to the extreme right of the view
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        lst = list()
        if (root is None):
            return []
        else:

            lst = list()
            queue = deque()
            queue.append(root)

            while (len(queue) != 0):
                length_of_queue = len(queue)
                counter = 0
                temp = list()

                while (counter != length_of_queue):
                    elem = queue.popleft()
                    temp.append(elem.val)
                    if (elem.left):
                        queue.append(elem.left)
                    if (elem.right):
                        queue.append(elem.right)
                    counter += 1

                lst.append(temp[-1])
            return lst