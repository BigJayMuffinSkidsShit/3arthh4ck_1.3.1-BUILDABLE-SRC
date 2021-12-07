package me.earth.earthhack.impl.modules.client.hud;

import me.earth.earthhack.api.hud.HudElement;
import me.earth.earthhack.impl.event.events.render.Render2DEvent;
import me.earth.earthhack.impl.event.listeners.ModuleListener;
import me.earth.earthhack.impl.managers.Managers;
import me.earth.earthhack.impl.modules.client.hud.modes.RenderMode;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

final class ListenerRender extends ModuleListener<HUD, Render2DEvent> {
    public ListenerRender(HUD module) {
        super(module, Render2DEvent.class);
    }

    @Override
    public void invoke(Render2DEvent event) {
        GL11.glPushMatrix();
        GL11.glColor4f(1.0f,1.0f,1.0f,1.0f);
        if (module.animations.getValue()) {
            final float ySpeed = 22.f / (Minecraft.getDebugFPS() >> 2);
            if (mc.ingameGUI.getChatGUI().getChatOpen()) {
                if (module.animationY != 14) {
                    if (module.animationY > 14) {
                        module.animationY = Math.max(module.animationY - ySpeed, 14);
                    } else if (module.animationY < 14) {
                        module.animationY = Math.min(module.animationY + ySpeed, 14);
                    }
                }
            } else {
                if (module.animationY != 0) {
                    if (module.animationY > 0) {
                        module.animationY = Math.max(module.animationY - ySpeed, 0);
                    } else if (module.animationY < 0) {
                        module.animationY = Math.min(module.animationY + ySpeed, 0);
                    }
                }
            }
        } else {
            if (mc.ingameGUI.getChatGUI().getChatOpen()) {
                module.animationY = 14;
            } else {
                module.animationY = 0;
            }
        }
        if (module.renderMode.getValue() == RenderMode.Normal) {
            module.renderLogo();
            module.renderModules();
        } else if (module.renderMode.getValue() == RenderMode.Editor) {
            for (HudElement element : Managers.ELEMENTS.getRegistered()) {
                if (mc.currentScreen == null) {
                    element.hudUpdate(mc.getRenderPartialTicks());
                    if (element.isEnabled()) {
                        element.hudDraw(mc.getRenderPartialTicks());
                    }
                }
            }
        } else {
            module.renderLogo();
            module.renderModules();

            for (HudElement element : Managers.ELEMENTS.getRegistered()) {
                if (mc.currentScreen == null) {
                    element.hudUpdate(mc.getRenderPartialTicks());
                    if (element.isEnabled()) {
                        element.hudDraw(mc.getRenderPartialTicks());
                    }
                }
            }
        }
        GL11.glPopMatrix();
    }

}
