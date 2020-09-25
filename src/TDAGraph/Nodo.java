package TDAGraph;

public class Nodo 
{
	/*
	 * Attributes
	 */
	protected int node;
	
	/*
	 * Crea un arco.
	 */
	public Nodo(int node)
	{
		this.node = node;
	}
	
	/*
	 * 
	 */
	public int getNode()
	{
		return this.node;
	}
	
	/*
	 * 
	 */
	public void setNodes(int node)
	{
		this.node = node;
	}
}
