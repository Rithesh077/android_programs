#include <stdio.h>
#include <stdlib.h>
int main(){
    int *array=malloc(10*sizeof(int));
    if (array[i]>10){
        for (int i=0;i<10;i++){
            array[i]=i*i;
            printf("%d ",array[i]);
        }
    }
    free(array);
    return 0;
}