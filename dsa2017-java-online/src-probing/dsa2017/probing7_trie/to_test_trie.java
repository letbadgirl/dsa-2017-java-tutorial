package dsa2017.probing7_trie;

public class to_test_trie {

	public static void main(String[] args) 
	{
		AbcTrie t = new AbcTrie();
		t.add("she", 0);
		t.add("sells", 1);
		t.add("sea", 2);
		t.add("shells", 3);
		t.add("by", 4);
		t.add("the", 5);
		t.add("sea", 6);
		t.add("shore", 7);
		
		//t.dump();
		//t.dumpPref("sh");
		
		{ String s="she"; System.out.println("("+s+" inside tree)=" + t.contains(s));}
		{ String s="shed"; System.out.println("("+s+" inside tree)=" + t.contains(s));}
		
		t.remove("she");
		t.remove("by");
		t.dump();
	}

}
