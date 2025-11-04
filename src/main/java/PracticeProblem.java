public class PracticeProblem {

	public static void main(String args[]) {

	}
    public static int[] bubbleSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++; // Comparison
                if (nums[j] > nums[j + 1]) {
                    // Swap
                    double temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps += 3; // Each swap counts as 3
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization
        }

        return new int[]{swaps, steps};
    }


    public static int[] selectionSort(double[] arr) {
        int swapEvent = 0;
        int stepEvent = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                stepEvent++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapEvent++;
                }
            }
            swapEvent += 3;
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return new int[]{swapEvent, stepEvent};
    }


    public static int[] insertionSort(double[] nums) {
        int swaps = 0;
        int steps = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            double key = nums[i];
            swaps++; // Assignment to key counts as 1
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                steps++; // Comparison that is true
                nums[j + 1] = nums[j];
                swaps++; // Single variable change counts as 1
                j = j - 1;
            }

//            // Count the final comparison that breaks the loop
//            if (j >= 0) {
//                steps++;
//            }

            nums[j + 1] = key;
            swaps++; // Final assignment counts as 1
        }

        return new int[]{swaps, steps};
    }

    public static String leastSwaps(double[] nums) {
        // Copy arrays for each sort
        double[] bubbleArr = nums.clone();
        double[] selectionArr = nums.clone();
        double[] insertionArr = nums.clone();

        // Run each sort
        int[] bubbleResult = bubbleSort(bubbleArr);
        int[] selectionResult = selectionSort(selectionArr);
        int[] insertionResult = insertionSort(insertionArr);

        int bubbleSwaps = bubbleResult[0];
        int selectionSwaps = selectionResult[0];
        int insertionSwaps = insertionResult[0];

        // Find minimum swaps
        int minSwaps = Math.min(bubbleSwaps, Math.min(selectionSwaps, insertionSwaps));

        // Return first alphabetically if tie
        if (bubbleSwaps == minSwaps) {
            return "Bubble";
        } else if (insertionSwaps == minSwaps) {
            return "Insertion";
        } else {
            return "Selection";
        }
    }


    public static String leastIterations(double[] nums) {
        // Copy arrays for each sort
        double[] bubbleArr = nums.clone();
        double[] selectionArr = nums.clone();
        double[] insertionArr = nums.clone();

        // Run each sort
        int[] bubbleResult = bubbleSort(bubbleArr);
        int[] selectionResult = selectionSort(selectionArr);
        int[] insertionResult = insertionSort(insertionArr);

        int bubbleSteps = bubbleResult[1];
        int selectionSteps = selectionResult[1];
        int insertionSteps = insertionResult[1];

        // Find minimum steps
        int minSteps = Math.min(bubbleSteps, Math.min(selectionSteps, insertionSteps));

        // Return first alphabetically if tie
        if (bubbleSteps == minSteps) {
            return "Bubble";
        } else if (insertionSteps == minSteps) {
            return "Insertion";
        } else {
            return "Selection";
        }
    }

}
