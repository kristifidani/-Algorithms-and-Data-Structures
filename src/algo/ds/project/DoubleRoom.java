package algo.ds.project;

/**
 * Class representing a DoubleRoom type
 * 
 * @author Kristi
 *
 */
public class DoubleRoom extends Room {

	private final int capacity = 2;
	private final int cleanTime = 1;

	/**
	 * @param wing
	 * @param roomNumber
	 * @param id
	 * @param status
	 */
	public DoubleRoom(String wing, int roomNumber, int id, String status) {
		super(wing, roomNumber, id, status);
	}

	/**
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return
	 */
	public int getCleanTime() {
		return cleanTime;
	}

	@Override
	public String toString() {
		return "DoubleRoom{" + "wing=" + wing + ", roomNumber=" + roomNumber + ", id=" + id + ", status=" + status
				+ '}';
	}
}
