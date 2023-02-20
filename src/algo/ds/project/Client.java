package algo.ds.project;

/**
 * Class representing a Client
 * 
 * @author Kristi
 *
 */
public class Client implements Comparable<Client> {

	private String name;
	private String emailAddress;
	private int id;
	private boolean checkedOut = false;
	private Room bookedRoom;

	/**
	 * @param name
	 * @param emailAddress
	 * @param id
	 */
	public Client(String name, String emailAddress, int id) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.id = id;
	}

	/**
	 * @return
	 */
	public Room getBookedRoom() {
		return bookedRoom;
	}

	/**
	 * @param bookedRoom
	 */
	public void setBookedRoom(Room bookedRoom) {
		checkedOut = bookedRoom == null;
		this.bookedRoom = bookedRoom;
	}

	/**
	 * @return
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}

	/**
	 * @param checkedOut
	 */
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Client{" + "name=" + name + ", emailAddress=" + emailAddress + ", id=" + id + ", bookedRoom="
				+ bookedRoom + '}';
	}

	@Override
	public int compareTo(Client o) {
		return ((Comparable<Integer>) this.id).compareTo(o.id);
	}
}
