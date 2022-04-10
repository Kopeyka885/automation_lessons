package qa.automation.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StorekeeperSenior extends StorekeeperJunior {

    @Override
    public void bubbleSort(ArrayList<Integer> data) {
        System.out.println("Я сеньер помидор, бабл-сорт для джунов");
    }

    public void mergeSort(int[] data, int n) {
        if (n < 2) {
            return;
        }
        int middleIndex = n / 2;
        int[] leftHalfArray = Arrays.copyOfRange(data,0, middleIndex);
        int[] rightHalfArray = Arrays.copyOfRange(data, middleIndex, data.length);
        mergeSort(leftHalfArray, middleIndex);
        mergeSort(rightHalfArray, n - middleIndex);

        mergeArrays(data, leftHalfArray, rightHalfArray, middleIndex, n - middleIndex);
    }

    private void mergeArrays(int[] result, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]){
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }
        while (i < left){
            result[k++] = leftArray[i++];
        }
        while (j < right){
            result[k++] = rightArray[j++];
        }

        this.array = (ArrayList<Integer>) Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
