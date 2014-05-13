package SortingAlgorithms;

public class ShellSort extends AnimatedSort {
	public ShellSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Shell Sort", order);
	}

	@Override
	protected void sort() {
		int listLength = length();
		int k = listLength / 2;

		while (k != 0) {
			for (int i = 0; i < listLength - k; i++) {
				if (compare(i + k, i) == order) {
					swap(i, i + k);
					for (int j = i; j != 0 && j % k == 0; j -= k) {
						if (compare(j, j - k) == order)
							swap(j, j - k);
						else
							break;
					}
				} else
					sleep();
			}
			k = k / 2;
		}
	}
}
