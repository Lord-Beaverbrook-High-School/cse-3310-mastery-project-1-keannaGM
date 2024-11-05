import java.util.Arrays;
public class Task {
  //put your task here
  public static void quicksort(int[] arr, int min, int max){
    int pivot = (int)(Math.random()*(max - min)+min); //randomly selects the pivot
    System.out.println(arr[pivot]);
    int temp = min;
    boolean scoot = false; //boolean which checks if the variable being compared to the pivot can be moved without moving the pivot
      if (min < max){
        for (int i = min; i <= max; i++){ //variable that is initially compared to the pivot
            if (i < pivot) { //checks to see that "i" is to the left of the pivot
              if (arr[i] > arr[pivot]) {
                for (int w = max; w >= pivot + 1; w--) { //variable being compared to "i" in the case that "i" is greater than the pivots value
                  if (arr[w] < arr[pivot] && w > pivot) { //if "w" is less than the pivot and is to the right of the pivot than "i" and "w" can be swapped using the variable temp
                    //test printing
                    System.out.println("testing 1");
                    //System.out.println(arr[w]);
                    //System.out.println(arr[pivot]);
                    //System.out.println(w);
                    //System.out.println(pivot);
                    System.out.println(Arrays.toString(arr));
                    temp = arr[w];
                    arr[w] = arr[i];
                    arr[i] = temp;
                    scoot = true; //tells 'i' not to switch with the pivot
                    break;
                  }
                }
                if (!scoot) { //if "i" can not be swapped with anything that is not the pivot
                  temp = arr[i];
                  for (int mooch = i; mooch < pivot; mooch++) { //moves all values after and including the pivot to the right to make space for the variable being moved
                    arr[mooch] = arr[mooch + 1];
                  }
                  arr[pivot] = temp;
                  pivot--; //ensures the pivot's numerical value is not changing
                  i--; //ensures the comparing variable's value is not changing
                  break;
                  }
              }
            } else { //checks if "i" is less than the pivot and to the right of the pivot CAN NOT BE REACHED
              while (i >= min) {
                if (arr[i] < arr[pivot]) {
                  for (int x = min; x < pivot; x++) { //variable being compared to "i" if "i" is less than the pivot
                    if (arr[x] > arr[pivot] && x > pivot) { //if x is greater than the pivot 'x' and 'i' can be swapped
                      //test printing
                      System.out.println("testing 2");
                      //System.out.println(arr[x]);
                      //System.out.println(arr[pivot]);
                      //System.out.println(x);
                      //System.out.println(pivot);
                      System.out.println(Arrays.toString(arr));
                      temp = arr[x];
                      arr[x] = arr[i];
                      arr[i] = temp;
                      scoot = true; //tells program not to swap 'i' with the pivot
                      break;
                    }
                    if (!scoot) { //if there is no value to the right of the pivot that can be swapped with 'i' so pivot and 'i' must swap places
                      temp = arr[i];
                      for (int dooch = i; dooch > pivot; dooch--) {
                        arr[dooch] = arr[dooch - 1];
                      }
                      arr[pivot] = temp;
                      pivot++; //ensures the pivot's value remains the same
                      break;
                    }

                  }
                }
              }
            }
        }
        quicksort(arr, min, pivot - 1); //recursively runs the first half of the array ending at the pivot
        quicksort(arr, pivot + 1, max); //recursively runs the second half of the array starting at the pivot
      }
  }
  public static void main(String[] args) {
    int[] arr = {9,11,4,2,6,8}; //defines the array which will be sorted
    quicksort(arr,0, arr.length-1);
    for (int i: arr){
      System.out.print(i + ", ");
    }
    System.out.println();
  }
}
//program does not swap all values because it can not reach else statement (pivot is less than 'i') due to infinite loop
/* testing with array (9,11,4,2,6,8):
TEST 1
4 (pivot)
testing 1
[9, 11, 4, 2, 6, 8]

TEST 2
6
4
testing 1
[11, 4, 2, 6, 9, 8]*/