package de.walluhn.tc.android.map;

import java.util.Arrays;

import de.walluhn.tc.android.backend.DummyBackend;
import de.walluhn.tc.android.particle.Particle;
import de.walluhn.tc.android.particle.ParticleView;
import de.walluhn.tc.android.path.Bend;
import de.walluhn.tc.android.path.Straight;
import de.walluhn.tc.android.trail.Trail;


public class Map {
    private Trail trail1 = new Trail();
    private Trail trail2 = new Trail();
    private Trail trail3 = new Trail();
    private Trail trail4 = new Trail();
    private Trail trail5 = new Trail();
    private Trail trail6 = new Trail();
    private Trail trail7 = new Trail();
    private Trail trail8 = new Trail();

    public Map() {
        trail1.setBackend(new DummyBackend(trail1));
        trail2.setBackend(new DummyBackend(trail2));
        trail3.setBackend(new DummyBackend(trail3));
        trail4.setBackend(new DummyBackend(trail4));
        trail5.setBackend(new DummyBackend(trail5));
        trail6.setBackend(new DummyBackend(trail6));
        trail7.setBackend(new DummyBackend(trail7));
        trail8.setBackend(new DummyBackend(trail8));
    }

    private Particle[][] particles = {
        {
            new Particle(),
            new Particle(trail1, (new Bend()).rotate(180)),
            new Particle(trail1, new Straight()),
            new Particle(trail1, new Straight()),
            (new Particle(trail1, new Straight()).addTrailPath(trail2, new Straight())),
            (new Particle(trail1, new Straight()).addTrailPath(trail2, new Straight())),
            (new Particle(trail2, new Straight()).addTrailPath(trail3, (new Bend()).rotate(180))),
            (new Particle(trail2, new Straight()).addTrailPath(trail3, new Straight())),
            (new Particle(trail2, new Straight()).addTrailPath(trail3, new Straight())),
        }, {
            (new Particle(trail1, new Straight()).addTrailPath(trail4, new Straight())),
            (new Particle(trail1, new Bend()).addTrailPath(trail4, new Straight())),
            (new Particle(trail4, new Straight()).addTrailPath(trail5, (new Bend()).rotate(180))),
            (new Particle(trail4, new Straight()).addTrailPath(trail5, new Straight())),
            (new Particle(trail3, new Straight()).addTrailPath(trail4, new Straight()).addTrailPath(trail5, new Straight()).addTrailPath(trail6, new Straight())),
            (new Particle(trail3, new Straight()).addTrailPath(trail4, new Straight()).addTrailPath(trail5, new Straight()).addTrailPath(trail6, new Straight())),
            (new Particle(trail3, new Bend()).addTrailPath(trail6, new Straight())),
            (new Particle(trail6, new Straight()).addTrailPath(trail7, (new Bend()).rotate(180))),
            (new Particle(trail6, new Straight()).addTrailPath(trail7, new Straight()))
        }, {
            (new Particle(trail5, new Straight()).addTrailPath(trail8, new Straight())),
            (new Particle(trail5, new Straight()).addTrailPath(trail8, new Straight())),
            (new Particle(trail5, new Bend()).addTrailPath(trail8, new Straight())),
            new Particle(trail8, new Straight()),
            (new Particle(trail7, new Straight()).addTrailPath(trail8, new Straight())),
            (new Particle(trail7, new Straight()).addTrailPath(trail8, new Straight())),
            new Particle(trail7,  new Straight()),
            new Particle(trail7, new Bend()),
            new Particle()
        }
    };

    public Particle getParticle(int position) {
        int i  = position / particles[0].length;
        int k = position % particles[0].length;
        return particles[i][k];
    }

    public int getCount() {
        return particles.length * particles[0].length;
    }

    public int getColumns() {
        return particles[0].length;
    }
}
