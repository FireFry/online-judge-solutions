var i,j,k,l,m,n:longint;
ok:boolean;
begin
readln(n,m,k);
for i:=0 to m-1 do
begin
l:=i;
for j:=1 to n-1 do
l:=(l*i) mod m;
if l mod m=k then
begin
write(i,' ');
ok:=true;
end;
end;
if not ok then write(-1);
end.
