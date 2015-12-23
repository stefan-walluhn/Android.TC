package de.walluhn.tc.android;

import java.util.Arrays;

import de.walluhn.tc.android.Particle;
import de.walluhn.tc.android.views.ParticleView;
import de.walluhn.tc.android.path.Bend;
import de.walluhn.tc.android.path.Straight;
import de.walluhn.tc.android.path.Turnout;


public class NetworkMap {
    private Trail trail1 = new Trail();
    private Trail trail2 = new Trail();
    private Trail trail3 = new Trail();
    private Trail trail4 = new Trail();
    private Trail trail5 = new Trail();
    private Trail trail6 = new Trail();
    private Trail trail7 = new Trail();
    private Trail trail8 = new Trail();

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
