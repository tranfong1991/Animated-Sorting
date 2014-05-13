package SortingAlgorithms;

public class SelectionSort extends AnimatedSort {
	public SelectionSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Selection Sort", order);
	}

	@Override
	protected void sort() {
		int listLength = length();
		int minOrMax;

		for (int i = 0; i < listLength; i++) {
			minOrMax = i;
			for (int j = i + 1; j < listLength; j++) {
				if (compare(j, minOrMax) == order)
					minOrMax = j;
				sleep();
			}
			if (minOrMax != i)
				swap(minOrMax, i);
		}
	}
}
