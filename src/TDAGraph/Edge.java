package TDAGraph;

public class Edge 
{
	/*
	 * Attributes
	 */
	protected int node1;
	protected int node2;
	
	/*
	 * Crea un arco.
	 */
	public Edge(int node1, int node2)
	{
		this.node1 = node1;
		this.node2 = node2;
	}
	
	/*
	 * 
	 */
	public int getNode1()
	{
		return this.node1;
	}
	
	/*
	 * 
	 */
	public int getNode2()
	{
		return this.node2;
	}
	
	/*
	 * 
	 */
	public void setNodes(int node1, int node2)
	{
		this.node1 = node1;
		this.node2 = node2;
	}
}
