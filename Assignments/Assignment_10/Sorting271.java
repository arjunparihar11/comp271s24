public class Sorting271 {

    /**
     * Merge two arrays into a single sorted array
     * @param left First Sorted Array
     * @param right Second Sorted Array
     * @return left and right Merged Array
     */
    public static int[] merge(int[] left, int[] right) {
        int i = 0;//merge index for while loop
        int iL = 0;//index for L array
        int iR = 0;//index for R array
        int[] merged = new int[(left.length + right.length)];//merge array size of L+R lengths
        //Merge into one array until L or R runs out of elements
        while((iL < left.length) && (iR < right.length)) {
            if(left[iL] <= right[iR]) {//if left first add it
                merged[i] = left[iL];
                iL++;//next L element
            } else {//otherwise if right first add that first
                merged[i] = right[iR];
                iR++;//next R element
            }
            i++;//next position in merged array
        }
        //Merge remaining elements after L or R runs out first
        while (iL < left.length) {//if remaining elements exist
            merged[i] = left[iL];//add to end of merge
            i++;
            iL++;
        }
        while (iR < right.length) {//if remaining elements exist
            merged[i] = right[iR];//add to end of merge
            i++;
            iR++;
        }
        return merged;
    }

    /**
     * String to print out array in testing
     * @param x array being printed
     * @return string representation of array
     */
    public static String printArray(int[] x) {
        StringBuilder sb = new StringBuilder();//string builder
        sb.append("[");//begin array with '['
        for (int i = 0; i < x.length; i++) {//for every element in array
            sb.append(x[i]);//add element
            if (i < x.length - 1) {//if not last element
                sb.append(",");//add ',' between elements
            }
        }
        sb.append("]");//end with ']'
        return sb.toString();//return completed string
    }

    public static int[] sort(int[] array) {
        int[] sorted = new int[array.length];//sorted array to return
        if(array.length <= 1) {//if array has 1 or less elements
            sorted = array;//then it is already sorted
        } else {//else we need to sort it via merge sort
            int mid = array.length / 2; // find the midpoint
            int[] arr1 = new int[mid];//first hald array
            int[] arr2 = new int[array.length - mid];//second half array
            for (int i = 0; i < mid; i++) {//fill first half
                arr1[i] = array[i];
            }
            for (int i = mid; i < array.length; i++) {//fill second half
                arr2[i - mid] = array[i];
            }
            //System.out.printf("%nArr1: %s", printArray(arr1));
            //System.out.printf("%nArr2: %s", printArray(arr2));
            arr1 = sort(arr1);//recursive sort till each array has 1 element
            arr2 = sort(arr2);//recursive sort till each array has 1 element
            sorted = merge(arr1, arr2);//merge together into a sorted array
        }
        //System.out.printf("%nSorted: %s", printArray(sorted));
        return sorted;//return sorted array
    }

    public static void main(String[] args) {
        //TEST MERGE
        int[] a = {1,2,8};
        int[] b = {0,5,6,7,9};
        int[] c = merge(a,b);
        System.out.printf("%nArray A:%n%s",printArray(a));
        System.out.printf("%nArray B:%n%s",printArray(b));
        System.out.printf("%nMerge(A,B):%n%s%n",printArray(c));
        //TEST SORT
        int[] d = {10, 8, 5, 3, 7, 6, 2, 1};
        int[] e = sort(d);
        System.out.printf("%nOriginal Array:%n%s%nSorted Array:%n%s%n",printArray(d), printArray(e));
    }
}