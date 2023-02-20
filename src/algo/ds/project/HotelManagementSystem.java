package algo.ds.project;

import data.structures.Graph;
import data.structures.PriorityQueue;
import data.structures.Queue;
import data.structures.RbTreeAction;
import data.structures.RedBlackTree;
import data.structures.Vector;

/**
 * @author Kristi
 *
 */
public class HotelManagementSystem implements IManagementSystem {

	private RedBlackTree clients = new RedBlackTree();
	private RedBlackTree doubleRoom = new RedBlackTree();
	private RedBlackTree familyRoom = new RedBlackTree();
	private Graph cleaningGraph = new Graph();

	private int roomID = 0;
	private int clientID = 0;

	@Override
	public int addDoubleRoom(String wing, int roomNumber, String status) {
		doubleRoom.rbInsert(new DoubleRoom(wing, roomNumber, ++roomID, status));
		return roomID;
	}

	@Override
	public int addFamilyRoom(String wing, int roomNumber, String status) {
		familyRoom.rbInsert(new FamilyRoom(wing, roomNumber, ++roomID, status));
		return roomID;
	}

	@Override
	public int addClient(String name, String emailAddress) {
		clients.rbInsert(new Client(name, emailAddress, ++clientID));
		return clientID;
	}

	@Override
	public void printRooms() {
		doubleRoom.recPrint();
		familyRoom.recPrint();
	}

	@Override
	public void printClients() {
		clients.recPrint();
	}

	@Override
	public int checkInDoubleRoom(int client) {
		Client c = findClient(client);
		DoubleRoom dready = findDoubleRoom("Ready");
		if (dready != null) {
			dready.setStatus("Occupied");
			c.setBookedRoom(dready);
			System.out.println("Client with ID " + c.getId() + ", successfully booked double room with number "
					+ dready.getRoomNumber() + ". Room is ready!");
		} else {
			DoubleRoom dclean = findDoubleRoom("CheckedOut");
			dclean.setStatus("Occupied");
			c.setBookedRoom(dclean);
			System.out.println("Client with ID " + c.getId() + ", successfully booked double room with number "
					+ dclean.getRoomNumber() + ". Please wait " + dclean.getCleanTime() + " hour/s until it's ready!");
		}
		return c.getId();
	}

	@Override
	public int checkInFamilyRoom(int client) {
		Client c = findClient(client);
		FamilyRoom fready = findFamilyRoom("Ready");
		if (fready != null) {
			fready.setStatus("Occupied");
			c.setBookedRoom(fready);
			System.out.println("Client with ID " + c.getId() + ", successfully booked family room with number "
					+ fready.getRoomNumber() + ". Room is ready!");
		} else {
			FamilyRoom fclean = findFamilyRoom("CheckedOut");
			fclean.setStatus("Occupied");
			c.setBookedRoom(fclean);
			System.out.println("Client with ID " + c.getId() + ", successfully booked family room with number "
					+ fclean.getRoomNumber() + ". Please wait " + fclean.getCleanTime() + " hour/s until it's ready!");
		}
		return c.getId();
	}

	@Override
	public boolean checkOutRoom(int client) {
		Client c = findClient(client);
		Room r = c.getBookedRoom();
		if (r == null) {
			return false;
		} else {
			r.setStatus("CheckedOut");
		}
		c.setBookedRoom(null);
		System.out.println(
				"Client with ID " + c.getId() + ", checked-out from room with number " + r.getRoomNumber() + ".");
		return c.isCheckedOut();
	}

	@Override
	public Vector searchAvailableRooms() {
		Vector availableDoubleRooms = doubleRoom.traverseInOrderV(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if ("Ready".equals(r.status)) {
					return r.id;
				}
				return null;
			}
		});
		Vector availableFamilyRooms = familyRoom.traverseInOrderV(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if ("Ready".equals(r.status)) {
					return r.id;
				}
				return null;
			}
		});

		Vector availableRooms = new Vector(availableDoubleRooms.size() + availableFamilyRooms.size());
		for (int i = 0; i < availableDoubleRooms.size(); i++) {
			availableRooms.addLast(availableDoubleRooms.get(i));
		}
		for (int i = 0; i < availableFamilyRooms.size(); i++) {
			availableRooms.addLast(availableFamilyRooms.get(i));
		}
		if (availableRooms.isEmpty()) {
			System.out.println("There are no available rooms! \n");
		}
		return availableRooms;
	}

	@Override
	public void printAvailableRooms() {
		familyRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if (r.status.equals("Ready")) {
					System.out.println(r.toString() + "\n");
				}
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				return null;
			}
		});
		doubleRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if (r.status.equals("Ready")) {
					System.out.println(r.toString() + "\n");
				}
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				return null;
			}
		});
	}

	@Override
	public void printOccupiedRooms() {
		familyRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if (r.status.equals("Occupied")) {
					System.out.println(r.toString() + "\n");
				}
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				return null;
			}
		});
		doubleRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if (r.status.equals("Occupied")) {
					System.out.println(r.toString() + "\n");
				}
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				return null;
			}
		});
	}

	@Override
	public void addWing(String wingName) {
		cleaningGraph.addNode(wingName);
	}

	@Override
	public void connectWings(String wing1, String wing2, double distance) {
		cleaningGraph.addEdge(wing1, wing2, distance);
	}

	@Override
	public void organizeCleaning() {
		Queue toCleanDoubleRooms = doubleRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if ("CheckedOut".equals(r.status)) {
					return r.wing;
				}
				return null;
			}
		});
		Queue toCleanFamilyRooms = familyRoom.traverseInOrderQ(new RbTreeAction<Object>() {
			@Override
			public void run(RedBlackTree.ColouredTreeNode n) {
			}

			@Override
			public Object runObj(RedBlackTree.ColouredTreeNode n) {
				Room r = (Room) n.getValue();
				if ("CheckedOut".equals(r.status)) {
					return r.wing;
				}
				return null;
			}
		});

		PriorityQueue cleaning = new PriorityQueue();
		if (!toCleanFamilyRooms.empty() && !toCleanDoubleRooms.empty()) {
			cleaning.push(toCleanFamilyRooms, 1);
			cleaning.push(toCleanDoubleRooms, 2);
		} else if (!toCleanFamilyRooms.empty() && toCleanDoubleRooms.empty()) {
			cleaning.push(toCleanFamilyRooms, 1);
		} else if (toCleanFamilyRooms.empty() && !toCleanDoubleRooms.empty()) {
			cleaning.push(toCleanDoubleRooms, 2);
		} else {
			System.out.println("No rooms for cleaning!!");
		}

		Queue start = (Queue) cleaning.pop();
		cleaningGraph.shortestPath((String) start.pop());
	}

	/**
	 * @param client
	 * @return
	 */
	private Client findClient(int client) {
		return (Client) clients.find(new Client("", "", client));
	}

	/**
	 * @param status
	 * @return
	 */
	private DoubleRoom findDoubleRoom(String status) {
		return (DoubleRoom) doubleRoom.find(new DoubleRoom("", -1, -1, status));
	}

	/**
	 * @param status
	 * @return
	 */
	private FamilyRoom findFamilyRoom(String status) {
		return (FamilyRoom) familyRoom.find(new FamilyRoom("", -1, -1, status));
	}

}
