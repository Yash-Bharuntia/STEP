package week3.assignmentProblems;

import java.util.*;
class Room{
    String id;
    String type;
    double rate;
    boolean available;
    int capacity;
    public Room(String id,String type,double rate,boolean available,int capacity){
        this.id=id;
        this.type=type;
        this.rate=rate;
        this.available=available;
        this.capacity=capacity;
    }
}
class Guest{
    String name;
    String phone;
    String email;
    String idProof;
    String[] preferences;
    public Guest(String name,String phone,String email,String idProof,String[] preferences){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.idProof=idProof;
        this.preferences=preferences;
    }
}
class Booking{
    String id;
    Guest guest;
    Room room;
    String checkIn;
    String checkOut;
    double total;
    public Booking(String id,Guest guest,Room room,String checkIn,String checkOut,double total){
        this.id=id;
        this.guest=guest;
        this.room=room;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.total=total;
    }
}
class Hotel{
    static int totalBookings=0;
    static double revenue=0;
    static String name="Simple Hotel";
    ArrayList<Room> rooms=new ArrayList<>();
    ArrayList<Booking> bookings=new ArrayList<>();
    public void addRoom(Room r){
        rooms.add(r);
    }
    public Room search(String type,int people){
        for(Room r:rooms) if(r.available && r.type.equals(type) && r.capacity>=people) return r;
        return null;
    }
    public Booking reserve(Guest g,String type,int people,int nights){
        Room r=search(type,people);
        if(r==null) return null;
        r.available=false;
        double t=r.rate*nights;
        Booking b=new Booking("B"+(bookings.size()+1),g,r,"D1","D"+(nights+1),t);
        bookings.add(b);
        totalBookings++;
        revenue+=t;
        return b;
    }
    public boolean cancel(String bookingId){
        for(Booking b:bookings){
            if(b.id.equals(bookingId)){
                b.room.available=true;
                revenue-=b.total;
                bookings.remove(b);
                return true;
            }
        }
        return false;
    }
    public void checkout(String bookingId){
        for(Booking b:bookings){
            if(b.id.equals(bookingId)){
                b.room.available=true;
                return;
            }
        }
    }
    public static void report(){
        System.out.println("Hotel: "+name+" Bookings: "+totalBookings+" Revenue: "+revenue);
    }
    public void listBookings(){
        for(Booking b:bookings) System.out.println(b.id+" "+b.guest.name+" "+b.room.id+" "+b.total);
    }
}
public class Assignment3{
    public static void main(String[] args){
        Hotel h=new Hotel();
        h.addRoom(new Room("R1","Deluxe",3000,true,2));
        h.addRoom(new Room("R2","Suite",5000,true,4));
        h.addRoom(new Room("R3","Standard",2000,true,2));
        Guest g=new Guest("Neha","9999","n@x.com","ID1",new String[]{"NonSmoking"});
        Booking b=h.reserve(g,"Deluxe",2,3);
        if(b!=null) System.out.println("Reserved "+b.id+" "+b.total);
        h.listBookings();
        Hotel.report();
        h.checkout(b.id);
        Hotel.report();
    }
}