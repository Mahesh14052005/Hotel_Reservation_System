package service;

import java.util.ArrayList;

import data.BookingFileService;
import model.Bill;
import model.Booking;
import model.Custemer;
import model.Room;

public class BookingService {
	ArrayList<Booking> bookings=new ArrayList<>();
	private int bookingCounter=1001;
	private CustemerService customerService;
	private RoomService roomService;
	private BookingFileService fileService;
	public BookingService(CustemerService customerService,RoomService roomService) {
		this.customerService=customerService;
		this.roomService=roomService;
		fileService = new BookingFileService();
	    fileService.loadBookings(bookings,
	                             customerService,
	                             roomService);
	    for (Booking booking : bookings) {
	        if (booking.getBookingId() >= bookingCounter) {
	            bookingCounter = booking.getBookingId() + 1;
	        }
	    }
	}
	public void bookRoom(int custemerId,int roomId,int numberOfDays) {
		Custemer custemer=customerService.searchCustemerById(custemerId);
		if(custemer==null) {
			System.out.println("Custemer Not Found");
			return;
		}
		Room room=roomService.searchRoomById(roomId);
		if(room==null) {
			System.out.println("Room Not Found");
			return;
		}
		if(!room.isAvailable()) {
			System.out.println("Room is not Available");
			return;
		}
		if(numberOfDays<=0) {
			System.out.println("Please Enter a valid days");
			return;
		}
		
		Booking booking = new Booking(bookingCounter++, custemer, room, numberOfDays);
		bookings.add(booking);
		
		room.setAvailable(false);
		fileService.saveBookings(bookings);
		System.out.println("\n-------- Book Room --------");
		System.out.println("Booking Successful!");

		System.out.println("Booking ID   : " + booking.getBookingId());
		System.out.println("Customer ID  : " + custemer.getCustomerId());
		System.out.println("Room No      : " + room.getRoomNo());
		System.out.println("No. of Days  : " + numberOfDays);

		int total = room.getCost() * numberOfDays;
		System.out.println("Total Amount : " + total);
	}
	
	public Booking searchBookingById(int id) {
		for(Booking booking:bookings) {
			if(booking.getBookingId()==id) {
				return booking;
			}
		}
		return null;
	}	
	
	public void checkOut(int bookingId) {

	    Booking booking = searchBookingById(bookingId);

	    if (booking == null) {
	        System.out.println("Booking Not Found.");
	        return;
	    }

	    Room room = booking.getRoom();

	    Bill bill = new Bill();
	    double totalAmount = bill.calculateBill(booking);

	    System.out.println("\n========== CHECK OUT ==========");
	    System.out.println("Booking Details");
	    System.out.println("----------------------------------");
	    System.out.println("Booking ID    : " + booking.getBookingId());
	    System.out.println("Customer ID   : " + booking.getCustemer().getCustomerId());
	    System.out.println("Customer Name : " + booking.getCustemer().getName());
	    System.out.println("Room No       : " + room.getRoomNo());
	    System.out.println("Room Type     : " + room.getType());
	    System.out.println("Days Stayed   : " + booking.getNumberOfDays());
	    System.out.println("Total Bill    : " + totalAmount);
	    System.out.println("----------------------------------");

	    room.setAvailable(true);

	    bookings.remove(booking);

	    fileService.saveBookings(bookings);

	    System.out.println("Checkout Successful!");
	}
	
	
}
