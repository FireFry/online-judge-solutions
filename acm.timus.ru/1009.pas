program kbasednumbers;
var i:integer;
a:array[0..16] of longint;
n,k:word;
begin
read(n);
read(k);
a[0]:=1;
a[1]:=k-1;
for i:=2 to n do
a[i]:=(k-1)*(a[i-1]+a[i-2]);
writeln(a[n]);
end.