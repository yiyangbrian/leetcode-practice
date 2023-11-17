#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *mergeAlternately(char *word1, char *word2)
{
    int len1 = strlen(word1);
    int len2 = strlen(word2);
    int returnSize = len1 + len2;

    char *result = malloc((returnSize + 1) * sizeof(char));

    int i = 0, j = 0, k = 0;
    while (i < len1 || j < len2)
    {
        if (i < len1)
        {
            result[k++] = word1[i++];
        }
        if (j < len2)
        {
            result[k++] = word2[j++];
        }
    }
    result[k] = '\0';

    return result;
}

int main()
{
    char word1[] = "Hello";
    char word2[] = "World";

    char *merged = mergeAlternately(word1, word2);
    printf("Merged string: %s\n", merged);

    free(merged); // 释放动态分配的内存

    return 0;
}
