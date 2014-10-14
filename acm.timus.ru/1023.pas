var
n,l,i:longint;
begin
readln(n);
l:=n-1;
if ((n mod 2)=0) and (n div 2>2) then l:=n div 2-1;
for i:=2 to trunc(sqrt(n)) do
if n mod (i+1)=0 then begin
l:=i;
break
end;
writeln(l)
end.