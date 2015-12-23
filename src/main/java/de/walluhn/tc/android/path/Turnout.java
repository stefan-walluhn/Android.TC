package de.walluhn.tc.android.path;

import de.walluhn.tc.android.path.BasePath;


public class Turnout extends BasePath {

    public Turnout() {
        super();
        this.moveTo(width, height / 2);
        this.lineTo(0, height / 2);
        this.lineTo(width / 2, 0);
    }
}
