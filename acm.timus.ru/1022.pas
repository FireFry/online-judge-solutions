var
   a:array [1..250,1..250] of byte;
   c,b:array [1..250] of byte;
   N,i,j,t:word;
   fl:boolean;

procedure format_C(g:word);
var
   i:word;
begin
   c[g]:=1;
   for i:=1 to N do
      if (a[i,g]>0) and not fl then
         if c[i]=0 then
            format_C(i)
            else if c[i]=1 then
            begin
               fl:=true;
               break;
            end;
   c[g]:=2;
   b[j]:=g;
   dec(j);
end;

begin
   readln(N);
   fl:=false;
   for i:=1 to N do
   begin
      b[i]:=0;
      c[i]:=0;
   end;
   for j:=1 to N do
   begin
      read(i);
      while i<>0 do
      begin
         a[i,j]:=1;
         read(i);
      end;
      readln;
   end;
   j:=N;
   for i:=1 to N do
      if c[i]=0
         then format_C(i);
   if not fl then
      for i:=1 to N do
         write(b[i],' ')
      else write('No solution');
   writeln;
end.