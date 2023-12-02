#include <stdbool.h>
bool canPlaceFlowers(int *flowerbed, int flowerbedSize, int n)
{
    int *zeros = (int *)malloc(flowerbedSize * sizeof(int));
    int *ptr = zeros;
    int count = 0;
    int end = 0;
    bool start = false;
    bool tail = false;

    for (int i = 0; i < flowerbedSize; i++)
    {
        if (i == 0 && flowerbed[i] == 0)
        {
            start = true;
        }
        if (i == flowerbedSize - 1 && flowerbed[flowerbedSize - 1] == 0)
        {
            tail = true;
        }
        if (flowerbed[i] == 1)
        {
            *ptr = count;
            ptr++;
            end++;
            count = 0;
        }
        else
        {
            count++;
        }
    }
    if (count > 0)
    {
        *ptr = count;
        ptr++;
        end++;
        count = 0;
    }

    if (end == 1)
        return (zeros[0] + 1) / 2 >= n;

    int total = 0;

    for (int i = 0; i < end; i++)
    {

        if (start && i == 0)
        {
            total += zeros[i] / 2;
        }
        else if (tail && i == end - 1)
        {
            total += zeros[i] / 2;
        }
        else
        {
            total += (zeros[i] - 1) / 2;
        }
    }

    return total >= n;
}