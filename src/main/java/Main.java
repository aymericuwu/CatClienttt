import me.muffin.catclient.CatClient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "catclient", version = "v1.0.4")
public class Main {
    public static final String modid = "catclient";
    public static final String version = "v1.0.4";
    public static final String name = "CatClient";
    public  static final String acceptedversions = "[1.12.2]";

    @Mod.Instance
    public static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	CatClient.instance = new CatClient();
    	CatClient.instance.init();
    }

    @EventHandler
    public void PostInit (FMLPostInitializationEvent event) {

    }
}
