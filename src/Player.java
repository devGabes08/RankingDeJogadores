public class Player {
    private int ranking;
    private String nickName;

    public Player(String nickName, int ranking) {
        this.nickName = nickName;
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
