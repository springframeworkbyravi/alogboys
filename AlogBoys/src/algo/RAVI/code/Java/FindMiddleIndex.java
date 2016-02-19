package algo.RAVI.code.Java;

/**
 * Find out middle index where sum of both ends are equal - See more at:
 * 
 * @author ravikson
 * 
 * @Description You are given an array of numbers. Find out the array index or
 *              position where sum of numbers preceding the index is equals to
 *              sum of numbers succeeding the index.
 * 
 *              Example: { 2, 4, 4, 5, 4, 1 } ----------------------------
 *              A.(compare on middle) 2+4+4=10 <=> 5+4+1=10
 * 
 *              {1,1,1,1,1,3,2,0} ---------------------------- A. (compare on
 *              middle) 1+1+1+1 = 4 <=> 1+3+2+0 = 6 B. (if left is less than
 *              right, increase index by 1) 1+1+1+1+1 = 5 <=> 3+2+0 = 5
 */
public class FindMiddleIndex {
	public static void main(String[] args) {
		//int[] numArray = { 2, 4, 4, 5, 4, 1 };
		int[] numArray = { 1, 1, 1, 1, 1, 3, 2, 0 };
		System.out
				.println("Starting from index 0, adding numbers BEFORE index ->  "
						+ findMiddleIndex(numArray) + " <- and adding rest of the numbers can be equal");
	}

	private static int findMiddleIndex(int[] numArray) {
		int size = numArray.length;
		int sumA = 0, sumB = 0;
		int index = 0;

		if ((size > 2) && (size % 2 == 0)) {
			int temp = size / 2;
			do {
				sumA = 0;
				sumB = 0;
				for (int i = 0; i < temp; i++) {
					sumA += numArray[i];
				}
				for (int i = temp; i < size; i++) {
					sumB += numArray[i];
				}
				if ((sumA < sumB) && (temp < size)) {
					temp = temp + 1;
				} else if ((sumA > sumB) && (temp < size)) {
					temp = temp - 1;
				} else {
					index = temp;
				}
			} while (sumA != sumB);
		} else {
			index = -1;
		}
		return index;
	}
}
