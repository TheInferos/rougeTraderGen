/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rougetradergen.BirthRight;

/**
 *
 * @author Hex
 */
public class ChildOfTheCreed extends BirthRight {
    public ChildOfTheCreed()
    {
        super();
    }
    
    public int[] statChanges(int[] stats) //Choice between stats[7] and stats[8] pg26 pdf
    {
        stats[0]-=3;
        stats[7]+=3;
        stats[8]+=3;
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