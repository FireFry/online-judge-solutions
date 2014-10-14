program hanoi;
var
step:longint;
i,n:integer;
goal:array[1..31] of byte;
procedure p(k:integer;a,b,c:integer);
begin
if k=0 then exit;
if goal[k]=b then
begin
step:=step+trunc(exp((k-1)*ln(2)));
p(k-1,c,b,a);
end
else if goal[k]=c then begin writeln(-1); halt; end
else p(k-1,a,c,b);
end;
begin
readln(n);
for i:=1 to n do read(goal[i]);
step:=0;
p(n,1,2,3);
writeln(step);
end.