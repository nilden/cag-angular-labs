## REST-API
### Skapa en ny bok

    curl -X POST -H "Content-Type:application/json" -d '{
        "title": "The Universe in a Nutshell",
        "isbn": "SBN 0-553-80202-X",
        "publicationDate": "2001-01-01"
    }' http://localhost:8080/books

### Skapa en författare

    curl -X POST -H "Content-Type:application/json" -d '{
        "forename" : "John Ronald Reuel",
        "surname" : "Tolkien",
        "birthDate" : "1892-01-03"
    }' http://localhost:8080/authors

### Lägga till författare till lista av författare för bok:

- Boken har URI http://localhost:8080/books/2
- Associationen/Listan är en resurs som har URI:n http://localhost:8080/books/2/authors
- Författaren har URI:n http://localhost:8080/authors/1
- Gör PUT till associationen: `curl -v -X PUT -H "Content-Type: text/uri-list" -d "http://localhost:8080/authors/1" http://localhost:8080/books/2/authors`