int numTrees(int n)
{
    int i, j;
    int *sum = malloc((n + 1) * sizeof(int));
    for (int i = 0; i < n + 1; i++)
    {
        sum[i] = 0;
    }

    sum[0] = 1;
    sum[1] = 1;
    for (i = 2; i <= n; i++)
    {
        for (j = 1; j <= i; j++)
        {
            sum[i] += sum[j - 1] * sum[i - j];
        }
    }
    return sum[n];
}