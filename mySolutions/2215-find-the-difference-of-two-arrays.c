/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int **findDifference(int *nums1, int nums1Size, int *nums2, int nums2Size, int *returnSize, int **returnColumnSizes)
{
    int *hash = (int *)calloc(2001, sizeof(int));
    int **ans = (int **)malloc(sizeof(int *) * 2);
    ans[0] = (int *)calloc(nums1Size, sizeof(int));
    ans[1] = (int *)calloc(nums2Size, sizeof(int));

    for (int i = 0; i < nums2Size; i++)
    {
        hash[nums2[i] + 1000] = 1;
    }

    for (int i = 0; i < nums1Size; i++)
    {
        if (hash[nums1[i] + 1000] > 0)
        {
            hash[nums1[i] + 1000]++;
        }
        else
        {
            hash[nums1[i] + 1000] = -1;
        }
    }

    int *col = (int *)calloc(2, sizeof(int));
    for (int i = -1000; i <= 1000; i++)
    {
        if (hash[i + 1000] == -1)
        {
            ans[0][col[0]] = i;
            col[0]++;
        }
        else if (hash[i + 1000] == 1)
        {
            ans[1][col[1]] = i;
            col[1]++;
        }
    }

    *returnSize = 2;
    *returnColumnSizes = col;

    return ans;
}