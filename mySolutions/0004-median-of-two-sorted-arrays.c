double findMedianSortedArrays(int *nums1, int nums1Size, int *nums2, int nums2Size)
{
    int sum = nums1Size + nums2Size;
    int *nums = malloc(sizeof(int) * sum);
    int i = 0, j = 0, k = 0;
    int half = sum / 2 + 1;
    while (k < half)
    {
        int n;
        if (i < nums1Size && j < nums2Size)
        {
            n = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        else if (i < nums1Size)
        {
            n = nums1[i++];
        }
        else if (j < nums2Size)
        {
            n = nums2[j++];
        }
        nums[k++] = n;
    }
    if (sum % 2)
    {
        return nums[k - 1];
    }
    else
    {
        return (nums[k - 1] + nums[k - 2]) / 2.0;
    }
}