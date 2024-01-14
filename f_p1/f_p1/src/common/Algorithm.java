package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {
    public void bitStringKhongDeQuy(int size_array){
        int totalStrings = (int) Math.pow(2, size_array);
        for (int i = 0; i < totalStrings; i++) {
            String bitString = Integer.toBinaryString(i);
            while (bitString.length() < size_array) {
                bitString = "0" + bitString;
            }
            System.out.println(bitString);
        }
    }

    public void bitStringDeQuy(int n) {
        bitStringDeQuyControl("", n);
    }

    private void bitStringDeQuyControl(String currentString, int remainingBits) {

        if (remainingBits == 0) {
            System.out.println(currentString);
            return;
        }
        bitStringDeQuyControl(currentString + "1", remainingBits - 1);
        bitStringDeQuyControl(currentString + "0", remainingBits - 1);
    }
    public List<List<Integer>> permutationDeQuy(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[array.length];
        permutationDeQuyControl(array, used, currentPermutation, result);
        return result;
    }
    private void permutationDeQuyControl(int[] array, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == array.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(array[i]);
                permutationDeQuyControl(array, used, currentPermutation, result);
                used[i] = false;
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
    public void combinatorKoDeQuy(int k, int n){
        int a[] = new int[k + 1];
        for (int i = 1; i <= k; i++)
            a[i] = i;
        while (true) {
            int ok = 0;
            for (int i = 1; i <= k; i++)
                System.out.print(a[i]+ " ");
            System.out.println();
            for (int i = k; i >= 1; i--) {
                if (a[i] != n - k + i) {
                    ok = 1;
                    a[i]++;
                    for (int j = i + 1; j <= k; j++)
                        a[j] = a[j - 1] + 1;
                    break;
                }
            }
            if (ok == 0)
                break;
        }
    }
    public void combinatorDeQuy(int k, int n) {
        combinatorDeQuyControl(new int[k], 0, 1, n);
    }

    private  void combinatorDeQuyControl(int[] combination, int index, int start, int n) {
        if (index == combination.length) {
            for (int value : combination) {
                System.out.print(value+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            combination[index] = i;
            combinatorDeQuyControl(combination, index + 1, i + 1, n);
        }
    }
    public List<List<Integer>> permutationKhongDeQuy(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        int n = array.length;
        int[] indices = new int[n];
        Arrays.fill(indices, 0);
        result.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
        int i = 0;
        while (i < n) {
            if (indices[i] < i) {
                swap(array, i % 2 == 0 ? 0 : indices[i], i);
                result.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
                indices[i]++;
                i = 0;
            } else {
                indices[i] = 0;
                i++;
            }
        }
        return result;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}