var
   a:array[0..100,0..100]of word;
   N,i,j,k:word;
begin
   read(N);
   for j:=1 to N do
   begin
      a[n,j]:=a[n,j-1]+j;
      for i:=n-1 downto j do
         a[i,j]:=a[i+1,j]+n-i+j-1;
      for i:=j-1 downto 1 do
         a[i,j]:=a[i+1,j]+n-j+i;
   end;
   for j:=1 to N do
   begin
      for i:=1 to N do
         write(a[i,j],' ');
      writeln;
   end;
end.
