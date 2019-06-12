package online.shixun.project.data;

/**
 * 定义了战斗时的菜单选项
 */
public enum FightMenu {
    
    // 包含三个菜单选项，可以随时扩展。包含选项名和选项序号两个信息
    ATTACK("攻击",1), USERSKILL("施法",2);
    
    private int index;
    private String name;
    
    // 定义了上面三个菜单项的数据构成
    private FightMenu(String name,int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    //覆盖方法，方便输出
    @Override  
    public String toString() {  
    	return this.index+"."+this.name;  
    }  
}