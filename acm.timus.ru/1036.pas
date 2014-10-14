program pp;
type
ss=array[1..100] of integer;
var
a,b:array[0..1000] of ss;
r,h:ss;
st:array[1..1000] of integer;
la,lb:array[0..1000] of integer;
l,lr,lh,n,i,j,s,k,m:integer;
function max(a,b:integer):integer;
begin
if a>b then max:=a else max:=b;
end;
begin
readln(n,s); if odd(s) then begin writeln(0); halt; end;
s:=s div 2;
if (s div n>=10) then begin writeln(0); halt; end;
if s*2>n*9 then s:=n*9-s;
for i:=0 to s do
begin
if i<=9
then a[i,1]:=1;
la[i]:=1;
end;
la[0]:=1;la[1]:=1;
for i:=2 to n do
begin
b:=a; lb:=la;
for j:=1 to s do
for m:=0 to j-1 do
if j-m<=9 then
begin
for k:=1 to max(la[j],lb[m]) do
begin
a[j,k]:=a[j,k]+b[m,k];
a[j,k+1]:=a[j,k+1]+a[j,k] div 10;
a[j,k]:=a[j,k] mod 10;
end;
while a[j,la[j]+1]<>0 do la[j]:=la[j]+1;
end;
end;
lr:=la[s];lh:=la[s];
r:=a[s];h:=a[s];
for j:=lr downto 1 do
begin
for k:=lh downto 2 do inc(r[j+k-1],r[j]*h[k]);
r[j] :=r[j]*h[1];
end;
l:=0;
for j:=1 to lr+lh do
begin
inc(l,r[j]);
r[j] :=l mod 10;
l:=l div 10;
end;
if (r[lr+lh]<>0)
then inc(lr,lh)
else inc(lr,lh-1);
for i:=lr downto 1 do write(r[i]);
end.