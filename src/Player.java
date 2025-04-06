public class Player implements Comparable<Player> {
    private String name;
    private int score;
    public Player(String name,int score) {
        this.name=name;
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int compareTo(Player other) {
        return Integer.compare(other.score, this.score);
    }

}
