package online.shixun.project.service;

import online.shixun.project.data.PlaceData;
import online.shixun.project.model.Place;
import online.shixun.project.util.ScannerUtil;

/**
 * 跟场景相关的方法
 */
public class PlaceService {

    /**
     * 选择场景
     * 
     * @return 返回玩家选中的场景
     */
    public static Place choicePlace() {

        System.out.println("有这些场景可供您选择：");

        // 输出游戏数据中存在的场景信息
        for (int i = 0; i < PlaceData.places.length; i++) {
            // 让每个场景以“序号.场景名”的方式输出显示
            System.out.println((i + 1) + "." + PlaceData.places[i].getPlaceName());
        }

        // 定义一个场景对象以便后面返回
        Place place = null;

        // 让玩家根据数字做出选择，输入有误可以重复选择
        while (true) {
        	System.out.println("请做出您的选择：");
            int choice = ScannerUtil.scanner.nextInt();
            // 检查玩家输出的序号是否合理
            if (choice <= PlaceData.places.length && choice > 0) {
                place = PlaceData.places[choice - 1];
                // 输入无误就中止循环
                break;
            } else {
                System.out.println("输入有误，请重新选择");
            }
        }

        // 输出场景信息
        System.out.println("您进入了" + place.getPlaceName()+","+place.getPlaceIntroduction());

        return place;
    }
}