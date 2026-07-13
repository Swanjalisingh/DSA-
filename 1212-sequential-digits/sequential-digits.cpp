class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        queue<int> que;
        for(int i =1; i<=8; i++){
            que.push(i);
        }
        vector<int> result;
        while(!que.empty()){
            int temp = que.front();
            que.pop();
            if(temp >= low && temp <= high ){
                result.push_back(temp);
            }
            int lastdigit = temp%10;
            if(lastdigit +1 <= 9){
                que.push(temp * 10 +(lastdigit+1)); // temp = 12 -->123
            }
        }
          
        return result;
    }
};