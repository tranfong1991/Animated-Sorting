package SortingAlgorithms;

public class BubbleSort extends AnimatedSort {
	public BubbleSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Bubble Sort", order);
	}

	@Override
	protected void sort() {
		int listLength = length();

		while (listLength != 0) {
			for (int i = 0; i < listLength; ++i) {
				if (i != listLength - 1 && compare(i + 1, i) == order)
					swap(i, i + 1);
			}
			listLength--;
		}
	}
}
