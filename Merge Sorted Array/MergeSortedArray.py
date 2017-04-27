class MergeSortedArray(object):
    def merge(self, nums1, m, nums2, n):
        if nums1 is None or len(nums1) < m+n:
            return
        index1 = m-1
        index2 = n-1
        index3 = m+n-1
        
        while index1>=0 and index2>=0:
            if nums1[index1] == nums2[index2]:
                nums1[index3] = nums1[index1]
                index3 -=1
                index1 -=1
                nums1[index3] = nums2[index2]
                index3 -=1
                index2 -=1
            elif nums1[index1] > nums2[index2]:
                nums1[index3] = nums1[index1]
                index3 -=1
                index1 -=1
            else:
                nums1[index3] = nums2[index2]
                index3 -=1
                index2 -=1
        
        while index1>=0:
            nums1[index3] = nums1[index1]
            index3-=1
            index1-=1
        
        while index2>=0:
            nums1[index3] = nums2[index2]
            index3-=1
            index2-=1
            