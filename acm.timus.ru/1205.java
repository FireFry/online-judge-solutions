import java.io.*;
import java.util.Arrays;

public class Solution {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void solve() throws IOException {
        String[] input;

        input = in.readLine().split(" ");
        double walkSpeed = Double.parseDouble(input[0]);
        double undergroundSpeed = Double.parseDouble(input[1]);
        
        int stationsCount = Integer.parseInt(in.readLine());
        int nodesCount = stationsCount + 2; // Plus two points: A and B
        
        double[] nodeX = new double[nodesCount];
        double[] nodeY = new double[nodesCount];
        for (int i = 0; i < stationsCount; i++) {
            input = in.readLine().split(" ");
            nodeX[i] = Double.parseDouble(input[0]);
            nodeY[i] = Double.parseDouble(input[1]);
        }
                        
        int[][] undergroundEdges = new int[stationsCount * stationsCount][2];
        int undergroundEdgesCount = 0;
        input = in.readLine().split(" ");
        int edgeStation0 = Integer.parseInt(input[0]) - 1;
        int edgeStation1 = Integer.parseInt(input[1]) - 1;
        while (edgeStation0 >= 0 && edgeStation1 >= 0) {
            undergroundEdges[undergroundEdgesCount][0] = edgeStation0;
            undergroundEdges[undergroundEdgesCount][1] = edgeStation1;
            undergroundEdgesCount++;

            input = in.readLine().split(" ");
            edgeStation0 = Integer.parseInt(input[0]) - 1;
            edgeStation1 = Integer.parseInt(input[1]) - 1;
        }

        for (int i = stationsCount; i < nodesCount; i++) {
            input = in.readLine().split(" ");
            nodeX[i] = Double.parseDouble(input[0]);
            nodeY[i] = Double.parseDouble(input[1]);
        }

        double[][] timeAdjacencyMatrix = new double[nodesCount][nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            for (int j = i + 1; j < nodesCount; j++) {
                double dx = nodeX[i] - nodeX[j];
                double dy = nodeY[i] - nodeY[j];
                double distance = Math.sqrt(dx * dx + dy * dy);
                double time = distance / walkSpeed;
                timeAdjacencyMatrix[i][j] = timeAdjacencyMatrix[j][i] = time;
            }
        }

        for (int k = 0; k < undergroundEdgesCount; k++) {
            int i = undergroundEdges[k][0];
            int j = undergroundEdges[k][1];
            double dx = nodeX[i] - nodeX[j];
            double dy = nodeY[i] - nodeY[j];
            double distance = Math.sqrt(dx * dx + dy * dy);
            double time = distance / undergroundSpeed;
            timeAdjacencyMatrix[i][j] = timeAdjacencyMatrix[j][i] = time;
        }

        double nodeTime[] = new double[nodesCount];
        int previousStation[] = new int[nodesCount];
        Arrays.fill(nodeTime, Double.MAX_VALUE);
        nodeTime[nodesCount - 2] = 0d; // Node A

        boolean nodeMark[] = new boolean[nodesCount];

        for (int k = 0; k < nodesCount; k++) {
            double minTime = Double.MAX_VALUE;
            int minNode = -1;

            for (int i = 0; i < nodesCount; i++) {
                if (!nodeMark[i] && nodeTime[i] < minTime) {
                    minTime = nodeTime[i];
                    minNode = i;
                }
            }

            nodeMark[minNode] = true;
            for (int i = 0; i < nodesCount; i++) {
                double newTime;
                if (!nodeMark[i] && (newTime = minTime + timeAdjacencyMatrix[minNode][i]) < nodeTime[i]) {
                    nodeTime[i] = newTime;
                    previousStation[i] = minNode;
                }
            }
        }

        out.format("%.7f", nodeTime[nodesCount - 1]);
        out.println();

        int[] history = new int[nodesCount];
        int historySize = 0;
        for (int node = previousStation[nodesCount - 1]; node != nodesCount - 2; node = previousStation[node]) {
            history[historySize++] = node;
        }

        out.print(historySize);
        out.print(' ');
        for (int i = historySize - 1; i >= 0; i--) {
            out.print(history[i] + 1);
            if (i == 0) {
                out.println();
            } else {
                out.print(' ');
            }
        }

        out.flush();
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}