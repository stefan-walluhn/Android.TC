package de.walluhn.tc.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import de.walluhn.tc.android.graphics.ParticleDrawable;
import de.walluhn.tc.android.Particle;
import de.walluhn.tc.android.Trail;
import de.walluhn.tc.android.TrailEvent;


public class ParticleView extends View
        implements View.OnClickListener, Trail.TrailEventListener {
    private ParticleDrawable particleDrawable;
    private Particle particle;

    public ParticleView(
            Context context, AttributeSet attrs, Particle particle) {
        super(context, attrs);
        setOnClickListener(this);

        this.particle = particle;
        particleDrawable = new ParticleDrawable(particle);
    }

    public void onClick(View v) {
        particle.selectTrails();
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
