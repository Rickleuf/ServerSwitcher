import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwitchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            if (args.length==0) {
                sender.sendMessage("Please use /srv servername");
            } else if (args.length>1) {
                sender.sendMessage("Please use /srv servername");
            } else {
                ServerSwitcher.sendPlayerToServer(player, args[0]);
            }
        }
        return true;
    }
}
