import java.util.*;

public class directedVertex{
	String name;
	LinkedList<directedVertex> neighbors= new LinkedList<directedVertex>();

	public directedVertex(String name){
		this.name=name;
	}

}
