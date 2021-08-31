class Solution{
    public:
    // arr : given array
    // l : starting index of the array i.e 0
    // r : ending index of the array i.e size-1
    // k : find kth smallest element and return using this function
    
    void swap(int *a, int *b) {
        int temp = *a;
        *a = *b;
        *b = temp;
    }

    int partition(int arr[], int l, int r) {
        
        int i = l, j = l;
        while (i <= r) {
            if (arr[i] > arr[r])
                i++;
            else {
                swap(&arr[i], &arr[j]);
                i++; j++;
            }
        }
        
        return (j - 1);
    }

    int randomPartition(int arr[], int l, int r) {
        int n = r - l + 1;
        int pivot = rand() % n;
        swap(&arr[l + pivot], &arr[r]);
        return partition(arr, l, r);
    }
    
    int kthSmallest(int arr[], int l, int r, int k) {
        //code here
        
        
        int pi = randomPartition(arr, l, r);
        if (pi > (k - 1)) 
            return kthSmallest(arr, l, pi - 1, k);
        else if (pi < (k - 1))
            return kthSmallest(arr, pi + 1, r, k);
            
        return arr[k - 1];
    }
};