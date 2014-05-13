package SortingAlgorithms;

public class CocktailShakerSort extends AnimatedSort {
	public CocktailShakerSort(int width, int height, Integer[] obj, int order) {
		super(width, height, obj, "Cocktail Shaker Sort", order);
	}

	@Override
	protected void sort() {
		int start = 0;
		int end = length() - 1;

		while (end > start) {
			for (int i = start; i < end; i++) {
				if (compare(i + 1, i) == order)
					swap(i, i + 1);
			}
			for (int i = end - 1; i > start; i--) {
				if (compare(i, i - 1) == order)
					swap(i, i - 1);
			}
			start++;
			end--;
		}
	}
}
