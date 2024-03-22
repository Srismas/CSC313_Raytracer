import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static Vector<Float> vertices = new Vector<>();
    public static Vector<Integer> indices = new Vector<>();
    public static Vector<Float> normals = new Vector<>();

    public static void main(String[] args) throws IOException{
        String objFile = "obj/teapot.obj";
        loadObj(objFile);
        System.out.println("\nFinished loading obj file");
    }

    // this is just to try and see if this actually works haha
    // from ChatGPT currently
    private static void loadObj(String filename) throws IOException {
        System.out.println("Start loading obj file");
//        ArrayList<Float> vertices = new ArrayList<>();
//        ArrayList<Integer> indices = new ArrayList<>();
//        ArrayList<Float> normals = new ArrayList<>();
//        ArrayList<Float> textCoords = new ArrayList<>();
        try {
           BufferedReader reader = new BufferedReader(new FileReader(filename));
           String line;

           while ((line = reader.readLine()) != null) {
               String[] components = line.split("\\s+");
               if (line.startsWith("v ")) {
                   vertices.add(Float.parseFloat(components[1]));
                   vertices.add(Float.parseFloat(components[2]));
                   vertices.add(Float.parseFloat(components[3]));
               } else if (line.startsWith("f " )) {
                   for (int i = 1; i < 4; i++) { // assuming triangular faces
                       String[] vertex = components[i].split("/");
                       indices.add((Integer.parseInt(vertex[0]) - 1)); // vertex indices start from 1 in ojb, so subtract 1
                   }
               }
           }
           reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("Vertices size: " + vertices.size());
//        System.out.println("Indices size: " + indices.size());
        printFloat("vertices", vertices);
//        printFloatArrayList("normals", normals);
//        printFloatArrayList("texture", textCoords);
        printInt("indices", indices);
    }

    // takes in float array list
    private static void printFloat(String type, Vector<Float> A) {
        System.out.println("\n" + type + ":");
        for (int i = 0; i < A.size(); i++) {
            if (i == A.size() - 1) {
                System.out.println(A.get(i));
            } else {
                System.out.print(A.get(i) + ", ");
            }
        }
    }

    // takes in integer array list
    private static void printInt(String type, Vector<Integer> A) {
        System.out.println("\n" + type + ":");
        for (int i = 0; i < A.size(); i++) {
            if (i == A.size() - 1) {
                System.out.println(A.get(i));
            } else {
                System.out.print(A.get(i) + ", ");
            }
        }
    }

}
