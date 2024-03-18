#include <stdbool.h>
bool closeStrings(char *word1, char *word2)
{
    if (strlen(word1) != strlen(word2))
        return false;
    int hash1[26] = {0};
    int hash2[26] = {0};
    for (int i = 0; i < strlen(word1); i++)
    {
        char char1 = *(word1 + i);
        char char2 = *(word2 + i);
        hash1[char1 - 'a']++;
        hash2[char2 - 'a']++;
    }

    for (int i = 0; i < 26; i++)
    {
        if (hash1[i] == 0 && hash2[i] != 0 ||
            hash1[i] != 0 && hash2[i] == 0)
        {
            return false;
        }
        else
        {
            int flag = 0;
            for (int j = 0; j < 26; j++)
            {
                if (hash2[j] == hash1[i])
                {
                    flag = 1;
                    hash2[j] = -1;
                    break;
                }
            }
            if (flag == 0)
            {
                return false;
            }
        }
    }

    return true;
}