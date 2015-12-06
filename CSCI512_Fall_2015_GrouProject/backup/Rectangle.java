package csci512.bean;

@Deprecated
public class Rectangle {
	private Position topLeft;
	private Position topRight;
	private Position bottomLeft;
	private Position bottomRight;

	public Rectangle(Position topLeft, Position topRight, Position bottomLeft, Position bottomRight) {
		super();
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}

	public Position getTopLeft() {
		return topLeft;
	}

	public Position getTopRight() {
		return topRight;
	}

	public Position getBottomLeft() {
		return bottomLeft;
	}

	public Position getBottomRight() {
		return bottomRight;
	}
}