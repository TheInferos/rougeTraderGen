/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguetradergen.Motivation;

/**
 *
 * @author Hex
 */
public class Endurance extends Motivation {
    public Endurance()
    {
        super();
    }
    
    public int[] statChanges(int[] stats)
    {
        // wound+1
        return stats;
    }
    
    public String[] skillList(String[] skills)
    {
        return skills;
    }
    
    public String[] talentList(String[] talents)
    {
        return talents;
    }
    public roguetradergen.Career.Career whereNext(int movement)
    {
        if (movement == -1)
        {
            return new roguetradergen.Career.AstropathTranscendent();
        }
        else if(movement == 1)
            {
                return new roguetradergen.Career.VoidMaster();
            }        
        else 
        {
            return new roguetradergen.Career.Archmilitant();
        }
    } 
}
