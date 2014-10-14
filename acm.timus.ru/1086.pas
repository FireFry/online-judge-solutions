var prost:array[1..16000] of longint;
i,j,k,x,n:longint;flag:boolean;
procedure look(x:longint);
var i:longint;
begin
i:=prost[k];
repeat
i:=i+2;
flag:=true;
for j:=1 to k do begin
if i mod prost[j]=0 then begin
flag:=false;
break;
end;
if prost[j]*prost[j]>i then break;{This is very important}
end;
if flag then begin
k:=k+1;
prost[k]:=i;
end;
until k=x;
writeln(prost[k]);
end;
begin
prost[1]:=2;
prost[2]:=3;
prost[3]:=5;
k:=3;
read(n);
for i:=1 to n do begin
read(x);
if x>k then look(x)
else writeln(prost[x]);
end;
end.