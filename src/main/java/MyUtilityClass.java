public final class MyUtilityClass {

  //constants
  final static int MAXIMUM = 3000;
  
  //private constructor
  private MyUtilityClass() {
  }
  
  //methods - function
  public static int returnZero() {
    return 0;
  }

  //overloading methods
  //parameters have to be different
  public static void removeValue(Integer[] arr, int index) {
    //remove the value at the provided index in the array
  }

  public static void removeValue(Integer[] arr, Integer value) {
    //find the value and remove it.
  }

  public static void removeValue(String[] arr, int index) {
    //remove the value at the provided index in the array
  }

  public static void removeValue(String[] arr, String value) {
    //find the value and remove it.
  }

  //overloaded version to return correct data types
  
  public static int add(int a, int b) {
    return a + b;
  }

  public static double add(double a, double b) {
    return a + b;
  }
}
