
public class CategoryNode {
	private String AminoAcids;//CategoryName 
	private CategoryNode down;
	private ItemNode right;
		
	public CategoryNode(String dataToAdd) {
		AminoAcids = dataToAdd;
		down = null;
		right = null;
	}
	
	public Object getCategoryName() 
	{ 
		return AminoAcids; 
	}
	public void setCategoryName(String data) 
	{ 
		this.AminoAcids = data;  
	}
	public CategoryNode getDown() 
	{ 
		return down;  
	}
	public void setDown(CategoryNode down) 
	{ 
		this.down = down;   
	}
	public ItemNode getRight() 
	{ 
		return right; 
	}
	public void setRight(ItemNode right) 
	{
		this.right = right;   
	}
}
