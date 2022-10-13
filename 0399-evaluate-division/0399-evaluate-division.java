class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = makeGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private Map<String, Map<String, Double>> makeGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;
        
        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);

            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
        }

        return graph;
    }

    private double dfs(String first, String second, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(first)) {
            return -1.0;
        }

        if (graph.get(first).containsKey(second)) {
            return graph.get(first).get(second);
        }

        visited.add(first);

        for (Map.Entry<String, Double> subG : graph.get(first).entrySet()) {
            if (!visited.contains(subG.getKey())) {
                double num = dfs(subG.getKey(), second, visited, graph);
                if (num != -1.0) {
                    return subG.getValue() * num;
                }
            }
        }

        return -1;
    }
}