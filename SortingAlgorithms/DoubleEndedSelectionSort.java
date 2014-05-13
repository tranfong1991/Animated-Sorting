package SortingAlgorithms;

public class DoubleEndedSelectionSort extends AnimatedSort {
	public DoubleEndedSelectionSort(int width, int height, Integer[] obj,
			int order) {
		super(width, height, obj, "Double Ended Selection Sort", order);
	}

	@Override
	public void sort() {
		int start = 0;
		int end = length() - 1;
		int first = 0, last = 0;

		while (end > start) {
			first = start;
			last = end;
			for (int i = start; i <= end; i++) {
				if (compare(i, first) == order)
					first = i;
				if (compare(last, i) == order)
					last = i;
				sleep();
			}
			if (first != start) {
				// In case of start == last,
				// update last position to the current first position
				if (start == last)
					last = first;
				swap(first, start);
			}
			if (last != end)
				swap(last, end);
			start++;
			end--;
		}
	}
}
