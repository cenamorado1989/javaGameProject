import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
		private Handler handler;
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velY = 5;
		velX = 5;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,5,5);
	}
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 16) {
			velY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
		}
		handler.addObject(new Trail(x, y,ID.Trail, Color.red, 5, 5, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y, 5,5);
	}

}
