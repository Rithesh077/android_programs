//simple singly liked lists
#include <stdio.h>
#include <stdlib.h>
typedef struct Node{
    int intData;
    float floatData;
    struct Node* next;
}Node;
Node* createNewNode(int inData,float floatData){
    Node* newNode=(Node*)malloc(sizeof(Node));
    if (newNode==NULL){
        printf("Memory allocation failed!\n");
        exit(1);
    }
    newNode->intData=inData;
    newNode->floatData=floatData;
    newNode->next=NULL;
    return newNode;
}
void printList(Node* head){
    Node* current=head;
    while(current!=NULL){
        printf("Int: %d, Float: %.2f\n",current->intData,current->floatData);
        current=current->next;
    }
}
void freeList(Node* head){
    Node* current=head;
    while(current!=NULL){
        Node* temp=current;
        current=current->next;
        free(temp);
    }
}
int main(){
    int intData;
    float floatData;
    Node* head=NULL;
    Node* tail=NULL;

    while(1){
        printf("Enter your choice:\n1. Add new node\n2. Display list\n3. Exit\n");
        int choice;
        scanf("%d",&choice);
        switch(choice){
            case 1:
                printf("Enter integer data: ");
                scanf("%d",&intData);
                printf("Enter float data: ");
                scanf("%f",&floatData);
                Node* newNode=createNewNode(intData,floatData);
                if (head==NULL){
                    head=newNode;
                    tail=newNode;
                }else{
                    tail->next=newNode;
                    tail=newNode;
                }
                break;
            case 2:
                {
                    if (head==NULL){
                        printf("List is empty.\n");
                    }else{
                        printList(head);
                    }
                }
                break;
            case 3:
                freeList(head);
                head=NULL;
                tail=NULL;
                printf("Exiting...\n");
                return 0;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
    return 0;
}