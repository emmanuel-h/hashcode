package hashcode;

public class Ride {
    private int id;
    private int startR;
    private int startC;
    private int stopR;
    private int stopC;
    private int start;
    private int finish;

    public Ride(){

    }

    public Ride(int id, int startR, int startC, int stopR, int stopC, int start, int finish) {
        this.id = id;
        this.startR = startR;
        this.startC = startC;
        this.stopR = stopR;
        this.stopC = stopC;
        this.start = start;
        this.finish = finish;
    }

    public int timeToTravel(){
        return calculateDistance(startR, startC, stopR, stopC);
    }

    public int calculateWeight(int actualStep, int stopCPrev, int stopRPrev){
        int distance = calculateDistance(startR, startC, stopRPrev, stopCPrev);
        int res = distance;
        if(distance + actualStep < this.start){
            res += this.start - (distance + actualStep);
        }
        return res;
    }

    private int calculateDistance(int startX, int startY, int stopX, int stopY){
        return Math.abs(stopX-startX)+Math.abs(stopY-startY);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartR() {
        return startR;
    }

    public void setStartR(int startR) {
        this.startR = startR;
    }

    public int getStartC() {
        return startC;
    }

    public void setStartC(int startC) {
        this.startC = startC;
    }

    public int getStopR() {
        return stopR;
    }

    public void setStopR(int stopR) {
        this.stopR = stopR;
    }

    public int getStopC() {
        return stopC;
    }

    public void setStopC(int stopC) {
        this.stopC = stopC;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        return id == ride.getId();
    }


}
