package online.shixun.project.service;

import java.util.Random;
import java.util.Scanner;

import online.shixun.project.data.FightMenu;
import online.shixun.project.model.Enemy;
import online.shixun.project.model.Player;
import online.shixun.project.model.Skill;
import online.shixun.project.util.ScannerUtil;

/**
 * 玩家角色具有的方法
 * 
 * @author 浪
 */
public class PlayerService {

	/**
	 * 初始化玩家角色信息
	 * 
	 * @return 返回实例化的player对象
	 */
	public static Player initPlayer() {

		// 输出欢迎信息
		System.out.println("*****************************************");
		System.out.println("欢迎来到大型文字角色扮演游戏《伏魔录》");
		System.out.println("我该如何称呼您？");

		// 输出角色名
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();

		// 调用构造函数初始化角色
		Player player = new Player(name, 1, 99, 100, 10, 5, 100, 100, 20, 20);

		// 输出初始化结果信息
		System.out.println("角色初始化完毕，您的伏魔之旅即将开始");
		System.out.println("*****************************************");

		return player;
	}

	/**
	 * 玩家跟敌人战斗
	 * 
	 * @param player
	 *            参与战斗的玩家
	 * @param enemy
	 *            挑战的敌人
	 */
	public static void fight(Player player, Enemy enemy) {

		// 使用do-while循环，持续进行战斗，到有一方血量扣完为止
		do {
			// 玩家行动，根据玩家的攻击方式和敌人的防御力返回伤害值
			int damageByPlayer = PlayerService.action(player, enemy);

			// 敌人生命值进行扣减
			enemy.setHp(enemy.getHp() - damageByPlayer);

			// 对于敌人是否战败进行判断
			if (enemy.getHp() <= 0) {
				System.out.println("敌人已死亡，您获得了胜利");
				victory(player, enemy);
				break;
			} else {
				System.out.println("敌人剩余血量：" + enemy.getHp());
			}

			// 敌人行动，根据敌人攻击力和玩家防御力返回敌人伤害值
			int damageByEnemy = EnemyService.action(enemy, player);

			// 玩家生命值进行扣减
			player.setHp(player.getHp() - damageByEnemy);

			// 对于玩家是否战败进行判断
			if (player.getHp() <= 0) {
				System.out.println("您已战败，落荒而逃");
				break;
			} else {
				System.out.println(player.getPlayerName() + "剩余血量：" + player.getHp());
			}

		} while (true);

	}

	/**
	 * 战斗胜利后玩家获得奖励
	 * 
	 * @param player
	 *            战斗胜利的玩家
	 * @param enemy
	 *            被击败的敌人
	 */
	private static void victory(Player player, Enemy enemy) {

		// 增加玩家的金钱
		player.setMoney(player.getMoney() + enemy.getMoney());
		System.out.println("得到金钱" + enemy.getMoney() + "，目前存款：" + player.getMoney());

		// 增加玩家的经验
		player.setExp(player.getExp() + enemy.getExp());
		System.out.println("得到经验值" + enemy.getExp() + "，目前经验值：" + player.getExp());

		// 判断是否升级,是的话根据职业进行属性的改变
		if (player.getExp() >= 100) {
			player.setLevel(player.getLevel() + 1);
			player.setAttack(player.getAttack() + player.getProfession().getAttackGrow());
			player.setDefense(player.getDefense() + player.getProfession().getDefenseGrow());
			player.setMaxHp(player.getMaxHp() + player.getProfession().getHpGrow());
			player.setMaxMana(player.getMaxMana() + player.getProfession().getManaGrow());
			player.setExp(player.getExp() - 100);
			System.out.println("您的等级得到了提升，当前为" + player.getLevel() + "级！");
		}
	}

	/**
	 * 玩家选择战斗中的行动
	 * 
	 * @param player
	 *            参与战斗的玩家
	 * @param enemy
	 *            挑战的敌人
	 * @return 对敌人造成伤害
	 */
	private static int action(Player player, Enemy enemy) {

		// 输出可选行动
		System.out.println("当前回合，您可采取如下行动：");

		// 输出战斗选项，遍历Menu
		for (FightMenu fightMenu : FightMenu.values()) {
			System.out.println(fightMenu.toString());
		}

		// 变量result用来表示造成伤害
		int result = 0;

		// 键盘录入做出选择
		switch (ScannerUtil.scanner.nextInt()) {
		// 普通攻击
		case 1:
			Random random = new Random();
			int probability = random.nextInt(100);// 产生一个0-100的随机数
			result = player.getAttack() - enemy.getDefense(); // 普通攻击：伤害值=玩家攻击力-敌人防御
			if (result<0) {
				result=0;
			}
			// 暴击判定
			if (probability >= 90) {
				result=2*result;
				System.out.println(player.getPlayerName() + "使用了普通攻击，产生暴击，造成" + result + "伤害");
			} else {
				System.out.println(player.getPlayerName() + "使用了普通攻击，造成" + result + "伤害");
			}
			break;
		// 使用技能
		case 2:
			result = userSkill(player, enemy);
			break;
		default:
			System.out.println("无意义的选择，错过了行动机会");
			break;
		}
		return result;
	}

	/**
	 * 玩家对敌人释放技能进行攻击
	 * 
	 * @param player
	 *            参与战斗的玩家
	 * @return 技能产生的伤害
	 */
	private static int userSkill(Player player, Enemy enemy) {

		System.out.println("您掌握的技能如下：");

		// 输出所有已掌握技能
		for (int i = 0; i < player.getSkills().size(); i++) {
			System.out.println((i + 1) + "." + player.getSkills().get(i).getSkillName());
		}

		// 选择技能
		System.out.println("请选择您要是使用的技能：");
		int choice = ScannerUtil.scanner.nextInt();

		int result = 0;

		// 检验输入合法性
		if (choice <= player.getSkills().size() && choice > 0) {

			Skill skill = player.getSkills().get(choice - 1);

			// 检验法力值是否足够被技能消耗
			if (player.getMana() > skill.getMana()) {

				// 根据技能加成和敌人防御计算出伤害
				Random random = new Random();
				int probability = random.nextInt(100);// 产生一个0-100的随机数
				result = player.getAttack() * skill.getAttackAddition() - enemy.getDefense();
				System.out.println(skill.getSkillInstruction());
				if (result<0) {
					result=0;
				}
				if (probability >= 90) {
					result=2*result;
					System.out.println("您使出了" + skill.getSkillName() + ",产生暴击，造成了" + result + "点伤害");
				} else {
					System.out.println("您使出了" + skill.getSkillName() + ",造成了" + result + "点伤害");
				}

				// 消耗法力
				player.setMana(player.getMana() - skill.getMana());
				System.out.println("消耗法力:" + skill.getMana() + "，剩余法力:" + player.getMana());

			} else {
				System.out.println("法力不够，释放技能失败");
			}
		} else {
			System.out.println("输入有误，浪费了当前回合");
		}
		return result;
	}
}
