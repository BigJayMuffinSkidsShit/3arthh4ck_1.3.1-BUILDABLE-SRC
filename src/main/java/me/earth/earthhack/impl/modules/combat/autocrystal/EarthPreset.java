/*
 * Decompiled with CFR 0.150.
 */
package me.earth.earthhack.impl.modules.combat.autocrystal;

import java.awt.Color;
import me.earth.earthhack.api.config.preset.BuildinPreset;
import me.earth.earthhack.api.util.bind.Bind;
import me.earth.earthhack.impl.modules.combat.autocrystal.AutoCrystal;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.ACPages;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.ACRotate;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.AntiFriendPop;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.AntiWeakness;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.Attack;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.AutoSwitch;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.PreCalc;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.RenderDamagePos;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.RotationThread;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.SwingTime;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.SwingType;
import me.earth.earthhack.impl.modules.combat.autocrystal.modes.Target;
import me.earth.earthhack.impl.util.helpers.blocks.modes.PlaceSwing;
import me.earth.earthhack.impl.util.helpers.blocks.modes.RayTraceMode;
import me.earth.earthhack.impl.util.helpers.blocks.modes.Rotate;

public class EarthPreset
extends BuildinPreset {
    public EarthPreset(AutoCrystal module) {
        super("crystalpvp.cc", module, "3arthqu4ke's config for Crystalpvp.cc (~30ms, eu). Abuses the Fast-Mainhand Switch.");
        this.add(module.pages, ACPages.Place);
        this.add(module.place, Boolean.valueOf(true));
        this.add(module.targetMode, Target.Damage);
        this.add(module.placeRange, Float.valueOf(5.25f));
        this.add(module.placeTrace, Float.valueOf(5.25f));
        this.add(module.minDamage, Float.valueOf(6.0f));
        this.add(module.placeDelay, Integer.valueOf(0));
        this.add(module.maxSelfPlace, Float.valueOf(9.0f));
        this.add(module.multiPlace, Integer.valueOf(2));
        this.add(module.slowPlaceDmg, Float.valueOf(5.0f));
        this.add(module.slowPlaceDelay, Integer.valueOf(500));
        this.add(module.override, Boolean.valueOf(false));
        this.add(module.newVer, Boolean.valueOf(false));
        this.add(module.newVerEntities, Boolean.valueOf(true));
        this.add(module.placeSwing, SwingTime.None);
        this.add(module.simulatePlace, Integer.valueOf(0));
        this.add(module.attackMode, Attack.Always);
        this.add(module.attack, Boolean.valueOf(true));
        this.add(module.breakRange, Float.valueOf(6.0f));
        this.add(module.breakDelay, Integer.valueOf(0));
        this.add(module.breakTrace, Float.valueOf(3.0f));
        this.add(module.minBreakDamage, Float.valueOf(2.0f));
        this.add(module.maxSelfBreak, Float.valueOf(10.0f));
        this.add(module.slowBreakDamage, Float.valueOf(3.0f));
        this.add(module.slowBreakDelay, Integer.valueOf(500));
        this.add(module.instant, Boolean.valueOf(true));
        this.add(module.asyncCalc, Boolean.valueOf(true));
        this.add(module.alwaysCalc, Boolean.valueOf(true));
        this.add(module.packets, Integer.valueOf(1));
        this.add(module.overrideBreak, Boolean.valueOf(false));
        this.add(module.antiWeakness, AntiWeakness.Switch);
        this.add(module.instantAntiWeak, Boolean.valueOf(true));
        this.add(module.efficient, Boolean.valueOf(true));
        this.add(module.manually, Boolean.valueOf(true));
        this.add(module.manualDelay, Integer.valueOf(500));
        this.add(module.breakSwing, SwingTime.Post);
        this.add(module.rotate, ACRotate.None);
        this.add(module.endRotations, Integer.valueOf(250));
        this.add(module.angle, Float.valueOf(86.05f));
        this.add(module.placeAngle, Float.valueOf(82.05f));
        this.add(module.height, Float.valueOf(0.04f));
        this.add(module.rotationTicks, Integer.valueOf(20));
        this.add(module.existed, Integer.valueOf(0));
        this.add(module.pingExisted, Boolean.valueOf(false));
        this.add(module.targetRange, Float.valueOf(12.0f));
        this.add(module.pbTrace, Float.valueOf(3.1f));
        this.add(module.range, Float.valueOf(12.0f));
        this.add(module.suicide, Boolean.valueOf(false));
        this.add(module.multiTask, Boolean.valueOf(true));
        this.add(module.multiPlaceCalc, Boolean.valueOf(false));
        this.add(module.multiPlaceMinDmg, Boolean.valueOf(true));
        this.add(module.dangerSpeed, Boolean.valueOf(true));
        this.add(module.cooldown, Integer.valueOf(0));
        this.add(module.placeCoolDown, Integer.valueOf(0));
        this.add(module.antiFriendPop, AntiFriendPop.None);
        this.add(module.motionCalc, Boolean.valueOf(false));
        this.add(module.holdFacePlace, Boolean.valueOf(true));
        this.add(module.facePlace, Float.valueOf(10.0f));
        this.add(module.minFaceDmg, Float.valueOf(2.0f));
        this.add(module.armorPlace, Float.valueOf(5.0f));
        this.add(module.pickAxeHold, Boolean.valueOf(false));
        this.add(module.antiNaked, Boolean.valueOf(false));
        this.add(module.fallBack, Boolean.valueOf(true));
        this.add(module.fallBackDiff, Float.valueOf(10.0f));
        this.add(module.fallBackDmg, Float.valueOf(2.0f));
        this.add(module.autoSwitch, AutoSwitch.Always);
        this.add(module.mainHand, Boolean.valueOf(true));
        this.add(module.switchBind, Bind.none());
        this.add(module.switchBack, Boolean.valueOf(true));
        this.add(module.useAsOffhand, Boolean.valueOf(false));
        this.add(module.instantOffhand, Boolean.valueOf(true));
        this.add(module.pingBypass, Boolean.valueOf(true));
        this.add(module.swing, SwingType.MainHand);
        this.add(module.placeHand, SwingType.MainHand);
        this.add(module.obbyHand, SwingType.MainHand);
        this.add(module.render, Boolean.valueOf(true));
        this.add(module.boxColor, new Color(255, 255, 255, 120));
        this.add(module.outLine, new Color(255, 255, 255, 255));
        this.add(module.renderDamage, RenderDamagePos.None);
        this.add(module.setDead, Boolean.valueOf(false));
        this.add(module.instantSetDead, Boolean.valueOf(true));
        this.add(module.pseudoSetDead, Boolean.valueOf(true));
        this.add(module.simulateExplosion, Boolean.valueOf(false));
        this.add(module.soundRemove, Boolean.valueOf(true));
        this.add(module.deathTime, Integer.valueOf(30));
        this.add(module.obsidian, Boolean.valueOf(true));
        this.add(module.obbySwitch, Boolean.valueOf(false));
        this.add(module.obbyDelay, Integer.valueOf(500));
        this.add(module.obbyCalc, Integer.valueOf(500));
        this.add(module.helpingBlocks, Integer.valueOf(1));
        this.add(module.terrainCalc, Boolean.valueOf(false));
        this.add(module.obbySafety, Boolean.valueOf(false));
        this.add(module.obbyTrace, RayTraceMode.Fast);
        this.add(module.obbyTerrain, Boolean.valueOf(true));
        this.add(module.obbyPreSelf, Boolean.valueOf(true));
        this.add(module.fastObby, Integer.valueOf(0));
        this.add(module.maxDiff, Integer.valueOf(1));
        this.add(module.maxDmgDiff, Double.valueOf(0.0));
        this.add(module.obbySwing, PlaceSwing.Once);
        this.add(module.obbyFallback, Boolean.valueOf(false));
        this.add(module.obbyRotate, Rotate.None);
        this.add(module.antiTotem, Boolean.valueOf(true));
        this.add(module.totemHealth, Float.valueOf(1.5f));
        this.add(module.minTotemOffset, Float.valueOf(0.0f));
        this.add(module.maxTotemOffset, Float.valueOf(2.0f));
        this.add(module.popDamage, Float.valueOf(13.0f));
        this.add(module.totemSync, Boolean.valueOf(true));
        this.add(module.forceAntiTotem, Boolean.valueOf(false));
        this.add(module.syncForce, Boolean.valueOf(true));
        this.add(module.forcePlaceConfirm, Integer.valueOf(100));
        this.add(module.forceBreakConfirm, Integer.valueOf(100));
        this.add(module.attempts, Integer.valueOf(500));
        this.add(module.damageSync, Boolean.valueOf(false));
        this.add(module.preSynCheck, Boolean.valueOf(false));
        this.add(module.discreteSync, Boolean.valueOf(false));
        this.add(module.placeConfirm, Integer.valueOf(250));
        this.add(module.breakConfirm, Integer.valueOf(250));
        this.add(module.syncDelay, Integer.valueOf(500));
        this.add(module.surroundSync, Boolean.valueOf(true));
        this.add(module.bExtrapol, Integer.valueOf(0));
        this.add(module.placeExtrapolation, Integer.valueOf(0));
        this.add(module.selfExtrapolation, Boolean.valueOf(false));
        this.add(module.fullExtrapol, Boolean.valueOf(false));
        this.add(module.idPredict, Boolean.valueOf(false));
        this.add(module.idOffset, Integer.valueOf(1));
        this.add(module.idPackets, Integer.valueOf(1));
        this.add(module.godAntiTotem, Boolean.valueOf(false));
        this.add(module.godSwing, PlaceSwing.Once);
        this.add(module.preCalc, PreCalc.None);
        this.add(module.preCalcDamage, Float.valueOf(13.6f));
        this.add(module.multiThread, Boolean.valueOf(true));
        this.add(module.rotationThread, RotationThread.Predict);
        this.add(module.partial, Float.valueOf(0.8f));
        this.add(module.maxCancel, Integer.valueOf(10));
        this.add(module.timeOut, Integer.valueOf(2));
        this.add(module.entityThread, Boolean.valueOf(true));
        this.add(module.blockDestroyThread, Boolean.valueOf(true));
        this.add(module.threadDelay, Integer.valueOf(25));
        this.add(module.explosionThread, Boolean.valueOf(true));
        this.add(module.soundThread, Boolean.valueOf(true));
        this.add(module.spawnThread, Boolean.valueOf(true));
        this.add(module.destroyThread, Boolean.valueOf(true));
        this.add(module.blockChangeThread, Boolean.valueOf(true));
        this.add(module.priority, Integer.valueOf(1500));
    }
}

