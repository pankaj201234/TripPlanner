package com.tripplanner.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TSP
{
    private Stack<Integer> stack;
    public TSP() {
        stack = new Stack<Integer>();
    }

    public List<Integer> tsp(Integer[][] cityGraph) {
        Integer numberOfNodes = cityGraph[1].length - 1;
        List<Integer> route = new ArrayList<>();
        Integer[] visited = new Integer[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        Integer element, dst = 0, i;
        Integer min;

        boolean minFlag = false;
        route.add(1);
        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes) {
                if (cityGraph[element][i] > 1 && visited[i] == 0) {
                    if (min > cityGraph[element][i]) {
                        min = cityGraph[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                visited[dst] = 1;
                stack.push(dst);
                route.add(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return route;
    }
    public static List<Integer> TSPUtil(Integer[][] cityGraph, Integer number_of_nodes) {
        for (int i = 1; i <= number_of_nodes; i++) {
            for (int j = 1; j <= number_of_nodes; j++) {
                if (cityGraph[i][j] == 1 && cityGraph[j][i] == 0) {
                    cityGraph[j][i] = 1;
                }
            }
        }
        TSP tspNearestNeighbour = new TSP();
        return tspNearestNeighbour.tsp(cityGraph);
        }
    }
