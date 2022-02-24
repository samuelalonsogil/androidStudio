package com.example.juegopepe;

import android.graphics.Rect;

public class Animadora {
    private Rect rect;
    private int cuentaFrame;
    private int actualFrame;
    private long corazonFrame;
    private int periodoFrame;
    private int anchoFrame;

    public Animadora(float alturaFrame, float anchoFrame, int cuentaFrame) {
        this.cuentaFrame = cuentaFrame;
        this.actualFrame = actualFrame;
        this.anchoFrame = anchoFrame;
    }
}
