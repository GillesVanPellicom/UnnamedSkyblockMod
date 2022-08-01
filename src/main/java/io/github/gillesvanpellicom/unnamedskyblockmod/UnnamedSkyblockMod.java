package gillesvanpellicom.github.io;

import gillesvanpellicom.github.io.event.EventListener;
import gillesvanpellicom.github.io.gui.Vignette;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod(modid = UnnamedSkyblockMod.MODID, version = UnnamedSkyblockMod.VERSION)
public class UnnamedSkyblockMod {
    public static final String MODID = "UnnamedSkyblockMod";
    public static final String VERSION = "1.0-INDEV";

    private File config;

    private static UnnamedSkyblockMod INSTANCE;

    // Define all keybinds
    // Warps
    public static KeyBinding WARP_HOME = new KeyBinding("keyBind.warpHome", Keyboard.KEY_HOME, "category.UnnamedSkyblockMod");
    public static KeyBinding WARP_HUB = new KeyBinding("keyBind.warpHub", Keyboard.KEY_INSERT, "category.UnnamedSkyblockMod");
    // GUI's
    public static KeyBinding GUI_STORAGE = new KeyBinding("keyBind.guiStorage", Keyboard.KEY_F, "category.UnnamedSkyblockMod");
    public static KeyBinding GUI_WARDROBE = new KeyBinding("keyBind.guiWardrobe", Keyboard.KEY_V, "category.UnnamedSkyblockMod");

    public Vignette vignette;

    // Preinit
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        INSTANCE = this;
        config = new File(event.getModConfigurationDirectory(), "unnamedskyblockmod");
        MinecraftForge.EVENT_BUS.register(new EventListener(this));
    }

    // Init
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        ClientRegistry.registerKeyBinding(WARP_HOME);
        ClientRegistry.registerKeyBinding(WARP_HUB);
        ClientRegistry.registerKeyBinding(GUI_STORAGE);
        ClientRegistry.registerKeyBinding(GUI_WARDROBE);


    }
}

