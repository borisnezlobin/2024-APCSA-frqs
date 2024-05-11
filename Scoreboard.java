public class Scoreboard {
    private int teamOneScore;
    private int teamTwoScore;
    private String teamOneName;
    private String teamTwoName;
    private boolean isTeamOneActive = true;

    public Scoreboard(String teamOne, String teamTwo){
        this.teamOneName = teamOne;
        this.teamTwoName = teamTwo;
    }

    public void recordPlay(int score){
        if(score == 0){
            isTeamOneActive = !isTeamOneActive;
            return;
        }

        if(isTeamOneActive) teamOneScore += score;
        else teamTwoScore += score;
    }

    public String getScore(){
        return teamOneScore + "-" + teamTwoScore + "-" +
            (isTeamOneActive ? teamOneName : teamTwoName);
    }

    public static void main(String[] args){
        // example code from the AP FRQ problem statement
        // print statements added by me for debugging purposes

        String info;
        Scoreboard game = new Scoreboard("Red", "Blue");

        info = game.getScore();
        System.out.println(info); // "0-0-Red"

        game.recordPlay(1);

        info = game.getScore();
        System.out.println(info); // "1-0-Red"

        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info); // "1-0-Blue"
        info = game.getScore();
        System.out.println(info); // "1-0-Blue"

        game.recordPlay(3);
        info = game.getScore();
        System.out.println(info); // "1-3-Blue"

        game.recordPlay(1);
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info); // "1-4-Red"

        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        info = game.getScore();
        System.out.println(info); // "1-8-Red"

        Scoreboard match = new Scoreboard("Lions", "Tigers");
        
        info = match.getScore();
        System.out.println(info); // "0-0-Lions"

        info = game.getScore();
        System.out.println(info); // "1-8-Red"
    }
}
