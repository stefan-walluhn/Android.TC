package de.walluhn.tc.android;

import android.graphics.Path;
import java.util.HashMap;
import java.util.Set;

import de.walluhn.tc.android.Trail;
import de.walluhn.tc.android.TrailSelector;


public class Particle {
    private HashMap<Trail, Path> ptrails;
    private TrailSelector trailSelector;

    public Particle() {
        ptrails = new HashMap<Trail, Path>();
        trailSelector = TrailSelector.getInstance();
    }

    public Particle(Trail trail, Path path) {
        this();
        addTrailPath(trail, path);
    }

    public Path getPath() {
        Path merged = new Path();
        for (Path path: ptrails.values()) {
                merged.addPath(path);
        }
        return merged;
    }

    public Path getPath(Trail trail) {
        return ptrails.get(trail);
    }

    public Particle addTrailPath(Trail trail, Path path) {
        ptrails.put(trail, path);
        return this;
    }

    public Set<Trail> getTrails() {
        return ptrails.keySet();
    }

    public void selectTrails() {
        trailSelector.selectTrails(getTrails());
    }
}
