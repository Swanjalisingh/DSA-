
class Solution {
    void dfs(vector<vector<int>>& image, int r, int c,
             int oldColor, int newColor) {

        image[r][c] = newColor;

        // Up
        if (r - 1 >= 0 && image[r - 1][c] == oldColor) {
            dfs(image, r - 1, c, oldColor, newColor);
        }

        // Down
        if (r + 1 < image.size() &&
            image[r + 1][c] == oldColor) {
            dfs(image, r + 1, c, oldColor, newColor);
        }

        // Left
        if (c - 1 >= 0 && image[r][c - 1] == oldColor) {
            dfs(image, r, c - 1, oldColor, newColor);
        }

        // Right
        if (c + 1 < image[0].size() &&
            image[r][c + 1] == oldColor) {
            dfs(image, r, c + 1, oldColor, newColor);
        }
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image,
                                  int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }

        return image;
    }
};
