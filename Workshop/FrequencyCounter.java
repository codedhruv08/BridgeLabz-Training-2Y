public class FrequencyCounter {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 6, 3, 2, 5, 6, 6, 2, 6};
        boolean[] visited = new boolean[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (visited[i]) continue;

            int count = 0;
            for (int j = i ; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr1[i] + ": " + count + " times");
        }
    }
}
