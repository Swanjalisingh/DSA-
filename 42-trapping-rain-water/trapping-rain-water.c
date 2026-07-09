#include <stdio.h>

int trap(int* height, int heightSize) {
    if (heightSize == 0) return 0;

    int leftMax = 0, rightMax = 0;
    int area= 0;

    int left = 0;
    int right = heightSize - 1;

    
    for (; left < right; ) {

        if (height[left] < height[right]) {
            
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                area += leftMax - height[left];
            }
            left++;   
        } else {
            
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                area += rightMax - height[right];
            }
            right--;  
        }
    }

    return area;
}

