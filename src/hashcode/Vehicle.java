package hashcode;

import java.util.LinkedList;
import java.util.List;

public class Vehicle {
    private int id;
    private LinkedList<Ride> ridesDone;
    private LinkedList<Ride> ridesToDo;
    private int posR;
    private int posC;
    private int destR;
    private int destC;
    private int destStep;

    public Vehicle(){
        this.ridesDone = new LinkedList<>();
        this.ridesToDo = new LinkedList<>();
    }

    public Vehicle(int id, int posR, int posC, int destR, int destC, int destStep) {
        this.ridesDone = new LinkedList<>();
        this.ridesToDo = new LinkedList<>();
        this.id = id;
        this.posR = posR;
        this.posC = posC;
        this.destR = destR;
        this.destC = destC;
        this.destStep = destStep;
    }

    public Vehicle(LinkedList<Ride> ridesDone, LinkedList<Ride> ridesToDo, int id, int posR, int posC, int destR, int destC, int destStep) {
        this.ridesDone = ridesDone;
        this.ridesToDo = ridesToDo;
        this.id = id;
        this.posR = posR;
        this.posC = posC;
        this.destR = destR;
        this.destC = destC;
        this.destStep = destStep;
    }

    public List<Ride> getRidesDone() {
        return ridesDone;
    }

    public void setRidesDone(LinkedList<Ride> rides) {
        this.ridesDone = rides;
    }

    public void addRideDone(Ride ride){
        this.ridesDone.add(ride);
    }

    public List<Ride> getRidesToDo() {
        return ridesToDo;
    }

    public void setRidesToDo(LinkedList<Ride> ridesToDo) {
        this.ridesToDo = ridesToDo;
    }

    public void addRideToDo(Ride ride){
        this.ridesToDo.addFirst(ride);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosR() {
        return posR;
    }

    public void setPosR(int posR) {
        this.posR = posR;
    }

    public int getPosC() {
        return posC;
    }

    public void setPosC(int posC) {
        this.posC = posC;
    }

    public int getDestR() {
        return destR;
    }

    public void setDestR(int destR) {
        this.destR = destR;
    }

    public int getDestC() {
        return destC;
    }

    public void setDestC(int destC) {
        this.destC = destC;
    }

    public int getDestStep() {
        return destStep;
    }

    public void setDestStep(int destStep) {
        this.destStep = destStep;
    }
}
