var 
   n,a,b,c:longint; 
begin
   readln(n);
   if n=1 then 
   begin
      a:=1; 
      b:=2; 
      c:=3;
   end;
   if n=2 then 
   begin
      a:=3; 
      b:=4; 
      c:=5;
   end;   
   if (n<>2) and (n<>1) 
      then writeln(-1) else
   begin
      writeln(a,' ',b,' ',c);
   end;
end.