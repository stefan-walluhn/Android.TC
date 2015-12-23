package de.walluhn.tc.android;

import android.graphics.Path;

import de.walluhn.tc.android.Trail;


public class ParticleTrail {
    Trail trail;
    Path path;

    public ParticleTrail(Trail trail, Path path) {
        this.trail = trail;
        this.path = path;
    }

    public Trail getTrail() {
        return trail;
    }

    public Path getPath() {
        return path;
    }
}
