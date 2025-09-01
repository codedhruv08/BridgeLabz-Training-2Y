public class FrequencySmall {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 3, 2, 5, 6, 3, 2, 6};

        for (int i = 0; i < arr.length; i++) {
            boolean counted = false;

            
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    counted = true;
                    break;
                }
            }Z

            if (!counted) {
                int count = 1;
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] == arr[k]) {
                        count++;
                    }
                }
                System.out.println(arr[i] + "->" + count);
            }
        }
    }
}
