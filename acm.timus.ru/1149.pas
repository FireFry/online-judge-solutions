var
   N:word;

procedure A(N:byte);
var
   i:word;
begin
   write('sin(1');
   for i:=2 to N do
   begin
      if i mod 2=0
         then write('-')
         else write('+');
      write('sin(',i);
   end;
   for i:=1 to N do
      write(')');
end;

procedure S(N:byte);
var
   i:word;
begin
   for i:=1 to n-1 do
      write('(');
   for i:=1 to n-1 do
   begin
      A(i);
      write('+',n+1-i,')');
   end;
   A(N);
   write('+',1);
end;

begin
   readln(N);
   S(N);
   writeln;
end.