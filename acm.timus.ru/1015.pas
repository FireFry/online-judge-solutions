program ural1015;
const ps:array[1..6,0..4] of byte=
((2,3,4,5,6),(1,6,5,4,3),(5,1,6,2,4),(6,1,3,2,5),(3,2,6,1,4),(4,5,2,3,1));
type dicetype=array[1..6] of byte;
var dice:array[1..10000] of dicetype;
ans:array[1..10000] of byte;
n,i,j,k:longint;
function compare(a,b:dicetype):boolean;
var i,j,k,p:longint;
temp:array[1..6] of byte;
s1,s2:string[4];
begin
compare:=false;
for i:=1 to 6 do
temp[a[i]]:=ps[a[i],0];
for i:=1 to 6 do
if ps[b[i],0]<>temp[b[i]] then exit;
for p:=1 to 3 do
begin
case p of
1:i:=1;
2:i:=3;
3:i:=4;
end;
s1:='';
s2:='';
for k:=1 to 6 do
if b[k]=a[i] then break;
for j:=1 to 4 do
begin
s1:=s1+chr(a[ps[i,j]]+48);
s2:=s2+chr(b[ps[k,j]]+48);
end;
// writeln(s1,' ',s2);
j:=pos(s1[1],s2);
if j=0 then exit;
s2:=copy(s2,j,5-j)+copy(s2,1,j-1);
if s1<>s2 then exit;
// writeln(s1,' ',s2);
end;
compare:=true;
end;

begin
// assign(input,'ural1015.in');
// reset(input);
readln(n);
fillchar(dice,sizeof(dice),0);
for i:=1 to n do
begin
for j:=1 to 6 do
read(dice[i,j]);
readln;
end;
fillchar(ans,sizeof(ans),0);
k:=0;
for i:=1 to n do
if ans[i]=0 then
begin
inc(k);
for j:=i+1 to n do
if compare(dice[i],dice[j]) then ans[j]:=i;
end;
writeln(k);
for i:=1 to n do
if ans[i]=0 then
begin
write(i);
for j:=i+1 to n do
if ans[j]=i then write(' ',j);
writeln;
end;
// close(input);
end.