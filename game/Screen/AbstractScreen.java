package com.mygdx.game.Screen;

import com.badlogic.gdx.Screen;

import com.mygdx.game.PolymorphicPhiters;


public abstract class AbstractScreen implements Screen {
	public PolymorphicPhiters game;

    public AbstractScreen(PolymorphicPhiters game){
        this.game = game;
    }

    abstract void inputHandler(); 
    
}
