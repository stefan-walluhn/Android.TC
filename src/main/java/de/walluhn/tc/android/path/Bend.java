package de.walluhn.tc.android.path;

import android.graphics.RectF;

import de.walluhn.tc.android.path.BasePath;


public class Bend extends BasePath {

    public Bend() {
        super();
        arcTo(new RectF(
                width/2-width, height/2-height, width/2, height/2), 0, 90);
    }
}
