#include <iostream>
#include <cmath>
#include <math.h>
#include "conio.h"
#include <string>

using namespace std;

//Defining the math operations the calculator supports

//addition
void addition(){
	double x, y;

	cout<<"Enter 1st Number: "<<endl;
	cin>>x;
	cout<<"Enter 2nd Number: "<<endl;
	cin>>y;

	cout<<"The sum is: "<<x+y<<endl;
}

//subtraction
void subtraction(){
	double x, y;

	cout<<"Enter 1st Number: "<<endl;
	cin>>x;
	cout<<"Enter 2nd Number: "<<endl;
	cin>>y;

	cout<<"The differance is: "<<x-y<<endl;
}

//multiplication
void multiplication(){
	double x, y;

	cout<<"Enter 1st Number: "<<endl;
	cin>>x;
	cout<<"Enter 2nd Number: "<<endl;
	cin>>y;

	cout<<"The product is: "<<x*y<<endl;
}

//division
void division(){
	double x, y;

	cout<<"Enter 1st Number: "<<endl;
	cin>>x;
	cout<<"Enter 2nd Number: "<<endl;
	cin>>y;

	cout<<"The quotient is: "<<x/y<<endl;
}

//factorial
void factorial() {
	double x, y;

	coutt<<"Enter Number: "<<endl;
	cin>>x;

	for(int i=x; i>0; i--) {
		y*=x;
	}

	cout<<"The Factorial is: "<<y<<endl;
}

//sin
void sin() {
	double x;
	
	cout<<"Enter Number: "<<endl;
	cin>>x;

	cout<<"The Sin is: "<<sin(x)<<endl;
}

//cosin
void cosin() {
	double x;

	cout<<"Enter Number: "<<endl;
	cin>>x;

	cout<<"The Cosin is: "<<cos(x)<<endl;
}

//tangent
void tangent() {
	double x;

	cout<<"Enter Number: "<<endl;
	cin>>x;

	cout<<"The Tangent is: "<<tan(x)<<endl;
}

//power
void power() {
	double x, y;

	cout<<"Enter Number: "<<endl;
	cin>>x;
	cout<<"Enter Power: "<<endl;
	cin>>y;

	for(int i=0; i<y; ++i) {
		x*=x;
	}

	cout<<"The Product is: "<<x<<endl;
}

//sqrt
void sqrt() {
	double x;

	cout<<"Enter Number: "<<endl;
	cin>>x;

	cout<<"The Square Root is: "<<sqrt(x)<<endl;
}

//logarithm
void logarithm() {
	double x;

	cout<<"Enter Number: "<<endl;
	cin>>x;

	cout<<"The Logarithm is: "<<log(x)<<endl;
}

/*Standard, generic calculator which is only capable
* of computing basic math such as addition, subtraction,
* multiplication and division
*/
void standardcalc(){
	string calcFuncStand;

	//Introduction
	cout<<"Functions:"<<endl;
	cout<<"+ - * /"<<endl<<endl;
	cout<<"Please select a function: ";

	cin>>calcFuncStand;

	//Methods to call the appropriate calculator method
	if(calcFuncStand.compare("+")){addition();}
	if(calcFuncStand.compare("-")){subtraction();}
	if(calcFuncStand.compare("*")){multiplication();}
	if(canlcFuncStand.compare("/") {division();}
}

/*The function to handle the scientific calculator option,
* featuring a few more advanced operators not needed for
* everyday/general use
*/
void scientificcalc() {
	string calcFuncStand;

	//Introduction
	cout<<"Functions:"<<endl<<endl;
	cout<<"! sin cos tan ^ sqrt log"<<endl<<endl;
	cout<<"Please select a function: "<<endl;

	cin>>calcFuncStand;

	//Running the input function on the calculator
	if(calcFuncStand.compare("!")) {factorial();}
	if(calcFuncStand.compare("sin")) {sin();}
	if(calcFuncStand.compare("cos")) {cosin();}
	if(calcFuncStand.compare("tan")) {tangent();}
	if(calcFuncStand.compare("^")) {power();}
	if(calcFuncStand.compare("sqrt")) {sqrt();}
	if(calcFuncStand.compare("log")) {logarithm();}
}

/*A very basic calculator in C++ made as I was just beginning to learn
* the language, and to code in general
*/
void main() {
	string calcFunc;

	//Intro
	cout<<"Calculator release v.alpha 1.01"<<endl<<";
	cout<<"Options:"<<endl;
	cout<<"Standard, Scientific"<<endl;

	//Main loop 
	while(true) {
		cout<<"Which calculator would you like to use? ";

		cin>>calcFunc;
		cout<<endl;

		if(calcFunc.tolower().compare("Standard")){
			standardcalc();
		}

		if(calcFunc.tolower().compare("Scientific")){
			scientificcalc();
		}
	}

	//Pause the program
	_getch();		
}
