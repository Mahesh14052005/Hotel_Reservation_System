package service;
import java.io.*;
import java.util.ArrayList;

import model.Custemer;

public class CustomerFileService {

    private static final String FILE_NAME = "custemers.txt";

    // Save all customers
    public void saveCustomers(ArrayList<Custemer> customers) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Custemer customer : customers) {

                String data = customer.getCustomerId() + "," +
                              customer.getName() + "," +
                              customer.getEmail() + "," +
                              customer.getPhoneNo();

                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all customers
    public void loadCustomers(ArrayList<Custemer> customers) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Custemer customer = new Custemer(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Long.parseLong(data[3])
                );

                customers.add(customer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}