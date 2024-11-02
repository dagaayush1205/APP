#include <stdio.h>
#include <stdlib.h>  // For atoi and exit

int main(int argc, char *argv[]) {
    // Check if the number of arguments is valid
    if (argc < 3) {
        printf("Invalid command line: supply two integers \n");
        exit(1);  // Exit with error code 1
    }

    // Convert the command-line arguments from strings to integers
    int num1 = atoi(argv[1]);
    int num2 = atoi(argv[2]);

    // Calculate the sum of the two numbers
    int sum = num1 + num2;

    // Print the result
    printf("The sum of %d and %d is: %d\n", num1, num2, sum);

    return 0;
}

