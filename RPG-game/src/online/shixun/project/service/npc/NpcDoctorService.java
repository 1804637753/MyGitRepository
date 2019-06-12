package online.shixun.project.service.npc;

import online.shixun.project.data.NpcData;
import online.shixun.project.model.Player;
import online.shixun.project.util.ScannerUtil;

/**
 * 包含医师npc的具有的方法
 */
public class NpcDoctorService extends AbstractNpcService {

	/**
	 * 构造方法，在实例化医师npc时生效
	 */
	public NpcDoctorService() {

		// 给从父类继承的npc对象进行赋值
		this.npc = NpcData.npcDoctor;

	}

	/**
	 * 重写helpPlayer()方法,完成医生所能提供的服务
	 */
	@Override
	public void helpPlayer(Player player) {
		System.out.println("确定接受治疗吗？（Y）");

		// 判定是否接受治疗
		if ("Y".equalsIgnoreCase(ScannerUtil.scanner.next())) {
			int resultMoney = player.getMoney() - 5;
			// 判定存款
			if (resultMoney >= 0) {
				// 恢复血量和法力到最大值
				player.setHp(player.getMaxHp());
	            player.setMana(player.getMaxMana());
	            
	            //扣除所需金钱
				player.setMoney(player.getMoney() - 5);
				System.out.println("已经治疗完毕，您当前血量：" + player.getHp());

			} else {
				// 没钱治疗
				System.out.println("您钱没带够，等死吧");
			}
		} else {
			// 拒绝治疗
			System.out.println("弃疗，再见");
		}
	}
}