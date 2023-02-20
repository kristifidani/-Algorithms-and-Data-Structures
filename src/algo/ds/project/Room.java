package algo.ds.project;

/**
 * General class representing a Room
 * 
 * @author Kristi
 *
 */
public class Room extends Object implements Comparable<Room> {

	protected String wing;
	protected int roomNumber;
	protected int id;
	protected String status;

	/**
	 * @param wing
	 * @param roomNumber
	 * @param id
	 * @param status
	 */
	public Room(String wing, int roomNumber, int id, String status) {
		this.wing = wing;
		this.roomNumber = roomNumber;
		this.id = id;
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	@Override
	public int compareTo(Room o) {
		return ((Comparable<String>) status).compareTo(o.status);
	}
}
