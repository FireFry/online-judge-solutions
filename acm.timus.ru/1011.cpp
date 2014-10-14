#include<iostream.h>
#include<math.h>
void main(){
double P,Q;
cin>>P>>Q;
int number=1,min=1,max=0;
while(min>=max)
{
min=(int)(number*P*100)/10000+1;
max=(int)(number*Q*100)/10000;
if((int)(number*Q*100)%10000!=0)max++;
number++;
}
cout<<(number-1)<<endl;
}
