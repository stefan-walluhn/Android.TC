package de.walluhn.tc.android.views;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import de.walluhn.tc.android.views.ParticleView;
import de.walluhn.tc.android.Particle;
import de.walluhn.tc.android.NetworkMap;
import de.walluhn.tc.android.Trail;


public class ParticleAdapter extends BaseAdapter {
    private GridView view;
    private AttributeSet attr;
    private NetworkMap networkMap;

    public ParticleAdapter(GridView v, AttributeSet a) {
        view = v;
        attr = a;
        networkMap = new NetworkMap();
    }

    public int getCount() {
        return networkMap.getCount();
    }

    public int getColumns() {
        return networkMap.getColumns();
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
                view.getContext(), attr, networkMap.getParticle(position));
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
