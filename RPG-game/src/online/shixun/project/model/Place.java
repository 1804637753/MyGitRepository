package online.shixun.project.model;

/**
 * 游戏场景，包含敌人
 * @author 浪
 */
public class Place {
	
	//初始化地点介绍信息
	public Place(String placeName, String placeIntroduction) {
		this.setPlaceName(placeName);
		this.setPlaceIntroduction(placeIntroduction);
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceIntroduction() {
		return placeIntroduction;
	}

	public void setPlaceIntroduction(String placeIntroduction) {
		this.placeIntroduction = placeIntroduction;
	}

	public Enemy[] getEnemys() {
		return enemys;
	}
	
	//直接以数组形式进行赋值
	public void setEnemys(Enemy enemys[]) {
		this.enemys = enemys;
	}

	// 地名
	private String placeName;

	// 场景介绍
	private String placeIntroduction;

	// 某个区域敌人，一维形式存储一组Enemy对象
	private Enemy enemys[] = new Enemy[10];

}