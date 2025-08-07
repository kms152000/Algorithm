#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {   
    if (num1 < num2) {
        return num1;
    } else {
        return num1 % num2;
    }
}