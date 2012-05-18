package local.JumperTutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Hero {
	private int posX;
	private int posY;
	private float x;
	private int dx;
	private float y;
	private int dy;
	private int speed = 100;
	private Texture imgUp = new Texture(Gdx.files.internal("heroDown.png"));
	private Texture imgDown = new Texture(Gdx.files.internal("heroUp.png"));
	private Texture imgLeft = new Texture(Gdx.files.internal("heroLeft.png"));
	private Texture imgRight = new Texture(Gdx.files.internal("heroRight.png"));
	private Texture image;

	public Hero() {
		setImage(imgUp);
	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}

	public void setY(float y) {
		if (this.y > y) {
			setImage(imgUp);
		} else {
			setImage(imgDown);
		}
		this.y = y;
	}

	public void setX(float x) {
		if (this.x > x) {
			setImage(imgLeft);
		} else {
			setImage(imgRight);
		}
		this.x = x;
	}

	public Texture getImage() {
		return image;
	}

	private void setImage(Texture image) {
		if (this.image != image) {
			this.image = image;
			dx = image.getWidth();
			dy = image.getHeight();
		}
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		y = dy * posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
		x = dx * posX;
	}
	public void moveChar(float delta, int dirX, int dirY){
		if(dirX != 0) setX(getX() + dirX * speed * delta);
		if(dirY != 0) setY(getY() + dirY * speed * delta);
	}
	public void dispose() {
		imgUp.dispose();
		imgDown.dispose();
		imgLeft.dispose();
		imgRight.dispose();
	}
}
