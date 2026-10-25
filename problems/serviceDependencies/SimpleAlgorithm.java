package problems.serviceDependencies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SimpleAlgorithm {

    public int[] findStartupOrder(int n, int[][] dependencies) {

        int[] remainingDependencies = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dependency : dependencies) {
            int service = dependency[0];
            int prerequisite = dependency[1];

            remainingDependencies[service]++;
            graph.get(prerequisite).add(service);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (remainingDependencies[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[n];
        int index = 0;

        while (!queue.isEmpty()) {
            int service = queue.poll();

            result[index++] = service;

            for (int dependent : graph.get(service)) {
                remainingDependencies[dependent]--;

                if (remainingDependencies[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }

        return index == n ? result : new int[0];
    }
}
