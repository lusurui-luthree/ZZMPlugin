package pers.luthree.zzmplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZZMPlugin extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("欢迎使用ZZM插件！by luthree. "); // 在控制台输出日志
        saveDefaultConfig(); // 保存config.yml至插件文件夹
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ZZM插件正在卸载。。。"); // 在控制台输出日志
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { // 指令/zzm
        if (command.getName().equalsIgnoreCase("zzm")) { // 判断输入的指令是否是 /zzm 且忽略大小写
            if (!(sender instanceof Player)) { // 判断输入者的类型 为了防止出现 控制台或命令方块 输入的情况
                sender.sendMessage("你必须是一名玩家!");
                return true; // 这里返回true只是因为该输入者不是玩家,并不是输入错指令,所以我们直接返回true即可
            }
            // 将其强转为Player对象,把它作为玩家来处理
            Player player = (Player) sender;
            player.sendMessage(config.getString("zzm"));
            return true; // 返回true防止返回指令的usage信息
        }
        if (command.getName().equalsIgnoreCase("zzmtitle")){
            if (!(sender instanceof Player)){
                sender.sendMessage("你必须是一名玩家！");
                return true;
            }
            Player player = (Player) sender;
            player.sendTitle(config.getString("zzm"), "Vi Zi O!!!!!", 10, 20, 10);
        }
        if (command.getName().equalsIgnoreCase("zzmtitleall")){
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(config.getString("zzm"), "Vi Zi O!!!!!", 10, 20, 10);
            }
        }
        return false; // 返回usage
    }
}