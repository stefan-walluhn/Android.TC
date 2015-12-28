package de.walluhn.tc.android.backend;

import de.walluhn.tc.proto.State;


public interface BackendEventListener {
    public void onStateChange(State.TrailState state);
}
