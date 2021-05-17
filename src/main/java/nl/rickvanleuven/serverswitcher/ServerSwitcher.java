package nl.rickvanleuven.serverswitcher;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerSwitcher extends JavaPlugin {
    private static ServerSwitcher plugin;

    @Override
    public void onEnable(){
        plugin = this;
        this.getCommand("srv").setExecutor(new SwitchCommand());
        System.out.println("Plugin ServerSwitcher enabled");
    }
    @Override
    public void onDisable(){
        System.out.println("Plugin ServerSwitcher disabled");
    }

    private static ServerSwitcher getInstance() {
        return plugin;
    }

    public static void sendPlayerToServer(Player player, String server) {
        Bukkit.getMessenger().registerOutgoingPluginChannel(ServerSwitcher.getInstance(), "BungeeCord");

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        player.sendMessage("§4§lBTE §8» §aSending to §6" + server);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException e) {
        }
        player.sendPluginMessage(ServerSwitcher.getInstance(), "BungeeCord", b.toByteArray());
    }

}

