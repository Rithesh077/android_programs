#include<stdio.h>
/*int main(){
    float maxQuant,rate,time;
    printf("Enter max quantity:");
    scanf("%f",&maxQuant);
    printf("Enter time in seconds:");
    scanf("%f",&time);
    rate=maxQuant/time;
    printf("Rate: %f",rate);
    return 0;
}*/
/*int main(){
    float side1,side2,side3;
    printf("Enter 3 sides' length to determine the type of triangle:");
    scanf("%f %f %f",&side1,&side2,&side3);
    if(side1==side2==side3){
        printf("'Tis an Equilateral Triangle.\n");
        break;
    }else if(side1==side2||side2==side3||side1==side3){
        printf("'Tis an Isosceles Triangle.\n");
    }else{
        printf("'Tis a Scalene Triangle.\n");
    }
    return 0;
}*/
/*
#include<stdbool.h>
bool isEven(int num);
bool isOdd(int num);
float getExponent(float base, int exponent);
signed float createVector(signed float dataEntry);


typedef struct vectorNode{
    signed float dataEntry;
    struct vectorNode *next;
} vectorNode;

int main(){
    int number;
    printf("Enter a number to check if it's even or odd:");
    scanf("%d",&number);
    if(isEven(number)){
        printf("%d is Even.\n",number);
    }else if(isOdd(number)){
        printf("%d is Odd.\n",number);
    }
    return 0;
}
bool isEven(int num){
    if(num%2==0){
        return true;
    }else{
        return false;
    }
}
bool isOdd(int num){
    if(num%2!=0){
        return true;
    }else{
        return false;
    }
}
float getExponent(float base, int exponent){
    float result=1.0;
    for(int i=0;i<exponent;i++){
        result=result*base;
    }
    return result;
}
*/
/*
#include<stdlib.h>
int main() {
    int x = 10;
    int* p = &x;

    printf("Value of x: %d\n", x);
    printf("Address of x: %p\n", &x);
    printf("Value of p: %p\n", p);
    printf("Value pointed to by p: %d\n", *p);

    *p = 20; // Change the value using the pointer
    printf("New value of x: %d\n", x);
    return 0;
}*/
/*
#include <stdio.h>
int main() {
    int a = 100;
    int b = 200;
    int* p = &a;

    printf("p points to a: %d\n", *p);

    p = &b; // Make p point to b instead
    printf("p now points to b: %d\n", *p);

    *p = 250;
    printf("Final value of a: %d\n", a);
    printf("Final value of b: %d\n", b);
    return 0;
}*/
/*
#include <stdio.h>
#include <stdlib.h>

void allocate_memory(int** ptr) {
    *ptr = (int*)malloc(sizeof(int));
    **ptr = 42;
}

int main() {
    int* my_ptr = NULL;
    allocate_memory(&my_ptr);

    if (my_ptr == NULL) {
        printf("my_ptr is still NULL!\n");
    } else {
        printf("Value: %d\n", *my_ptr);
    }

    free(my_ptr);
    return 0;
}
*/


void swap_fail(int x, int y) {
    int temp = x;
    x = y;
    y = temp;
}

void swap_correct(int* ptr_a, int* ptr_b) {
    int temp = *ptr_a;
    *ptr_a = *ptr_b;
    *ptr_b = temp;
}

int main() {
    int a = 5, b = 10;
    printf("Before swap: a = %d, b = %d\n", a, b);
    swap_fail(a, b);
    printf("After swap_fail: a = %d, b = %d\n", a, b);
    swap_correct(&a, &b);
    printf("After swap_correct: a = %d, b = %d\n", a, b);
    
    return 0;
}