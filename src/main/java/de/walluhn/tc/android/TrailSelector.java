package de.walluhn.tc.android;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import de.walluhn.tc.android.Trail;
import de.walluhn.tc.android.TrailEvent;


public class TrailSelector {
    private TrailHashSet trails;

    public static TrailSelector getInstance() {
        return Instance.INSTANCE;
    }

    private static final class Instance {
        static final TrailSelector INSTANCE = new TrailSelector();
    }

    private TrailSelector() {
        trails = new TrailHashSet();
    }

    public void selectTrails(Set<Trail> trails) {
        if (!this.trails.retainAll(trails) && this.trails.size()==1) {
            registerTrails(selectedTrails());
        }
        if (this.trails.isEmpty()) this.trails.addAll(trails);
    }

    public Set<Trail> selectedTrails() {
        return trails;
    }

    protected void registerTrails(Set<Trail> trails) {
        for (Trail trail: trails) {
            trail.setState(Trail.TrailState.REGISTERED);
            trail.dispatch(new TrailEvent(this, trail));
        }
    }
}


class TrailHashSet extends HashSet<Trail> {
    private class IteratorAdapter implements Iterator<Trail> {
        private Iterator<Trail> iterator;
        private Trail current;

        public IteratorAdapter(Iterator<Trail> iterator) {
            this.iterator = iterator;
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public Trail next() {
            current = iterator.next();
            return current;
        }

        public void remove() {
            current.dispatch(new TrailEvent(this, current));
            iterator.remove();
        }
    }

    public boolean add(Trail trail) {
        trail.dispatch(new TrailEvent(this, trail));
        return super.add(trail);
    }

    public Iterator<Trail> iterator() {
        return new IteratorAdapter(super.iterator());
    }
}
