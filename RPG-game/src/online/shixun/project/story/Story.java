package online.shixun.project.story;

import online.shixun.project.data.Menu;
import online.shixun.project.model.Enemy;
import online.shixun.project.model.Place;
import online.shixun.project.model.Player;
import online.shixun.project.service.EnemyService;
import online.shixun.project.service.PlaceService;
import online.shixun.project.service.PlayerService;
import online.shixun.project.service.ProfessionService;
import online.shixun.project.service.npc.NpcDoctorService;
import online.shixun.project.service.npc.NpcMasterService;
import online.shixun.project.service.npc.NpcService;
import online.shixun.project.util.ScannerUtil;

/**
 * 故事
 * 
 * @author 浪
 */
public class Story {

	// 故事中的玩家
	Player player;

	// 故事中的场景
	Place place;

	// 要打的敌人
	Enemy enemyInfo;

	/**
	 * 开始游戏
	 */
	public void start() {

		// 初始化角色
		player = PlayerService.initPlayer();

		// 选择职业
		player.setProfession(ProfessionService.choiceProfession());

		// 开始游戏流程
		menu();

	}

	/**
	 * 提供游戏行动菜单供玩家选择
	 */
	private void menu() {
		while (true) {
			System.out.println("现在您打算做什么?");
			for (Menu menu : Menu.values()) {
				System.out.println(menu.toString());
			}
			switch (ScannerUtil.scanner.nextInt()) {
			case 1:
				// 打怪
				hunt();
				break;
			case 2:
				// 疗伤
				healing();
				break;
			case 3:
				// 学习技能
				learnSkill();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 打怪
	 */
	private void hunt() {

		// 选择要去的场景
		place = PlaceService.choicePlace();

		// 选择要打的敌人
		enemyInfo = EnemyService.choiceEnemy(place);

		// 将敌人初始化信息保留在新的Enemy对象中，开发新的空间复制信息，避免敌人初始化信息被操作
		Enemy enemy = new Enemy(enemyInfo);

		// 玩家与敌人进行战斗，玩家信息实时改变（受伤害生命值保留修改后），敌人初始化信息不能直接修改只能通过局部变量修改
		PlayerService.fight(player, enemy);

	}

	/**
	 * 疗伤
	 */
	private void healing() {

		// 使用多态，让npcService指向医师npc的NpcDoctorService
		NpcService npcService = new NpcDoctorService();

		// 调用医师的welcome方法
		npcService.welcome();

		// 调用医师的helpPlayer方法，治疗
		npcService.helpPlayer(player);
	}

	/**
	 * 学习技能
	 */
	private void learnSkill() {

		// 使用多态，让npcService指向技能导师npc的NpcMasterService
		NpcService npcService = new NpcMasterService();

		// 调用技能导师的welcome方法
		npcService.welcome();
		
		// 调用技能导师的helpPlayer方法，传授技能
        npcService.helpPlayer(player);

	}

}