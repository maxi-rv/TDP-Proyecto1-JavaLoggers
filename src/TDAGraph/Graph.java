package TDAGraph;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph 
{
	/*
	 * Attributes
	 */
	protected Map<Integer, Nodo> nodes;
	protected Map<String, Edge> edges;
	private static Logger logger;
	
	/*
	 * Crea un un grafo.
	 */
	public Graph()
	{
		this.nodes = new HashMap<Integer, Nodo>();
		this.edges = new HashMap<String, Edge>();
		//Edge es una clase que encapsula dos enteros para representar un arco.
		
		if (logger == null)
		{
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.WARNING);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.INFO);
			
			//Setea el nivel del logger padre como "OFF", evitando que tambien muestre mensajes.
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers())
			{
				h.setLevel(Level.OFF);
			}
		}	
	}
	
	/*
	 * Agrega el nodo “node” al grafo, si aún no pertenecía a la estructura.
	 */
	public void addNode(int node)
	{
		boolean estaN = this.nodes.containsKey(node);
		//De acuerdo al valor de estaN se sabe si node es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN es falso o verdadero.
		if(!estaN)
		{
			Nodo nodo = new Nodo(node);
			Nodo value = this.nodes.put(node, nodo);
			
			if(value==null)
			{
				//Significa que el nodo no estaba.
				logger.info("El nodo "+node+" fue agregado a la estructura.");
			}
		}
		else
		{
			//Significa que el nodo ya estaba.
			logger.warning("El nodo "+node+" ya existe en la estructura.");
		}
	}
	
	/*
	 * Agrega un arco entre el nodo “node1” y el nodo “node2”, si aún no existía el 
	 * arco y ambos parámetros son nodos pertenecientes a la estructura.
	 */
	public void addEdge(int node1, int node2)
	{
		boolean estaN1 = this.nodes.containsKey(node1);
		//De acuerdo al valor de estaN1 se sabe si node1 es un nodo que esta en la ED o no.
		boolean estaN2 = this.nodes.containsKey(node2);
		//De acuerdo al valor de estaN2 se sabe si node2 es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN1 es falso o verdadero y lo mismo para estaN2.
		if(estaN1 && estaN2)
		{
			Edge edge = new Edge(node1, node2);
			String key = node1 + "," + node2;
			Edge value = this.edges.put(key, edge);
			
			if(value!=null)
			{
				//Significa que el arco ya estaba
				logger.warning("El arco "+node1+">"+node2+" ya existe en la estructura.");
			}
			else
			{
				//Significa que el arco no estaba
				logger.info("El arco "+node1+">"+node2+" fue agregado a la estructura.");
			}
		}
		else
		{
			logger.warning("Uno o ambos nodos, "+node1+" y "+node2+", no pertenecian a la estructura");
		}
	}
	
	/*
	 * Remueve el nodo “node” del grafo, si el parámetro es un nodo de la estructura.
	 * Se asume que el cliente se encarga de borrar los arcos que corresponda.
	 */
	public void removeNode(int node)
	{
		boolean estaN = this.nodes.containsKey(node);
		//De acuerdo al valor de estaN se sabe si node es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN es falso o verdadero.
		if(estaN)
		{
			Nodo value = this.nodes.remove(node);
			
			if(value!=null)
			{
				//Significa que el nodo ya estaba.
				logger.info("El nodo "+node+" fue eliminado de la estructura.");
			}
		}
		else
		{
			//Significa que el nodo no estaba.
			logger.warning("El nodo "+node+" no existe en la estructura.");
		}
	}
	
	/*
	 * Remueve el arco entre el nodo “node1” y el nodo “node2”, si el arco formado por 
	 * los parámetros pertenecen a la estructura.
	 */
	public void removeEdge(int node1, int node2)
	{
		boolean estaN1 = this.nodes.containsKey(node1);
		//De acuerdo al valor de estaN1 se sabe si node1 es un nodo que esta en la ED o no.
		boolean estaN2 = this.nodes.containsKey(node2);
		//De acuerdo al valor de estaN2 se sabe si node2 es un nodo que esta en la ED o no.
		
		//Considerar los casos en que estaN1 es falso o verdadero y lo mismo para estaN2.
		if(estaN1 && estaN2)
		{
			String key = node1 + "," + node2;
			Edge value = this.edges.remove(key);
			
			if(value!=null)
			{
				//Significa que el arco ya estaba
				logger.info("El arco "+node1+">"+node2+" fue removido de la estructura.");
			}
			else
			{
				//Significa que el arco no estaba
				logger.warning("El arco "+node1+">"+node2+" no existia en la estructura.");
			}
		}
		else
		{
			logger.warning("Uno o ambos nodos, "+node1+" y "+node2+", no pertenecian a la estructura");
		}
	}
}
