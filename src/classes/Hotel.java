package classes;

import java.io.*;
import java.util.*;

public class Hotel {
    static CQueue list = new CQueue();

    public static void main(String[] args) {
        String roomName = "";
        int roomNum = 0;
        String menu;
        Room[] hotel = new Room[8];
        Scanner input = new Scanner(System.in);

        //initialising
        initialise(hotel);

        System.out.println("Welcome to the Hotel Grand123");

        System.out.println("Classes Version");

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

    public static void initialise(Room hotelRef[]) {
        Person person = new Person("e", "e", 0);
        for (int x = 0; x < 8; x++) {
            hotelRef[x] = new Room(0, person);
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

    //adddCustomersMethod
    public static void addCustomers(Room hotelRef[]) {
        while (true) {
            boolean empty = false;
            for (int i = 0; i < hotelRef.length; i++) {
                if (hotelRef[i].getNumberOfGuests() == 0) {
                    empty = true;
                }
            }

            Scanner input = new Scanner(System.in);
            int roomNumber = 0;
            try {
                System.out.println("Enter room number (0-7) or 8 to Stop:");
                roomNumber = input.nextInt();

                if (empty) {
                    if (roomNumber < 8) {
                        hotelRef[roomNumber] = takeRoomDetails(roomNumber);

                        System.out.println("\n");
                        System.out.println("Adding Customer to Room Number " + roomNumber + " Successful");
                    } else if (roomNumber > 8) {
                        System.out.println("Please Enter (0-7) to Add Customers");
                    } else {
                        break;
                    }
                }
                else {
                    if ((roomNumber >= 0 || roomNumber < 8) && roomNumber != 8) {
                        list.enQueue(takeRoomDetails(roomNumber));
                    }
                    else {
                        break;
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter Valid Room Number to Add Customers");
            }
        }
    }

    //promptingDetailsMethod
    public static Room takeRoomDetails(int roomNumber) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Payer's First Name for Room " + roomNumber + " :");
        String roomCustomerFirstName = input.next().toLowerCase();
        System.out.println("Enter Payer's Surname for Room " + roomNumber + " :");
        String roomCustomerSurname = input.next().toLowerCase();
        System.out.println("Enter Payer's Credit Card Number for Room " + roomNumber + " :");
        long roomCustomerCardNo = input.nextLong();
        System.out.println("Number of Guests in the Room for Room " + roomNumber + " :");
        int noOfGuests = input.nextInt();

        Person person = new Person(roomCustomerFirstName, roomCustomerSurname, roomCustomerCardNo);
        return new Room(noOfGuests, person);
    }

    //emptyRoomsMethod
    public static void emptyRooms(Room hotelRef[]) {
        System.out.println("\n");
        System.out.println("Empty Rooms");

        for (int x = 0; x < 8; x++) {
            if (hotelRef[x].getPerson().getFirstName().equals("e")) {
                System.out.println("room " + x + " is Empty");
            }
        }
    }

    //viewRoomsMethod
    public static void viewRooms(Room hotelRef[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("All Rooms");

        for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x].getPerson().getFirstName() + " " + hotelRef[x].getPerson().getSurName());
        }

        while (true) {
            System.out.println("For Additional Information, Enter 'Add' or to Stop Enter 'X': ");
            String prompt = input.next().toLowerCase();
            if (prompt.equalsIgnoreCase("add")) {
                viewInfoRooms(hotelRef);
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

    //viewRoomsAdditionalInfoMethod
    public static void viewInfoRooms(Room hotelRef[]) {
        System.out.println("\n");
        System.out.println("All Info about Rooms");

        for (int x = 0; x < 8; x++) {
            System.out.println("room " + x + " occupied by " + hotelRef[x].getPerson().getFirstName() + " " + hotelRef[x].getPerson().getSurName() + " & there's " + hotelRef[x].getNumberOfGuests() + " Guests in the Room. " + "Credit Card Number is " + hotelRef[x].getPerson().getCardNo());
        }
    }

    //sortCustomersMethod
    public static void sortCustomers(Room hotelRef[]) {
        String guests[] = new String[hotelRef.length];

        System.out.println("\n");
        System.out.println("Sort Customers by Alphabetical Order");

        for (int i = 0; i < hotelRef.length; i++) {
            guests[i] = hotelRef[i].getPerson().getFirstName();
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

    //deleteCustomersMethod
    public static void deleteCustomers(Room hotelRef[]) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int roomNumber = 0;
            try {
                System.out.println("Enter room number (0-7) to delete customer from Room or 8 to Stop:");
                roomNumber = input.nextInt();

                if (roomNumber < 8) {
                    System.out.println("Enter First Name for room " + roomNumber + " to confirm the deletion:");
                    String roomCustomerFirstName = input.next();

                    if (roomCustomerFirstName.equalsIgnoreCase(hotelRef[roomNumber].getPerson().getFirstName())) {
                        hotelRef[roomNumber].getPerson().setFirstName("e");
                        hotelRef[roomNumber].getPerson().setSurName("e");
                        hotelRef[roomNumber].getPerson().setCardNo(0);
                        hotelRef[roomNumber].setNumberOfGuests(0);
                        System.out.println("\n");
                        System.out.println("Deletion Customer from Room Number " + roomNumber + " Completed");
                        if (!list.isEmpty()) {
                            hotelRef[roomNumber] = list.deQueue();
                        }
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

    //findCustomersMethod
    public static void findCustomers(Room hotelRef[]) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int index;
            System.out.println("Enter Customer's First Name to Find Room from Customer Name or 'Stop' to Stop the Search: ");
            String roomCustomerName = input.next().toLowerCase();

            if (!(roomCustomerName.equalsIgnoreCase("stop"))) {
                for (index = 0; index < hotelRef.length; index++) {
                    if (hotelRef[index].getPerson().getFirstName().equalsIgnoreCase(roomCustomerName)) {
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

    //storeIntoTxt
    public static void storeFile(Room hotelRef[]) {
        try {
            File myObject = new File("src/filename.txt");
            if (myObject.createNewFile()) {
                System.out.println("File created: " + myObject.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        try {
            FileWriter myWriter = new FileWriter("src/filename.txt");
            for (int x = 0; x < 8; x++) {
                myWriter.write( x + "-" + hotelRef[x].getPerson().getFirstName() + "-" + hotelRef[x].getPerson().getSurName() + "-" + hotelRef[x].getNumberOfGuests() + "-" + hotelRef[x].getPerson().getCardNo() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error Occurred.");
        }
    }

    //readFromTxt
    public static void loadFile(Room hotelRef[]) {
        try {
            File myObject = new File("src/filename.txt");
            Scanner myReader = new Scanner(myObject);
            int i=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String values[] = data.split("-");

                Person person = new Person(values[1], values[2], Long.parseLong(values[4]));
                hotelRef[i].setNumberOfGuests(Integer.parseInt(values[3]));
                hotelRef[i].setPerson(person);
                i++;
            }
            myReader.close();
            System.out.println("Successfully Load the File.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
}

/*
 *
 * References
 *
 * https://www.programiz.com/dsa/circular-queue
 *
 * */