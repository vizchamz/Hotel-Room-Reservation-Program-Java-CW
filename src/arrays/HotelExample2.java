package arrays;
import java.io.*;
import java.util.*;

public class HotelExample2 {
    public static void main(String[] args) {
        String roomName = "";
        int roomNum = 0;
        String menu;
        String[] hotel = new String[8];
        Scanner input = new Scanner(System.in);

        for (int x = 0; x < 8; x++) {
            hotel[x] = "e";
        }

        while (true) {
            extras();
            System.out.println("Enter 'V' to View All Rooms: ");
            System.out.println("Enter 'E' to View Empty Rooms: ");
            System.out.println("Enter 'A' to Add a Customer to a Room: ");
            System.out.println("Enter 'D' to Delete a Customer from a Room: ");
            System.out.println("Enter 'F' to Find Room from Customer Name: ");
            System.out.println("Enter 'S' to Store Program Data into File: ");
            System.out.print("Enter 'L' to Load Program Data from File: ");
            extras();
            menu = input.nextLine().toUpperCase();

            switch (menu) {
                case ("A"):
                    addCustomers(roomNum, roomName, hotel);
                    break;

                case ("E"):
                    emptyRooms(hotel);
                    break;

                case ("V"):
                    viewRooms(hotel);
                    break;

                case ("D"):
                    deleteCustomers(roomNum, roomName, hotel);
                    break;

                case ("F"):
                    findCustomers(roomName, hotel);
                    break;

                case ("S"):
                    storeFile(hotel);
                    break;

                case ("L"):
                    loadFile();
                    break;

                case ("O"):
                    sortCustomers(hotel);
                    break;
            }
        }
    }

    public static void extras() {
        System.out.println("\n");
        for (int x = 0; x < 50; x++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    public static void addCustomers(int roomNumber, String roomCustomerName, String hotelRef[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter room number (0-7):");
        roomNumber = input.nextInt();

        System.out.println("Enter name for room " + roomNumber + " :");
        roomCustomerName = input.next();

        hotelRef[roomNumber] = roomCustomerName;
        System.out.println("\n");
        System.out.println("Adding Customer to Room Number " + roomNumber + " Successful");
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

        for (int index = 0; index < hotelRef.length; index++) {
            for (int indexTwo = 0; indexTwo < guests.length; indexTwo++) {
                if (hotelRef[index].equals(guests[index])) {
                    System.out.println( + " has occupied Room Number " + index);
                }
            }
        }
        for (int x = 0; x < guests.length; x++) {
            System.out.println(guests[x]);
        }

        /*for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x]);
        }*/
    }

    public static void deleteCustomers(int roomNumber, String roomCustomerName, String hotelRef[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter room number (0-7) to delete customer from Room:");
        roomNumber = input.nextInt();

        System.out.println("Enter name for room " + roomNumber + " to confirm the deletion:");
        roomCustomerName = input.next();

        hotelRef[roomNumber] = "e";
        System.out.println("\n");
        System.out.println("Deletion Customer from Room Number " + roomNumber + " Completed");
    }

    public static void findCustomers(String roomCustomerName, String hotelRef[]) {
        Scanner input = new Scanner(System.in);
        int index;

        System.out.println("Enter customer name to find room from customer name: ");
        roomCustomerName = input.next();

        for (index = 0; index < hotelRef.length; index++) {
            if (hotelRef[index].equals(roomCustomerName)) {
                System.out.println(roomCustomerName + " has occupied Room Number " + index);
            }
        }
    }

    public static void storeFile(String hotelRef[]) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for (int x = 0; x < 8; x++) {
                myWriter.write("\n" + hotelRef[x]);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }

    public static void loadFile() {
        try {
            File myObject = new File("filename.txt");
            Scanner myReader = new Scanner(myObject);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            System.out.println("Successfully Load the File.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Unable to Read the File.");
            e.printStackTrace();
        }
    }
}
