var
    a,b:word;
begin
   readln(a,b);
   if (b-a+1) mod 2=0
      then writeln((b-a+1)div 2)
      else writeln((b-a+1)div 2+a mod 2);
end.