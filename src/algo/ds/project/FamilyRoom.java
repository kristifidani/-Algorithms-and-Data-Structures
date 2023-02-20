package algo.ds.project;

/**
 * Class representing a FamilyRoom type
 * 
 * @author Kristi
 *
 */
public class FamilyRoom extends Room {

	private final int capacity = 4;
	private final int cleanTime = 2;

	/**
	 * @param wing
	 * @param roomNumber
	 * @param id
	 * @param status
	 */
	public FamilyRoom(String wing, int roomNumber, int id, String status) {
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
		return "FamilyRoom{" + "wing=" + wing + ", roomNumber=" + roomNumber + ", id=" + id + ", status=" + status
				+ '}';
	}
}
