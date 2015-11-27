package csci512.bean;

@Deprecated
public class Position {
	private Integer x;
	private Integer y;

	public Position(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}
}
