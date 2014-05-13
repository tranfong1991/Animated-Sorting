package SortingAlgorithms;

import ArrayPosition.ArrayPosition;

public class MergeSort extends AnimatedSort {
	public MergeSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Merge Sort", order);
	}

	private ArrayPosition[] split(int start, int end) {
		ArrayPosition[] pos = new ArrayPosition[2];
		int length = end - start + 1;
		int mid = length / 2 + start;

		if (start != end) {
			pos[0] = new ArrayPosition(start, mid - 1);
			pos[1] = new ArrayPosition(mid, end);
		}

		return pos;
	}

	private void merge(ArrayPosition p1, ArrayPosition p2) {
		Integer[] arr = new Integer[p2.end - p1.start + 1];
		int s1 = p1.start, s2 = p2.start;
		int e1 = p1.end, e2 = p2.end;
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

		int start = p1.start;
		for (int k = 0; k < arr.length; k++, start++)
			setObj(start, arr[k]);
	}

	private void mergeSort(ArrayPosition ap) {
		ArrayPosition[] pos = split(ap.start, ap.end);

		if (pos[0] != null)
			mergeSort(pos[0]);
		if (pos[1] != null)
			mergeSort(pos[1]);

		if (pos[0] != null && pos[1] != null)
			merge(pos[0], pos[1]);
	}

	@Override
	protected void sort() {
		mergeSort(new ArrayPosition(0, length() - 1));
	}
}
