/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool *kidsWithCandies(int *candies, int candiesSize, int extraCandies, int *returnSize)
{
    bool *result = (bool *)malloc(candiesSize * sizeof(bool));
    int biggest = *candies;
    for (int i = 1; i < candiesSize; i++)
    {
        if (candies[i] > biggest)
        {
            biggest = candies[i];
        }
    }
    for (int i = 0; i < candiesSize; i++)
    {
        if (candies[i] + extraCandies >= biggest)
        {
            result[i] = true;
        }
        else
        {
            result[i] = false;
        }
    }
    *returnSize = candiesSize;

    return result;
}