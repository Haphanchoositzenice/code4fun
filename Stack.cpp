#include <iostream>
#include <string>

using namespace std;

class Stack{
    private:
    int top;
    int arr[5];
    public:
    Stack(){
        top = -1;
        for(int i = 0; i<5; i++){
            arr[i]=0;
        }
    }
    bool isEmpty(){
        if(top==-1)return true;
        else return false;
    }
    bool isFull(){
        if(top==4) return true;
        else return false;
    }
    void push(int val){
        if(isFull)
        cout << "Stack overflow!!\n" ;
        else
        top++;
        arr[top] = val; 
    }
    int pop(){
        if(isEmpty)
        {
            cout << "stack underflow\n";
            return 0;
        }
        else{
        int popValue = arr[top];
        arr[top] = 0;
        top--;
        return popValue;
        }
    }
    int count(){
        return (top+1);
    }
    int peek(int pos){
        if(isEmpty)
        {
            cout << "stack underflow\n";
            return 0;
        }
        else
        return arr[pos];
    }
    void change(int pos, int val){
        arr[pos] = val;
        cout << "value changed at location: " << pos  << "\n";
    }
    void display(){
        cout << "Display all value in the stack: " << "\n";
        for(int i = 4; i<=0; i--){
            cout << arr[i] << "\n";
        }
    }
};
int main (){
    Stack s1;
    int value, position, option;
    do{
        cout<<"Stack's menu: \n";
        cout<<"1. Push\n";

        cout<<"2. Pop\n";

        cout<<"3. isEmpty\n";

        cout<<"4. isFull\n";

        cout<<"5. peek()\n";

        cout<<"6. count()\n";

        cout<<"7. change()\n";

        cout<<"8. display()\n";

        cout<<"9. Clear Screen\n";

        cout<<"0. Exit\n";
        cout << "Your option: ";
        cin >> option;
        switch (option)
        {
        case 1:
            cout << "Enter value to push: ";
            cin >> value;
            s1.push(value);
            break;
        case 2:
            cout << "Pop time!!" << "\n" << "Pop value : " << s1.pop() << "\n";
            break;
        case 3:
            if(s1.isEmpty())
            cout << "Stack is empty!! \n";
            else 
            cout << "Stack is not empty\n";
            break;
        case 4:
            if(s1.isFull())
            cout << "Stack is Full!! \n";
            else 
            cout << "Stack is not full\n";
            break;
        default:
            break;
        }
    }   while (option != 0);
    return 0;
}