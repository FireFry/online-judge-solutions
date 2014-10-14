var
   i,j:word;
   s1,s2,s3:string;

begin
   s1:='Fry';
   while not EOF(input) do
   begin
      readln(s1);
      i:=1;
      while i<=length(s1) do
      begin
         s2:='';
         while (((s1[i]>='A') and (s1[i]<='Z')) or ((s1[i]>='a') and (s1[i]<='z')))
         and (i<=length(s1)) do
         begin
            s2:=s2+s1[i];
            inc(i);
         end;
         for j:=length(s2) downto 1 do
            write(s2[j]);
         while not (((s1[i]>='A') and (s1[i]<='Z')) or ((s1[i]>='a') and (s1[i]<='z')))
         and (i<=length(s1)) do
         begin
             write(s1[i]);
             inc(i);
         end;
      end;
      writeln;
   end;
end.