package SortingAlgorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public abstract class AnimatedSort extends JComponent implements Runnable {
	final static private int SLEEP_TIME = 30;
	final static private int BASELINE = 200;
	final static private int MAGNIFICATION = 2;
	final static private Color RECT_COLOR = new Color(0x0066FF);
	final static private Color FINISH_COLOR = Color.GREEN;
	final static private Color BORDER_COLOR = Color.BLACK;

	// 1 : a > b
	// -1: a < b
	protected int order;
	private Graphics2D g2;
	private Integer[] obj;
	private Rectangle[] rect;
	private String algorithmName;
	private boolean isSorted = false;

	protected AnimatedSort(int width, int height, Integer[] obj, String name,
			int order) {
		this.order = order;
		this.obj = obj.clone();
		this.algorithmName = name;
		this.rect = new Rectangle[obj.length];

		int h, w = (width - 20) / obj.length;
		for (int i = 0; i < rect.length; ++i) {
			h = this.obj[i] * MAGNIFICATION;
			if (i == 0)
				this.rect[i] = new Rectangle(10, BASELINE - h, w, h);
			else
				this.rect[i] = new Rectangle(rect[i - 1].x + w, BASELINE - h,
						w, h);
		}
	}

	public String getAlgorithmName() {
		return this.algorithmName;
	}

	protected int length() {
		return obj.length;
	}

	protected Integer getObj(int i) {
		if (obj[i] == null)
			throw new NullPointerException();
		return obj[i];
	}

	// Change value and repaint the corresponding rectangle
	protected void setObj(int i, Integer val) {
		if (obj[i] == null)
			throw new NullPointerException();

		obj[i] = val;
		modifyRect(i);
		sleepAndRepaint();
	}

	protected int compare(int i, int j) {
		if (obj[i] == null || obj[j] == null)
			throw new NullPointerException();

		if (obj[i] < obj[j])
			return -1;
		if (obj[i] > obj[j])
			return 1;
		return 0;
	}

	// Swap and repaint the corresponding rectangles
	protected void swap(int i, int j) {
		if (obj[i] == null || obj[j] == null)
			throw new NullPointerException();

		Integer temp = obj[i];
		obj[i] = obj[j];
		obj[j] = temp;

		swapRect(i, j);
		sleepAndRepaint();
	}

	private void modifyRect(int i) {
		if (rect[i] == null)
			throw new NullPointerException();

		int height = obj[i] * MAGNIFICATION;
		rect[i].height = height;
		rect[i].y = BASELINE - height;
	}

	private void swapRect(int i, int j) {
		if (rect[i] == null || rect[j] == null)
			throw new NullPointerException();

		int tempY = rect[i].y;
		rect[i].y = rect[j].y;
		rect[j].y = tempY;

		int tempHeight = rect[i].height;
		rect[i].height = rect[j].height;
		rect[j].height = tempHeight;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		for (int i = 0; i < rect.length; ++i) {
			if (!isSorted)
				g2.setColor(RECT_COLOR);
			else
				g2.setColor(FINISH_COLOR);
			g2.fill(rect[i]);
			g2.setPaint(BORDER_COLOR);
			g2.draw(rect[i]);
		}
	}

	protected void sleep() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void sleepAndRepaint() {
		sleep();
		revalidate();
		repaint();
	}

	public void run() {
		// Display rectangles on screen when first started.
		// Otherwise, it won't show anything until swap is called.
		revalidate();
		sort();
		isSorted = true;
		repaint();
	}

	protected abstract void sort();
}
