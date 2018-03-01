package hashcode;

import java.util.List;

public class RideList {

    private List<Ride> rideList;
    private int score;

    public RideList(List<Ride> rideList, int score) {
        this.rideList = rideList;
        this.score = score;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
