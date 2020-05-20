package system.model.businessModel.staticModel;

import system.model.businessModel.*;

import java.util.ArrayList;

public class StaticModel
{
  /**
   * Class for transporting static objects between server and client.
   */

  private ArrayList<Ability> abilities;
  private ArrayList<Skill> skills;
  private ArrayList<Race> races;
  private ArrayList<Spell> spells;
  private ArrayList<Subclass> subclasses;
  private ArrayList<Subrace> subraces;
  private ArrayList<EquipmentArmor> equipmentArmors;
  private ArrayList<EquipmentGeneral> equipmentGenerals;
  private ArrayList<EquipmentWeapon> equipmentWeaponList;

  public void load(ArrayList<Ability> abilities, ArrayList<Skill> skills, ArrayList<Race> races, ArrayList<Spell> spells, ArrayList<Subclass> subclasses, ArrayList<Subrace> subraces,
      ArrayList<EquipmentArmor> equipmentArmors, ArrayList<EquipmentGeneral> equipmentGenerals, ArrayList<EquipmentWeapon> equipmentWeaponList)
  {
    this.abilities = abilities;
    this.skills = skills;
    this.races = races;
    this.spells = spells;
    this.subclasses = subclasses;
    this.subraces = subraces;
    this.equipmentArmors = equipmentArmors;
    this.equipmentGenerals = equipmentGenerals;
    this.equipmentWeaponList = equipmentWeaponList;
  }

  public ArrayList<Ability> getAbilities()
  {
    return abilities;
  }

  public ArrayList<Skill> getSkills()
  {
    return skills;
  }

  public ArrayList<Race> getRaces()
  {
    return races;
  }

  public ArrayList<Spell> getSpells()
  {
    return spells;
  }

  public ArrayList<Subclass> getSubclasses()
  {
    return subclasses;
  }

  public ArrayList<Subrace> getSubraces()
  {
    return subraces;
  }

  public ArrayList<EquipmentArmor> getEquipmentArmors()
  {
    return equipmentArmors;
  }

  public ArrayList<EquipmentGeneral> getEquipmentGenerals()
  {
    return equipmentGenerals;
  }

  public ArrayList<EquipmentWeapon> getEquipmentWeaponList()
  {
    return equipmentWeaponList;
  }
}
