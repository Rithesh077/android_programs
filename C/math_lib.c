#include <stdio.h>
#include <stdlib.h>

int main()
{
    int choice;
    while (1)
    {
        printf("Choose an operation:\n1. Calculate Exponentiation.\n 2.Calculate Factorial.\n3. Exit\n");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            int base;
            int exponent;
            printf("Enter the base:");
            scanf("%d", &base);
            printf("Enter exponent:");
            scanf("%d", &exponent);
            break;

        default:
            printf("Invalid Input");
            break;
        }
    }
    return 0;
}

float exponent_x(float base, int exponent)
{
    float result = 1.0;
    for (int i = 0; i < exponent; i++)
    {
        result = result * base;
    }
    return result;
}