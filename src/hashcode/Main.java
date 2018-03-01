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

    public static final int maxWeight = 10;

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


    public static void algorithm(){
        boolean end = false;
        while(!end){
            Ride ride = rides.pop();
            int step = 0;
            int duration = ride.getStart() + ride.timeToTravel();
            LinkedList<Ride> tempRideList = new LinkedList<>();
            tempRideList.addFirst(ride);
            step += duration;
            int maxWeight = 999999999;
            Ride rideTemp = null;
            for(Ride rideDest : rides){
                if(!tempRideList.contains(rideDest)){
                    int weight = rideDest.calculateWeight(step, ride.getStopC(), ride.getStopR());
                    if(weight < maxWeight){
                        maxWeight = weight;
                        rideTemp = rideDest;
                    }
                }
            }
            if(null != rideTemp) {
                tempRideList.addLast(rideTemp);
                rides.remove(rideTemp);
            }else{
                rideListCollection.add(new RideList(tempRideList));
            }
            if(rides.isEmpty()){
                end = true;
            }
        }
    }


    public static void sortRideByStartTime(){
        rides.sort(Comparator.comparing(Ride::getStart));
    }


    public static void main(String[] args) {
        File fileIn = new File("out/b_should_be_easy.in");
        File fileOut = new File("out/b_should_be_easy.out");
        try {
            parse(fileIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rides.size());
        sortRideByStartTime();
        algorithm();
        System.out.println(rideListCollection.size());
        for(RideList list : rideListCollection){
            for(Ride ride : list.getRideList()){
                System.out.print(ride.getId() + " ");
            }
            System.out.println();
        }
    }
}
