import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private final String[] pointsGame = {"Love", "Fifteen", "Thirty", "Forty"};
    private final String playerName1;
    private final String playerName2;
    private int playerPoint2;
    private int playerPoint1;

    public TennisGame3(String playerName1, String playerName2) {
        this.playerName1 = Objects.requireNonNull(playerName1, "Name Player1 can't Be Null Or Empty");
        this.playerName2 = Objects.requireNonNull(playerName2, "Name Player2 can't Be Null Or Empty");
    }

    public void wonPoint(String playerName) {
        if (playerName1.equalsIgnoreCase(playerName)) {
            this.playerPoint1 += 1;
        } else {
            this.playerPoint2 += 1;
        }
    }

    private String pointPlayersUnderSix() {
        String pointFinalPlayer1 = pointsGame[playerPoint1];
        String pointFinalPlayer2 = pointsGame[playerPoint2];
        return (playerPoint1 == playerPoint2) ? pointFinalPlayer1 + "-All" : pointFinalPlayer1 + "-" + pointFinalPlayer2;
    }

    private String pointPlayersEqual() {
        boolean isPointPlayersEqualOne = (playerPoint1 - playerPoint2) * (playerPoint1 - playerPoint2) == 1;
        String playerNameFinal = (playerPoint1 > playerPoint2) ? playerName1 : playerName2;
        if (playerPoint1 == playerPoint2) {
            return "Deuce";
        }
        return isPointPlayersEqualOne ? "Advantage " + playerNameFinal : "Win for " + playerNameFinal;
    }

    public String getScore() {
        boolean isPointPlayerUnderFourOrNoSix = (playerPoint1 < 4 && playerPoint2 < 4) && (playerPoint1 + playerPoint2 != 6);
        return isPointPlayerUnderFourOrNoSix ? pointPlayersUnderSix() : pointPlayersEqual();
    }
}