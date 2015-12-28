package de.walluhn.tc.android.trail;

import java.util.EventObject;

import de.walluhn.tc.android.trail.Trail;


public class TrailEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private Trail trail;

    public TrailEvent(Object source, Trail trail) {
        super(source);
        this.trail = trail;
    }

    public Trail getTrail() {
        return trail;
    }
}
