package de.walluhn.tc.android.trail;

import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;

import de.walluhn.tc.android.backend.Backend;
import de.walluhn.tc.android.backend.BackendEventListener;
import de.walluhn.tc.proto.State;


class BaseTrail {
    private HashSet<TrailEventListener> listeners;
    private State.TrailState state;

    public BaseTrail() {
        state = State.TrailState.IDLE;
        listeners = new HashSet<TrailEventListener>();
    }

    public interface TrailEventListener extends EventListener {
        public void onTrailEvent(TrailEvent e);
    }

    public boolean setTrailEventListener(TrailEventListener listener){
        return this.listeners.add(listener);
    }

    public void dispatch(TrailEvent event) {
        for (TrailEventListener listener: listeners) {
            listener.onTrailEvent(event);
        }
    }

    public State.TrailState getState() {
        return state;
    }

    protected void setState(State.TrailState state) {
        this.state = state;
    }
}


public class Trail extends BaseTrail implements BackendEventListener {
    private Backend backend;

    protected class TrailStateChangeEvent extends TrailEvent {
        private State.TrailState state;

        public TrailStateChangeEvent(
                Object source, Trail trail, State.TrailState state) {
            super(source, trail);
            this.state = state;
        }

        public State.TrailState getState() {
            return state;
        }
    }

    public Trail setBackend(Backend backend) {
        this.backend = backend;
        return this;
    }

    public void register() {
        backend.register();
    }

    public void onStateChange(State.TrailState state) {
        setState(state);
        dispatch(new TrailStateChangeEvent(this, this, state));
    }
}
