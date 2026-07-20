class ProductOfNumbers {
public:
vector<int> prefixproduct;
    ProductOfNumbers() {
        prefixproduct.push_back(1);
        
    }
    
    void add(int num) {
        if(num ==0){
            prefixproduct.clear();
            prefixproduct.push_back(1);
            return;
        }
        prefixproduct.push_back(prefixproduct.back() * num);
        
    }
    
    int getProduct(int k) {
        int size = prefixproduct.size();
        if(size <= k){
            return 0;

        }
        return prefixproduct[size -1]/ prefixproduct[size - k- 1];
        
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */