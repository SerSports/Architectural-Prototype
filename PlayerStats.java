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
    
    private String getNodesNamedItem(Node node, String namedItem)
    {
        String returnVal("0");
        
        // Check the attribute exists
        if (node.getAttributes().hasAttribute(namedItem))
            node.getAttributes().getNamedItem(namedItem).getNodeValue();

        return returnVal;
    }
    
    private void loadPlayerData(Node node)
    {
        // Get "player" data
        id               = node.getAttributes().getNamedItem("id").getNodeValue();
        first_name       = node.getAttributes().getNamedItem("first_name").getNodeValue();
        last_name        = node.getAttributes().getNamedItem("last_name").getNodeValue();
        preferred_name   = node.getAttributes().getNamedItem("preferred_name").getNodeValue();
    }
    
    private void loadTeamData(Node node)
    {
        // Get "team" data
        team_id      = node.getAttributes().getNamedItem("id").getNodeValue();
        team_name    = node.getAttributes().getNamedItem("name").getNodeValue();
    }
    
    private void loadHittingData(Node node)
    {
        // Get the "hitting" data
        hitting_ab       = Integer.parseInt(node.getAttributes().getNamedItem("ab").getNodeValue());
        hitting_ap       = Integer.parseInt(node.getAttributes().getNamedItem("ap").getNodeValue());
        hitting_avg      = Float.parseFloat(node.getAttributes().getNamedItem("avg").getNodeValue());
        hitting_lob      = Integer.parseInt(node.getAttributes().getNamedItem("lob").getNodeValue());
        hitting_pcount   = Integer.parseInt(node.getAttributes().getNamedItem("pcount").getNodeValue());
        hitting_rbi      = Integer.parseInt(node.getAttributes().getNamedItem("rbi").getNodeValue());
        hitting_abhr     = Float.parseFloat(node.getAttributes().getNamedItem("abhr").getNodeValue());
        hitting_abk      = Float.parseFloat(node.getAttributes().getNamedItem("abk").getNodeValue());
        hitting_bip      = Integer.parseInt(node.getAttributes().getNamedItem("bip").getNodeValue());
        hitting_babip    = Float.parseFloat(node.getAttributes().getNamedItem("babip").getNodeValue());
        hitting_bbk      = Float.parseFloat(node.getAttributes().getNamedItem("bbk").getNodeValue());
        hitting_bbpa     = Float.parseFloat(node.getAttributes().getNamedItem("bbpa").getNodeValue());
        hitting_gofo     = Float.parseFloat(node.getAttributes().getNamedItem("gofo").getNodeValue());
        hitting_iso      = Float.parseFloat(node.getAttributes().getNamedItem("iso").getNodeValue());
        hitting_obp      = Float.parseFloat(node.getAttributes().getNamedItem("obp").getNodeValue());
        hitting_ops      = Float.parseFloat(node.getAttributes().getNamedItem("ops").getNodeValue());
        hitting_seca     = Float.parseFloat(node.getAttributes().getNamedItem("seca").getNodeValue());
        hitting_slg      = Float.parseFloat(node.getAttributes().getNamedItem("slg").getNodeValue());
        hitting_xbh      = Integer.parseInt(node.getAttributes().getNamedItem("xbh").getNodeValue());
    }
    
    private void loadPitchingData(Node node)
    {
        pitching_pcount = Integer.parseInt(node.getAttributes().getNamedItem("pcount").getNodeValue());
        pitching_error  = Integer.parseInt(node.getAttributes().getNamedItem("error").getNodeValue());
        pitching_ip_1   = Integer.parseInt(node.getAttributes().getNamedItem("ip_1").getNodeValue());
        pitching_ip_2   = Float.parseFloat(node.getAttributes().getNamedItem("ip_2").getNodeValue());
        pitching_bf     = Integer.parseInt(node.getAttributes().getNamedItem("bf").getNodeValue());
        pitching_oba    = Float.parseFloat(node.getAttributes().getNamedItem("oba").getNodeValue());
        pitching_gofo   = Float.parseFloat(node.getAttributes().getNamedItem("gofo").getNodeValue());
        pitching_lob    = Integer.parseInt(node.getAttributes().getNamedItem("lob").getNodeValue());
        pitching_era    = Float.parseFloat(node.getAttributes().getNamedItem("era").getNodeValue());
        pitching_k9     = Float.parseFloat(node.getAttributes().getNamedItem("k9").getNodeValue());
        pitching_whip   = Float.parseFloat(node.getAttributes().getNamedItem("whip").getNodeValue());
        pitching_kbb    = Float.parseFloat(node.getAttributes().getNamedItem("kbb").getNodeValue());
    }
    
    private void loadOnbaseData(Node node)
    {
        // Load "onbase" data
        onbase_h     = Integer.parseInt(node.getAttributes().getNamedItem("h").getNodeValue());
        onbase_s     = Integer.parseInt(node.getAttributes().getNamedItem("s").getNodeValue());
        onbase_d     = Integer.parseInt(node.getAttributes().getNamedItem("d").getNodeValue());
        onbase_t     = Integer.parseInt(node.getAttributes().getNamedItem("t").getNodeValue());
        onbase_hr    = Integer.parseInt(node.getAttributes().getNamedItem("hr").getNodeValue());
        onbase_tb    = Integer.parseInt(node.getAttributes().getNamedItem("tb").getNodeValue());
        onbase_bb    = Integer.parseInt(node.getAttributes().getNamedItem("bb").getNodeValue());
        onbase_ibb   = Integer.parseInt(node.getAttributes().getNamedItem("ibb").getNodeValue());
        onbase_hbp   = Integer.parseInt(node.getAttributes().getNamedItem("hbp").getNodeValue());
        onbase_fc    = Integer.parseInt(node.getAttributes().getNamedItem("fc").getNodeValue());
        onbase_roe   = Integer.parseInt(node.getAttributes().getNamedItem("roe").getNodeValue());
    }
    
    private void loadRunsData(Node node)
    {
        // Load "runs" data
        runs_unearned    = Integer.parseInt(node.getAttributes().getNamedItem("unearned").getNodeValue());
        runs_earned      = Integer.parseInt(node.getAttributes().getNamedItem("earned").getNodeValue());
        runs_total       = Integer.parseInt(node.getAttributes().getNamedItem("total").getNodeValue());
    }
    
    private void loadOutcomeData(Node node)
    {
        // Load "outcome" data
        outcome_klook    = Integer.parseInt(node.getAttributes().getNamedItem("klook").getNodeValue());
        outcome_kswing   = Integer.parseInt(node.getAttributes().getNamedItem("kswing").getNodeValue());
        outcome_ktotal   = Integer.parseInt(node.getAttributes().getNamedItem("ktotal").getNodeValue());
        outcome_ball     = Integer.parseInt(node.getAttributes().getNamedItem("ball").getNodeValue());
        outcome_iball    = Integer.parseInt(node.getAttributes().getNamedItem("iball").getNodeValue());
        outcome_dirtball = Integer.parseInt(node.getAttributes().getNamedItem("dirtball").getNodeValue());
        outcome_foul     = Integer.parseInt(node.getAttributes().getNamedItem("foul").getNodeValue());
    }
    
    private void loadOutsData(Node node)
    {
        // Load "outs" data
        outs_klook   = Integer.parseInt(node.getAttributes().getNamedItem("klook").getNodeValue());
        outs_kswing  = Integer.parseInt(node.getAttributes().getNamedItem("kswing").getNodeValue());
        outs_ktotal  = Integer.parseInt(node.getAttributes().getNamedItem("ktotal").getNodeValue());
        outs_po      = Integer.parseInt(node.getAttributes().getNamedItem("po").getNodeValue());
        outs_fo      = Integer.parseInt(node.getAttributes().getNamedItem("fo").getNodeValue());
        outs_fidp    = Integer.parseInt(node.getAttributes().getNamedItem("fidp").getNodeValue());
        outs_go      = Integer.parseInt(node.getAttributes().getNamedItem("go").getNodeValue());
        outs_gidp    = Integer.parseInt(node.getAttributes().getNamedItem("gidp").getNodeValue());
        outs_lo      = Integer.parseInt(node.getAttributes().getNamedItem("lo").getNodeValue());
        outs_lidp    = Integer.parseInt(node.getAttributes().getNamedItem("lidp").getNodeValue());
        outs_sacfly  = Integer.parseInt(node.getAttributes().getNamedItem("sacfly").getNodeValue());
        outs_sachit  = Integer.parseInt(node.getAttributes().getNamedItem("sachit").getNodeValue());
    }
    
    private void loadStealData(Node node)
    {
        // Load "steal" data
        steal_caught = Integer.parseInt(node.getAttributes().getNamedItem("caught").getNodeValue());
        steal_stolen = Integer.parseInt(node.getAttributes().getNamedItem("stolen").getNodeValue());
        steal_pct    = Float.parseFloat(node.getAttributes().getNamedItem("pct").getNodeValue());
    }
    
    private void loadGamesData(Node node)
    {
        // Load "games" data
        games_start      = Integer.parseInt(node.getAttributes().getNamedItem("start").getNodeValue());
        games_play       = Integer.parseInt(node.getAttributes().getNamedItem("play").getNodeValue());
        games_finish     = Integer.parseInt(node.getAttributes().getNamedItem("finish").getNodeValue());
        games_complete   = Integer.parseInt(node.getAttributes().getNamedItem("complete").getNodeValue());
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
    
    public PlayerStats(Node node)
    {
        // Initialize from XML Node
        loadDataFromNode(node);
    }
    
    public String toString()
    {
        return new String("id: " + id + " " +
                          "first_name: " + first_name + " " +
                          "last_name: " + last_name + " " +
                          "preferred_name: " + preferred_name
                          );
    }
}