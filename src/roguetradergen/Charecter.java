/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguetradergen;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Hex
 */
public class Charecter {
    public int [] statline;
    public int WeaponSkill;
    public int BallisticSkill;
    public int Strength;
    public int Toughness;
    public int Agility;
    public int Intelligence;
    public int Perception;
    public int Willpower;
    public int Fellowship;
    public int Wounds;
    public int InsanityPoints;
    public int CorruptionPoints;
    public roguetradergen.worlds.World World;
    public roguetradergen.BirthRight.BirthRight birthRight;
    public roguetradergen.LureOfTheVoid.LureOfTheVoid lure;
    public roguetradergen.TrailsAndTravails.TrailsAndTravails trial;
    public roguetradergen.Motivation.Motivation motivation;
    public roguetradergen.Career.Career career;
    public Map<String, Integer> stats;
    
    public Charecter(int[] statline, roguetradergen.worlds.World homeWorld, roguetradergen.BirthRight.BirthRight birthRight, 
            roguetradergen.LureOfTheVoid.LureOfTheVoid lure, roguetradergen.TrailsAndTravails.TrailsAndTravails trial, roguetradergen.Motivation.Motivation motivation,
            roguetradergen.Career.Career career)
    {
        this.statline = statline;
        setStatline();
        World = homeWorld;
        this.birthRight = birthRight;
        this.lure = lure;
        this.trial = trial;
        this.motivation = motivation;
        this.career = career;
        modStats();
        stats = new HashMap<String, Integer>();
        mapStats();

    }
    public void mapStats()
    {
        stats.put("WS", WeaponSkill);
        stats.put("BS", BallisticSkill);
        stats.put("Str", Strength );
        stats.put("T", Toughness);
        stats.put("Ag", Agility);
        stats.put("Int", Intelligence);
        stats.put("Per", Perception);
        stats.put("Wp", Willpower);
        stats.put("Fel", Fellowship);
    }
    public void setStatline()
    {
        WeaponSkill = 25 +statline[0];
        BallisticSkill = 25 +statline[1];
        Strength = 25 + statline[2];
        Toughness = 25 + statline[3];
        Agility = 25 + statline[4];
        Intelligence = 25 + statline[5];
        Perception = 25 + statline[6];
        Willpower = 25 + statline[7];
        Fellowship = 25 +statline[8];
    }
    
    public void refreshStatline()
    {
        WeaponSkill = 25 +statline[0];
        BallisticSkill = 25 +statline[1];
        Strength = 25 + statline[2];
        Toughness = 25 + statline[3];
        Agility = 25 + statline[4];
        Intelligence = 25 + statline[5];
        Perception = 25 + statline[6];
        Willpower = 25 + statline[7];
        Fellowship = 25 +statline[8];
        
    }
    public void printStats()
    {
        for (Map.Entry<String,Integer> entry : stats.entrySet()) 
        {
                String key = entry.getKey();
                int value = entry.getValue();
                System.out.println("Your " + key + " score is " + value);
        }
    }
    
    public void worldStatChanges(int [] statline)
    {
        World.statChanges(statline);
        if (null != World)
        switch (World.getClass().getSimpleName()) 
        {
            case "DeathWorld":
                Wounds = RogueTraderGen.rollDie(5)+2+2*(getBonus(Toughness));
                break;
            case "VoidBorn":
                Wounds = RogueTraderGen.rollDie(5)+2*(getBonus(Toughness));
                break;
            case "ForgeWorld":
                Wounds = RogueTraderGen.rollDie(5)+1+2*(getBonus(Toughness));
                break;
            case "HiveWorld":
                Wounds = RogueTraderGen.rollDie(5)+ 1+2*(getBonus(Toughness));
                break;
            case "ImperialWorld":
                Wounds = RogueTraderGen.rollDie(5)+2*(getBonus(Toughness));
                break;
            case "NobleBorn":
                Wounds = RogueTraderGen.rollDie(5)+2*(getBonus(Toughness));
                break;                    
            default:
                break;
        }
    }
    public void modStats()
    {
        statline = World.statChanges(statline);
        statline = birthRight.statChanges(statline);
        statline = lure.statChanges(statline);
        statline = trial.statChanges(statline);
        statline = motivation.statChanges(statline);
        statline = career.statChanges(statline);
        refreshStatline();
        mapStats();
    }
    
    public int getBonus(int stat)
    {
        return stat/10;
    }
}
