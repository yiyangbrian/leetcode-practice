/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

void k_sum(int *nums, int low, int high, long target, int total, int k, int *stack, int len, int **results, int *count)
{
    if (k == 2)
    {
        while (low < high)
        {
            int sum = nums[low] + nums[high];
            if (sum < target)
            {
                low++;
            }
            else if (sum > target)
            {
                high--;
            }
            else
            {
                stack[len++] = nums[low];
                stack[len++] = nums[high];
                results[*count] = malloc(total * sizeof(int));
                results[*count][0] = stack[0];
                results[*count][1] = stack[1];
                results[*count][2] = stack[2];
                results[*count][3] = stack[3];
                (*count)++;
                len -= 2;
                while (++low < high && nums[low] == nums[low - 1])
                {
                }
                while (--high > low && nums[high] == nums[high + 1])
                {
                }
            }
        }
    }
    else
    {
        for (int i = low; i <= high - k + 1; i++)
        {
            if (i > low && nums[i] == nums[i - 1])
                continue;
            stack[len] = nums[i];
            k_sum(nums, i + 1, high, target - nums[i], 4, k - 1, stack, len + 1, results, count);
        }
    }
}

int **fourSum(int *nums, int numsSize, int target, int *returnSize, int **returnColumnSizes)
{
    *returnSize = 0;
    int capacity = 50000;
    int **results = malloc(capacity * sizeof(int *));
    *returnColumnSizes = malloc(capacity * sizeof(int));

    if (numsSize >= 4)
    {
        qsort(nums, numsSize, sizeof(*nums), compare);
        int *stack = malloc(4 * sizeof(int));
        k_sum(nums, 0, numsSize - 1, target, 4, 4, stack, 0, results, returnSize);
    }

    for (int i = 0; i < *returnSize; i++)
    {
        (*returnColumnSizes)[i] = 4;
    }
    return results;
}