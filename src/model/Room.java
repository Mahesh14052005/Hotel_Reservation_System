package model;

public class Room {
	private int roomNo;
	private String type;
	private int cost;
	private boolean available;
	@Override
	public String toString() {
		 return "\n------------------------------"
		            + "\nRoom No   : " + roomNo
		            + "\nType      : " + type
		            + "\nCost      : " + cost
		            + "\nAvailable : " + (available ? "Yes" : "No")
		            + "\n------------------------------";
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Room(int roomNo, String type, int cost, boolean available) {
		super();
		this.roomNo = roomNo;
		this.type = type;
		this.cost = cost;
		this.available = available;
	}
	
}
