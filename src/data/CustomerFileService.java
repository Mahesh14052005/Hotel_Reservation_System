package data;

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
            System.out.println("Error while saving customers.");
            e.printStackTrace();
        }
    }

    // Load all customers
    public void loadCustomers(ArrayList<Custemer> customers) {

        File file = new File(FILE_NAME);

        // If file doesn't exist, nothing to load
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Skip invalid records
                if (data.length != 4) {
                    System.out.println("Invalid record : " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String email = data[2].trim();
                Long phone = Long.parseLong(data[3].trim());

                Custemer customer = new Custemer(id, name, email, phone);

                customers.add(customer);
            }

        } catch (IOException e) {
            System.out.println("Error while loading customers.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in customer file.");
            e.printStackTrace();
        }
    }
}