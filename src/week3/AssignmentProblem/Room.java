package Week3.AssignmentProblem;

import java.util.*;

class Room {
    private String roomNumber, roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String number, String type, double price, int maxOcc) {
        roomNumber = number; roomType = type; pricePerNight = price; isAvailable = true; maxOccupancy = maxOcc;
    }
    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }
    public void setAvailable(boolean a) { isAvailable = a; }
    public String toString() { return roomNumber + " | " + roomType + " | " + pricePerNight + " | Available: " + isAvailable; }
}

class Guest {
    private String guestId, guestName;
    private static int counter = 1;
    public Guest(String name) { guestId = "G" + String.format("%03d", counter++); guestName = name; }
    public String getGuestName() { return guestName; }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private double totalAmount;
    private static int counter = 1;
    private static double hotelRevenue = 0;

    public Booking(Guest g, Room r, int nights) {
        bookingId = "BKG" + String.format("%04d", counter++);
        guest = g; room = r;
        if (room.isAvailable()) { room.setAvailable(false); totalAmount = room.getPricePerNight() * nights; hotelRevenue += totalAmount; }
    }
    public static double getHotelRevenue() { return hotelRevenue; }
    public String toString() { return bookingId + " | " + guest.getGuestName() + " | " + room.getRoomNumber() + " | " + totalAmount; }
}

public class Assignment3Main {
    public static void main(String[] args) {
        Room r1 = new Room("101","Deluxe",4000,2);
        Room r2 = new Room("102","Suite",7000,4);
        Guest g1 = new Guest("Alice");
        Guest g2 = new Guest("Bob");
        Booking b1 = new Booking(g1,r1,3);
        Booking b2 = new Booking(g2,r2,2);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("Total Revenue: " + Booking.getHotelRevenue());
    }
}
