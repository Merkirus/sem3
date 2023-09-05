public class Polacz {
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9,11};
		int[] arr2 = {2,4,6,8};
		int[] res = polacz(arr1, arr2);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] polacz(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];

		int index = 0;

		int lower_size = arr1.length < arr2.length ? arr1.length : arr2.length;

		int i;

		for (i = 0; i < lower_size; i++) {
			result[index] = arr1[i]; 
			index++;
			result[index] = arr2[i];
			index++;
		}

		if (arr1.length > arr2.length)
			for (; index < result.length; index++, i++) result[index] = arr1[i];
		else
			for (; index < result.length; index++, i++) result[index] = arr2[i];

		return result;
	}
}