package de.walluhn.tc.android.backend;

import de.walluhn.tc.android.backend.Backend;
import de.walluhn.tc.android.backend.BackendEventListener;
import de.walluhn.tc.proto.State;


public class DummyBackend implements Backend {
    private BackendEventListener listener;

    public DummyBackend(BackendEventListener listener) {
        this.listener = listener;
    }

    public void register() {
        listener.onStateChange(State.TrailState.REGISTERED);
    }
}
