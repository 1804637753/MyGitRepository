package online.shixun.project.service.npc;

import online.shixun.project.model.Player;

/**
 * 以接口形式定义了Npc应具有的行为
 */
public interface NpcService {

    /**
     * 当玩家访问时打招呼并自我介绍
     */
    void welcome();

    /**
     * 对玩家提供相应的帮助
     * 
     * @param player
     *            访问NPC的玩家
     */
    void helpPlayer(Player player);

}