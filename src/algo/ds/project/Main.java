package algo.ds.project;

/**
 * @author Kristi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelManagementSystem hms = new HotelManagementSystem();

		hms.addClient("Kristi", "k@hotmail.com");
		hms.addClient("Test", "t@gmail.com");
		hms.addClient("John", "j@live.com");
		hms.addClient("Doe", "d@live.com");
		hms.addClient("Roger", "r@vub.be");

		hms.addDoubleRoom("A", 10, "Ready");
		hms.addDoubleRoom("A", 12, "Occupied");
		hms.addDoubleRoom("B", 13, "CheckedOut");
		hms.addDoubleRoom("C", 14, "CheckedOut");
		hms.addDoubleRoom("D", 15, "Ready");
		hms.addDoubleRoom("E", 17, "CheckedOut");
		hms.addDoubleRoom("F", 18, "CheckedOut");
		hms.addDoubleRoom("F", 19, "Ready");

		hms.addFamilyRoom("B", 21, "Ready");
		hms.addFamilyRoom("A", 23, "CheckedOut");
		hms.addFamilyRoom("B", 24, "Occupied");
		hms.addFamilyRoom("B", 26, "CheckedOut");
		hms.addFamilyRoom("D", 27, "CheckedOut");
		hms.addFamilyRoom("F", 28, "CheckedOut");
		hms.addFamilyRoom("E", 29, "CheckedOut");
		hms.addFamilyRoom("A", 40, "Ready");
		hms.addFamilyRoom("F", 50, "Ready");

		System.out.println("~~~~~~ Clients ~~~~~~ \n");
		hms.printClients();

		System.out.println("~~~~~~ All Rooms ~~~~~~ \n");
		hms.printRooms();

		System.out.println("~~~~~ Performing Check-in ~~~~~~ \n");
		System.out.println("Family rooms check-in:");
		hms.checkInFamilyRoom(1);
		hms.checkInFamilyRoom(2);
		System.out.println("Double rooms check-in:");
		hms.checkInDoubleRoom(3);
		hms.checkInDoubleRoom(4);
		hms.checkInDoubleRoom(5);

		System.out.println("\n~~~~~~ Clients after Check-in ~~~~~~ \n");
		hms.printClients();

		System.out.println("~~~~~ Available Rooms ~~~~~ \n");
		hms.printAvailableRooms();

		System.out.println("~~~~~~ Occupied Rooms ~~~~~~ \n");
		hms.printOccupiedRooms();

		System.out.println("~~~~~~ Performing Check-out ~~~~~~");
		hms.checkOutRoom(3);
		hms.checkOutRoom(1);

		System.out.println("\n~~~~~~ All rooms after Check-in/out ~~~~~~ \n");
		hms.printRooms();
		System.out.println("~~~~~~ Clients after Check-out ~~~~~~ \n");
		hms.printClients();

		System.out.println("~~~~~~ Search Available Rooms ~~~~~~");
		hms.searchAvailableRooms().toString();

		System.out.println("\n~~~~~~ Add Wings ~~~~~~");
		hms.addWing("A");
		hms.addWing("B");
		hms.addWing("C");
		hms.addWing("D");
		hms.addWing("E");
		hms.addWing("F");

		System.out.println("~~~~~~ Connect Wings ~~~~~~");
		hms.connectWings("A", "B", 10);
		hms.connectWings("A", "D", 5);
		hms.connectWings("A", "E", 60);
		hms.connectWings("B", "C", 100);
		hms.connectWings("B", "E", 20);
		hms.connectWings("C", "D", 20);
		hms.connectWings("C", "F", 15);
		hms.connectWings("E", "F", 5);
		hms.connectWings("F", "D", 45);

		System.out.println("~~~~~~ Organize Cleaning ~~~~~~");
		hms.organizeCleaning();
	}
}
