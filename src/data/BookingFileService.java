package data;

import java.io.*;
import java.util.ArrayList;

import model.Booking;
import model.Custemer;
import model.Room;
import service.CustemerService;
import service.RoomService;

public class BookingFileService {

    private static final String FILE_NAME = "booking.txt";

    public void saveBookings(ArrayList<Booking> bookings) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Booking booking : bookings) {

                String data = booking.getBookingId() + "," +
                              booking.getCustemer().getCustomerId() + "," +
                              booking.getRoom().getRoomNo() + "," +
                              booking.getNumberOfDays();

                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBookings(ArrayList<Booking> bookings,
                             CustemerService custemerService,
                             RoomService roomService) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int bookingId = Integer.parseInt(data[0]);
                int customerId = Integer.parseInt(data[1]);
                int roomId = Integer.parseInt(data[2]);
                int numberOfDays = Integer.parseInt(data[3]);

                Custemer custemer =
                        custemerService.searchCustemerById(customerId);

                Room room =
                        roomService.searchRoomById(roomId);

                if (custemer != null && room != null) {

                    bookings.add(
                        new Booking(
                            bookingId,
                            custemer,
                            room,
                            numberOfDays
                        )
                    );

                    room.setAvailable(false);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}