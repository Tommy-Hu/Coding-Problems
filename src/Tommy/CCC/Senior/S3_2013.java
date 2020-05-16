package Tommy.CCC.Senior;

import java.util.*;

public class S3_2013
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int favouriteTeam = s.nextInt();
        int gamesPlayed = s.nextInt();
        int[] teamScores = new int[4];

        //The first one is empty.
        ArrayList[] teamsPlayed = new ArrayList[5];

        teamsPlayed[0] = new ArrayList();
        teamsPlayed[1] = new ArrayList();
        teamsPlayed[2] = new ArrayList();
        teamsPlayed[3] = new ArrayList();
        teamsPlayed[4] = new ArrayList();

        for (int i = 0; i < gamesPlayed; i++)
        {
            int t1 = s.nextInt();
            int t2 = s.nextInt();
            int t1Score = s.nextInt();
            int t2Score = s.nextInt();
            if (t1Score > t2Score)
            {
                teamScores[t1 - 1] += 3;
            }
            else if (t2Score > t1Score)
            {
                teamScores[t2 - 1] += 3;
            }
            else
            {
                teamScores[t1 - 1]++;
                teamScores[t2 - 1]++;
            }
            //noinspection unchecked
            teamsPlayed[t1].add(t2);
            //noinspection unchecked
            teamsPlayed[t2].add(t1);
        }

//        System.out.print(Arrays.toString(teamScores) + "\n" + Arrays.toString(teamsPlayed) + "\n\n" + GetProbabilities(teamScores, teamsPlayed, favouriteTeam - 1) + "\n\n");
        System.out.println(GetProbabilities(teamScores, teamsPlayed, favouriteTeam - 1));
    }


    private static int GetProbabilities(int[] teamScores, ArrayList[] teamsPlayed, int favTeamZeroBased)
    {

        //Is every match filled?
        if (teamsPlayed[1].size() == 3 && teamsPlayed[2].size() == 3 && teamsPlayed[3].size() == 3 && teamsPlayed[4].size() == 3)
        {
            int fT = teamScores[favTeamZeroBased];
            boolean foundFavTeam = false;
            for (int s : teamScores)
            {
                if (fT == s)
                {
                    if (!foundFavTeam)
                    {
                        foundFavTeam = true;
                    }
                    else
                    {
                        return 0;
                    }
                }
                if (fT < s)
                {
                    return 0;
                }
            }
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < 4; i++)
        {
            if (teamsPlayed[i + 1].size() < 3)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (!teamsPlayed[i + 1].contains(j + 1) && i != j)
                    {
                        int originalTeamScorei = teamScores[i];
                        int originalTeamScorej = teamScores[j];

                        teamsPlayed[i + 1].add(j + 1);
                        teamsPlayed[j + 1].add(i + 1);

                        ArrayList[] teamsPlayedOriginal = new ArrayList[5];
                        for (int k = 0; k < teamsPlayed.length; k++)
                        {
                            teamsPlayedOriginal[k] = new ArrayList();
                            for (int l = 0; l < teamsPlayed[k].size(); l++)
                            {
                                teamsPlayedOriginal[k].add((int) teamsPlayed[k].get(l));
                            }
                        }

                        //Tie
                        teamScores[i]++;
                        teamScores[j]++;
                        ans += GetProbabilities(teamScores, teamsPlayed, favTeamZeroBased);
                        teamScores[i] = originalTeamScorei;
                        teamScores[j] = originalTeamScorej;
                        for (int k = 0; k < teamsPlayed.length; k++)
                        {
                            teamsPlayed[k] = new ArrayList();
                            for (int l = 0; l < teamsPlayedOriginal[k].size(); l++)
                            {
                                teamsPlayed[k].add((int) teamsPlayedOriginal[k].get(l));
                            }
                        }

                        //Team[i] wins and Team[j] looses
                        teamScores[i] += 3;
                        ans += GetProbabilities(teamScores, teamsPlayed, favTeamZeroBased);
                        teamScores[i] = originalTeamScorei;
                        for (int k = 0; k < teamsPlayed.length; k++)
                        {
                            teamsPlayed[k] = new ArrayList();
                            for (int l = 0; l < teamsPlayedOriginal[k].size(); l++)
                            {
                                teamsPlayed[k].add((int) teamsPlayedOriginal[k].get(l));
                            }
                        }

                        //Team[i] looses and Team[j] wins
                        teamScores[j] += 3;
                        ans += GetProbabilities(teamScores, teamsPlayed, favTeamZeroBased);
                        teamScores[j] = originalTeamScorej;
                        for (int k = 0; k < teamsPlayed.length; k++)
                        {
                            teamsPlayed[k] = new ArrayList();
                            for (int l = 0; l < teamsPlayedOriginal[k].size(); l++)
                            {
                                teamsPlayed[k].add((int) teamsPlayedOriginal[k].get(l));
                            }
                        }
                    }
                }
                break;
            }
        }


        return ans;
    }
}
