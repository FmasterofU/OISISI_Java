# Help section for Studentska Služba Application


## HotKeys

- New `CTRL+N`
- Close `CTRL+Q`
- Edit `CTRL+E`
- Delete `CRTL+D`
- Help `CTRL+H`
- About `CTRL+I`
- Search `ALT+S`
- Add Professor to Subject `ALT+P`
- Remove Professor from Subject `ALT+R`
- Add Student to Subject `ALT+T`
- Remove Student from Subject `ALT+U`


**Date fields** are following format `dd.MM.yyyy.`


## Valid Field inputs (RegEx definition follows)

- Name, Surname `[a-zA-ZŠĐČĆŽšđčćž ]+`
- Subject code `[a-zA-Z0-9\-\.]+`
- Subject name `[a-zA-ZZŠĐČĆŽšđčćž 1-9]+`
- Student index number `[a-zA-ZZŠĐČĆŽšđčćž]{2}[1-9][0-9]{0,2}/[0-9]{4}`
- Email `([a-zA-Z0-9]+\.?)*[a-zA-Z0-9]@[a-z0-9]+(\.[a-z]{2,3})+`
- Phone number `(\+[1-9][0-9]{2}|0)[1-9][0-9][/][0-9]{3}-[0-9]{3,5}`
- Professor ID card `[0-9]{9}`
- Title, calling `[a-zA-Z. ]+`
- Search query for Student `(ime:[^;:]+;)?(prezime:[^;:]+;)?(indeks:[^;:]+;)?(email:[^;:]+;)?`
- Search query for Professor `(ime:[^;:]+;)?(prezime:[^;:]+;)?(email:[^;:]+;)?(brlk:[^;:]+;)?`
- Search query for Subject `(sifra:[^;:]+;)?(naziv:[^;:]+;)?(semestar:[^;:]+;)?(godina:[^;:]+;)?`




For further help contact developers:
- [Radoš Milićev](mailto:rados280698@yahoo.com)
- [Igor Šikuljak](mailto:igorsikuljak@uns.ac.rs)


[**Go to Product page**](https://fmasterofu.github.io/OISISI_Java/)

