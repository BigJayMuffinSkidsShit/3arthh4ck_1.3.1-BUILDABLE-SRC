/*
 * Decompiled with CFR 0.150.
 */
package me.earth.earthhack.impl.modules.render.crystalchams;

import java.awt.Color;
import me.earth.earthhack.api.module.Module;
import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.api.setting.Setting;
import me.earth.earthhack.api.setting.settings.BooleanSetting;
import me.earth.earthhack.api.setting.settings.ColorSetting;
import me.earth.earthhack.api.setting.settings.EnumSetting;
import me.earth.earthhack.impl.modules.render.handchams.modes.ChamsMode;

public class CrystalChams
extends Module {
    public final Setting<ChamsMode> mode = this.register(new EnumSetting<ChamsMode>("Mode", ChamsMode.Normal));
    public final Setting<Boolean> chams = this.register(new BooleanSetting("Chams", false));
    public final Setting<Boolean> throughWalls = this.register(new BooleanSetting("ThroughWalls", false));
    public final Setting<Boolean> wireframe = this.register(new BooleanSetting("Wireframe", false));
    public final Setting<Boolean> wireWalls = this.register(new BooleanSetting("WireThroughWalls", false));
    public final Setting<Color> color = this.register(new ColorSetting("Color", new Color(255, 255, 255, 255)));
    public final Setting<Color> wireFrameColor = this.register(new ColorSetting("WireframeColor", new Color(255, 255, 255, 255)));

    public CrystalChams() {
        super("CrystalChams", Category.Render);
    }
}

