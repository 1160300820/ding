package P3;
import java.util.ArrayList;
import java.util.LinkedList;
public class FriendShipGraph {
	static int num=0;         //图中顶点个数
    static ArrayList<node> fsp = new ArrayList<node>();
    public static boolean addVertex(Person name) {
    	for(node m:fsp)
    	{
    		if(m.p.equals(name.point))
    		{
    			System.out.println("the name is not unique");
    	    	return false;
    		}
    	}
    	node n = new node(name.point,null);
    	fsp.add(n);
        num++;
        return true;
    }//加入新的顶点
    public static boolean addEdge(Person name1,Person name2) {
    	int i;
    	int flag = 0;
    	for(i=0;i<num;i++)
    	{
    		if((name2.point).equals((fsp.get(i)).p))
    		{
    			flag = 1;
    			break;
    		}
    	}//判断name2是否在图中
    	if(flag==0)
    	{
    		System.out.println("name2 is not in the graph");
    		return false;
    	}
    	for(i=0;i<num;i++)
    	{
    		if((name1.point).equals((fsp.get(i)).p))
    		{
    			(fsp.get(i)).next = new node(name2.point,fsp.get(i).next);
    			return true;
    		}
    	}
    	System.out.println("name1 is not in the graph");
    	return false;
    }//加入新的边
    public static int getDistance(Person name1,Person name2) {
    	int length = 0,i;
    	String temp1;
    	node temp2=null;
    	ArrayList<String> flag = new ArrayList<String>();
    	LinkedList<String> queue = new LinkedList<String>();
    	queue.add(name1.point);
    	flag.add(name1.point);
    	if(name1==name2)
    		return 0;
    	while(queue.size()>0)
    	{
    		length++;
    		temp1 = queue.get(0);
    		queue.poll();
    		for(i=0;i<num;i++)
    		{
    			if(fsp.get(i).p.equals(temp1))
    			{
    				temp2 = fsp.get(i);
    				break;
    			}
    		}
    		while(temp2.next!=null)
    		{
    			if(flag.indexOf(temp2.next.p)==-1)
    			{
    				if(temp2.next.p.equals(name2.point))
    					return length;
    				queue.add(temp2.next.p);
    				flag.add(temp2.next.p);
    			}
    			temp2 = temp2.next;
    		}
    	}
    	return -1;
    }//返回两顶点之间的最短距离，两顶点互不连通则返回-1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    FriendShipGraph graph = new FriendShipGraph();
    Person rachel = new Person("Rachel");
    Person ross = new Person("Ross");
    Person ben = new Person("Ben");
    Person kramer = new Person("Kramer");
    graph.addVertex(rachel);
    graph.addVertex(ross);
    graph.addVertex(ben);
    graph.addVertex(kramer);
    graph.addEdge(rachel, ross);
    graph.addEdge(ross, rachel);
    graph.addEdge(ross, ben);
    graph.addEdge(ben,ross);
    System.out.println(graph.getDistance(rachel, ross));
    System.out.println(graph.getDistance(rachel, ben));
    System.out.println(graph.getDistance(rachel, rachel));
    System.out.println(graph.getDistance(rachel, kramer));
	}
static class node{
	String p;
	node next;
	public node(String p,node next) {
		this.p = p;
		this.next = next;
	}
}
}