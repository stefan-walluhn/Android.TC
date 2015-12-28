package de.walluhn.tc.android.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import de.walluhn.tc.android.particle.Particle;
import de.walluhn.tc.android.particle.ParticleDrawable;
import de.walluhn.tc.android.trail.Trail;
import de.walluhn.tc.android.trail.TrailEvent;
import de.walluhn.tc.android.trail.TrailSelector;


public class ParticleView extends View
        implements View.OnClickListener, Trail.TrailEventListener {
    private Particle particle;
    private ParticleDrawable particleDrawable;
    private TrailSelector trailSelector;

    public ParticleView(
            Context context, AttributeSet attrs, Particle particle) {
        super(context, attrs);
        this.particle = particle;
        particleDrawable = new ParticleDrawable(particle);
        trailSelector = TrailSelector.getInstance();

        setOnClickListener(this);
    }

    public void onClick(View v) {
        trailSelector.selectTrails(particle.getTrails());
    }

    public void onTrailEvent(TrailEvent e) {
        invalidate();
    }

    protected void onLayout(
            boolean changed, int left, int top, int right, int bottom) {
        if (changed) particleDrawable.setBounds(0, 0, right-left, bottom-top);
    }

    protected void onDraw(Canvas canvas) {
        particleDrawable.draw(canvas);
    }
}
