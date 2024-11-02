#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    char filename[100], inputData[1000];

    // Get the filename from the user
    printf("Enter the filename to append to: ");
    scanf("%s", filename);

    // Open the file in append mode
    file = fopen(filename, "a");
    if (file == NULL) {
        printf("Could not open file %s for appending.\n", filename);
        exit(1);
    }

    // Get input data from the user
    printf("Enter the data to append: ");
    getchar();  // To consume the newline left by scanf
    fgets(inputData, sizeof(inputData), stdin);

    // Write the data to the file
    fprintf(file, "%s", inputData);

    // Close the file
    fclose(file);

    printf("Data appended to the file successfully.\n");

    return 0;
}

