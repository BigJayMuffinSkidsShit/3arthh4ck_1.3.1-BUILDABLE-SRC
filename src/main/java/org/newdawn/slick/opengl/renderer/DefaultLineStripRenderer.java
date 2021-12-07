/*
 * Decompiled with CFR 0.150.
 */
package org.newdawn.slick.opengl.renderer;

import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class DefaultLineStripRenderer
implements LineStripRenderer {
    private SGL GL = Renderer.get();

    @Override
    public void end() {
        this.GL.glEnd();
    }

    @Override
    public void setAntiAlias(boolean antialias) {
        if (antialias) {
            this.GL.glEnable(2848);
        } else {
            this.GL.glDisable(2848);
        }
    }

    @Override
    public void setWidth(float width) {
        this.GL.glLineWidth(width);
    }

    @Override
    public void start() {
        this.GL.glBegin(3);
    }

    @Override
    public void vertex(float x, float y) {
        this.GL.glVertex2f(x, y);
    }

    @Override
    public void color(float r, float g, float b, float a) {
        this.GL.glColor4f(r, g, b, a);
    }

    @Override
    public void setLineCaps(boolean caps) {
    }

    @Override
    public boolean applyGLLineFixes() {
        return true;
    }
}

