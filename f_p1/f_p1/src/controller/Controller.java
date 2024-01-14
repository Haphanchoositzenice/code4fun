package controller;

import common.Algorithm;
import model.Model;
import view.Menu;


import java.util.Scanner;

public class Controller extends Menu {
    static String[] mc =
            {
                    "Bit String with Recursion",
                    "Bit String without Recursion",
                    "Combinators with Recursion",
                    "Combinators without Recursion",
                    "Permutations with Recursion",
                    "Permutations without Recursion",
                    "Exit"
            };

    protected Algorithm algorithm;
    public Controller(Model model){
        super("CSD201", mc);
        algorithm = new Algorithm();
    }
    @Override
    public void execute(int n) {
        switch (n){
            case 1:{
                System.out.println("Enter length");
                int l = new Scanner(System.in).nextInt();
                algorithm.bitStringDeQuy(l);
                break;
            }
            case 2:{
                System.out.println("Enter length");
                int l = new Scanner(System.in).nextInt();
                algorithm.bitStringKhongDeQuy(l);
                break;
            }
            case 3:{
                System.out.println("Enter k: ");
                int k = new Scanner(System.in).nextInt();
                System.out.println("Enter n: ");
                int b = new Scanner(System.in).nextInt();
                algorithm.combinatorDeQuy(k, b);
                break;

            }
            case 4:
            {
                System.out.println("Enter k: ");
                int k = new Scanner(System.in).nextInt();
                System.out.println("Enter n: ");
                int b = new Scanner(System.in).nextInt();
                algorithm.combinatorKoDeQuy(k, b);
                break;
            }
            case 5:{
                System.out.println("Enter the number òf array: ");
                int size = new Scanner(System.in).nextInt();
                int[] arr = new int[size];
                for (int i = 0; i<size; i++){
                    System.out.print("array ["+i+"]: ");
                    arr[i] = new Scanner(System.in).nextInt();
                }
                System.out.println(algorithm.permutationDeQuy(arr));
                break;
            }
            case 6:{
                System.out.println("Enter the number òf array: ");
                int size = new Scanner(System.in).nextInt();
                int[] arr = new int[size];
                for (int i = 0; i<size; i++){
                    System.out.print("array ["+i+"]: ");
                    arr[i] = new Scanner(System.in).nextInt();
                }
                System.out.println(algorithm.permutationKhongDeQuy(arr));
                break;
            }
            case 7:{
                System.exit(0);
                break;
            }
            default:
                System.out.println("Please enter again!!");
                break;
        }
    }
}
