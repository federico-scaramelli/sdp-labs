package theatre;

public class Reservation {
    int totalSeats = 5;
    int reservedSeats = 0;
//    private Object lockReservedSeat = new Object();

    public int getFreeSeats() {
//        synchronized (lockReservedSeat) {
            if(reservedSeats == totalSeats)
                return 0;
            else return totalSeats - reservedSeats;
//        }
    }

    public void reserveSeat() throws InterruptedException {
//        synchronized (lockReservedSeat) {
            reservedSeats++;
//        }
    }
}
