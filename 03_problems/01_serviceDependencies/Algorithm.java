package problems.serviceDependencies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Algorithm {

    public int[] findStartupOrder(int n, int[][] dependencies) {
        return findStartupOrder(n, dependencies, false);
    }

    public int[] findStartupOrder(int n, int[][] dependencies, boolean showSteps) {

        int[] remainingDependencies = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        // Build dependency graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dependency : dependencies) {
            int service = dependency[0];
            int prerequisite = dependency[1];

            remainingDependencies[service]++;
            graph.get(prerequisite).add(service);
        }

        if (showSteps) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("         SERVICE STARTUP ORDER");
            System.out.println("========================================");
            System.out.println("Services:     " + n);
            System.out.println("Dependencies: " + dependencies.length);

            System.out.println("\nDEPENDENCY GRAPH");
            System.out.println("----------------------------------------");

            for (int i = 0; i < n; i++) {
                System.out.println("Service " + i + " -> " + graph.get(i));
            }
        }

        // Find services without dependencies
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (remainingDependencies[i] == 0) {
                queue.add(i);
            }
        }

        if (showSteps) {
            System.out.println("\nINITIAL STATE");
            System.out.println("----------------------------------------");
            System.out.println("Remaining: " + Arrays.toString(remainingDependencies));
            System.out.println("Queue:     " + queue);
        }

        // Process services
        int[] result = new int[n];
        int index = 0;

        while (!queue.isEmpty()) {

            int service = queue.poll();
            result[index++] = service;

            if (showSteps) {
                System.out.println("\n[STEP " + index + "] Starting service " + service);
            }

            if (showSteps && graph.get(service).isEmpty()) {
                System.out.println("  No dependent services");
            }

            for (int dependent : graph.get(service)) {

                int previous = remainingDependencies[dependent];
                remainingDependencies[dependent]--;

                if (showSteps) {
                    System.out.print("  Service " + dependent + ": "
                            + previous + " -> " + remainingDependencies[dependent]);
                }

                if (remainingDependencies[dependent] == 0) {
                    queue.add(dependent);

                    if (showSteps) {
                        System.out.print("  [READY]");
                    }
                }

                if (showSteps) {
                    System.out.println();
                }
            }

            if (showSteps) {
                System.out.println("  Queue: " + queue);
                System.out.println("  Order: " + Arrays.toString(Arrays.copyOf(result, index)));
            }
        }

        // Validate startup order
        if (index == n) {

            if (showSteps) {
                System.out.println("\n========================================");
                System.out.println("[SUCCESS] All services processed!");
                System.out.println("Startup order: " + Arrays.toString(result));
                System.out.println("========================================");
            } else {
                System.out.println("Startup order: " + Arrays.toString(result));
            }

            return result;
        }

        // Circular dependency detected
        if (showSteps) {
            System.out.println("\n========================================");
            System.out.println("[ERROR] Circular dependency detected!");
            System.out.println("Processed: " + index + "/" + n + " services");
            System.out.println("Remaining: " + Arrays.toString(remainingDependencies));
            System.out.println("No valid startup order exists.");
            System.out.println("========================================");
        } else {
            System.out.println("No valid startup order exists.");
        }

        return new int[0];
    }
}
