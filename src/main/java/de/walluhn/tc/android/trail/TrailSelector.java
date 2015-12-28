package de.walluhn.tc.android.trail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import de.walluhn.tc.android.trail.Trail;
import de.walluhn.tc.android.trail.TrailEvent;


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
        // XXX this is not thread save
        if (!this.trails.retainAll(trails) && picked()) {
            registerTrails(this.trails);
        }
        if (this.trails.isEmpty()) this.trails.addAll(trails);
    }

    public boolean selected(Trail trail) {
        return trails.contains(trail);
    }

    public boolean picked() {
        return (trails.size()==1);
    }

    protected void registerTrails(Set<Trail> trails) {
        for (Trail trail: trails) {
            trail.register();
        }
    }
}

// XXX hacky stuff
class TrailHashSet extends HashSet<Trail> {

    private class TrailSelectEvent extends TrailEvent {
        private boolean selected;

        public TrailSelectEvent(Object source, Trail trail, boolean selected) {
            super(source, trail);
            this.selected = selected;
        }

        public boolean selected() {
            return selected;
        }
    }

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
            iterator.remove();
            current.dispatch(new TrailSelectEvent(this, current, false));
        }
    }

    public boolean add(Trail trail) {
        trail.dispatch(new TrailSelectEvent(this, trail, true));
        return super.add(trail);
    }

    public Iterator<Trail> iterator() {
        return new IteratorAdapter(super.iterator());
    }
}
