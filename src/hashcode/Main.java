package hashcode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static int F;
    public static int N;
    public static int B;
    public static int T;

    public static List<Vehicle> vehicles = new ArrayList<>();
    public static List<Ride> rides = new ArrayList<>();


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
        while((currentLine = bufferedReader.readLine()) != null) {
            stringTokenizer = new StringTokenizer(currentLine, delim);
            rides.add(new Ride(Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())));
        }
        bufferedReader.close();
    }

    

    public static void main(String[] args) {
        File fileIn = new File("out/b_should_be_easy.in");
        File fileOut = new File("out/b_should_be_easy.out");
        try {
            parse(fileIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
