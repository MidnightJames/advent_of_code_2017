package _2017.day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day_1
{
    static final int INVALID_FILENAME = -1;
    static final int FILE_NOT_FOUND = -2;

    public static String getFilename()
    {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboardScanner.nextLine();

        if (filename.isEmpty() || filename.isBlank())
        {
            System.out.println("Invalid filename entered.");
            System.exit(INVALID_FILENAME);;
        }

        keyboardScanner.close();
        return filename;
    }

    public static void main(String[] args)
    {
        String filename = getFilename();
        File file = new File(filename);

        long startTime = System.nanoTime();

        char[] input = new char[0];
        int numberOfMatches = 0;
        try
        {
            Scanner fileScanner = new Scanner(file);
            input = fileScanner.nextLine().toCharArray();
            numberOfMatches = input[0] == input[input.length - 1] ? Integer.parseInt("" + input[0]) : 0;
            fileScanner.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File not found.");
            System.exit(FILE_NOT_FOUND);
        }

        for (int i = 1; i < input.length; ++i)
        {
            if (input[i] == input[i - 1])
            {
                System.out.println("Adding " + input[i]);
                numberOfMatches += Integer.parseInt("" + input[i]);
            }
        }

        System.out.println("Part 1: " + numberOfMatches);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Time: " + duration + " ms");
    }
}
