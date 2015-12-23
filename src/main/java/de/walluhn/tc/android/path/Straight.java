package de.walluhn.tc.android.path;

import de.walluhn.tc.android.path.BasePath;


public class Straight extends BasePath {
    public Straight() {
        super();
        this.moveTo(0, height / 2);
        this.lineTo(width, height / 2);
    }
}
