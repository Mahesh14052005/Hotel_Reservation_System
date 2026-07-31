package main;

import java.util.Scanner;

import model.Custemer;
import model.Room;
import service.BookingService;
import service.CustemerService;
import service.RoomService;

public class MainClass {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		CustemerService cs=new CustemerService();
		RoomService rs=new RoomService();
		BookingService bs=new BookingService(cs,rs);
		
		System.out.println("===================================================================================================");
		System.out.println("                          HOTEL RESERVATION SYSTEM           ");
		System.out.println("===================================================================================================");
		boolean runnig=true;
		while(runnig) {
			System.out.println("1. Add Custemer");
			System.out.println("2. View Custemers");
			System.out.println("3. View Rooms");
			System.out.println("4. Book Room");
			System.out.println("5. Check Out");
			System.out.println("6.Exit");
			System.out.print("Enter your choice: ");
			int n=sc.nextInt();
			switch(n) {
			case 1 :{
				System.out.print("Enter Custemer ID: ");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Custemer Name: ");
				String name=sc.next();
				sc.nextLine();
				System.out.print("Enter Email: ");
				String email=sc.next();
				sc.nextLine();
				System.out.print("Enter Phone Number: ");
				long phone=sc.nextLong();
				cs.addCustomer(id, name, email, phone);	
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
				break;
			}
			case 2 :{
				for(Custemer c:cs.viewAllCustemers()) {
				    System.out.println(c);
				    
				}
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
				break;
			}
			case 3 :{
				System.out.println("-----------------------------------------------");
				System.out.printf("%-10s %-12s %-15s %-12s%n",
				        "Room No", "Type", "Price Per Day", "Status");
				System.out.println("-----------------------------------------------");

				for (Room r : rs.viewAllRooms()) {
				    System.out.printf("%-10d %-12s %-15d %-12s%n",
				            r.getRoomNo(),
				            r.getType(),
				            r.getCost(),
				            r.isAvailable() ? "Available" : "Booked");
				}
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
				break;
			}
			case 4 :{
				System.out.print("Enter Custemer ID: ");
				int cId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Room ID: ");
				int rId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Number Of Days To Stay: ");
				int noOfDays=sc.nextInt();
				bs.bookRoom(cId,rId,noOfDays);
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
				break;
			}
			case 5 :{
				System.out.print("Enter Check Out ID: ");
				int chId=sc.nextInt();
				bs.checkOut(chId);
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
				break;
			}
			case 6 :{
				runnig=false;
				System.out.println("Thank You For Using Hotel Reservation System.");
				break;
			}
			default :{
				System.out.println("Please Enter Valid Option.");
				sc.nextLine();
				System.out.println("\nPress Enter to continue...");
				sc.nextLine();
			}
			}
			
		}
		sc.close();
	}

}
