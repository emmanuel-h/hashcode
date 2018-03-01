package hashcode;

import java.util.LinkedList;
import java.util.List;

public class RideList {

    private LinkedList<Ride> rideList;
    private int score;

    public RideList(){

    }

    public RideList(LinkedList<Ride> rideList) {
        this.rideList = rideList;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(LinkedList<Ride> rideList) {
        this.rideList = rideList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
