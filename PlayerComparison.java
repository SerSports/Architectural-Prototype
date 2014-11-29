
public class PlayerComparison implements PlayerComparisonInterface
{
    private float getStatPerc(float stat1, float stat2)
    {
        if (stat1 == 0 || stat2 == 0)
            return 0;
        else
            return stat1 / stat2;
    }
    private float getStatPerc(int stat1, int stat2)
    {
        return getStatPerc((float) stat1, (float) stat2);
    }
    
    public int compareTwoPlayers(PlayerStats player1, PlayerStats player2)
    {
        float sum = 0.0f;
        int result = 0;
        
        // Compare the stats
        sum += getStatPerc(player1.hitting_avg, player2.hitting_avg);
        sum += getStatPerc(player1.pitching_era, player2.pitching_era);
        sum += getStatPerc(player1.runs_total, player2.runs_total);
        
        // Calculate an average
        result = (int) ((sum * 100.0) / 3.0);
        
        return result;
    }
    
    public String getTwoPlayerComparisonDescription(PlayerStats player1, PlayerStats player2)
    {
        // Return the Description
        return new String("Player 1: " + player1.first_name + " " + player1.last_name + "\n" +
                          "Player 2: " + player2.first_name + " " + player2.last_name + "\n" +
                          "Overal Grade: %" + compareTwoPlayers(player1, player2));
    }
}