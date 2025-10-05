class Solution {
    public int alternatingSum(int[] arr) {
        int n = arr.length;
        int es =0;
        int os=0;
        for(int i =0;i<n;i++){
            if(i%2==0){
                es+=arr[i];
            }
            else{
                os+=arr[i];
            }

        }
        return es-os;

        
    }
}
