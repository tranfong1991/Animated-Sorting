package SortingAlgorithms;

import Range.Range;

public class MergeSort extends AnimatedSort {
	public MergeSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Merge Sort", order);
	}

	private Range[] split(int start, int end) {
		Range[] range = new Range[2];
		int length = end - start + 1;
		int mid = length / 2 + start;

		if (start != end) {
			range[0] = new Range(start, mid - 1);
			range[1] = new Range(mid, end);
		}

		return range;
	}

	private void merge(Range r1, Range r2) {
		Integer[] arr = new Integer[r2.end - r1.start + 1];
		int s1 = r1.start, s2 = r2.start;
		int e1 = r1.end, e2 = r2.end;
		int i = 0;

		while (true) {
			if (compare(s2, s1) == order) {
				arr[i++] = getObj(s2);
				if (s2 != e2)
					s2++;
				else {
					for (int j = s1; j <= e1; j++)
						arr[i++] = getObj(j);
					break;
				}
			} else {
				arr[i++] = getObj(s1);
				if (s1 != e1)
					s1++;
				else {
					for (int j = s2; j <= e2; j++)
						arr[i++] = getObj(j);
					break;
				}
			}
		}

		int start = r1.start;
		for (int k = 0; k < arr.length; k++, start++)
			setObj(start, arr[k]);
	}

	private void mergeSort(Range r) {
		Range[] range = split(r.start, r.end);

		if (range[0] != null)
			mergeSort(range[0]);
		if (range[1] != null)
			mergeSort(range[1]);

		if (range[0] != null && range[1] != null)
			merge(range[0], range[1]);
	}

	@Override
	protected void sort() {
		mergeSort(new Range(0, length() - 1));
	}
}
