int lengthOfLongestSubstring(char *s)
{
    int count[256] = {0};
    int max = 0, len = 0;

    for (int i = 0; s[i] != '\0'; i++)
    {
        if (count[s[i]] == 0)
        {
            count[s[i]]++;
            len++;
            max = len > max ? len : max;
        }
        else
        {
            int found = 0;
            for (int j = i - 1; j >= i - len; j--)
            {
                if (s[j] == s[i])
                {
                    found = 1;
                    max = i - j > max ? i - j : max;
                    len = i - j;
                    break;
                }
            }
            if (!found)
            {
                len++;
                max = max > len ? max : len;
            }
        }
    }
    return max;
}