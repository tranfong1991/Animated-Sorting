package SortingAlgorithms;

public class InsertionSort extends AnimatedSort {
	public InsertionSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Insertion Sort", order);
	}

	@Override
	protected void sort() {
		int listLength = length();
		int j = 0;

		for (int i = 1; i < listLength; i++) {
			j = i;
			while (j > 0 && compare(j, j - 1) == order) {
				swap(j, j - 1);
				j--;
			}
		}
	}
}
