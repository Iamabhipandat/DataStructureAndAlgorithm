class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        zero = nums.index(0)

        ans = float('inf')

        # Check increasing order moving right from 0
        if self.check(nums, zero, 1):
            ans = min(ans, zero)
            ans = min(ans, n - zero + 2)

        # Check increasing order moving left from 0
        if self.check(nums, zero, -1):
            ans = min(ans, zero + 2)
            ans = min(ans, n - zero)

        return -1 if ans == float('inf') else ans

    def check(self, nums: List[int], zero: int, step: int) -> bool:
        n = len(nums)

        for i in range(1, n):
            prev = (zero + (i - 1) * step + n) % n
            curr = (zero + i * step + n) % n

            if nums[prev] > nums[curr]:
                return False

        return True