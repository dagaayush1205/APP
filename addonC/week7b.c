#include <stdio.h>
#include <stdlib.h>  // For atoi

int main() {
    char str1[] = "123";
    char str2[] = "456abc";
    char str3[] = "abc456";

    int num1 = atoi(str1);
    int num2 = atoi(str2);
    int num3 = atoi(str3);

    printf("The integer value of str1 is: %d\n", num1);  // 123
    printf("The integer value of str2 is: %d\n", num2);  // 456
    printf("The integer value of str3 is: %d\n", num3);  // 0

    return 0;
}

