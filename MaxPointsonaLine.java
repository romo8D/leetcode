/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
 
 /**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int result = 0;
        if(points == null)return result;

        Map<Double, Integer> slopeMap = new HashMap<Double,Integer>();
      
        int samePoint = 0;
        int tempResult = 0;
        for(int i=0;i<points.length;i++) {
            samePoint = 0;
            slopeMap.clear();
            tempResult = 1;  //Forgot

            for(int j=i+1;j<points.length;j++) {
                double slope = Double.POSITIVE_INFINITY;
                if(points[i].x != points[j].x) {
                    slope = (double)(points[i].y-points[j].y)/(points[i].x-points[j].x) + 0.0; //-0.0 and 0.0, +0.0, double cast
                } else if(points[j].y == points[i].y) {
                    samePoint++;
                    continue;
                }
                int temp = 0;
                if(slopeMap.containsKey(slope)) {
                    temp = slopeMap.get(slope)+1;
 
                } else {
                    temp = 2;
                   
                }
                slopeMap.put(slope, temp);
                tempResult = Math.max(tempResult, temp);
            }
            result = Math.max(result, tempResult+samePoint);
        }
        return result;
    }
}
