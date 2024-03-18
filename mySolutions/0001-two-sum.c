/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

struct object
{
    int val;
    int index;
};

static int compare(const void *a, const void *b)
{
    return ((struct object *)a)->val - ((struct object *)b)->val;
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    int i, j;
    struct object *objs = malloc(numsSize * sizeof(*objs));
    for (i = 0; i < numsSize; i++)
    {
        objs[i].val = nums[i];
        objs[i].index = i;
    }
    qsort(objs, numsSize, sizeof(*objs), compare);

    int *results = malloc(2 * sizeof(int));
    i = 0;
    j = numsSize - 1;

    while (i < j)
    {
        int sum = objs[i].val + objs[j].val;
        if (sum < target)
        {
            i++;
        }
        else if (sum > target)
        {
            j--;
        }
        else
        {
            results[0] = objs[i].index;
            results[1] = objs[j].index;
            *returnSize = 2;
            return results;
        }
    }
    return NULL;
}