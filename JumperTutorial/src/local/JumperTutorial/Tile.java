package local.JumperTutorial;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
	public final boolean walkable;
	public final int frame;
	public final Texture image;
	public final int x;
	public final int y;
	
	Tile(boolean walkable, int frame, Texture image, int x, int y){
		this.walkable = walkable;
		this.frame = frame;
		this.image = image;
		this.x = x;
		this.y = y;
	}
}
