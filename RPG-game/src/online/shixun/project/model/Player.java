package online.shixun.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 * @author 浪
 */
public class Player {
	
	//昵称
	private String playerName;
	
	//职业
	private Profession profession;
	
	//等级
	private int level;
	
	//经验
	private int exp;
	
	//金钱
	private int money;
	
	//攻击力
	private int attack;
	
	//防御力
	private int defense;
	
	//当前血量
	private int hp;
	
	//血量上限
	private int maxHp;
	
	//法力
	private int mana;
	
	//法力上限
	private int maxMana;
	
	//掌握技能
	//此处采用集合
	private List<Skill> skills=new ArrayList<Skill>();

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	/**
	 * 创建Player实例的构造方法,带所有属性参数
	 */
	public Player(String playerName, int level, int exp, int money, int attack, int defense, int hp, int maxHp,
            int mana, int maxMana) {
        super();
        this.playerName = playerName;
        this.level = level;
        this.exp = exp;
        this.money = money;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mana = mana;
        this.maxMana = maxMana;
    }

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
