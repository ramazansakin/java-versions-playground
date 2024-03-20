package org.example.playground;

public class GasStationProblem {

    public static int canTravel(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If we run out of gas at this station, reset the start station and current gas
            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }

        // If the total gas is less than the total cost, it's not possible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        } else {
            return startStation;
        }
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = canTravel(gas, cost);
        if (result != -1) {
            System.out.println("Starting gas station: " + result);
        } else {
            System.out.println("It's not possible to complete the circuit.");
        }
    }

}
