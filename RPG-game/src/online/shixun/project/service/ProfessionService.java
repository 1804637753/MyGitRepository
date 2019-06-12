package online.shixun.project.service;

import online.shixun.project.data.ProfessionData;
import online.shixun.project.model.Profession;
import online.shixun.project.util.ScannerUtil;

/**
 * 跟职业相关的方法
 */
public class ProfessionService {

	/**
	 * 选择职业
	 * 
	 * @return 返回玩家选中的职业
	 */
	public static Profession choiceProfession() {

		System.out.println("有这些职业供您选择：");

		// 输出游戏数据中存在的职业信息
		for (int i = 0; i < ProfessionData.professions.length; i++) {
			// 让每个职业以“序号.职业名”的方式输出显示
			System.out.println((i + 1) + "." + ProfessionData.professions[i].getProfessionName());
		}

		Profession profession = null;

		// 让玩家根据数字做出选择，输入有误可以重复选择
		while (true) {
			System.out.println("请做出您的选择：");
			int choice = ScannerUtil.scanner.nextInt();
			// 检查玩家输出的序号是否合理
			if (choice <= ProfessionData.professions.length && choice > 0) {
				profession = ProfessionData.professions[choice - 1];
				// 输入无误就中止循环
				break;
			} else {
				System.out.println("输入有误，请重新选择");
			}
		}
		return profession;
	}

}
