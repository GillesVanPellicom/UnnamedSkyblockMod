package gillesvanpellicom.github.io.event;

import gillesvanpellicom.github.io.UnnamedSkyblockMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventListener {
    UnnamedSkyblockMod INSTANCE;
    public EventListener(UnnamedSkyblockMod INSTANCE) {
        this.INSTANCE = INSTANCE;
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.addChatMessage(new ChatComponentText("Welcome to the server!"));
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent e) {
        // Command senders
        if (UnnamedSkyblockMod.WARP_HOME.isKeyDown()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp home");
        } else if (UnnamedSkyblockMod.WARP_HUB.isKeyDown()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/hub");
        } else if (UnnamedSkyblockMod.GUI_WARDROBE.isKeyDown()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/wardrobe");
        } else if (UnnamedSkyblockMod.GUI_STORAGE.isKeyDown()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/storage");
        }

    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;

        if (mc.gameSettings.thirdPersonView == 0 && player.getHealth() <= 5) {
            INSTANCE.vignette.RenderVignette();
        }
    }
}
