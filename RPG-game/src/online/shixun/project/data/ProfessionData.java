package online.shixun.project.data;

import online.shixun.project.model.Profession;

/**
 * 保存着游戏中的职业信息
 */
public class ProfessionData {

	// 存储职业信息的数组
	public static Profession professions[] = new Profession[2];

	static {

		// 第一种职业：剑客
		Profession profession1 = new Profession("剑客", 8, 9, 8, 5);
		professions[0] = profession1;
		professions[0].setSkills(SkillData.swordmanSkills);
		

		// 第二种职业：术士
		Profession profession2 = new Profession("术士", 9, 5, 7, 9);
		professions[1] = profession2;
		professions[1].setSkills(SkillData.warlockSkills);
	}

}