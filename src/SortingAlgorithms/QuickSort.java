package SortingAlgorithms;

import java.util.Random;

import Range.Range;

public class QuickSort extends AnimatedSort {
	public QuickSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Quick Sort", order);
	}

	private Range[] partition(int start, int end) {
		Random rand = new Random();
		// Randomly choose an index between start and end (inclusive)
		int pivot = rand.nextInt(end - start + 1) + start;
		int i = start;
		int j = end;
		Range[] range = new Range[2];

		while (i <= j) {
			if (compare(pivot, i) == order) {
				if (j != pivot && !(compare(j, pivot) != order)) {
					swap(i, j);
					i++;
				}
				j--;
			} else
				i++;
		}

		// If i is on the left hand side of pivot, meaning that obj[i] is still
		// larger or smaller than obj[j], we swap pivot with i instead of with j.
		// Otherwise, check if pivot != j to prevent swapping in the same
		// position
		if (i < pivot) {
			swap(pivot, i);
			pivot = i;
		} else if (pivot != j) {
			swap(pivot, j);
			pivot = j;
		}

		if (pivot != start)
			range[0] = new Range(start, pivot - 1);
		if (pivot != end)
			range[1] = new Range(pivot + 1, end);

		return range;
	}

	private void quickSort(Range r) {
		Range[] pos = partition(r.start, r.end);

		if (pos[0] != null)
			quickSort(pos[0]);
		if (pos[1] != null)
			quickSort(pos[1]);
	}

	@Override
	protected void sort() {
		quickSort(new Range(0, length() - 1));
	}
}
