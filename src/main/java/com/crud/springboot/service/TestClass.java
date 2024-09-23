package com.crud.springboot.service;

import java.util.*;

class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading inputs
        int N = scanner.nextInt(); // number of applicants
        int M = scanner.nextInt(); // number of houses
        int K = scanner.nextInt(); // max allowed difference

        int[] applicants = new int[N];
        int[] houses = new int[M];

        // Reading desired house sizes of applicants
        for (int i = 0; i < N; i++) {
            applicants[i] = scanner.nextInt();
        }

        // Reading available house sizes
        for (int i = 0; i < M; i++) {
            houses[i] = scanner.nextInt();
        }

        // Sort arrays to simplify the matching process
        Arrays.sort(applicants);
        Arrays.sort(houses);

        // Using two pointers technique to match applicants with houses
        int housesAllocated = 0;
        int j = 0; // index for houses array

        for (int i = 0; i < N; i++) {
            int desiredSize = applicants[i];
            // Find the smallest house size that fits the current applicant
            while (j < M && houses[j] < desiredSize - K) {
                j++;
            }

            // Check if there is any house that can accommodate the applicant
            if (j < M && houses[j] <= desiredSize + K) {
                housesAllocated++;
                j++; // move to the next house
            }
        }

        System.out.println(housesAllocated);
        scanner.close();
    }
}
