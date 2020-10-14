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
    {name : "User2", num_stars : "2"},
    {name : "User3", num_stars : "2"}

])

db.createcollection ("Delivery")

db.delivery.insertmany ([
    {string : "Monday", time : "0900"}
    {string : "Tuesday", time : "1000"}
    {string : "Wednesday", time : "1100"}
    {string : "Thursday", time : "1200"}
    {string : "Friday", time : "1300"}
    {string : "Saturday", time : "1400"}
    {string : "Sunday", time : "1500"}

])


