#include <stdio.h>

int main(){
int mas[100000],i;
for(i=0;i<100000;i++)
mas[i]=0;
int N,k,y;
scanf("%d",&N);
for(i=0;i<N;i++){
scanf("%d",&k);
y=32768+k;
mas[y]=1;
}
scanf("%d",&N);
int sol=0;
for(i=0;i<N;i++){
scanf("%d",&k);
y=10000-k;
if((y>=-32768)&&(y<=32767)){
y=32768+y;
if(mas[y]==1){
sol=1;
break;
}
}
}
if(sol)
printf("YES");
else
printf("NO");

return 0;
}
