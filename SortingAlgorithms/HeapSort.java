package SortingAlgorithms;

public class HeapSort extends AnimatedSort {
	public HeapSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Heap Sort", order);
	}

	// Transform current array into a maximum or minimum heap
	private void heapify() {
		int child = 0;

		for (int i = (length() - 2) / 2; i >= 0; i--) {
			for (int j = i; 2 * j + 1 < length(); j = child) {
				child = 2 * j + 1;
				if ((2 * j + 2) < length()
						&& compare(2 * j + 1, 2 * j + 2) == order)
					child = 2 * j + 2;
				if (compare(j, child) == order)
					swap(child, j);
			}
		}
	}

	// Remove first element, which can be a max or a min, and walk down
	private void removeFirst(int newLength) {
		int child = 0;
		int listLength = newLength - 1;

		swap(0, listLength);
		for (int i = 0; 2 * i + 1 < listLength; i = child) {
			child = 2 * i + 1;
			if (2 * i + 2 < listLength && compare(child, 2 * i + 2) == order)
				child = 2 * i + 2;
			if (compare(i, child) == order)
				swap(child, i);
		}
	}

	@Override
	protected void sort() {
		int listLength = length();

		heapify();
		for (int i = 0; i < length(); i++)
			removeFirst(listLength--);
	}
}
