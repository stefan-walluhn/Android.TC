package de.walluhn.tc.android.path;

import android.graphics.Matrix;
import android.graphics.Path;


public class BasePath extends Path {
    int width = 8;
    int height = 8;

    public Path rotate(float degrees) {
        Matrix m = new Matrix();
        m.setRotate(degrees, width / 2, height / 2);
        this.transform(m);
        return this;
    }

    public Path flip() {
        Matrix m = new Matrix();
        m.setScale(-1,1, width / 2, height / 2);
        this.transform(m);
        return this;
    }
}
