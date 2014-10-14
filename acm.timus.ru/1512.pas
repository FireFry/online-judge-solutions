var
   n:longint;

procedure Format_C(n:longint);
var
   i,j:longint;
begin
   if n mod 6=2 then
   begin
      j:=n div 2;
      i:=1;
      while i<=n div 2 do
      begin
         writeln(i,' ',j);
         i:=i+1;
         j:=j+2;
         if j>n then
            j:=j-n;
      end;
      i:=n;
      j:=n div 2+1;
      while i>n div 2 do
      begin
         writeln(i,' ',j);
         i:=i-1;
         j:=j-2;
         if j<=0 then
            j:=j+n;
      end;
   end else
   begin
      i:=n div 2;
      j:=1;
      while (i>=1) and (j<=n) do
      begin
         writeln(i,' ',j);
         i:=i-1;
         j:=j+2;
      end;
      i:=n div 2+1;
      j:=n;
      while (i<=n) and (j>=1) do
      begin
         writeln(i,' ',j);
         i:=i+1;
         j:=j-2;
      end;
   end;
end;

begin
   readln(n);
   Format_C(N - N mod 2);
   if N mod 2=1 then
      writeln(N,' ',N);
end.