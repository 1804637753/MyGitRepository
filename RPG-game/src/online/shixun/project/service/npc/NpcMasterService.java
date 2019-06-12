package online.shixun.project.service.npc;

import java.util.List;

import online.shixun.project.data.NpcData;
import online.shixun.project.model.Player;
import online.shixun.project.model.Skill;
import online.shixun.project.util.ScannerUtil;

/**
 * 包含技能导师npc的具有的方法
 */
public class NpcMasterService extends AbstractNpcService {

	/**
	 * 构造方法，在实例化技能导师npc时生效
	 */
	public NpcMasterService() {

		// 给从父类继承的npc对象进行赋值
		this.npc = NpcData.npcMaster;

	}

	/**
	 * 重写helpPlayer()方法,完成技能导师所能提供的服务
	 */
	@Override
	public void helpPlayer(Player player) {
		// 以集合形式获取玩家角色对应职业的所有可选技能
		List<Skill> skills = player.getProfession().getSkills();
		// 遍历集合，输出所有技能
		for (int i = 0; i < skills.size(); i++) {
			System.out.println((i + 1) + ":" + skills.get(i).getSkillName());
		}
		// 选择想学习的技能
		System.out.println("请选择:");
		int choice = ScannerUtil.scanner.nextInt();
		// 验证输入是否有效
		if (choice <= skills.size() && choice > 0) {
			// 判断要学习的技能是否是玩家已掌握的技能
			if (!player.getSkills().contains(skills.get(choice - 1))) {
				// 确认是否付费
				System.out.println("学习该技能需要金钱：" + skills.get(choice - 1).getSkillMoney() + "确定支付吗？（Y）");
				if ("Y".equalsIgnoreCase(ScannerUtil.scanner.next())) {
					// 尝试扣除学费
					int resultMoney = player.getMoney() - skills.get(choice - 1).getSkillMoney();
					// 判断玩家余额是否足够
					if (resultMoney > 0) {
						player.setMoney(resultMoney);
						// 学习成功，将新技能添加进玩家拥有的技能集合
						player.getSkills().add(skills.get(choice - 1));
						System.out.println("学习成功！目前技能列表：");
						// 输出玩家已掌握技能进行查看,List可以用加强for循环遍历，同数组
						for (Skill skill : player.getSkills()) {
							System.out.println(skill.getSkillName());
						}
					} else {
						System.out.println("金钱不够");
					}
				} else {
					System.out.println("取消学习");
				}
			} else {
				System.out.println("这项技能你已经掌握了");
			}
		} else {
			System.out.println("选择有误");
		}
	}
}
