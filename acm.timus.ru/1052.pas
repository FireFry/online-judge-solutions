 var n,i,j,p,t,max,a,b,c:integer;
 x,y:array [1..200] of longint;
 begin
 readln(n);
 for i:=1 to n do readln(x[i],y[i]);
 max:=0;
 for i:=1 to n-1 do
 for j:=i+1 to n do
 begin
 a:=y[j]-y[i]; b:=x[j]-x[i];
 c:=x[i]*a-y[i]*b; t:=0;
 for p:=1 to n do
 if a*x[p]-b*y[p]=c then inc(t);
 if t>max then max:=t;
 end;
 writeln(max);
 end.