package online.shixun.project.story;

/**
 * 游戏开始入口，包含main方法 
 */
public class Play {

    public static void main(String[] args) {
        
        // 实例化Story，开启一个新故事
        Story story = new Story();
        // 开始游戏
        story.start();
    }
}