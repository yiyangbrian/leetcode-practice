/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

static void bfs(struct TreeNode *root, int **results, int *count, int *col_sizes, int *size, int level) {
    if(root == NULL) return;

    *count = level + 1 > *count ? level + 1 : *count;
    if(col_sizes[level] == 0) {
        *size = *size > 256 ? 256 : *size * 2;
        results[level] = malloc(*size * sizeof(int));
    }
    results[level][col_sizes[level] ++] = root->val;
    bfs(root->left, results, count, col_sizes, size, level + 1);
    bfs(root->right, results, count, col_sizes, size, level + 1);
}

int** levelOrderBottom(struct TreeNode* root, int* returnSize, int** returnColumnSizes) {
    if(root == NULL) {
        *returnSize = 0;
        return NULL;
    }
    int size = 1;
    *returnSize = 0;
    int **results = malloc(800 * sizeof(int *));
    *returnColumnSizes = malloc(800 * sizeof(int));
    memset(*returnColumnSizes, 0, 800 * sizeof(int));
    bfs(root, results, returnSize, *returnColumnSizes, &size, 0);

    int i, j;
    for(i = 0, j = *returnSize - 1; i < j; i ++, j --) {
        int *ptmp = results[i];
        results[i] = results[j];
        results[j] = ptmp;
        int tmp = (*returnColumnSizes)[i];
        (*returnColumnSizes)[i] = (*returnColumnSizes)[j];
        (*returnColumnSizes)[j] = tmp;
    }
    return results;
}