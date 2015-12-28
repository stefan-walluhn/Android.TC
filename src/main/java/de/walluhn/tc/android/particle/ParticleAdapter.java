package de.walluhn.tc.android.particle;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import de.walluhn.tc.android.map.Map;
import de.walluhn.tc.android.trail.Trail;
import de.walluhn.tc.android.particle.Particle;
import de.walluhn.tc.android.particle.ParticleView;


public class ParticleAdapter extends BaseAdapter {
    private GridView view;
    private AttributeSet attr;
    private Map map;

    public ParticleAdapter(GridView v, AttributeSet a) {
        view = v;
        attr = a;
        map = new Map();
    }

    public int getCount() {
        return map.getCount();
    }

    public int getColumns() {
        return map.getColumns();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View particleView;
        if (convertView == null) {
            particleView = getParticleView(position);
        } else {
            particleView = (ParticleView) convertView;
        }
        particleView.setLayoutParams(
                new GridView.LayoutParams(
                    view.getColumnWidth(), view.getColumnWidth()));
        return particleView;
    }

    private View getParticleView(int position) {
        return ParticleViewFactory.getView(
                view.getContext(), attr, map.getParticle(position));
    }
}


class ParticleViewFactory {

    public static final View getView(
            Context context, AttributeSet attr, Particle particle) {
        ParticleView view = new ParticleView(context, attr, particle);
        for (Trail trail: particle.getTrails()) {
            trail.setTrailEventListener(view);
        }
        return view;
    }
}
