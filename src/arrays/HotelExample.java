package arrays;

import java.io.*;
import java.util.*;

public class HotelExample {
    public static void main(String[] args) {
        String roomName = "";
        int roomNum = 0;
        String menu;
        String[] hotel = new String[8];
        Scanner input = new Scanner(System.in);

        for (int x = 0; x < 8; x++) {
            hotel[x] = "e";
        }

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
                    addCustomers(hotel);
                    break;

                case ("E"):
                    emptyRooms(hotel);
                    break;

                case ("V"):
                    viewRooms(hotel);
                    break;

                case ("D"):
                    deleteCustomers(hotel);
                    break;

                case ("F"):
                    findCustomers(hotel);
                    break;

                case ("S"):
                    storeFile(hotel);
                    break;

                case ("L"):
                    loadFile(hotel);
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

    public static void extras() {
        System.out.println("\n");
        for (int x = 0; x < 60; x++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    public static void addCustomers(String hotelRef[]) {
        Scanner input = new Scanner(System.in);
        int roomNumber = 0;

        while (true) {
            try {
                System.out.println("Enter room number (0-7) or 8 to Stop:");
                roomNumber = input.nextInt();

                if (roomNumber < 8) {
                    System.out.println("Enter name for room " + roomNumber + " :");
                    String roomCustomerName = input.next().toLowerCase();

                    hotelRef[roomNumber] = roomCustomerName;
                    System.out.println("\n");
                    System.out.println("Adding Customer to Room Number " + roomNumber + " Successful");
                }
            /*else if (roomNumber == 8) {
                break;
            }*/
                else if (roomNumber > 8) {
                    System.out.println("Please Enter (0-7) to Add Customers");
                } else {
                    break;
                }
            /*else {
                try {
                    System.out.println("Please Enter (0-7) to Add Customers");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }*/
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter Valid Room Number to Add Customers");
                break;
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

    public static void viewRooms(String hotelRef[]) {
        System.out.println("\n");
        System.out.println("All Rooms");

        for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x]);
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

        /*for (int index = 0; index < guests.length; index++) {
            if (hotelRef[index].equals(guests[index])) {
                System.out.println(guests[index] + " has occupied Room Number " + index);
            }
        }*/

        /*for (int index = 0; index < hotelRef.length; index++) {
            for (int indexTwo = 0; indexTwo < guests.length; indexTwo++) {
                if (hotelRef[index].equals(guests[index])) {
                    System.out.println(guests[index] + " has occupied Room Number " + index);
                }
            }
        }*/

        for (int x = 0; x < guests.length; x++) {
            System.out.println(guests[x]);
        }

        /*for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x]);
        }*/
    }

    public static void deleteCustomers(String[] hotelRef) {
        Scanner input = new Scanner(System.in);
        int roomNumber = 0;

        while (true) {
            try {
                System.out.println("Enter room number (0-7) to delete customer from Room or 8 to Stop:");
                roomNumber = input.nextInt();

                if (roomNumber < 8) {
                    System.out.println("Enter name for room " + roomNumber + " to confirm the deletion:");
                    String roomCustomerName = input.next();

                    if (roomCustomerName.equalsIgnoreCase(hotelRef[roomNumber])) {
                        hotelRef[roomNumber] = "e";
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
                break;
            }
        }
    }

    public static void findCustomers(String[] hotelRef) {
        Scanner input = new Scanner(System.in);
        int index;

        while (true) {
            System.out.println("Enter customer name to find room from customer name or 'Stop' to Stop the Search: ");
            String roomCustomerName = input.next().toLowerCase();

            if (!(roomCustomerName.equalsIgnoreCase("stop"))) {
                for (index = 0; index < hotelRef.length; index++) {
                    if (hotelRef[index].equals(roomCustomerName)) {
                        System.out.println(roomCustomerName + " has occupied Room Number " + index);
                    }
                    /*else {
                        System.out.println("Customer Name Invalid");
                        break;
                    }*/
                }
            }
            else {
                break;
            }
        }
    }

    public static void storeFile(String hotelRef[]) {
        try {
            FileWriter myWriter = new FileWriter("Hotel-Room-Reservation-Program-Java-CW/src/filename.txt");
            for (int x = 0; x < 8; x++) {
                myWriter.write( x + "-" + hotelRef[x] + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }

    public static void loadFile(String hotelRef[]) {
        try {
            File myObject = new File("Hotel-Room-Reservation-Program-Java-CW/src/filename.txt");
            Scanner myReader = new Scanner(myObject);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String values[] = data.split("-");
                /*int numValues[] = new int[values.length/2];
                numValues[0] = Integer.parseInt(values[0]);
                for (int i=1; i < (values.length/2); i++) {
                    numValues[i] = Integer.parseInt(values[i+1]);
                }
                int stringValues[] = new int[values.length/2];
                for (int i=1; i < (values.length/2); i++) {
                    stringValues[i] = Integer.parseInt(values[i+2]);
                }*/
                for (int i=0; i < (values.length/2); i+=2) {
                    hotelRef[Integer.parseInt(values[i])] = values[i+1];
                    //System.out.println(str);
                }
                //System.out.println(data);
            }
            myReader.close();
            System.out.println("Successfully Load the File.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }
    }
}
