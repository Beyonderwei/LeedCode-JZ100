package com.beyonderwei.lcjz;

import java.util.Arrays;

public class TenSorts {

    /**
     * 1. 选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr){
        //最开始除第一个元素外为未排序区间,循环i < arr.length-1 是因为最后一个树不用排序
        for (int i = 0; i < arr.length-1; i++) {
            int min = i; // 记录最小值的下标
            //遍历未排序区间，注意j的初始值，j比i大1
            for (int j = min + 1; j < arr.length; j++) {
                //找出未排序区间的最小值的下标
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            //最小值下标不等于i,交换元素位置
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 2. 冒泡排序
     * @param arr
     */
    // 把最大的每次往后移的方式，每次把最大的挪到最后
    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            // subLen = len - 1 - i 减一是因为最后一个不用再交换
            for(int j = 0, subLen = len - 1 - i; j < subLen; j++) {
                // 把大的数往后移
                if(arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    /**
     * 3. 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        // 从1开始，将第一个元素作为已经排好的数组
        for(int i = 1; i < arr.length; i++){
            // 循环已经排好序的数组，从后往前比较
            for(int j = i; j > 0; j--){
                // 如果要插入的值比排好序的小，就把排好序的向后移动
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        // 递归结束条件
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];
        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位，此时left=right 指向基准所在的下标
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }


    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            //将堆顶元素与末尾元素进行交换
            int tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }


    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] mergeSort(int[] arr,int left,int right){
        int mid = left + (right - left) / 2; // 防止整数相加越界
        if(left < right){
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            //左右归并
            merge(arr,left,mid,right);
        }
        return arr;
    }

    /**
     * 合并已经排好序的数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left; // i 指向左半部分的开始下标
        int j = mid + 1; // j 指向右半部分开始的下标
        int k = 0; // k 指向临时数组的开始坐标
        // 把较小的数先移到新数组中
        while(i <= mid && j <= right) temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        // 把左边剩余的数移入数组
        while(i <= mid)  temp[k++] = arr[i++];
        // 把右边边剩余的数移入数组
        while(j <= right) temp[k++] = arr[j++];
        // 把合并好的数组数据放到原数组中
        for(int x = 0; x < temp.length; x++) arr[x + left] = temp[x];
    }


    public static void main(String[] args) {
        int[] arr = {5,3,2,6,1,4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
