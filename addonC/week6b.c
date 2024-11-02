#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *sourceFile, *destFile;
    char sourceFilename[100], destFilename[100];
    char ch;

    // Get the source file name from the user
    printf("Enter the name of the source file: ");
    scanf("%s", sourceFilename);

    // Open the source file in read mode
    sourceFile = fopen(sourceFilename, "r");
    if (sourceFile == NULL) {
        printf("Could not open file %s for reading.\n", sourceFilename);
        exit(1);
    }

    // Get the destination file name from the user
    printf("Enter the name of the destination file: ");
    scanf("%s", destFilename);

    // Open the destination file in write mode
    destFile = fopen(destFilename, "w");
    if (destFile == NULL) {
        printf("Could not open file %s for writing.\n", destFilename);
        fclose(sourceFile);
        exit(1);
    }

    // Copy the content from source file to destination file
    while ((ch = fgetc(sourceFile)) != EOF) {
        fputc(ch, destFile);
    }

    printf("File copied successfully.\n");

    // Close both files
    fclose(sourceFile);
    fclose(destFile);

    return 0;
}

