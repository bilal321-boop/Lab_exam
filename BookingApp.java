package javaapplication1;

class MovieBookingApp {
    private int availableSeats = 20; 
    public synchronized void bookSeats(String user, int seatsToBook) {
        if (seatsToBook <= availableSeats) {
            System.out.println(user + " successfully booked " + seatsToBook + " seats.");
            availableSeats -= seatsToBook;
        } else {
            System.out.println(user + " booking failed. Not enough seats available.");
        }
        System.out.println("Seats remaining: " + availableSeats);
    }
}
public class BookingApp {
    public static void main(String[] args) {
        MovieBookingApp app = new MovieBookingApp(); 

        Thread userA = new Thread(() -> app.bookSeats("User A", 10));
        Thread userB = new Thread(() -> app.bookSeats("User B", 12));
        userA.start();
        userB.start();
        try {
            userA.join();
            userB.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
} 