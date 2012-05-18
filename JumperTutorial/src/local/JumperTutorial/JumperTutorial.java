package local.JumperTutorial;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

//made by flash tutor http://www.tonypa.pri.ee/tbw/start.html

public class JumperTutorial implements ApplicationListener {
	Array<Texture> images;
	Hero hero;

	Camera camera;
	SpriteBatch batch;

	List<Tile> map = new ArrayList<Tile>();

	private void buildMap(int[][] arr) {
		int x = 0;
		int y = 0;
		int dx = images.get(0).getWidth();
		int dy = images.get(0).getHeight();

		for (int[] a : arr) {
			for (int i : a) {
				Tile tile = new Tile((i == 0), i + 1, images.get(i), x, y);
				map.add(tile);
				x += dx;
			}
			x = 0;
			y += dy;
		}
	}

	@Override
	public void create() {
		images = new Array<Texture>(2);
		images.add(new Texture(Gdx.files.internal("white.png")));
		images.add(new Texture(Gdx.files.internal("black.png")));

		int arr[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		buildMap(arr);
		hero = new Hero();
		hero.setPosX(2);
		hero.setPosY(1);

		camera = new OrthographicCamera();
		((OrthographicCamera) camera).setToOrtho(true, 800, 480);

		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		for (Texture img : images) {
			img.dispose();
		}
		hero.dispose();
		batch.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Tile tile : map) {
			batch.draw(tile.image, tile.x, tile.y);
		}
		batch.draw(hero.getImage(), hero.getX(), hero.getY());
		batch.end();

		int speed = 100;
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			hero.moveChar(Gdx.graphics.getDeltaTime(), -1, 0);
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			hero.moveChar(Gdx.graphics.getDeltaTime(), 1, 0);
		}
		else if (Gdx.input.isKeyPressed(Keys.UP)) {
			hero.moveChar(Gdx.graphics.getDeltaTime(), 0, -1);
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			hero.moveChar(Gdx.graphics.getDeltaTime(), 0, 1);
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
