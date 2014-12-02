import javax.xml.parsers.*;
import java.net.*;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;

class PlayerStats
{
    String id;
    String first_name;
    String last_name;
    String preferred_name;
    
    String team_id;
    String team_name;
    
    int hitting_ab;
    int hitting_ap;
    float hitting_avg;
    int hitting_lob;
    int hitting_pcount;
    int hitting_rbi;
    float hitting_abhr;
    float hitting_abk;
    int hitting_bip;
    float hitting_babip;
    float hitting_bbk;
    float hitting_bbpa;
    float hitting_gofo;
    float hitting_iso;
    float hitting_obp;
    float hitting_ops;
    float hitting_seca;
    float hitting_slg;
    int hitting_xbh;
    
    int pitching_pcount;
    int pitching_error;
    int pitching_ip_1;
    float pitching_ip_2;
    int pitching_bf;
    float pitching_oba;
    float pitching_gofo;
    int pitching_lob;
    float pitching_era;
    float pitching_k9;
    float pitching_whip;
    float pitching_kbb;
    
    int onbase_h;
    int onbase_s;
    int onbase_d;
    int onbase_t;
    int onbase_hr;
    int onbase_tb;
    int onbase_bb;
    int onbase_ibb;
    int onbase_hbp;
    int onbase_fc;
    int onbase_roe;
    
    int runs_unearned;
    int runs_earned;
    int runs_total;
    
    int outcome_klook;
    int outcome_kswing;
    int outcome_ktotal;
    int outcome_ball;
    int outcome_iball;
    int outcome_dirtball;
    int outcome_foul;
    
    int outs_klook;
    int outs_kswing;
    int outs_ktotal;
    int outs_po;
    int outs_fo;
    int outs_fidp;
    int outs_go;
    int outs_gidp;
    int outs_lo;
    int outs_lidp;
    int outs_sacfly;
    int outs_sachit;
    
    int steal_caught;
    int steal_stolen;
    float steal_pct;
    
    int games_start;
    int games_play;
    int games_finish;
    int games_complete;
    
    public PlayerStats(Node node)
    {
        // Initialize from XML Node
        loadDataFromNode(node);
    }
    
    private String getNodesNamedItem(Node node, String namedItem)
    {
        String returnVal = new String("0");
        
        // Check the attribute exists
        if (node.getAttributes().getNamedItem(namedItem) != null)
            returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();

        return returnVal;
    }
    
    private void loadPlayerData(Node node)
    {
        // Get "player" data
        id               = getNodesNamedItem(node, "id");
        first_name       = getNodesNamedItem(node, "first_name");
        last_name        = getNodesNamedItem(node, "last_name");
        preferred_name   = getNodesNamedItem(node, "preferred_name");
    }
    
    private void loadTeamData(Node node)
    {
        // Get "team" data
        team_id      = getNodesNamedItem(node, "id");
        team_name    = getNodesNamedItem(node, "name");
    }
    
    private void loadHittingData(Node node)
    {
        // Get the "hitting" data
        hitting_ab       = Integer.parseInt(getNodesNamedItem(node, "ab"));
        hitting_ap       = Integer.parseInt(getNodesNamedItem(node, "ap"));
        hitting_avg      = Float.parseFloat(getNodesNamedItem(node, "avg"));
        hitting_lob      = Integer.parseInt(getNodesNamedItem(node, "lob"));
        hitting_pcount   = Integer.parseInt(getNodesNamedItem(node, "pcount"));
        hitting_rbi      = Integer.parseInt(getNodesNamedItem(node, "rbi"));
        hitting_abhr     = Float.parseFloat(getNodesNamedItem(node, "abhr"));
        hitting_abk      = Float.parseFloat(getNodesNamedItem(node, "abk"));
        hitting_bip      = Integer.parseInt(getNodesNamedItem(node, "bip"));
        hitting_babip    = Float.parseFloat(getNodesNamedItem(node, "babip"));
        hitting_bbk      = Float.parseFloat(getNodesNamedItem(node, "bbk"));
        hitting_bbpa     = Float.parseFloat(getNodesNamedItem(node, "bbpa"));
        hitting_gofo     = Float.parseFloat(getNodesNamedItem(node, "gofo"));
        hitting_iso      = Float.parseFloat(getNodesNamedItem(node, "iso"));
        hitting_obp      = Float.parseFloat(getNodesNamedItem(node, "obp"));
        hitting_ops      = Float.parseFloat(getNodesNamedItem(node, "ops"));
        hitting_seca     = Float.parseFloat(getNodesNamedItem(node, "seca"));
        hitting_slg      = Float.parseFloat(getNodesNamedItem(node, "slg"));
        hitting_xbh      = Integer.parseInt(getNodesNamedItem(node, "xbh"));
    }
    
    private void loadPitchingData(Node node)
    {
        pitching_pcount = Integer.parseInt(getNodesNamedItem(node, "pcount"));
        pitching_error  = Integer.parseInt(getNodesNamedItem(node, "error"));
        pitching_ip_1   = Integer.parseInt(getNodesNamedItem(node, "ip_1"));
        pitching_ip_2   = Float.parseFloat(getNodesNamedItem(node, "ip_2"));
        pitching_bf     = Integer.parseInt(getNodesNamedItem(node, "bf"));
        pitching_oba    = Float.parseFloat(getNodesNamedItem(node, "oba"));
        pitching_gofo   = Float.parseFloat(getNodesNamedItem(node, "gofo"));
        pitching_lob    = Integer.parseInt(getNodesNamedItem(node, "lob"));
        pitching_era    = Float.parseFloat(getNodesNamedItem(node, "era"));
        pitching_k9     = Float.parseFloat(getNodesNamedItem(node, "k9"));
        pitching_whip   = Float.parseFloat(getNodesNamedItem(node, "whip"));
        pitching_kbb    = Float.parseFloat(getNodesNamedItem(node, "kbb"));
    }
    
    private void loadOnbaseData(Node node)
    {
        // Load "onbase" data
        onbase_h     = Integer.parseInt(getNodesNamedItem(node, "h"));
        onbase_s     = Integer.parseInt(getNodesNamedItem(node, "s"));
        onbase_d     = Integer.parseInt(getNodesNamedItem(node, "d"));
        onbase_t     = Integer.parseInt(getNodesNamedItem(node, "t"));
        onbase_hr    = Integer.parseInt(getNodesNamedItem(node, "hr"));
        onbase_tb    = Integer.parseInt(getNodesNamedItem(node, "tb"));
        onbase_bb    = Integer.parseInt(getNodesNamedItem(node, "bb"));
        onbase_ibb   = Integer.parseInt(getNodesNamedItem(node, "ibb"));
        onbase_hbp   = Integer.parseInt(getNodesNamedItem(node, "hbp"));
        onbase_fc    = Integer.parseInt(getNodesNamedItem(node, "fc"));
        onbase_roe   = Integer.parseInt(getNodesNamedItem(node, "roe"));
    }
    
    private void loadRunsData(Node node)
    {
        // Load "runs" data
        runs_unearned    = Integer.parseInt(getNodesNamedItem(node, "unearned"));
        runs_earned      = Integer.parseInt(getNodesNamedItem(node, "earned"));
        runs_total       = Integer.parseInt(getNodesNamedItem(node, "total"));
    }
    
    private void loadOutcomeData(Node node)
    {
        // Load "outcome" data
        outcome_klook    = Integer.parseInt(getNodesNamedItem(node, "klook"));
        outcome_kswing   = Integer.parseInt(getNodesNamedItem(node, "kswing"));
        outcome_ktotal   = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
        outcome_ball     = Integer.parseInt(getNodesNamedItem(node, "ball"));
        outcome_iball    = Integer.parseInt(getNodesNamedItem(node, "iball"));
        outcome_dirtball = Integer.parseInt(getNodesNamedItem(node, "dirtball"));
        outcome_foul     = Integer.parseInt(getNodesNamedItem(node, "foul"));
    }
    
    private void loadOutsData(Node node)
    {
        // Load "outs" data
        outs_klook   = Integer.parseInt(getNodesNamedItem(node, "klook"));
        outs_kswing  = Integer.parseInt(getNodesNamedItem(node, "kswing"));
        outs_ktotal  = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
        outs_po      = Integer.parseInt(getNodesNamedItem(node, "po"));
        outs_fo      = Integer.parseInt(getNodesNamedItem(node, "fo"));
        outs_fidp    = Integer.parseInt(getNodesNamedItem(node, "fidp"));
        outs_go      = Integer.parseInt(getNodesNamedItem(node, "go"));
        outs_gidp    = Integer.parseInt(getNodesNamedItem(node, "gidp"));
        outs_lo      = Integer.parseInt(getNodesNamedItem(node, "lo"));
        outs_lidp    = Integer.parseInt(getNodesNamedItem(node, "lidp"));
        outs_sacfly  = Integer.parseInt(getNodesNamedItem(node, "sacfly"));
        outs_sachit  = Integer.parseInt(getNodesNamedItem(node, "sachit"));
    }
    
    private void loadStealData(Node node)
    {
        // Load "steal" data
        steal_caught = Integer.parseInt(getNodesNamedItem(node, "caught"));
        steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
        steal_pct    = Float.parseFloat(getNodesNamedItem(node, "pct"));
    }
    
    private void loadGamesData(Node node)
    {
        // Load "games" data
        games_start      = Integer.parseInt(getNodesNamedItem(node, "start"));
        games_play       = Integer.parseInt(getNodesNamedItem(node, "play"));
        games_finish     = Integer.parseInt(getNodesNamedItem(node, "finish"));
        games_complete   = Integer.parseInt(getNodesNamedItem(node, "complete"));
    }
    
    public void loadDataFromNode(Node node)
    {
        // Get "player" data
        loadPlayerData(node);
        
        NodeList child1Nodes = node.getChildNodes();
        for (int j = 0; j < child1Nodes.getLength(); j++)
        {
            Node teamNode = child1Nodes.item(j);
            if (teamNode instanceof Element)
            {
                // Get "team" data
                loadTeamData(teamNode);
                
                NodeList child2Nodes = teamNode.getChildNodes();
                for (int k = 0; k < child2Nodes.getLength(); k++)
                {
                    Node c1Node = child2Nodes.item(k);
                    if (c1Node instanceof Element)
                    {
                        //Identifying the child tag
                        switch (c1Node.getNodeName())
                        {
                        case "onbase":
                            loadHittingData(c1Node);
                            break;
                        case "pitching":
                            loadPitchingData(c1Node);
                            break;
                        }
                        
                        NodeList child3Nodes = c1Node.getChildNodes();
                        for (int l = 0; l < child3Nodes.getLength(); l++)
                        {
                            Node c2Node = child3Nodes.item(l);
                            if (c2Node instanceof Element)
                            {
                                //Identifying the child tag
                                switch (c2Node.getNodeName())
                                {
                                    case "onbase":
                                        loadOnbaseData(c2Node);
                                        break;
                                    case "runs":
                                        loadRunsData(c2Node);
                                        break;
                                    case "outcome":
                                        loadOutcomeData(c2Node);
                                        break;
                                    case "outs":
                                        loadOutsData(c2Node);
                                        break;
                                    case "steal":
                                        loadStealData(c2Node);
                                        break;
                                    case "games":
                                        loadGamesData(c2Node);
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public String toString()
    {
        return new String("id: " + id + "\n" +
                          "first_name: " + first_name + "\n" +
                          "last_name: " + last_name + "\n" +
                          "preferred_name: " + preferred_name + "\n" +
                          "team_id: " + team_id + "\n" +
                          "team_name: " + team_name + "\n" +
                          
                          "hitting_ab: " + hitting_ab + "\n" +
                          "hitting_ap: " + hitting_ap + "\n" +
                          "hitting_avg: " + hitting_avg + "\n" +
                          "hitting_lob: " + hitting_lob + "\n" +
                          "hitting_pcount: " + hitting_pcount + "\n" +
                          "hitting_rbi: " + hitting_rbi + "\n" +
                          "hitting_abhr: " + hitting_abhr + "\n" +
                          "hitting_abk: " + hitting_abk + "\n" +
                          "hitting_bip: " + hitting_bip + "\n" +
                          "hitting_babip: " + hitting_babip + "\n" +
                          "hitting_bbk: " + hitting_bbk + "\n" +
                          "hitting_bbpa: " + hitting_bbpa + "\n" +
                          "hitting_gofo: " + hitting_gofo + "\n" +
                          "hitting_iso: " + hitting_iso + "\n" +
                          "hitting_obp: " + hitting_obp + "\n" +
                          "hitting_ops: " + hitting_ops + "\n" +
                          "hitting_seca: " + hitting_seca + "\n" +
                          "hitting_slg: " + hitting_slg + "\n" +
                          "hitting_xbh: " + hitting_xbh + "\n" +
                          
                          "pitching_pcount: " + pitching_pcount + "\n" +
                          "pitching_error: " + pitching_error + "\n" +
                          "pitching_ip_1: " + pitching_ip_1 + "\n" +
                          "pitching_ip_2: " + pitching_ip_2 + "\n" +
                          "pitching_bf: " + pitching_bf + "\n" +
                          "pitching_oba: " + pitching_oba + "\n" +
                          "pitching_gofo: " + pitching_gofo + "\n" +
                          "pitching_lob: " + pitching_lob + "\n" +
                          "pitching_era: " + pitching_era + "\n" +
                          "pitching_k9: " + pitching_k9 + "\n" +
                          "pitching_whip: " + pitching_whip + "\n" +
                          "pitching_kbb: " + pitching_kbb + "\n" +
                          
                          "onbase_h: " + onbase_h + "\n" +
                          "onbase_s: " + onbase_s + "\n" +
                          "onbase_d: " + onbase_d + "\n" +
                          "onbase_t: " + onbase_t + "\n" +
                          "onbase_hr: " + onbase_hr + "\n" +
                          "onbase_tb: " + onbase_tb + "\n" +
                          "onbase_bb: " + onbase_bb + "\n" +
                          "onbase_ibb: " + onbase_ibb + "\n" +
                          "onbase_hbp: " + onbase_hbp + "\n" +
                          "onbase_fc: " + onbase_fc + "\n" +
                          "onbase_roe: " + onbase_roe + "\n" +
                          
                          "runs_unearned: " + runs_unearned + "\n" +
                          "runs_earned: " + runs_earned + "\n" +
                          "runs_total: " + runs_total + "\n" +
                          
                          "outcome_klook: " + outcome_klook + "\n" +
                          "outcome_kswing: " + outcome_kswing + "\n" +
                          "outcome_ktotal: " + outcome_ktotal + "\n" +
                          "outcome_ball: " + outcome_ball + "\n" +
                          "outcome_iball: " + outcome_iball + "\n" +
                          "outcome_dirtball: " + outcome_dirtball + "\n" +
                          "outcome_foul: " + outcome_foul + "\n" +
                          
                          "outs_klook: " + outs_klook + "\n" +
                          "outs_kswing: " + outs_kswing + "\n" +
                          "outs_ktotal: " + outs_ktotal + "\n" +
                          "outs_po: " + outs_po + "\n" +
                          "outs_fo: " + outs_fo + "\n" +
                          "outs_fidp: " + outs_fidp + "\n" +
                          "outs_go: " + outs_go + "\n" +
                          "outs_gidp: " + outs_gidp + "\n" +
                          "outs_lo: " + outs_lo + "\n" +
                          "outs_lidp: " + outs_lidp + "\n" +
                          "outs_sacfly: " + outs_sacfly + "\n" +
                          "outs_sachit: " + outs_sachit + "\n" +
                          
                          "steal_caught: " + steal_caught + "\n" +
                          "steal_stolen: " + steal_stolen + "\n" +
                          "steal_pct: " + steal_pct + "\n" +
                          
                          "games_start: " + games_start + "\n" +
                          "games_play: " + games_play + "\n" +
                          "games_finish: " + games_finish + "\n" +
                          "games_complete: " + games_complete
                          );
    }
}
