public class ArrayStructures {

    private int[] theArray = new int[50];

    private int arraySize = 10;

    public void generateRandomArray(){

        for(int i = 0; i < arraySize; i++){

            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    public void printArray(){

        System.out.println("-----------");
        for(int i = 0; i < arraySize; i++){

            System.out.print(" | " + i + " | ");
            System.out.println(theArray[i] + " | " );

            System.out.println("-----------");
        }
    }

    public int getValueAtIndex(int index){
        if(index < arraySize) return theArray[index];

        return 0;
    }

    public boolean doesArrayContainThisValue(int searchValue){

        boolean valueInArray = false;

        for(int i = 0; i < arraySize; i++){

            if(theArray[i] == searchValue){

                valueInArray = true;
            }
        }

        return valueInArray;
    }

    public void deleteIndex(int index){

        if(index < arraySize){

            for(int i = index; i < (arraySize - 1); i++){

                theArray[i] = theArray[i+1];

            }

            arraySize--;
        }
    }

    public void insertValue(int value){

        if(arraySize < 50){

            theArray[arraySize] = value;

            arraySize++;
        }
    }

    public String linearSearchForValue(int value) {

        boolean valueInArray = false;

        String indexWithValue = "";

        System.out.println("The Value was found in the following: ");

        for(int i = 0; i < arraySize; i++){

            if(theArray[i] == value){
                valueInArray = true;

                System.out.println(i + " ");

                indexWithValue+= i + " ";
            }
        }

        if(!valueInArray) {

            indexWithValue = "None";

            System.out.println(indexWithValue);

        }

        System.out.println();

        return indexWithValue;

    }

    public void printHorzArray(int i, int j){

        for(int n = 0; n < 51; n++)System.out.println("-");

        System.out.println();

        for(int n = 0; n < arraySize; n++){

            System.out.println("| " + n + "  ");

        }

        System.out.println("|");

        for(int n = 0; n< 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < arraySize; n++){

            System.out.print("| " + theArray[n] + " ");
        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        // END OF FIRST PART

        // ADDED FOR BUBBLE SORT

        if(j != -1){

            // ADD THE +2 TO FIX SPACING

            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");

            System.out.print(j);

        }

        // THEN ADD THIS CODE

        if(i != -1){

            // ADD THE -1 TO FIX SPACING

            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");

            System.out.print(i);

        }

        System.out.println();
    }

    public void binarySearchForValue(int value){

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex){

            int middleIndex = (highIndex + lowIndex) / 2;

            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;

            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;

            else {

                System.out.println("\nFound a match for " + value + " at Index " + middleIndex);

                lowIndex = highIndex + 1;
            }

            printHorzArray(middleIndex, -1);

        }
    }

    public void insertionSort(){

        for(int i = 1; i < arraySize; i++){

            int j = i;

            int toInsert = theArray[i];

            while((j > 0) && (theArray[j-1] > toInsert)) {

                theArray[j] = theArray[j - 1];
                j--;

                printHorzArray(i, j);

                }
                theArray[j] = toInsert;

                printHorzArray(i, j);

                System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");

        }
    }

    public static void main(String[] args){
        ArrayStructures newArray = new ArrayStructures();

        newArray.generateRandomArray();

        //newArray.printArray();

        //System.out.println(newArray.getValueAtIndex(3));

        //System.out.println(newArray.doesArrayContainThisValue(18));

        //newArray.deleteIndex(4);

        //newArray.printArray();

        //newArray.insertValue(55);

        // newArray.printArray();

        // newArray.binarySearchForValue(11);

        newArray.insertionSort();

    }
}
