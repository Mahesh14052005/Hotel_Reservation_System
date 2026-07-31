package model;

public class Booking {
	private int bookingId;
	private Custemer custemer;
	private Room room;
	private int numberOfDays;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Custemer getCustemer() {
		return custemer;
	}
	public void setCustemer(Custemer custemer) {
		this.custemer = custemer;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public Booking(int bookingId, Custemer custemer, Room room, int numberOfDays) {
		super();
		this.bookingId = bookingId;
		this.custemer = custemer;
		this.room = room;
		this.numberOfDays = numberOfDays;
	}
	@Override
	public String toString() {
		return "\n------------------------------"
	            + "\nBooking ID : " + bookingId
	            + "\nCustomer   : " + custemer.getName()
	            + "\nRoom No    : " + room.getRoomNo()
	            + "\nDays       : " + numberOfDays
	            + "\n------------------------------";
	}
	
}
