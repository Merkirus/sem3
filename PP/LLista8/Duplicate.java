public class Duplicate {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {0,3,1,4};
		int[] res = duplicate(arr1, arr2);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] duplicate(int[] in, int[] mult) {
		int size = in.length < mult.length ? in.length : mult.length;
		int length = 0;
		for (int i = 0; i < size; i++)
			length += mult[i];
		int[] result = new int[length];

		int index = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < mult[i]; j++) {
				result[index] = in[i];
				index++;
			}
		}

		return result;
	}
}

