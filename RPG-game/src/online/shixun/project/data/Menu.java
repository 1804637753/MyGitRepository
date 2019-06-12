package online.shixun.project.data;

/**
 * 定义了菜单选项的枚举类
 */
public enum Menu {

    // 包含三个菜单选项，可以随时扩展。包含选项名和选项序号两个信息
    HUNT("打怪", 1), HEALING("疗伤", 2), LEANSKILL("学习技能", 3);

    private int index;
    private String name;

    // 定义了上面三个菜单项的数据构成，相当于给指定的Menu对象进行初始化
    private Menu(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 覆盖方法，方便输出
    @Override
    public String toString() {
        return this.index + "." + this.name;
    }

}