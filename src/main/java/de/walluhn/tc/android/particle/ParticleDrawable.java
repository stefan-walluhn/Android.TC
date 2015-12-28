package de.walluhn.tc.android.particle;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.graphics.Path;

import de.walluhn.tc.android.particle.Particle;
import de.walluhn.tc.android.trail.Trail;
import de.walluhn.tc.android.trail.TrailSelector;
import de.walluhn.tc.proto.State;


public class ParticleDrawable extends LayerDrawable {

    public ParticleDrawable(Particle particle) {
        super(new Drawable[]{
            new BackgroundDrawable(),
            new BackgroundTrailDrawable(particle),
            new SelectTrailDrawable(particle),
            new PreselectTrailDrawable(particle)});
    }
}

/*
abstract class ParticleElementDrawable extends Drawable {
    private ShapeDrawable shapeDrawable;

    public ParticleElementDrawable(Shape shape) {
        shapeDrawable = new ShapeDrawable(shape);
    }

    public void draw(Canvas canvas) {
        shapeDrawable.draw(canvas);
    }

    public Paint getPaint() {
        return shapeDrawable.getPaint();
    }

    public int getOpacity() {
        return shapeDrawable.getOpacity();
    }

    public void setAlpha(int alpha) {
        shapeDrawable.setAlpha(alpha);
    }

    public void setBounds(int left, int top, int right, int bottom) {
        shapeDrawable.setBounds(left, top, right, bottom);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        shapeDrawable.setColorFilter(colorFilter);
    }
}
*/

class BackgroundDrawable extends ShapeDrawable {
    public BackgroundDrawable() {
        super(new RectShape());
        getPaint().setColor(0xff74AC23);
    }
}


class BackgroundTrailDrawable extends ShapeDrawable {
    public BackgroundTrailDrawable(Particle particle) {
        super(new PathShape(particle.getPath(), 8, 8));
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setAntiAlias(true);
        getPaint().setStrokeWidth((float)1.5);
        getPaint().setStrokeCap(Paint.Cap.SQUARE);
        getPaint().setColor(0xffffffff);
    }
}


class SelectTrailDrawable extends ShapeDrawable {
    private Particle particle;

    public SelectTrailDrawable(Particle particle) {
        super();
        this.particle = particle;
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setAntiAlias(true);
        getPaint().setStrokeWidth(1);
        getPaint().setStrokeCap(Paint.Cap.SQUARE);
    }

    public void draw(Canvas canvas) {
        for (Trail trail: particle.getTrails()) {
            if (trail.getState() != State.TrailState.IDLE) {
                setShape(new PathShape(particle.getPath(trail), 8, 8));
                getPaint().setColor(0xffff0000);
                super.draw(canvas);
            }
        }
    }
}


class PreselectTrailDrawable extends ShapeDrawable {
    private Particle particle;
    private TrailSelector trailSelector;

    public PreselectTrailDrawable(Particle particle) {
        super();
        this.particle = particle;
        trailSelector = TrailSelector.getInstance();
        getPaint().setStyle(Paint.Style.STROKE);
        getPaint().setAntiAlias(true);
        getPaint().setStrokeWidth(1);
        getPaint().setStrokeCap(Paint.Cap.SQUARE);
        getPaint().setColor(0x99000000);
    }

    public void draw(Canvas canvas) {
        Path merged_path = new Path();
        for (Trail trail: particle.getTrails()) {
            if (trailSelector.selected(trail)) {
                merged_path.addPath(particle.getPath(trail));
            }
        }
        setShape(new PathShape(merged_path, 8, 8));
        super.draw(canvas);
    }
}
