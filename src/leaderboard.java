import java.util.ArrayList;

public class leaderboard {
    private ArrayList<Player> x;

    public leaderboard() {
        x=new ArrayList<>();
    }

    public void addData(Player player) {
        x.add(player);
    }

    public String playerData() {
        String a= "";
        for (int i=0; i<x.size(); i++)  {
            a+=(i+1)+". Name: "+x.get(i).getName()+" Score: "+x.get(i).getScore()+"<br>";

        }
        return a;
    }
         public ArrayList<Player> getList() {
    return x; }


}
