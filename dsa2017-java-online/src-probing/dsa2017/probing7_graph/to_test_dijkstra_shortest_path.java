package dsa2017.probing7_graph;

import dsa2017.day5.swing.befaf.Figures;

public class to_test_dijkstra_shortest_path 
{

	public static void main(String[] args) 
	{
		MyGraph g = new MyGraph();
		
		MyNode n1 = g.add(new MyNode("1")); 
		MyNode n2 = g.add(new MyNode("2")); 
		MyNode n3 = g.add(new MyNode("3")); 
		MyNode n4 = g.add(new MyNode("4")); 
		MyNode n5 = g.add(new MyNode("5")); 
		MyNode n6 = g.add(new MyNode("6")); 
		
		g.add(new MyLink(n1, n6, 14)); 
		g.add(new MyLink(n1, n3, 9)); 
		g.add(new MyLink(n1, n2, 7));
		
		g.add(new MyLink(n2, n3, 10)); 
		g.add(new MyLink(n2, n4, 15)); 
		
		g.add(new MyLink(n3, n6, 2)); 
		g.add(new MyLink(n3, n4, 11)); 
		
		g.add(new MyLink(n6, n5, 9)); 
		g.add(new MyLink(n5, n4, 6)); 
		
		placeAndDraw(g);
	}
	
	protected static void placeAndDraw(MyGraph g) 
	{
		g.dump();
		
		g.find("1").tag = new MyTag(10, 120, 20, 30);

		g.find("6").tag = new MyTag(30, 30, 20, 30);
		g.find("3").tag = new MyTag(50, 130, 20, 30);
		g.find("2").tag = new MyTag(30, 200, 20, 30);
		
		g.find("5").tag = new MyTag(200, 70, 20, 30);
		g.find("4").tag = new MyTag(230, 200, 20, 30);
		
		Figures.show(640, 480, x -> { x.translate(30, 30); g.draw(x); });
	}
	

}
