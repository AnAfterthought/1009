package com.mygdx.base_game_1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class base_game_1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	Vector2 lightPosition, heavyPosition;
	float moveSpeed;
	
	Fighter fighter_one = new Fighter(1, 1, 1, 1, 1, 1);
	Fighter fighter_two = new Fighter(1, 1, 1, 1, 1, 1);
	
	private TextureAtlas lightIdleTexture, lightAttackTexture, lightRunTexture;
	private TextureAtlas heavyIdleTexture, heavyAttackTexture, heavyRunTexture;
	private TextureRegion lightCurrentFrame, heavyCurrentFrame;
	private Animation <TextureRegion> lightBaseAnimation, heavyBaseAnimation;
	private float elapsedTimeFighterOne, elapsedTimeFighterTwo = 0;
	
	// everything here all temporary, organization of these vars settle later on
	final int IDLE = 0, LEFT = 1, RIGHT = 2, DOWN = 3, UP = 4, ATTACK_LIGHT = 5;
	static boolean FACING_LEFT_FIGHTER_ONE, FACING_LEFT_FIGHTER_TWO = true;
	int prevActionFighterOne, prevActionFighterTwo;
	int actionFighterOne, actionFighterTwo = IDLE;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		// Sprites can probably be initialized using spritesheets only, https://www.youtube.com/watch?v=KwnDuc08LNE
		// Tentatively we just use this first
		lightIdleTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Light/idle.atlas"));
		lightAttackTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Light/attack_light.atlas"));
		lightRunTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Light/run.atlas"));

		heavyIdleTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Heavy/idle.atlas"));
		heavyAttackTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Heavy/attack_light.atlas"));
		heavyRunTexture = new TextureAtlas(Gdx.files.internal("spritesheets/Heavy/run.atlas"));

		lightPosition = new Vector2(0,0);
		heavyPosition = new Vector2(10,0);
		
		fighter_one.setX(lightPosition.x);
		fighter_one.setY(lightPosition.y);
		fighter_two.setX(heavyPosition.x);
		fighter_two.setY(heavyPosition.y);

		moveSpeed = 10f;
	}
	
	@Override
	public void render () {
		    
        // Sets the character to the IDLE animation    
        if ((actionFighterOne == IDLE) && (prevActionFighterOne == IDLE))
        {
        	lightBaseAnimation = new Animation(1f/10f, lightIdleTexture.getRegions());
        }
        
        if ((actionFighterTwo == IDLE) && (prevActionFighterTwo == IDLE))
        {
        	heavyBaseAnimation = new Animation(1f/10f, heavyIdleTexture.getRegions());
        }
              
        prevActionFighterOne = actionFighterOne;
        prevActionFighterTwo = actionFighterTwo;
        elapsedTimeFighterOne += Gdx.graphics.getDeltaTime();
        elapsedTimeFighterTwo += Gdx.graphics.getDeltaTime();
        
        lightCurrentFrame = lightBaseAnimation.getKeyFrame(elapsedTimeFighterOne, true);
		heavyCurrentFrame = heavyBaseAnimation.getKeyFrame(elapsedTimeFighterTwo, true);
        
		// smoll
        if (FACING_LEFT_FIGHTER_ONE)
        {
        	 if (!lightCurrentFrame.isFlipX()) 
			 lightCurrentFrame.flip(true, false);
        }
        else
        {
        	if (lightCurrentFrame.isFlipX())
			lightCurrentFrame.flip(true, false);
        }
        
        // bik
        if (FACING_LEFT_FIGHTER_TWO)
        {
        	 if (!heavyCurrentFrame.isFlipX()) 
			 heavyCurrentFrame.flip(true, false);
        }
        else
        {
        	if (heavyCurrentFrame.isFlipX())
        		heavyCurrentFrame.flip(true, false);
        }
              
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        	
        
        batch.begin();
        fighter_one.draw(batch, lightCurrentFrame, lightPosition.x, lightPosition.y);
        fighter_two.draw(batch, heavyCurrentFrame, heavyPosition.x, heavyPosition.y);
        //batch.draw(lightCurrentFrame, lightPosition.x, lightPosition.y);
		//batch.draw(heavyCurrentFrame, heavyPosition.x, heavyPosition.y);
        batch.end();
        
        
        // to put all of these into a function (inputs). all of these hardcoded for now
        
        // smoll character
        if(Gdx.input.isKeyPressed(Keys.A))
        {
        	actionFighterOne = LEFT;
        	lightPosition.x -= moveSpeed * elapsedTimeFighterOne;
        	if (lightPosition.x <= 0) {
        		lightPosition.x = 0;
        	}
        	FACING_LEFT_FIGHTER_ONE = true;
        }     
        else if(Gdx.input.isKeyPressed(Keys.S))
        {
        	actionFighterOne = DOWN;
        }
        else if(Gdx.input.isKeyPressed(Keys.D))
        {
        	actionFighterOne = RIGHT;
        	lightPosition.x += moveSpeed * elapsedTimeFighterOne;
        	FACING_LEFT_FIGHTER_ONE = false;
        }     
        else if(Gdx.input.isKeyJustPressed(Keys.W))
        {
        	actionFighterOne = UP;
        }
        else if(Gdx.input.isKeyJustPressed(Keys.J))
        {
        	actionFighterOne = ATTACK_LIGHT;
        }
        else if(Gdx.input.isKeyJustPressed(Keys.K))
        {
        	// Heavy attack
        }
        
        // bik chara
        if(Gdx.input.isKeyPressed(Keys.LEFT))
        {
        	actionFighterTwo = LEFT;
        	heavyPosition.x -= moveSpeed * elapsedTimeFighterTwo;
        	FACING_LEFT_FIGHTER_TWO = true;
        }     
        else if(Gdx.input.isKeyPressed(Keys.DOWN))
        {
        	actionFighterTwo = DOWN;
        }
        else if(Gdx.input.isKeyPressed(Keys.RIGHT))
        {
        	actionFighterTwo = RIGHT;
        	heavyPosition.x += moveSpeed * elapsedTimeFighterTwo;
        	FACING_LEFT_FIGHTER_TWO = false;
        }     
        else if(Gdx.input.isKeyJustPressed(Keys.UP))
        {
        	actionFighterTwo = UP;
        }
        else if(Gdx.input.isKeyJustPressed(Keys.NUMPAD_1))
        {
        	actionFighterTwo = ATTACK_LIGHT;
        }
        else if(Gdx.input.isKeyJustPressed(Keys.NUMPAD_2))
        {
        	// Heavy attack
        }
                  
        // Change the action based on the key pressed
        
        // smoll
        if(actionFighterOne != prevActionFighterOne) {
        	if (actionFighterOne == ATTACK_LIGHT)
        		lightBaseAnimation = new Animation(1f/10f, lightAttackTexture.getRegions());
        	else if (actionFighterOne == RIGHT)
        		lightBaseAnimation = new Animation(1f/10f, lightRunTexture.getRegions());
        	else if (actionFighterOne == LEFT)
        		lightBaseAnimation = new Animation(1f/10f, lightRunTexture.getRegions());
        	prevActionFighterOne = actionFighterOne;
        }
        
        // bik
        if(actionFighterTwo != prevActionFighterTwo) {
        	if (actionFighterTwo == ATTACK_LIGHT)
        		heavyBaseAnimation = new Animation(1f/10f, heavyAttackTexture.getRegions());
        	else if (actionFighterTwo == RIGHT)
        		heavyBaseAnimation = new Animation(1f/10f, heavyRunTexture.getRegions());
        	else if (actionFighterTwo == LEFT)
        		heavyBaseAnimation = new Animation(1f/10f, heavyRunTexture.getRegions());
        	prevActionFighterTwo = actionFighterTwo;
        }
        
        // Once a certain animation has been completed, set back to the IDLE animation
        
      
        
        // smoll
        if (lightBaseAnimation.isAnimationFinished(elapsedTimeFighterOne))
        {
        	prevActionFighterOne = IDLE;
        	actionFighterOne = IDLE;
        	elapsedTimeFighterOne = 0;
        } 
        
        // bik
        if (heavyBaseAnimation.isAnimationFinished(elapsedTimeFighterTwo))
        {
        	prevActionFighterTwo = IDLE;
        	actionFighterTwo = IDLE;
        	elapsedTimeFighterTwo = 0;
        }                     
        
	}
	
	
}
