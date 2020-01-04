### Help section for Studentska Služba Application


# HotKeys

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



# Valid Field inputs (RegEx definition follows)

- Name, Surname `[a-zA-ZŠĐČĆŽšđčćž ]+`
- Subject code `[a-zA-Z0-9\\-\\.]+`
- Subject name `[a-zA-ZZŠĐČĆŽšđčćž 1-9]+`
- Date format `dd.MM.YYYY.`
- Student index number `[a-zA-ZZŠĐČĆŽšđčćž]{2}[1-9][0-9]{0,2}/[0-9]{4}`
- Email `([a-zA-Z0-9]+\\.?)*[a-zA-Z0-9]@[a-z0-9]+(\\.[a-z]{2,3})+`
- Phone number `(\\+[1-9][0-9]{2}|0)[1-9][0-9][/][0-9]{3}-[0-9]{3,5}`
- Professor ID card `[0-9]{9}`
- Search query for Student `(ime:[^;:]+;)?(prezime:[^;:]+;)?(indeks:[^;:]+;)?(email:[^;:]+;)?`
- Search query for Professor `(ime:[^;:]+;)?(prezime:[^;:]+;)?(email:[^;:]+;)?(brlk:[^;:]+;)?`
- Search query for Subject `(sifra:[^;:]+;)?(naziv:[^;:]+;)?(semestar:[^;:]+;)?(godina:[^;:]+;)?`



For further help contact developers:
- [Radoš Milićev](mailto:rados280698@yahoo.com)
- [Igor Šikuljak](mailto:igorsikuljak@uns.ac.rs)


[**Go to Product page**](https://fmasterofu.github.io/OISISI_Java/)


## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/FmasterofU/OISISI_Java/edit/master/README.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/FmasterofU/OISISI_Java/settings). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://help.github.com/categories/github-pages-basics/) or [contact support](https://github.com/contact) and we’ll help you sort it out.
