CREATE OR REPLACE FUNCTION POVEZI 
(
  PIME IN VARCHAR2 
, PPREZIME IN VARCHAR2 
, PNAZIV IN VARCHAR2 
) RETURN NUMBER AS 
  nasID  integer;
  predID integer;

BEGIN
  
  select nastavnik_id into nasID from NASTAVNIK
    where ime = pime and prezime = pprezime;
  select predmet_id into predID from PREDMET
    where naziv = pnaziv;
  insert into PREDAJE (nastavnik_id, predmet_id)
    values (nasID, predID);
    return  0;
    
   EXCEPTION
   WHEN TOO_MANY_ROWS THEN 
    return -1;
  
   WHEN NO_DATA_FOUND THEN 
    return -2;
END POVEZI;

