package online.shixun.project.model;

/**
 * 敌人
 * @author 浪
 */
public class Enemy {

	public Enemy(String enemyName, int exp, int money, int attack, int defense, int hp) {
        super();
        this.enemyName = enemyName;
        this.exp = exp;
        this.money = money;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }
	
	// 创建这个方法，实现了构造方法的重载，保留初始化信息
    public Enemy(Enemy enemy) {
        super();
        this.enemyName = enemy.getEnemyName();
        this.exp = enemy.getExp();
        this.money = enemy.getMoney();
        this.attack = enemy.getAttack();
        this.defense = enemy.getDefense();
        this.hp = enemy.getHp();
    }

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
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

	// 昵称
    private String enemyName;

    // 提供经验
    private int exp;

    // 提供金钱
    private int money;

    // 攻击力
    private int attack;

    // 防御力
    private int defense;

    // 血量
    private int hp;

}