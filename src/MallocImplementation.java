

import java.util.Scanner;

public class MallocImplementation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id, size, instruction;
        Malloc m1 = new Malloc();
        System.out.println("Enter process id : ");
        id = sc.nextInt();
        System.out.println("Enter size of process in bytes : ");
        size = sc.nextInt();
        m1.MyMalloc(id, size);
        while (true) {
            System.out.println("To Allocate a process press->1  ");
            System.out.println("To Free a process press->2");
            System.out.println("To Display memory structure press->3");
            System.out.println("To Exit press->4");
            instruction = sc.nextInt();
            if (instruction == 4) {
                System.out.println("Exit");
                break;
            } else if (instruction == 1) {
                System.out.println("Enter process id : ");
                id = sc.nextInt();
                System.out.println("Enter size of process in bytes : ");
                size = sc.nextInt();
                m1.MyMalloc(id, size);
            } else if (instruction == 3) {
                m1.printmemory();
            } else if (instruction == 2) {
                System.out.println("Enter process id that want to free : ");
                id = sc.nextInt();
                m1.MyFree(id);
            }
            else{
                System.out.println("Wrong input.Try again.");
            }
        }
    }
}

class Malloc {

    public int storage[] = new int[25000];

    public void MyMalloc(int processId, int processSize) {
       
        int bestIndex = -1; //nothing is in the memory now
  
        int minSizeOfBestIndex = 25000; //minimum size for best allocation
       
        int testCount = 0;
        
        int testIndex = 0;
        
        for (int i = 0; i <= storage.length - 1; i++) {
            
            if (storage[i] == 0 && i < storage.length - 1) {
                testCount++;
            } else {
              
                if (testCount >= processSize && minSizeOfBestIndex > testCount) {
                    
                    minSizeOfBestIndex = testCount;
                    bestIndex = testIndex;

                } else {
                    
                    testCount = 0;
                    testIndex = i + 1;
                }
            }
        }
        
        if (bestIndex != -1) {
            for (int j = bestIndex; j <= bestIndex + processSize-1 ; j++) {
                storage[j] = processId;

            }
        } 
        else {
            System.out.println("Can't allocate.Process id:" + processId + " is Waiting.");
        }

    }

    public void MyFree(int processId) {
        for (int k = 0; k <= storage.length - 1; k++) {
            if (storage[k] == processId) {
                storage[k] = 0;
            }
        }
    }

    public void printmemory() {
        int blockNumber = 0;
        for (int i = 0; i <= storage.length - 1; i++) {

            if (i < storage.length - 1) {

                if (i == 0) {
                    blockNumber++;
                    System.out.println("Block Number : " + blockNumber);
                    System.out.println("Starting Address : " + i);
                    //System.out.println("||Memory Address||Process Id||");
                }

                else if ((storage[i-1] - storage[i]) != 0) {
                    blockNumber++;
                    int end = i - 1;
                    System.out.println("Endinging Address : " + end);
                    System.out.println("Block Number : " + blockNumber);
                    System.out.println("Starting Address : " + i);
                    //System.out.println("||Memory Address||Process Id||");
                       }
            }

            //System.out.println("||    " + i + "    ||    " + storage[i] + "    ||");
        }
    }
}
