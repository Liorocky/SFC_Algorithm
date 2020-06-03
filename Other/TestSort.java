import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSort {
    public static void main(String[] args) {
        int totalData = 80000;
        int[] arr = new int[totalData];
        for (int i = 0; i < totalData; i++) {
            arr[i] = (int) (Math.random() * totalData);
        }

        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");
        String startStr = simpleDateFormat.format(startDate);
        System.out.println("排序前的时间是：" + startStr);

        //开始排序
        new MergeSort().test(arr);

        // new BubbleSort().test(arr);

        Date endDate = new Date();
        String endStr = simpleDateFormat.format(endDate);
        System.out.println("排序后的时间是：" + endStr);
        System.out.println("消耗时间：" + (endDate.getTime() - startDate.getTime() + "毫秒"));
    }


    
}