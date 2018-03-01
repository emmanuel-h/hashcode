package hashcode;

import java.io.*;
import java.util.*;

public class Main {

    public static int R;
    public static int C;
    public static int F;
    public static int N;
    public static int B;
    public static int T;

    public static LinkedList<Ride> rides = new LinkedList<>();
    public static LinkedList<RideList> rideListCollection = new LinkedList<>();


    public static void parse(File file) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String delim = " ";
        String currentLine = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(currentLine, delim);
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        F = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());
        int i = 0;
        while((currentLine = bufferedReader.readLine()) != null) {
            stringTokenizer = new StringTokenizer(currentLine, delim);
            rides.add(new Ride(i, Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())));
            i++;
        }
        bufferedReader.close();
    }

    public static void out(File file) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        int size;
        for(RideList rideList : rideListCollection) {
            size = rideList.getRideList().size();
            bufferedWriter.write(String.valueOf(size));
            for(Ride ride : rideList.getRideList()){
                bufferedWriter.write(" "+String.valueOf(ride.getId()));
            }
            bufferedWriter.write("\n");
        }
        for(int i = rideListCollection.size() ; i<F ; i++){
            bufferedWriter.write("0\n");
        }
        bufferedWriter.close();
    }


    public static void algorithm(){
        boolean end = false;
        Ride actualRide;
        while(!end){
            Ride ride = rides.pop();
            actualRide = ride;
            int step = 0;
            int duration = ride.getStart() + ride.timeToTravel();
            LinkedList<Ride> tempRideList = new LinkedList<>();
            tempRideList.addFirst(ride);
            boolean hasNext = true;
            step += duration;
            while(hasNext) {
                int minWeight = 999999999;
                Ride rideTemp = null;
                for (Ride rideDest : rides) {
                    if (!tempRideList.contains(rideDest)) {
                        int weight = Math.abs(rideDest.calculateWeight(step, actualRide.getStopC(), actualRide.getStopR()));
                        if (weight < minWeight && ((rideDest.timeToTravel() + weight + step) < T)) {
                            minWeight = weight;
                            rideTemp = rideDest;
                        }
                    }
                }

                if(null != rideTemp) {
                    tempRideList.addLast(rideTemp);
                    rides.remove(rideTemp);
                    actualRide = rideTemp;
                    step += minWeight + rideTemp.timeToTravel();
                }else{
                    hasNext = false;
                    rideListCollection.add(new RideList(tempRideList));
                }
            }
            if(rides.isEmpty()){
                end = true;
            }
        }
    }


    public static void sortRideByStartTime(){
        rides.sort(Comparator.comparing(Ride::getStart));
    }

    public static void sortByScore(){
        for(RideList rideList : rideListCollection){
            for(Ride ride : rideList.getRideList()){
                rideList.setScore(rideList.getScore()+ride.timeToTravel());
            }
        }
        rideListCollection.sort(Comparator.comparing(RideList::getScore).reversed());
    }

    public static void main(String[] args) {
        File fileIn = new File("out/c_no_hurry.in");
        File fileOut = new File("out/c_no_hurry.out");
        try {
            parse(fileIn);
            sortRideByStartTime();
            algorithm();
            sortByScore();
            out(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
