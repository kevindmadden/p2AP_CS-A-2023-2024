import java.util.Arrays;

public class TestCodingBatQuestions {

    public static void main(String[] args){
        System.out.println("sumOdds");
        System.out.println(sumOdds(new int[] {}));
        System.out.println(sumOdds(new int[] {5,3}));
        System.out.println(sumOdds(new int[] {5,2}));
        System.out.println(sumOdds(new int[] {4,2}));
        System.out.println(sumOdds(new int[] {1,2,3,4,5,6,7,8}));
        System.out.println(sumOdds(new int[] {25,100,75,125,150}));
        System.out.println("----");
        System.out.println("add");
        System.out.println(Arrays.toString(add(new int[] {2,1}, new int[] {6,2})));
        System.out.println(Arrays.toString(add(new int[] {2}, new int[] {6})));
        System.out.println(Arrays.toString(add(new int[] {1,12}, new int[] {3,5})));
        System.out.println(Arrays.toString(add(new int[] {1,4}, new int[] {2,5,7})));
        System.out.println(Arrays.toString(add(new int[] {1,2,3}, new int[] {2,7,10})));
        System.out.println(Arrays.toString(add(new int[] {7,3,5,8}, new int[] {2,9,4,2})));
        System.out.println(Arrays.toString(add(new int[] {}, new int[] {})));
        System.out.println("---");
        System.out.println("removeDuplicates");
        System.out.println(Arrays.toString(removeDuplicates(new int[] {0,0,1,1,2,2})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {1,2,5,99})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {1,2,5,5,99})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {7,9,11,11})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {7,7,9,11})));
        System.out.println(Arrays.toString(removeDuplicates(new int[] {7,9,9,11})));
        System.out.println("---");
        System.out.println("Search Insert");
        System.out.println(searchInsert(1, new int[] {1,3,5,6}));
        System.out.println(searchInsert(5, new int[] {1,3,5,6}));
        System.out.println(searchInsert(3, new int[] {1,3,5,6}));
        System.out.println(searchInsert(2, new int[] {1,3,5,6}));
        System.out.println(searchInsert(7, new int[] {1,3,5,6}));
        System.out.println(searchInsert(-2, new int[] {1,3,5,6}));
        System.out.println(searchInsert(18, new int[] {1,5,9,13,14,17}));
        System.out.println(searchInsert(9, new int[] {1,5,9,13,14,17}));
        System.out.println(searchInsert(17, new int[] {}));
        System.out.println("---");
    }

    public static int searchInsert(int target, int[] nums){
        if(nums.length==0) return 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target) return i;
        }
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        for(int i=1; i<nums.length; i++){
            if(target<nums[i]) return i;
        }
        return -1;
    }

    public static int[] removeDuplicates(int[] nums){
        if(nums.length==0) return new int[] {};
        int currentNum = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(nums[i]==currentNum){
                nums[i]=-1;
            }else{
                currentNum = nums[i];
            }

        }
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]!=-1) count++;
        }
        int target=0;
        int[] nums2 = new int[count];
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=-1){
                nums2[target] = nums[i];
                target++;
            }
        }
        return nums2;
    }
    public static int[] add(int[] a, int[] b){
        if(a.length!=b.length){
            return new int[] {};
        }
        int[] c = new int[a.length];
        for(int i=0; i< c.length; i++){
            c[i] = a[i]+b[i];
        }
        return c;
    }

    public static int sumOdds(int[] nums){
        int sum=0;
        for(int num : nums){
            if(num%2==1){
                sum+=num;
            }
        }
        return sum;
    }
    public static int[] shiftRight(int[] a, int shift){
        int b[] = new int[a.length];
        shift = shift%a.length;
        int k = 0;
        for(int i=shift; i<a.length; i++){
            b[k] = a[i];
            k++;
        }
        System.out.println(Arrays.toString(b));
        for(int i=0; k<a.length; i++){
            b[k] = a[i];
            k++;
        }
        return b;
    }

}