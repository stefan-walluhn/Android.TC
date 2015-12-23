package de.walluhn.tc.android.views;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.util.AttributeSet;

import de.walluhn.tc.android.views.ParticleAdapter;


public class NetworkView extends GridView {
    ParticleAdapter particleAdapter;


    public NetworkView(Context context, AttributeSet attrs) {
        super(context, attrs);

        particleAdapter = new ParticleAdapter(this, attrs);
        this.setNumColumns(particleAdapter.getColumns());
        this.setAdapter(new ParticleAdapter(this, attrs));
    }
}
