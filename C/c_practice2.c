#include<stdio.h>
typedef struct weightedData{
    float dataPoint;
    float weight;
    struct weightedData *next;
}weightedData;
int main(){
    weightedData *head = NULL;
    weightedData *tail = NULL;
    float wtMean=0.0;
    float sumWtData=0.0;
    float wtSum=0.0;
    int count;
    while(true){
        float dataInput,wtInput;
        printf("Enter data point with its weight with a space in between them(enter 'q' to quit):");
        scanf("%f %f",&dataInput,&wtInput);
        // handle quitting condition
        if (dataInput == 'q' || wtInput == 'q') {
            break;
        }
        float dataPoint=dataInput;
        float weight=wtInput;
        weightedData *newNode=(weightedData*)malloc(sizeof(weightedData));
        (newNode).dataPoint=dataPoint;
        (newNode).weight=weight;
        (newNode).next=NULL;
        if(head==NULL){
            head=newNode;
            tail=newNode;
        }else{
            (tail).next=newNode;
        }
        wtSum+=weight;
        sumWtData+=(weight)*(dataPoint);
    }
    wtMean=(sumWtData)/(wtSum);
    printf("the weighted average of the data points:%f",wtMean);
}