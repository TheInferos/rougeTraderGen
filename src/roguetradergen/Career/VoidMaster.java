/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguetradergen.Career;

/**
 *
 * @author Hex
 */
public class VoidMaster extends Career {
    public VoidMaster()
    {
        super();
        place = 2;
    }
    
    public  int[] statChanges(int[] stats)
    {
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
}
