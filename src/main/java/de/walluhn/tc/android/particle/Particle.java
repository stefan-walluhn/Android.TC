package de.walluhn.tc.android.particle;

import android.graphics.Path;
import java.util.HashMap;
import java.util.Set;

import de.walluhn.tc.android.trail.Trail;


public class Particle {
    private HashMap<Trail, Path> ptrails;

    public Particle() {
        ptrails = new HashMap<Trail, Path>();
    }

    public Particle(Trail trail, Path path) {
        this();
        addTrailPath(trail, path);
    }

    public Particle addTrailPath(Trail trail, Path path) {
        ptrails.put(trail, path);
        return this;
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

    public Set<Trail> getTrails() {
        return ptrails.keySet();
    }

    /*
    public void selectTrails() {
        trailSelector.selectTrails(getTrails());
    }
    */
}
