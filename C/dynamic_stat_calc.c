#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct userInput
{
    float dataPoint;
    struct userInput *next;
} userInput;

int main(void)
{
    struct userInput *head = NULL;
    struct userInput *tail = NULL;
    struct userInput *current = NULL;
    float sum = 0.0;
    int count = 0;
    float mean = 0.0;
    while (true)
    {
        float input;
        printf("Enter a data point (or 'q' to quit): ");
        if (scanf("%f", &input) != 1)
        {
            int c = getchar();
            if (c == 'q')
            {
                break;
            }
            while (c != '\n' && c != EOF)
            {
                c = getchar();

            }
            printf("Invalid input, enter again or 'q' to quit.\n");
            continue;
        }

        struct userInput *newNode = (struct userInput *)malloc(sizeof(struct userInput));
        newNode->dataPoint = input;
        newNode->next = NULL;

        if (head == NULL)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail->next = newNode;
            tail = newNode;
        }

        sum += input;
        count++;
    }
    if (count == 0)
    {
        printf("No data points entered.\n");
    }
    else
    {
        mean = sum / count;
        printf("count: %d Sum: %.2f Mean: %.2f\n", count, sum, mean);
    }
    return (0);
}