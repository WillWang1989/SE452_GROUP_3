db.createcollection ("aisle",{
    id : 1,
    num : 3,
    dept_id : 4
})

db.aisle.insert ({
    id : 2
    num : 6
    dept_id : 4
})

db.createcollection ("runner_reviews")

db.runner_reviews.insertMany ([
    {name : "Roxxy Andrews", num_stars : "4"},
    {name : "RuPaul Charles", num_stars : "5"},
    {name : "Bianca Del Rio", num_stars : "3"}
])

db.createcollection ("customer_reviews)

db.customer_reviews.insertmany ([
    {name : "User1", num_stars : "2"},
    {name : "User1", num_stars : "2"},
    {name : "User1", num_stars : "2"}

])


