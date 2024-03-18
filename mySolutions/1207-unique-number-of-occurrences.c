#include <stdbool.h>
int compare(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

bool uniqueOccurrences(int *arr, int arrSize)
{
    int *hash = (int *)malloc(2001 * sizeof(int));
    for (int i = 0; i < 2001; i++)
    {
        hash[i] = 0;
    }
    for (int i = 0; i < arrSize; i++)
    {
        hash[arr[i] + 1000]++;
    }
    qsort(hash, 2001, sizeof(int), compare);
    for (int i = 2000; i > 0; i--)
    {
        if (hash[i] == 0)
            break;
        if (hash[i] == hash[i - 1])
        {
            return false;
        }
    }
    return true;
}