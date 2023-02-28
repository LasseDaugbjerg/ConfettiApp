package com.example.confettiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;
    private Party shortParty = null;
    private Party longParty = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        konfettiView = findViewById(R.id.konfettiView);

        EmitterConfig shortEmitterConfig = new Emitter(200, TimeUnit.MILLISECONDS).perSecond(50);
        shortParty = new PartyFactory(shortEmitterConfig)
                .spread(360)
                .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                .setSpeedBetween(0f, 30f)
                .position(new Position.Relative(0.5, 0.3))
                .build();

        EmitterConfig longEmitterConfig = new Emitter(500, TimeUnit.MILLISECONDS).perSecond(150);
        longParty = new PartyFactory(longEmitterConfig)
                .spread(500)
                .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                .setSpeedBetween(0f, 30f)
                .position(new Position.Relative(0.7, 0.6))
                .build();

    }

    public void ConfettiBoom(View view) {
        System.out.println("Confetti test");
        konfettiView.start(shortParty);
    }

    public void bigBurstOfConfetti(View view) {
        konfettiView.start(longParty);
    }
}