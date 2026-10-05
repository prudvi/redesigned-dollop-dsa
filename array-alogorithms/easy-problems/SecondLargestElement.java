
public class SecondLargestElement {
    /**
     * Finds the second largest element in an array.
     *
     * @param arr The input array.
     * @return The second largest element or Integer.MIN_VALUE if all elements are the same.
     */
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        boolean foundFirst = false;

        for (int num : arr) {
            if (!foundFirst || num != arr[0]) {
                if (num > first) {
                    second = first;
                    first = num;
                    foundFirst = true;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }

        // If all elements are the same, return Integer.MIN_VALUE or a specific value
        return first == second ? Integer.MIN_VALUE : second;
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 3, 5, 9, 7}; // Example array
        int secondLargest1 = findSecondLargest(arr1);
        System.out.println("Test Case 1 - The second largest element is: " + secondLargest1);

        // Test Case 2: All elements are the same
        int[] arr2 = {5, 5, 5, 5};
        try {
            int secondLargest2 = findSecondLargest(arr2);
            System.out.println("Test Case 2 - The second largest element is: " + secondLargest2);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 2 - Exception: " + e.getMessage());
        }
        int secondLargest2 = findSecondLargest(arr2);
        System.out.println("Test Case 2 - The second largest element is: " + secondLargest2);

        // Test Case 3: Array with only one element
        int[] arr3 = {1};
        try {
            int secondLargest3 = findSecondLargest(arr3);
            System.out.println("Test Case 3 - The second largest element is: " + secondLargest3);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 3 - Exception: " + e.getMessage());
        }

        // Test Case 4: Negative numbers
        int[] arr4 = {-1, -3, -5, -9, -7};
        int secondLargest4 = findSecondLargest(arr4);
        System.out.println("Test Case 4 - The second largest element is: " + secondLargest4);
    }
}