package dsa2017.day5.bst_dsw;

import java.util.TreeSet;

public class to_flatten_the_tree {

	public static void main(String[] args)
	{
		SearchTreeDsw t = new SearchTreeDsw();
		t.addMany(15, 4, 1, 20, 17, 19, 18, 5);
		
		t.dump(true);
		t.flatten();
		t.dump(true);
	}



}
