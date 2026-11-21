class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin() , arr.end());
        long long mod = 1e9+7;
        unordered_map<int , long long > mp;
        long long sum =0;
        for(int x : arr){
            mp[x]=1;
        }
        for(int i =1; i<n; i++){
            for(int j =0; j<i; j++){
                if(arr[i]%arr[j]==0){
                    int need = arr[i]/arr[j];
                    if(mp.find(need)!= mp.end()){
                    mp[arr[i]]+=mp[arr[j]]*mp[need];
                    mp[arr[i]]%=mod;     // M*N

                    }
                }

            }
        }
        for( auto p : mp){
            sum = (sum + p.second)%mod;
        }
        return (int)sum;


     

        
    }
};