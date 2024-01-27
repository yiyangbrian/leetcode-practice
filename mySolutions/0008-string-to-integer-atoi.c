int myAtoi(char *s)
{
    char *str;
    long n = 0;
    int sign = 0;

    while (*s == ' ')
    {
        s++;
    }

    if (*s == '-')
    {

        if (isdigit(*++s))
        {
            sign = 1;
        }
        else
        {
            return 0;
        }
    }

    if (*s == '+')
    {
        if (isdigit(*++s))
        {
            sign = 0;
        }
        else
        {
            return 0;
        }
    }

    for (str = s; *str != '\0'; str++)
    {
        if (isdigit(*str))
        {
            int d = *str - '0';
            if (sign)
            {
                if (-n < (INT_MIN + d) / 10)
                {
                    n = INT_MIN;
                    break;
                }
            }
            else
            {
                if (n > (INT_MAX - d) / 10)
                {
                    n = INT_MAX;
                    break;
                }
            }
            n = n * 10 + d;
        }
        else
        {
            break;
        }
    }
    return sign ? -n : n;
}