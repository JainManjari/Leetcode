import java.util.HashMap;
import java.util.Map;
public class May13th861 {
    public int matrixScore(int[][] a) {

        int m = a.length;
        int n = a[0].length;

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> mapBinary = new HashMap<>();

        int power = n-1;

        for (int i = 0; i < m; i++) {
            if (a[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) {
                        a[i][j] = 1;
                    } else {
                        a[i][j] = 0;
                    }
                }
            }
            map.put(i, 1);
            mapBinary.put(i, Math.pow(2, power));
        }

        power = power-1;

        //System.out.println(mapBinary+" "+power);

        for (int j = 1; j < n; j++) {

            int countZeros = 0;
            int countOnes = 0;

            int countZeroOnes = 0;
            int countOneOnes = 0;

            for (int i = 0; i < m; i++) {
                if (a[i][j] == 0) {
                    countZeros++;
                    countZeroOnes+=map.get(i);
                } else {
                    countOnes++;
                    countOneOnes+=map.get(i);
                    map.put(i, map.get(i)+1);
                    mapBinary.put(i, mapBinary.get(i)+Math.pow(2, power));
                }
            }

            boolean flip = false;
            if(countZeros>countOnes) {
                flip = true;
            } else if(countZeros==countOnes && countZeroOnes>countOneOnes) {
                flip = true;
            }

            if (flip) {
                for (int i = 0; i < m; i++) {
                    if (a[i][j] == 0) {
                        a[i][j] = 1;
                        map.put(i, map.get(i)+1);
                        mapBinary.put(i, mapBinary.get(i)+Math.pow(2, power));
                    } else {
                        a[i][j] = 0;
                        map.put(i, map.get(i)-1);
                        mapBinary.put(i, mapBinary.get(i)-Math.pow(2, power));
                    }
                }
            }

            power = power - 1;
        }

        for(Integer key:mapBinary.keySet()) {
            sum+=mapBinary.get(key);
        }

        return sum;

    }

}
