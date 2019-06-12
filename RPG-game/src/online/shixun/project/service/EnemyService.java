package online.shixun.project.service;

import online.shixun.project.model.Enemy;
import online.shixun.project.model.Place;
import online.shixun.project.model.Player;
import online.shixun.project.util.ScannerUtil;

/**
 * 跟敌人相关的方法
 */
public class EnemyService {

	public static Enemy choiceEnemy(Place place) {

		System.out.println(place.getPlaceName() + "有以下敌人：");

		// 从传入的场景place中拿到场景中有的敌人，将数组作为整体进行赋值操作
		Enemy[] enemys = place.getEnemys();

		// 显示全部场景中的敌人
		for (int i = 0; i < enemys.length; i++) {
			System.out.println((i + 1) + "." + enemys[i].getEnemyName());
		}

		// 定义一个敌人对象以便后面返回
		Enemy enemy = null;

		// 让玩家根据数字做出选择，输入有误可以重复选择
		while (true) {
			System.out.println("请做出您的选择：");
			int choice = ScannerUtil.scanner.nextInt();
			// 检查玩家输出的序号是否合理
			if (choice <= enemys.length && choice > 0) {
				enemy = enemys[choice - 1];
				// 输入无误就中止循环
				break;
			} else {
				System.out.println("输入有误，请重新选择");
			}
		}

		// 输出敌人信息
		System.out.println("遭遇了敌人：" + enemy.getEnemyName());

		return enemy;
	}
	
	/**
     * 敌人行动
     * 
     * @param enemy
     *            对战中的敌人
     * @param enemy
     *            对战中的玩家
     * @return 敌人行动造成的伤害
     */
    public static int action(Enemy enemy,Player player) {
    	int result=enemy.getAttack()-player.getDefense();//敌人普通攻击伤害=敌人攻击-玩家防御
    	if (result<0) {
			result=0;
		}
        System.out.println(enemy.getEnemyName() + "使用了普通攻击，造成" + result + "伤害");
        return result;
    }
}