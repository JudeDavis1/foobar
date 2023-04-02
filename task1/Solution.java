import java.util.ArrayList;


public class Solution {
    public static void main(String args[]) {
        solution(15324);
    }

    public static int[] solution(int area) {
        ArrayList<Integer> areas = new ArrayList<Integer>();

        int sum = 0;
        int i = area;
        while (sum < area && i > 0) {
            if (i == 1) {
                areas.add(1);
                sum += i;
                continue;
            };
            if (isSquare(i) && sum + i <= area) {
                areas.add(i);
                sum += i;
            }
            i--;
        }
        
        System.out.println(areas);
        
        // Convert to integer array
        int[] result = areas.stream().mapToInt(j -> j).toArray();

        return result;
    }
    public static boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
