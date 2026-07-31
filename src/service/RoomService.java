package service;

import java.util.ArrayList;
import java.util.List;

import model.Room;

public class RoomService {
	private ArrayList<Room> rooms=new ArrayList<>();
	public void initializeRoom() {
		rooms.add(new Room(101,"Luxary",4000,true));
		rooms.add(new Room(102,"Luxary",4000,true));
		rooms.add(new Room(103,"Standard",2500,true));
		rooms.add(new Room(104,"Standard",2500,true));
		rooms.add(new Room(105,"Top Class",6000,true));
		rooms.add(new Room(201,"Luxary",4000,true));
		rooms.add(new Room(202,"Luxary",4000,true));
		rooms.add(new Room(203,"Standard",2500,true));
		rooms.add(new Room(204,"Standard",2500,true));
		rooms.add(new Room(205,"Top Class",6000,true));
	}
	public RoomService(){
		initializeRoom();
	}
	public List<Room> viewAllRooms(){
		return rooms;
	}
    public Room searchRoomById(int roomNo) {
		for(Room r:rooms) {
			if(r.getRoomNo()==roomNo) {
				return r;
			}
		}
		return null;
	}
}
