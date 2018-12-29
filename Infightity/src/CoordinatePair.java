
public class CoordinatePair {

	int x, y;
	int dir;
	
	public CoordinatePair(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public int get_x()   { return   x; }
	public int get_y()   { return   y; }
	public int get_dir() { return dir; }
}
