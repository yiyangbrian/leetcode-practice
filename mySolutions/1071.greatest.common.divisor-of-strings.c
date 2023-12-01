char *gcdOfStrings(char *str1, char *str2)
{
    if (strcmp(str1, str2) == 0)
    {
        return str1;
    }

    if (strlen(str1) < strlen(str2))
    {
        char *temp = str1;
        str1 = str2;
        str2 = temp;
    }

    int len1 = strlen(str1);
    int len2 = strlen(str2);

    for (int i = len2; i > 0; i--)
    {
        if (len1 % i == 0 && len2 % i == 0)
        {
            int flag = 1;
            for (int j = 0; j < len1; j++)
            {
                if (str1[j] != str1[j % i])
                {
                    flag = 0;
                    break;
                }
            }
            for (int j = 0; j < len2; j++)
            {
                if (str2[j] != str1[j % i])
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
            {
                str1[i] = '\0';
                return str1;
            }
        }
    }

    return "";
}