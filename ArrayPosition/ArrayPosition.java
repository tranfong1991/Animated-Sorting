package ArrayPosition;

// Store the begin position and the end position of an array
// Convenient for merge sort and quick sort 
// because it just gives the positions in the same array instead of making sub arrays
public class ArrayPosition {
	public int start;
	public int end;

	public ArrayPosition(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
