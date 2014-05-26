import java.util.Random;
import SortingAlgorithms.AnimatedSort;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.CocktailShakerSort;
import SortingAlgorithms.DoubleEndedSelectionSort;
import SortingAlgorithms.HeapSort;
import SortingAlgorithms.InsertionSort;
import SortingAlgorithms.MergeSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.SelectionSort;
import SortingAlgorithms.ShellSort;
import javax.swing.JFrame;

public class AnimationMain {
	static int ORDER;
	static Integer[] NUM;
	final static int WIDTH = 300;
	final static int HEIGHT = 240;
	final static int LENGTH = 9;

	static final void randomNumbersGenerator(String n) {
		int num = Integer.parseInt(n);
		Random rand = new Random();

		NUM = new Integer[num];
		for (int i = 0; i < NUM.length; i++)
			NUM[i] = i + 1;

		// Shuffle the array
		for (int i = NUM.length - 1; i > 0; i--) {
			int index = rand.nextInt(i + 1);

			int a = NUM[index];
			NUM[index] = NUM[i];
			NUM[i] = a;
		}
	}

	public static void main(String[] args) {
		int x = 200, y = 0;
		JFrame[] frame = new JFrame[LENGTH];

		if (Integer.parseInt(args[0]) <= 0) {
			System.err.println("Invalid argument: Number of elements! Exiting!");
			return;
		}
		if (Integer.parseInt(args[1]) != 1 && Integer.parseInt(args[1]) != -1) {
			System.err.println("Invalid argument: Order! Exiting!");
			return;
		}
		randomNumbersGenerator(args[0]);
		ORDER = Integer.parseInt(args[1]);

		for (int i = 0; i < LENGTH; i++) {
			frame[i] = new JFrame();
			frame[i].setLocation(x, y);
			frame[i].setSize(WIDTH, HEIGHT);
			frame[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame[i].setVisible(true);

			// Go to a new line after 3 windows
			if (x == 800) {
				x = 200;
				y = y + HEIGHT;
			} else
				x += WIDTH;
		}

		AnimatedSort[] sort = new AnimatedSort[LENGTH];
		sort[0] = new BubbleSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[1] = new CocktailShakerSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[2] = new InsertionSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[3] = new SelectionSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[4] = new DoubleEndedSelectionSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[5] = new ShellSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[6] = new HeapSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[7] = new MergeSort(WIDTH, HEIGHT, NUM, ORDER);
		sort[8] = new QuickSort(WIDTH, HEIGHT, NUM, ORDER);

		for (int i = 0; i < LENGTH; i++) {
			frame[i].setTitle(sort[i].getAlgorithmName());
			frame[i].add(sort[i]);
		}

		for (int i = 0; i < LENGTH; i++) {
			new Thread(sort[i]).start();
		}
	}
}
