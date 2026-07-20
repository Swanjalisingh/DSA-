class ProductOfNumbers {

    int[] nums;
    int size;

    public ProductOfNumbers() {
        nums = new int[40000];
        size = 0;
    }

    public void add(int num) {
        nums[size] = num;
        size++;
    }

    public int getProduct(int k) {
        int product = 1;

        for (int i = size - k; i < size; i++) {
            product *= nums[i];
        }

        return product;
    }
}