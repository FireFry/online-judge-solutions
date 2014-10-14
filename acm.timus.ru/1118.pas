var
i,j,k,m,n,ans,start,stop:longint;
r:real;
p:boolean;
begin
readln(start,stop);
r:=maxlongint;
ans:=0;
if start=1 then
begin
writeln(1);
halt;
end;
for i:=stop downto start do
begin
p:=true;
for j:=2 to round(sqrt(i)) do
if i mod j=0 then
begin
p:=false;
break;
end;
if p then
begin
ans:=i;
r:=1/i;
break;
end;
end;
for i:=stop downto start do
begin
if abs(sqrt(i)-round(sqrt(i)))<1e-8 then
begin
if r>(1+sqrt(i))/i then ans:=i;
break;
end;
end;
if ans<>0 then
begin
writeln(ans);
halt;
end;
for i:=start to stop do
begin
k:=1;
for j:=2 to round(sqrt(i)) do
if i mod j=0 then
begin
k:=k+j+(i div j);
if j=i div j then k:=k-j;
end;
if r>k/i then
begin
ans:=i;
r:=k/i;
end;
end;
writeln(ans);
end.