 var m,n,sol:longint;
 var tg:longint;
 begin
 readln (m,n);
 if m>n then
 begin
 tg:=m;
 m:=n;
 n:=tg;
 end;
 if m=1 then 
 sol:=(n+1) div 2 
 else
 if (m mod 3=0)or(n mod 3=0) then 
 sol:=2 
 else 
 sol:=1;
 writeln (sol);
end.