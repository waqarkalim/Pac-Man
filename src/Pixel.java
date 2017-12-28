public class Pixel {
	
	private Location p;
	private int color;
	
	public Pixel(Location p, int color) {
		this.p = p;
		this.color = color;
	}
	
	public Location getLocation() {
		return this.p;
	}
	
	public int getColor() {
		return this.color;
	}
	
}
