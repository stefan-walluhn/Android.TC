package de.walluhn.tc.android;

import java.util.Collection;
import java.util.EventListener;
import java.util.HashSet;

import de.walluhn.tc.android.Particle;
import de.walluhn.tc.android.TrailEvent;


public class Trail {
    protected HashSet<TrailEventListener> listeners;
    private TrailState state;

    public static enum TrailState { IDLE, REGISTERED }

    public Trail() {
        listeners = new HashSet<TrailEventListener>();
        state = Trail.TrailState.IDLE;
    }

    public void dispatch(TrailEvent event) {
        for (TrailEventListener listener: listeners) {
            listener.onTrailEvent(event);
        }
    }

    public interface TrailEventListener extends EventListener {
        public void onTrailEvent(TrailEvent e);
    }

    public boolean setTrailEventListener(TrailEventListener listener){
        return this.listeners.add(listener);
    }

    public TrailState getState() {
        return state;
    }

    public void setState(TrailState state) {
        this.state = state;
    }
}

