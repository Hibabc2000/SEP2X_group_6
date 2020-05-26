package networking;

import Database.GetCoreFromDatabase;
import system.model.businessModel.*;
import system.model.businessModel.staticModel.Ability;
import system.model.businessModel.staticModel.Skill;
import system.model.businessModel.staticModel.Subclass;
import system.model.businessModel.staticModel.Subrace;

import java.util.ArrayList;

public class StaticModelImplementation
{
  public static ArrayList<Ability> abilities;
  public static ArrayList<Subrace> subraces;
  public static ArrayList<Subclass> subclasses;
  public static ArrayList<Skill> skills;
  public  static ArrayList<Spell> spells;
  public static ArrayList<Race> races;
  public static ArrayList<EquipmentWeapon> equipmentWeaponList;
  public static ArrayList<EquipmentGeneral> equipmentGenerals;
  public  static ArrayList<EquipmentArmor> equipmentArmors;
  private static GetCoreFromDatabase gafd;
  public StaticModelImplementation(GetCoreFromDatabase g)
  {
    gafd = g;
    gafd.loadDatabase();
  }
  public void  loadData()
  {

    abilities= gafd.getAbilities();
    subclasses= gafd.getSubclasses();
    subraces= gafd.getSubraces();
    skills = gafd.getSkills();
    spells = gafd.getSpells();
    races = gafd.getRaces();
    equipmentArmors = gafd.getEquipmentArmors();
    equipmentWeaponList = gafd.getEquipmentWeaponList();
    equipmentGenerals = gafd.getEquipmentGenerals();
  }


}
