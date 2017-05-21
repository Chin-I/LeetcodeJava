/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_593_ValidSquare {
    //Gene-Competition 25%
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // HashSet<Double> hs = new HashSet<Double>();
        // List<Double> hs = new ArrayList<>();
        double[] hs = new double[6];
        hs[0]=(Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1], 2));
        hs[1]=(Math.pow(p1[0]-p3[0], 2)+Math.pow(p1[1]-p3[1], 2));
        hs[2]=(Math.pow(p1[0]-p4[0], 2)+Math.pow(p1[1]-p4[1], 2));
        hs[3]=(Math.pow(p2[0]-p3[0], 2)+Math.pow(p2[1]-p3[1], 2));
        hs[4]=(Math.pow(p2[0]-p4[0], 2)+Math.pow(p2[1]-p4[1], 2));
        hs[5]=(Math.pow(p3[0]-p4[0], 2)+Math.pow(p3[1]-p4[1], 2));

        Arrays.sort(hs);

        for(double i:hs){
            System.out.println(i);
        }
        // Syste.
        // if (hs.size()==2)
        // return true;
        // Collections.sort(hs);

        if (hs[0]==hs[1] && hs[1]==hs[2] &&hs[2]==hs[3] && hs[3]!=hs[4] && hs[4]==hs[5]){
            // if ()
            return true;
        }

        return false;
    }
}
