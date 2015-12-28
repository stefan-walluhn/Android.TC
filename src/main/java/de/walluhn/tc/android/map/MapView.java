package de.walluhn.tc.android.map;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.util.AttributeSet;

import de.walluhn.tc.android.particle.ParticleAdapter;


public class MapView extends GridView {

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        ParticleAdapter particleAdapter = new ParticleAdapter(this, attrs);
        setNumColumns(particleAdapter.getColumns());
        setAdapter(particleAdapter);
    }
}
