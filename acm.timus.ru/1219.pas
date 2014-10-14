var i:longint;

function car(k:longint):char;
begin
car:=chr(k+ord('a'));
end;

begin
for i:=0 to 333332 do
begin
write(car((i div 676) mod 26),car((i div 26) mod 26),car(i mod 26));
end;
write('a');
end.