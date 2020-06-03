import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSort {
    public static void main(String[] args) {
        int totalData = 8000000;
        int[] arr = new int[totalData];
        for (int i = 0; i < totalData; i++) {
            arr[i] = (int) (Math.random() * totalData);
        }

        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");
        String startStr = simpleDateFormat.format(startDate);
        System.out.println("排序前的时间是：" + startStr);
        String type = "";
        // 开始排序

        // type = "归并排序";
        // new MergeSort().test(arr);

        type = "基数排序（桶排序）";
        new RadixSort().test(arr);;

        // type = "冒泡排序";
        // new BubbleSort().test(arr);

        Date endDate = new Date();
        String endStr = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间是：" + endStr);
        System.out.println(type + "消耗时间：" + (endDate.getTime() - startDate.getTime() + "毫秒"));
    }


    
}