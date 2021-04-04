package arrays;

import java.io.*;
import java.util.*;

public class HotelExample {
    public static void main(String[] args) {
        String roomName = "";
        int roomNum = 0;
        String menu;
        String[] hotel = new String[8];
        int[] customersPerRoom = new int[8];
        String[] customerLastName = new String[8];
        long[] cardNo = new long[8];
        Scanner input = new Scanner(System.in);

        initialise(hotel, customerLastName);
        initialise(customersPerRoom, cardNo);

        System.out.println("Arrays Version");

        while (true) {
            extras();
            System.out.println("Menu");
            System.out.println("Enter 'V' to View All Rooms: ");
            System.out.println("Enter 'E' to View Empty Rooms: ");
            System.out.println("Enter 'A' to Add a Customer to a Room: ");
            System.out.println("Enter 'D' to Delete a Customer from a Room: ");
            System.out.println("Enter 'F' to Find Room from Customer Name: ");
            System.out.println("Enter 'S' to Store Program Data into File: ");
            System.out.println("Enter 'L' to Load Program Data from File: ");
            System.out.println("Enter 'O' to View Guests Ordered Alphabetically by Name: ");
            System.out.println("Enter 'X' to Exit:");
            System.out.print("Enter Option");
            extras();
            menu = input.nextLine().toUpperCase();

            switch (menu) {
                case ("A"):
                    addCustomers(hotel, customersPerRoom, customerLastName, cardNo);
                    break;

                case ("E"):
                    emptyRooms(hotel);
                    break;

                case ("V"):
                    viewRooms(hotel, customerLastName, customersPerRoom, cardNo);
                    break;

                case ("D"):
                    deleteCustomers(hotel, customerLastName, customersPerRoom, cardNo);
                    break;

                case ("F"):
                    findCustomers(hotel);
                    break;

                case ("S"):
                    storeFile(hotel, customersPerRoom, customerLastName, cardNo);
                    break;

                case ("L"):
                    loadFile(hotel, customersPerRoom, customerLastName, cardNo);
                    break;

                case ("O"):
                    sortCustomers(hotel);
                    break;

                case ("X"):
                    System.out.println("End of Program");
                    System.exit(0);

                default:
                    System.out.println("Please Enter Valid Option");
                    break;
            }
        }
    }

    public static void initialise(String hotelRef[], String customerSurname[]) {
        for (int x = 0; x < 8; x++) {
            hotelRef[x] = "e";
            customerSurname[x] = "e";
        }
    }

    public static void initialise(int customersCount[], long customerCardNo[]) {
        for (int x = 0; x < 8; x++) {
            customersCount[x] = 0;
            customerCardNo[x] = 0;
        }
        System.out.println("Initialised");
    }

    public static void extras() {
        System.out.println("\n");
        for (int x = 0; x < 60; x++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    public static void addCustomers(String hotelRef[], int customersCount[], String customerSurname[], long customerCardNo[]) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int roomNumber = 0;
            try {
                System.out.println("Enter room number (0-7) or 8 to Stop:");
                roomNumber = input.nextInt();

                if (roomNumber < 8) {
                    System.out.println("Enter Payer's First Name for Room " + roomNumber + " :");
                    String roomCustomerFirstName = input.next().toLowerCase();
                    System.out.println("Enter Payer's Surname for Room " + roomNumber + " :");
                    String roomCustomerSurname = input.next().toLowerCase();
                    System.out.println("Enter Payer's Credit Card Number for Room " + roomNumber + " :");
                    long roomCustomerCardNo = input.nextLong();
                    System.out.println("Number of Guests in the Room for Room " + roomNumber + " :");
                    int noOfGuests = input.nextInt();

                    hotelRef[roomNumber] = roomCustomerFirstName;
                    customerSurname[roomNumber] = roomCustomerSurname;
                    customerCardNo[roomNumber] = roomCustomerCardNo;
                    customersCount[roomNumber] = noOfGuests;

                    System.out.println("\n");
                    System.out.println("Adding Customer to Room Number " + roomNumber + " Successful");
                }
                else if (roomNumber > 8) {
                    System.out.println("Please Enter (0-7) to Add Customers");
                } else {
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter Valid Room Number to Add Customers");
            }
        }
    }

    public static void emptyRooms(String hotelRef[]) {
        System.out.println("\n");
        System.out.println("Empty Rooms");

        for (int x = 0; x < 8; x++) {
            if (hotelRef[x].equals("e")) {
                System.out.println("room " + x + " is Empty");
            }
        }
    }

    public static void viewRooms(String hotelRef[], String customerSurname[], int customersCount[], long customerCardNo[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("All Rooms");

        for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x] + " " + customerSurname[x]);
        }

        while (true) {
            System.out.println("For Additional Information, Enter 'Add' or to Stop Enter 'X': ");
            String prompt = input.next().toLowerCase();
            if (prompt.equalsIgnoreCase("add")) {
                viewInfoRooms(hotelRef, customerSurname, customersCount, customerCardNo);
                break;
            }
            else if (prompt.equalsIgnoreCase("x")) {
                break;
            }
            else {
                System.out.println("Invalid Input, Please Enter Valid One");
            }
        }
    }

    public static void viewInfoRooms(String hotelRef[], String customerSurname[], int customersCount[], long customerCardNo[]) {
        System.out.println("\n");
        System.out.println("All Info about Rooms");

        for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x] + " " + customerSurname[x] + " & there's " + customersCount[x] + " Guests in the Room. " + "Credit Card Number is " + customerCardNo[x]);
        }
    }

    public static void sortCustomers(String hotelRef[]) {
        String guests[] = new String[hotelRef.length];

        System.out.println("\n");
        System.out.println("Sort Customers by Alphabetical Order");

        for (int i = 0; i < hotelRef.length; i++) {
            guests[i] = hotelRef[i];
        }

        for(int i = 0; i< guests.length-1; i++) {
            for (int j = i+1; j<guests.length; j++) {
                if(guests[i].compareTo(guests[j])>0) {
                    String temp = guests[i];
                    guests[i] = guests[j];
                    guests[j] = temp;
                }
            }
        }

        for (int x = 0; x < guests.length; x++) {
            System.out.println(guests[x]);
        }
    }

    public static void deleteCustomers(String hotelRef[], String customerSurname[], int customersCount[], long customerCardNo[]) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int roomNumber = 0;
            try {
                System.out.println("Enter room number (0-7) to delete customer from Room or 8 to Stop:");
                roomNumber = input.nextInt();

                if (roomNumber < 8) {
                    System.out.println("Enter First Name for room " + roomNumber + " to confirm the deletion:");
                    String roomCustomerName = input.next();

                    if (roomCustomerName.equalsIgnoreCase(hotelRef[roomNumber])) {
                        hotelRef[roomNumber] = "e";
                        customerSurname[roomNumber] = "e";
                        customersCount[roomNumber] = 0;
                        customerCardNo[roomNumber] = 0;
                        System.out.println("\n");
                        System.out.println("Deletion Customer from Room Number " + roomNumber + " Completed");
                    } else {
                        System.out.println("Customer Name Invalid");
                    }
                } else if (roomNumber > 8) {
                    System.out.println("Please Enter (0-7) to Delete Customers");
                } else {
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter Valid Room Number to Delete Customers");
            }
        }
    }

    public static void findCustomers(String hotelRef[]) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int index;
            System.out.println("Enter Customer's First Name to Find Room from Customer Name or 'Stop' to Stop the Search: ");
            String roomCustomerName = input.next().toLowerCase();

            if (!(roomCustomerName.equalsIgnoreCase("stop"))) {
                for (index = 0; index < hotelRef.length; index++) {
                    if (hotelRef[index].equals(roomCustomerName)) {
                        System.out.println(roomCustomerName + " has Occupied Room Number " + index);
                        break;
                    }
                    else if (hotelRef.length-1 == index) {
                        System.out.println("Customer Name Invalid");
                    }
                }
            }
            else {
                break;
            }
        }
    }

    public static void storeFile(String hotelRef[], int customersCount[], String customerSurname[], long customerCardNo[]) {
        try {
            File myObject = new File("src/filename.txt");
            if (myObject.createNewFile()) {
                System.out.println("File created: " + myObject.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        try {
            FileWriter myWriter = new FileWriter("src/filename.txt");
            for (int x = 0; x < 8; x++) {
                myWriter.write( x + "-" + hotelRef[x] + "-" + customerSurname[x] + "-" + customersCount[x] + "-" + customerCardNo[x] + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error Occurred.");
        }
    }

    public static void loadFile(String hotelRef[], int customersCount[], String customerSurname[], long customerCardNo[]) {
        try {
            File myObject = new File("src/filename.txt");
            Scanner myReader = new Scanner(myObject);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String values[] = data.split("-");

                int count=0;
                for (int i=0; i < (values.length/5); i+=5) {
                    hotelRef[Integer.parseInt(values[count])] = values[i+1];
                    customerSurname[Integer.parseInt(values[count])] = values[i+2];
                    customersCount[Integer.parseInt(values[count])] = Integer.parseInt(values[i+3]);
                    customerCardNo[Integer.parseInt(values[count])] = Long.parseLong(values[i+4]);
                    count++;
                }
            }
            myReader.close();
            System.out.println("Successfully Load the File.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}
