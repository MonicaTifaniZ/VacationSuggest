package test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
class Edge {

    public final Node target;
    public final double weight;

    public Edge(Node targetNode, double weightVal) {
        target = targetNode;
        weight = weightVal;
    }
}

class Node implements Comparable<Node> {

    public final String value;
    public final String Description;
    public Edge[] adjacencies;
    public double shortestDistance = Double.POSITIVE_INFINITY;
    public Node parent;

    public Node(String val,String Desc) {
        value = val;
        Description = Desc;
    }

    public String toString() {
        return value;
    }

    public int compareTo(Node other) {
        return Double.compare(shortestDistance, other.shortestDistance);
    }

}

public class Vacation {

    public static void computePaths(Node source) {
        source.shortestDistance = 0;

        //implement a priority queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Node u = queue.poll();

            /*visit the adjacencies, starting from 
			the nearest node(smallest shortestDistance)*/
            for (Edge e : u.adjacencies) {

                Node v = e.target;
                double weight = e.weight;

                //relax(u,v,weight)
                double distanceFromU = u.shortestDistance + weight;
                if (distanceFromU < v.shortestDistance) {

                    /*remove v from queue for updating 
					the shortestDistance value*/
                    queue.remove(v);
                    v.shortestDistance = distanceFromU;
                    v.parent = u;
                    queue.add(v);

                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {

        //trace path from target to source
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.parent) {
            path.add(node);
        }

        //reverse the order such that it will be from source to target
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {

        //initialize the graph base on the Romania map
        Node n1 = new Node("Bakso Presiden","Tempat makan bakso legendaris di malang");
        Node n2 = new Node("Lupa Lelah","Cafe low budget ramah anak muda");
        Node n3 = new Node("Brewok Amprong","Cafenya anak hitz ibu kota");
        Node n4 = new Node("Bakso Joged","Bakso murah meriah dan enak di Kabupaten Malang");
        Node n5 = new Node("Ayam Bebek Lalapan 17","Lalapan Ayam & bebek paling murah dan nikmat di karangploso");
        Node n6 = new Node("Sate 300","Sate ayam,kelinci dan kambing yang empuk di batu");
        Node n7 = new Node("Terangbulan Fantasi","Martabak manis enak buka pagi-siang-malam");
        Node n8 = new Node("Mie Setan Bromo","Mie setan paling setaaaan!!! di malang");
        Node n9 = new Node("Geprek Bensu","Warungnya artis nih :D");
        Node n10 = new Node("Ayam Nelongso","Ayam murah terjangkau buat mahasiswa");
        Node n11 = new Node("Golden Heritage","Coffee Shop murah &terjangkau untuk kamu milenial");
        Node n12 = new Node("Mbak Ida","Warung legendaris anak stiki!");
        Node n13 = new Node("Lingling Fruitbar","Es paling enak & murah ya di sini");
        Node n14 = new Node("Burger Buto Sarangan","Buat kamu yang perut karet wajib coba!1");
        Node n15 = new Node("Street Burgos","Burger gosong dan Siomay Gurita yang");

        //initialize the edges
        n1.adjacencies = new Edge[]{
            new Edge(n2, 10),
            new Edge(n4, 20)
        };

        n2.adjacencies = new Edge[]{
            new Edge(n1, 10),
            new Edge(n3, 9)
        };

        n3.adjacencies = new Edge[]{
            new Edge(n2, 9),
            new Edge(n6, 18)
        };

        n4.adjacencies = new Edge[]{
            new Edge(n1, 20),
            new Edge(n5, 4),
            new Edge(n9, 30),};

        n5.adjacencies = new Edge[]{
            new Edge(n4, 4),
            new Edge(n6, 3)
        };

        n6.adjacencies = new Edge[]{
            new Edge(n7, 13),
            new Edge(n5, 3),
            new Edge(n3, 18)
        };

        n7.adjacencies = new Edge[]{
            new Edge(n8, 8),
            new Edge(n13, 7),
            new Edge(n6, 13)
        };

        n8.adjacencies = new Edge[]{
            new Edge(n7, 8),
            new Edge(n9, 15)
        };

        n9.adjacencies = new Edge[]{
            new Edge(n8, 15),
            new Edge(n4, 30)
        };

        n10.adjacencies = new Edge[]{
            new Edge(n11, 4)
        };

        n11.adjacencies = new Edge[]{
            new Edge(n10, 4),
            new Edge(n12, 9)
        };

        n12.adjacencies = new Edge[]{
            new Edge(n11, 9),
            new Edge(n13, 3)
        };

        n13.adjacencies = new Edge[]{
            new Edge(n7, 7),
            new Edge(n14, 4),
            new Edge(n12, 3)
        };

        n14.adjacencies = new Edge[]{
            new Edge(n13, 4),
            new Edge(n15, 4)
        };

        n15.adjacencies = new Edge[]{
            new Edge(n14, 4)
        };

        Node[] nodes = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15};

        //compute paths
        //computePaths(n1);
        //print shortest paths
        /*
		for(Node n: nodes){
			System.out.println("Distance to " + 
				n + ": " + n.shortestDistance);
    		List<Node> path = getShortestPathTo(n);
    		System.out.println("Path: " + path);
		};
         */
//        List<Node> path = getShortestPathTo(n13);
//        System.out.println("Path: " + path);
        System.out.println("List tempat makan yang enak di malang:\n");
        for(int y = 0;y<nodes.length;y++){
            System.out.println((y+1)+"."+nodes[y].value);
        }
        System.out.println("==============================\n\n");
        Scanner sc = new Scanner(System.in);
        String awal, tujuan;
        Node aw_al = null;
        Node tu_juan = null;
        System.out.print("Your Location\t: ");
        awal = sc.nextLine();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].value.equalsIgnoreCase(awal)) {
                aw_al = nodes[i];
                break;
            }
        }
//        computePaths(new Node(awal));
        System.out.print("Your Destination\t : ");
        tujuan = sc.nextLine();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].value.equalsIgnoreCase(tujuan)) {
                tu_juan = nodes[i];
                break;
            }
        }
        computePaths(aw_al);
        //System.out.println("Distance to " + tu_juan + ": " + tu_juan.shortestDistance);
        List<Node> path = getShortestPathTo(tu_juan);
        //System.out.println("Path: " + path);
        System.out.println(path.size());
        if(path.size()<2){
            //computePaths(aw_al);   
            System.out.println("Maaf, anda nampaknya tidak ke mana-mana T_T");
        } else if(path.size()==2){
            System.out.println("Anda ada di : "+path.get(0));
            System.out.println("dan akan menuju ke : " +path.get(1).value);
            System.out.println("Deskripsi lokasi tujuan anda : \""+path.get(1).Description+"\"");
            System.out.println("Jarak ke " + tu_juan + " : " + tu_juan.shortestDistance+"km");
        } else if(path.size()>2){
            //computePaths(aw_al);
            System.out.println("Anda ada di : "+path.get(0).value);
            System.out.println("dan akan menuju ke : "+path.get((path.size()-1)).value);
            System.out.println("Deskripsi lokasi tujuan anda : \""+path.get((path.size()-1)).Description+"\"");
            System.out.println("Jarak ke " + tu_juan + " : " + tu_juan.shortestDistance+"km\n");
            System.out.println("===================");
            System.out.println("anda akan melewati beberapa tempat seperti : \n");
            for(int u=0;u<path.size();u++){
                System.out.println(path.get(u).value+" "+"\""+path.get(u-1).Description+"\"");
            }

        }

        //System.out.println(path.get(1).value+path.get(1).Description);
        //System.out.println(nodes[0].adjacencies[0].target.Description);
    }

}

