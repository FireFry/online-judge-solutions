var
pri: array[1..6000,1..2] of longint;
EME, ENE, i,k, j, cont, numprim, aux:longint;
qwe:boolean;

function PrimoNo(m:longint):boolean;
var
conP: longint;
begin
j:=0;
repeat
j:=j+1;
until ((m mod pri[j,1])=0) or (pri[j,1]>sqrt(m)) or (j=numprim);
if (m mod pri[j,1])=0 then primono:=false
else
primono:= true;
end;

begin
readln(input, ENE, EME);
if ene<>0 then
begin
pri[1,1]:=2;
numprim:=1;
for i:=2 to (2*((ene+2) div 2)+1) do
begin
k:=i;
k:=k+1;
qwe:=primono(k);
if qwe then
begin
numprim:=numprim+1;
pri[numprim,1]:=k;
end;
end;
for i:=1 to numprim do
begin
aux:=pri[i,1];
repeat
pri[i,2]:=pri[i,2]+(ene div aux);
pri[i,2]:=pri[i,2]-(eme div aux)-((ene-eme) div aux);
aux:=aux*pri[i,1];
until ene div aux =0;
end;
cont:=0;
for i:=1 to numprim do
if pri[i,2]<>0 then cont:=cont+1;
writeln(output, cont);
end
else writeln(output, 0);
end.
