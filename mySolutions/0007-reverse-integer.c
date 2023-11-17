int reverse(int x)
{
    int n = 0;
    while (x != 0)
    {
        int r = x % 10;

        if (n > INT_MAX / 10 || n == INT_MAX / 10 && r > 7)
        {
            return 0;
        }
        if (n < INT_MIN / 10 || n == INT_MIN / 10 && r < -8)
        {
            return 0;
        }
        n = n * 10 + r;
        x /= 10;
    }
    return n;
}