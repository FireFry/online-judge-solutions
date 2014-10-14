program ex;
const maxvalue=5000;
var a,b:array[1..5000] of longint;
m,n:longint;
x,i,j:longint;

begin
readln(n);
fillchar(a,sizeof(a),0);
for i:=1 to n do begin
readln(x);
inc(a[x]);
end;
b[1]:=a[1];
for i:=2 to maxvalue do 
b[i]:=b[i-1]+a[i];
readln;
readln(m);
for i:=1 to m do begin
readln(x);
j:=1;
while (x-b[j]>0) do begin
inc(j);
end;
writeln(j);
end;
end.
