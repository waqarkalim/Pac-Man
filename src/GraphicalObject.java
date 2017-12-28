public class GraphicalObject implements GraphicalObjectADT {
	
	private int id;
	private int width;
	private int height;
	private String type;
	private Location pos;
	private BinarySearchTree tree;
	
	public GraphicalObject(int id, int width, int height, String type, Location pos) {
		tree = new BinarySearchTree();
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	} 
	
	public String getType() {
		return this.type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Location getOffset() {
		return this.pos;
	}
	
	public void setOffset(Location value) {
		this.pos = value;
	}
	
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		try {
			tree.put(tree.getRoot(), pix);
		} catch (DuplicatedKeyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean intersects(GraphicalObject gobj) {
		BinarySearchTree thisTree = this.getTree();
		BinarySearchTree otherTree = gobj.getTree();
		
		BinaryNode thisroot = thisTree.getRoot();
		BinaryNode otherroot = otherTree.getRoot();
		
		Location thisSmallestLocation = thisTree.smallest(thisroot).getLocation();
		Location otherSmallestLocation = otherTree.smallest(otherroot).getLocation();
		
		Location thisLargestLocation = thisTree.largest(thisroot).getLocation();
		Location otherLargestLocation = otherTree.largest(otherroot).getLocation();
		
		while ((thisSmallestLocation != null) && (otherSmallestLocation != null)) {
			if ((thisSmallestLocation.compareTo(thisLargestLocation) == 0) || (otherSmallestLocation.compareTo(otherLargestLocation) == 0)) {
				return false;
			}
			
			Location otherOffSet = new Location(otherSmallestLocation.xCoord() + gobj.getOffset().xCoord(), otherSmallestLocation.yCoord() + gobj.getOffset().yCoord());
			Location thisOffSet = new Location(thisSmallestLocation.xCoord() + this.getOffset().xCoord(), thisSmallestLocation.yCoord() + this.getOffset().yCoord());
			
			if (thisOffSet.compareTo(otherOffSet) == 0) {
				return true;
			} else if (thisOffSet.compareTo(otherOffSet) == 1) {
				otherSmallestLocation = otherTree.successor(otherroot, otherSmallestLocation).getLocation();
			} else {
				thisSmallestLocation = thisTree.successor(thisroot, thisSmallestLocation).getLocation();
			}
		}
		return false;
	}
	
	private boolean findPixel(Location p) {
		if (tree.get(tree.getRoot(), p) == null) {
			return false;
		} else {
			return true;}
//		return tree.get(tree.getRoot(),  p);
	}
	
	private BinarySearchTree getTree() {
		return tree;
	}
}