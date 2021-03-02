package com.example.androiddevchallenge

data class Puppy(
    val name: String,
    val breed: String,
    val location: String,
    val sex: String,
    val description: String,
    val image: Int
)

val puppyList: List<Puppy> = listOf(
    Puppy(
        name = "Jenkins",
        breed = "Shar_Pei Mix",
        location = "Rosemont, IL",
        sex = "Male",
        description = "He’s not an old man, but his name is Jenkins. Jenkins is an approximately 8 month old, Shar-Pei/Labrador Retriever mix. If I recall correctly, I’ve seen his picture on Facebook being spotted as a runaway around town. Well, his owner had enough, his roaming proved to be too much to correct; so here we are.",
        image = R.drawable.ic_puppy_jenkins
    ),
    Puppy(
        name = "Sugar",
        breed = "Shepherd Mix",
        location = "Los Angeles, CA",
        sex = "Female",
        description = "Sugar is a 8 week old Shepherd Mix looking for her forever home. She will likely be a medium-large dog.",
        image = R.drawable.ic_puppy_sugar
    ),
    Puppy(
        name = "Dottie",
        breed = "Beagle",
        location = "St Charles, MO",
        sex = "Female",
        description = "Miss Dottie also known as Dot is an older gal ready for her forever home! We believe she is around 8 years old and 33 pounds! She loves the young boys in her foster home and loves playing with the other pups!",
        image = R.drawable.ic_puppy_dottie
    ),
    Puppy(
        name = "Ashley",
        breed = "Black Labrador Retriever Mix",
        location = "Crescent city, CA",
        sex = "Female",
        description = "Meet Ashley! She's a sweet and playful puppy, we think 10-12 weeks old! Ashley appears to be some sort of lab mix and will likely be on the larger side.",
        image = R.drawable.ic_puppy_ashley
    ),
    Puppy(
        name = "Elvis",
        breed = "Husky",
        location = "Tillamook, OR",
        sex = "Female",
        description = "Elvis is about a year old. He's a happy dog who loves all people, children & other dogs. He's not a huge fan of chickens.He loves going for walks, loves the beach, loves water.",
        image = R.drawable.ic_puppy_elvis
    )
)
