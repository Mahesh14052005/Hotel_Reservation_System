package model;

public class Bill {
	private int billId;
	private Booking booking;
	private double totalAmount;
	public Bill() {
		
	}
	public Bill(int billId, Booking booking, double totalAmount) {
		super();
		this.billId = billId;
		this.booking = booking;
		this.totalAmount = totalAmount;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
		
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double calculateBill(Booking booking) {
		totalAmount=booking.getRoom().getCost()*booking.getNumberOfDays();
		return totalAmount;
	}
}
