
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class leaderboard {
    private ArrayList<Player> x;
    private Scanner scan;

    public leaderboard() {
        x=new ArrayList<>();
        scan = new Scanner(System.in);
        readData();

    }

    public void addData(Player player) {
        x.add(player);
    }

    public String playerData() {
        String a= "";
        for (int i=0; i<x.size(); i++)  {
            a+=(i+1)+". Name: "+x.get(i).getName()+" Score: "+x.get(i).getScore()+"<br>";

        }
        savaData();
        return a;
    }
         public ArrayList<Player> getList() {
    return x; }
private void readData() {
        try{
            File data=new File("src\\playerData");
            Scanner fileScanner= new Scanner (data);
            while(fileScanner.hasNext()) {
                String x= fileScanner.nextLine();
                String[] splitData = x.split(",");
                String y = splitData[0];
                int q = Integer.parseInt(splitData[1]);
                Player a= new Player(y,q);
                this.x.add(a);

            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
}

private void savaData() {
    try {
        PrintWriter data = new PrintWriter("src\\playerData");
        for (int i = 0; i < x.size(); i++) {
            data.println(x.get(i).getName() + "," + x.get(i).getScore());
        }
        data.close();
    } catch (IOException exception) {
        System.out.println(exception.getMessage());
    }
}



}
