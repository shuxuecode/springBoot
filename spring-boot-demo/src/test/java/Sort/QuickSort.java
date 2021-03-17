package Sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.print("排序前：");
        System.out.println(printArray(arr));
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        System.out.print("排序后：");
        System.out.println(printArray(arr));
        System.out.println();

    }

    /**
     * 基本思想：
     * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,
     * 然后再用同样的方法递归地排序划分的两部分。
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {

        // 基准值
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {// 从右向左小循环
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high]; // 比key值小的移到低端

            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {// 从左向右小循环
                low++;
            }

            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low]; // 比key值大的 移到高端

            System.out.println(printArray(arr));
            System.out.println("low: " + low + "    high: " + high);
        }

        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;// 把轴元素放在轴所在地位置

        return low;// 返回基准值所在的位置
    }

    private static void quickSort(int[] data, int low, int high) {
        System.out.println("调用： " + low);
        // 递归
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = partition(data, low, high);
            quickSort(data, low, index - 1);
            quickSort(data, index + 1, high);
        }
    }


    public static String printArray(int[] arr) {
        StringBuffer str = new StringBuffer();
        for (int i : arr) {
            str.append(i + " , ");
        }
        return str.toString();
    }

}
